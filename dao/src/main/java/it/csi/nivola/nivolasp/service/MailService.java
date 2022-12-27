/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.csi.nivola.nivolasp.domain.SpMailRichiesta;
import it.csi.nivola.nivolasp.repository.SPMailRichiestaRepository;

/**
 * Service for sending emails.
 * <p>
 * We use the @Async annotation to send emails asynchronously.
 * </p>
 */
@Service
public class MailService {

    private final Logger log = LoggerFactory.getLogger(MailService.class);

    private final JavaMailSender javaMailSender;
    
    @Autowired
    private SPMailRichiestaRepository spMailRichiestaRepository;


    public MailService(JavaMailSender javaMailSender,
            MessageSource messageSource) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmail(String from, String to, String subject, String content, boolean isMultipart, boolean isHtml) {
        log.debug("Send email[multipart '{}' and html '{}'] from {} to '{}' with subject '{}' and content={}",
            isMultipart, isHtml, from, to, subject, content);

        // Prepare message using a Spring helper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, CharEncoding.UTF_8);
            message.setTo(to);
            message.setFrom(from);
            message.setSubject(subject);
            message.setText(content, isHtml);
            javaMailSender.send(mimeMessage);
            log.debug("Sent email to User '{}'", to);
        } catch (Exception e) {
            log.warn("Email could not be sent to user '{}'", to, e);
        }
    }
    
    
    @Async
    public void sendEmail(String to, String [] copia, String subject, String content, boolean isMultipart, boolean isHtml) {
    	log.debug("Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
    			isMultipart, isHtml, to, subject, content);
    	
    	// Prepare message using a Spring helper
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	try {
    		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, CharEncoding.UTF_8);
    		message.setTo(to);
    		message.setFrom("no-reply-nivola.support@csi.it");
    		message.setCc(copia);
    		message.setSubject(subject);
    		message.setText(content, isHtml);
    		javaMailSender.send(mimeMessage);
    		log.debug("Sent email to User '{}'", to);
    	} catch (Exception e) {
    		log.warn("Email could not be sent to user '{}'", to, e);
    	}
    }
    
    @Transactional
    public SpMailRichiesta inserisciRichiestaDB (SpMailRichiesta richiesta) {
    	return spMailRichiestaRepository.saveAndFlush(richiesta);
    }

	public SPMailRichiestaRepository getSpMailRichiestaRepository() {
		return spMailRichiestaRepository;
	}

	public void setSpMailRichiestaRepository(SPMailRichiestaRepository spMailRichiestaRepository) {
		this.spMailRichiestaRepository = spMailRichiestaRepository;
	}
    
    
}
