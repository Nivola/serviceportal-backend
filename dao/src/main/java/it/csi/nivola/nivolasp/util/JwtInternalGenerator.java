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
package it.csi.nivola.nivolasp.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import it.csi.nivola.nivolasp.config.ApplicationProperties;

/**
 * Classe di utilita' per la generazioe di un JWT ad uso interno
 */
@Component
public class JwtInternalGenerator {

	@Autowired
	ApplicationProperties proprieta;
	
	private final Logger log = LoggerFactory.getLogger(JwtInternalGenerator.class);

	
	/**
	 * Genera un JWT
	 * @param fineValidita facoltativa, se null expiration = fine giornata corrente
	 * @param issuer obbligatorio
	 * @param subject obbligatorio: business
	 * @return token JWT codificato in Base64
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public String generaJWT(Date fineValidita, String issuer, String subject) throws NoSuchAlgorithmException, InvalidKeySpecException {
		long nowMillis = System.currentTimeMillis();
		ZonedDateTime ora = ZonedDateTime.now();

		PrivateKey signingKey = estrazioneChiavePrivata();
		Date dateOra = Date.from(ora.toInstant());
		if (fineValidita == null)
			fineValidita = Date.from(ora.with(LocalTime.MAX).toInstant());

		JwtBuilder builder = Jwts.builder()
				.setId(UUID.randomUUID().toString())
				.setIssuedAt(dateOra)
				.setNotBefore(dateOra)
				.setExpiration(fineValidita)
				.setIssuer(issuer)
				.setAudience(proprieta.getDeploy().getRedirectTo())
				.setSubject(subject)
				.signWith(SignatureAlgorithm.RS512, signingKey);

		long expMillis = nowMillis + 100000;
		Date exp = new Date(expMillis);
		builder.setExpiration(exp);

		return builder.compact();
	}

	
	/**
	 * Verifica che il token passato sia valido e conforme nella firma.
	 * Restituisce un'eccezione in caso di verifica andata male.
	 * @throws ExpiredJwtException
	 * @throws UnsupportedJwtException
	 * @throws MalformedJwtException
	 * @throws SignatureException
	 * @throws IllegalArgumentException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public Boolean verificaToken(String jwt) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, NoSuchAlgorithmException, InvalidKeySpecException {
		Claims claim = Jwts.parser().setSigningKey(estrazioneChiavePrivata()).parseClaimsJws(jwt).getBody();
		log.info("SUBJECT: " + claim.getSubject());
		return "configuratore".equals(claim.getSubject());
	}
	
	
	/*
	 * Estrae la chiave privata per la generazione del token.
	 */
	private PrivateKey estrazioneChiavePrivata() throws NoSuchAlgorithmException, InvalidKeySpecException {
		// Recupero della chiave privata RSA
		String pkcs8Pem = new String(Base64.getDecoder().decode(proprieta.getBusinessApi().getPrivateKey()));

		/*
		 * La chiave decodificata contiene le diciture --- BEGIN [...] PRIVATE KEY --- e
		 * --- END [...] PRIVATE KEY --- a volte è scritto RSA, a volte no, in base a
		 * come viene generata la chiave. per cui la prima e l'ultima riga devono essere
		 * eliminate.
		 */
		String[] lineeChiave = pkcs8Pem.split("\n");
		StringBuilder chiaveSenzaIntestazioneCoda = new StringBuilder();
		for (int numeroLinea = 1; numeroLinea < lineeChiave.length; numeroLinea++) {
			if (numeroLinea != lineeChiave.length - 1)
				chiaveSenzaIntestazioneCoda.append(lineeChiave[numeroLinea]);
		}
		pkcs8Pem = chiaveSenzaIntestazioneCoda.toString();
		pkcs8Pem = pkcs8Pem.replaceAll("\\s+", "");

		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(pkcs8Pem));
		KeyFactory kf;

		kf = KeyFactory.getInstance(SignatureAlgorithm.RS512.getFamilyName());

		PrivateKey signingKey = kf.generatePrivate(spec);
		return signingKey;
	}


}
