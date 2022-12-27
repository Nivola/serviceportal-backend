/*-
 * ========================LICENSE_START=================================
 * Nivola Web
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.aop.logging;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import it.csi.nivola.nivolasp.domain.SpLogAzione;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.LoggingAccessiService;
import it.csi.nivola.nivolasp.util.StreamingObjectUtil;

@Aspect
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public LoggingAccessiService loggingAccessiService;
    
    @Autowired
    public MessageSource messageSource;

    /**
     * Pointcut that matches all repositories, services and Web REST endpoints.
     */
    @Pointcut("within(it.csi.nivola.nivolasp.repository..*) || within(it.csi.nivola.nivolasp.service..*) || within(it.csi.nivola.nivolasp.web.rest..*)")
    public void loggingPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Advice that logs methods throwing exceptions.
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "loggingPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null? e.getCause() : "NULL");
        log.error("", e);
    }

    /**
     * Advice that logs when a method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */
//    @Around("loggingPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (log.isDebugEnabled()) {
//            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
            log.debug("Ingresso nel metodo: {}.{}()", joinPoint.getSignature().getDeclaringTypeName(),
            		joinPoint.getSignature().getName());
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
//                log.debug("Uscita dal metodo: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                    joinPoint.getSignature().getName(), result);
                log.debug("Uscita dal metodo: {}.{}() ", joinPoint.getSignature().getDeclaringTypeName(),
                		joinPoint.getSignature().getName());
            }
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

            throw e;
        }
    }
    
    /**
     * Advice per tracciare le operazioni dispositive
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(AzioneDispositiva)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    	try {
    	if (SecurityUtils.getUtenteLoggatoCompleto() != null) {
	    	SpLogAzione azione = new SpLogAzione();
	    	azione.setOggetto(messageSource.getMessage("azione.oggetto."+joinPoint.getSignature().getName(), null, null));
	    	azione.setAzione(reperisciMetodoHttp(joinPoint));
	    	azione.setDescrizione(messageSource.getMessage("azione.descrizione."+joinPoint.getSignature().getName(), null, null));
	    	azione.setOrganizzazione(SecurityUtils.getCurrentUser().getAbilitazioneSelezionata().getOrgName());
	    	azione.setDivisione(SecurityUtils.getCurrentUser().getAbilitazioneSelezionata().getDivName());
	    	azione.setAccount(SecurityUtils.getCurrentUser().getAbilitazioneSelezionata().getAccountName());
	    	azione.setRuolo(SecurityUtils.getCurrentUser().getAbilitazioneSelezionata().getUserRole());
	    	azione.setDataAzione(new Timestamp(System.currentTimeMillis()));
	    	
	    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			Enumeration<String> enumer = request.getHeaderNames();
			while(enumer.hasMoreElements()) {
				String nextElement = enumer.nextElement();
				if ("X-Forwarded-For".equals(nextElement))
					azione.setIndirizzoIp(request.getHeader(nextElement));
			}
	    	
	    	azione.setSpUser(SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
	    	String parametri = null;
	    	if (joinPoint.getArgs() != null && joinPoint.getArgs().length == 1)
	    		parametri = "id:"+StreamingObjectUtil.streamObjectToJSONUnformatted(joinPoint.getArgs());
	    	else
	    		parametri = StreamingObjectUtil.streamObjectToJSONUnformatted(joinPoint.getArgs());
	    	
	    	azione.setParametri(StringUtils.truncate(parametri, 1024));
	    	loggingAccessiService.logAzione(azione);
    	}
    	} catch (Exception e) {
    		log.error("ERRORE NELLA DECODIFICA PARAMETRI DI AZIONE DISPOSITIVA " + joinPoint.getArgs(), e);
    	}
        return joinPoint.proceed();
    }
    
    private String reperisciMetodoHttp (JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        Annotation[] annotazioniDestinazione = method.getDeclaredAnnotations();
        for (Annotation anno : annotazioniDestinazione) {
            if (anno.annotationType().isAnnotationPresent(org.springframework.web.bind.annotation.RequestMapping.class)) {
            	RequestMapping annotazioneHttp = anno.annotationType().getAnnotation(org.springframework.web.bind.annotation.RequestMapping.class);
                return annotazioneHttp.method()[0].name();
            }
        }
        return null;
    }
}
