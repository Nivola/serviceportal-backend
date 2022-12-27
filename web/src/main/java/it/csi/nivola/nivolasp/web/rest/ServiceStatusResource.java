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
package it.csi.nivola.nivolasp.web.rest;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.integration.rest.api.base.BaseApi;
import it.csi.nivola.nivolasp.service.MailService;
import it.csi.nivola.nivolasp.service.dto.ServiceStatusDTO;
import it.csi.nivola.nivolasp.service.dto.TokenDTO;
import it.csi.nivola.nivolasp.service.dto.TokenedEmailRequest;
import it.csi.nivola.nivolasp.util.JwtInternalGenerator;
import it.csi.nivola.nivolasp.util.StreamingObjectUtil;

@RestController
@RequestMapping("/api/public")
public class ServiceStatusResource {

    private final Logger log = LoggerFactory.getLogger(ServiceStatusResource.class);
	@Autowired
	BaseApi api;
	@Autowired
	ApplicationProperties applicationProperties = null;
	
	@Autowired
	MailService mailService;
	
	
	
	@Autowired
	JwtInternalGenerator jwtInternalGenerator;

    @GetMapping("/test-all")
    
    public ResponseEntity<Map<String, ServiceStatusDTO>> getServicesStatus() {

    	Map<String, ServiceStatusDTO> output = new HashMap<>();

    	ServiceStatusDTO dto;

    	// dto = new ServiceStatusDTO("it.csi.nivola.deploy", "Informazioni ultimo deploy", 10, true, "Effettuato il: " + applicationProperties.getDeploy().getTimestamp() + " con profilo attivo: " + applicationProperties.getDeploy().getProfile() + " dall'utente: " + applicationProperties.getDeploy().getUtente());
    	// output.put(dto.getCode(), dto);

    	dto = new ServiceStatusDTO("it.csi.nivola.nivolasp.db", "Nivola Service Portal", 10, true, "Tutti servizi del Service Portal sono in funzione");
    	output.put(dto.getCode(), dto);

    	log.debug("INVOCAZIONE API BUSINESS ALL'URL:" + api.getApiClient().getBasePath());
    	try {
	    	api.v10ServerPingGet();
	    	log.debug("INVOCAZIONE API RIUSCITA");
	    	dto = new ServiceStatusDTO("it.csi.nivola.nivolasp.restapi", "Piattaforma Cloud Nivola", 20, true, "I webservices di Nivola sono disponibil");
    	}catch (Exception e) {
    		dto = new ServiceStatusDTO("it.csi.nivola.nivolasp.restapi", "Piattaforma Cloud Nivola", 20, false, "I webservices di Nivola non sono disponibil");
    		log.error("TIMEOUT???", e);
    	}


    	output.put(dto.getCode(), dto);



        return ResponseEntity.ok(output);
    }

    //TODO DA IMPLEMENTARE
    @PostMapping("/adminer/log")
    
	public ResponseEntity<String> insertAdminerLog(@RequestBody Map<String, Object> logInfo) {

		return new ResponseEntity<>("insertAdminerLog ok ", new HttpHeaders(), HttpStatus.OK);
	}

    @PostMapping("/adminer/check-token")
    
	public ResponseEntity<Boolean> checkAdminerToken(@RequestBody String jwt) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, NoSuchAlgorithmException, InvalidKeySpecException {
        Boolean response = jwtInternalGenerator.verificaToken(jwt);
		return new ResponseEntity<Boolean>(response, new HttpHeaders(), HttpStatus.OK);
	}
    
    @PostMapping("/configuratore/email")
    @CrossOrigin
	public ResponseEntity<Boolean> invioEmailControllato(@RequestBody TokenedEmailRequest richiestaEmail) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, NoSuchAlgorithmException, InvalidKeySpecException {
        log.info(StreamingObjectUtil.streamObjectToJSON(richiestaEmail));
    	
    	Boolean tokenValido = jwtInternalGenerator.verificaToken(richiestaEmail.getToken());
        if (!tokenValido)
        	return new ResponseEntity<Boolean>(tokenValido, new HttpHeaders(), HttpStatus.FORBIDDEN);
        
        mailService.sendEmail(richiestaEmail.getMailSupporto().getRichiedente(), 
        		richiestaEmail.getMailSupporto().getDestinatario(), 
        		richiestaEmail.getMailSupporto().getTitolo(), 
        		richiestaEmail.getMailSupporto().getCorpo(), true, true);
        
        mailService.sendEmail(richiestaEmail.getMailUtente().getRichiedente(), 
        		richiestaEmail.getMailUtente().getDestinatario(), 
        		richiestaEmail.getMailUtente().getTitolo(), 
        		richiestaEmail.getMailUtente().getCorpo(), true, true);
        
        return new ResponseEntity<Boolean>(tokenValido, new HttpHeaders(), HttpStatus.OK);
        
	}
    
    /**
	 * Genera un token JWT
	 * @param uuid
	 * @return
	 * @throws JSONException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
    @GetMapping("/token/{identita}")
    @CrossOrigin
	public ResponseEntity<TokenDTO> generaToken(@PathVariable String identita, String subject) throws JSONException, NoSuchAlgorithmException, InvalidKeySpecException {
    	LocalDateTime scadenzaToken = LocalDateTime.now().plusMinutes(1);
    	if (!"configuratore".equals(identita))
    		return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    	TokenDTO token = new TokenDTO();
    	token.setToken(jwtInternalGenerator.generaJWT(java.util.Date.from(
    			scadenzaToken.atZone(ZoneId.systemDefault()).toInstant()), 
    			"be@local",
    			identita));
    	return new ResponseEntity<TokenDTO>(token,
    		HttpStatus.OK);
	}
}
