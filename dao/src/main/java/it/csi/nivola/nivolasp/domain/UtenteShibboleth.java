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
package it.csi.nivola.nivolasp.domain;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.csi.nivola.nivolasp.restinvoker.AccessTokenResponse;
import it.csi.nivola.nivolasp.service.dto.UserDTO;

/**
 * Rappesentazione di un utente autenticato sul portale tramite IDP Shibboleth, con integrazione in Spring Security e
 * reperimento di tutte le informazioni sul portale e presso la CMP
 *
 */
public class UtenteShibboleth implements Serializable, UserDetails, Authentication {

	private static final long serialVersionUID = 2795047563420815665L;
	//nome utente
	private String nome;
	//cognome utenter
	private String cognome;
	// codice fiscale
	private String codFiscale;
	//identificativo del provider di questa identificazione
	private String idProvider;
	//timestamp avvenuto accesso
	private String timestamp;
	//livello OAUTH autenticazione
	private int livelloAutenticazione;
	//mac di questa asserzione
	private String mac;
	//costanti per livelli di autenticazione
	public static final int AUTENTICAZIONE_USERNAME_PASSWORD_UNVERIFIED = 1;
	public static final int AUTENTICAZIONE_USERNAME_PASSWORD = 2;
	public static final int AUTENTICAZIONE_USERNAME_PASSWORD_PIN = 4;
	public static final int AUTENTICAZIONE_CERTIFICATO = 8;
	public static final int AUTENTICAZIONE_CERTIFICATO_FORTE = 16;
	
	//dettaglio delle informazioni utente portale e CMP
	private UserDTO userDto;
	
	//dettaglio SpUser
	private SpUser spUser;
	
	//access token JWT in uso all'utente per l'invocazione dei servizi CMP
	private AccessTokenResponse accessToken = null;
	
	//elenco dei ruoli di portale e CMP per integrazione in Spring Security
	private Collection<GrantedAuthority> grantedAuthorities;
	
	//Asserzione sampl per controlli
	private String token = null;

	/**
	 * Crea un UtenteShibboleth con le informazioni minime provenienti dall'IdP.
	 * @param codFiscale
	 * @param nome
	 * @param cognome
	 * @param idProvider
	 * @param timestamp
	 * @param livelloAutenticazione
	 */
	public UtenteShibboleth(String codFiscale, String nome, String cognome, String idProvider, String timestamp, int livelloAutenticazione) {
		this.codFiscale = codFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.idProvider = idProvider;
		this.timestamp = timestamp;
		this.livelloAutenticazione = livelloAutenticazione;
	}

	/**
	 * Crea un UtenteShibboleth con le informazioni minime provenienti dall'IdP, partendo direttamente dall'asserzione in header.
	 * @param token
	 * @throws MalformedURLException
	 */
	public UtenteShibboleth(String token) throws MalformedURLException {
		this.token = token;
		int slash1Index = token.indexOf('/');
		if (slash1Index == -1)
			throw new MalformedURLException(token);
		codFiscale = token.substring(0, slash1Index);
		int slash2Index = token.indexOf('/', slash1Index + 1);
		if (slash2Index == -1)
			throw new MalformedURLException(token);
		nome = token.substring(slash1Index + 1, slash2Index);
		int slash3Index = token.indexOf('/', slash2Index + 1);
		if (slash3Index == -1)
			throw new MalformedURLException(token);
		cognome = token.substring(slash2Index + 1, slash3Index);
		int slash4Index = token.indexOf('/', slash3Index + 1);
		if (slash4Index == -1)
			throw new MalformedURLException(token);
		idProvider = token.substring(slash3Index + 1, slash4Index);
		int slash5Index = token.indexOf('/', slash4Index + 1);
		if (slash5Index == -1)
			throw new MalformedURLException(token);
		timestamp = token.substring(slash4Index + 1, slash5Index);
		int slash6Index = token.indexOf('/', slash5Index + 1);
		if (slash6Index == -1)
			throw new MalformedURLException(token);
		livelloAutenticazione = Integer.parseInt(token.substring(slash5Index + 1, slash6Index));
		mac = token.substring(slash6Index + 1);
	}


	public String toString() {
		return String.valueOf(String.valueOf(new StringBuffer(String.valueOf(String.valueOf(codFiscale))).append("/").append(nome).append("/").append(cognome).append("/").append(idProvider).append("/").append(timestamp).append("/")
				.append(livelloAutenticazione).append("/").append(mac)));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public String getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(String idProvider) {
		this.idProvider = idProvider;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getLivelloAutenticazione() {
		return livelloAutenticazione;
	}

	public void setLivelloAutenticazione(int livelloAutenticazione) {
		this.livelloAutenticazione = livelloAutenticazione;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	
	public String getName() {
		return codFiscale;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	public Object getCredentials() {
		return null;
	}

	
	public Object getDetails() {
		return userDto;
	}

	
	public Object getPrincipal() {
		return this.getCodFiscale();
	}

	public boolean isAuthenticated() {
		return true;
	}

	
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		//metodo vuoto perché se esiste l'oggetto corrente è sicuramente autenticato - vedi isAuthenticated
	}
	
	public void setUserDto (UserDTO userDto) {
		this.userDto = userDto;
	}
	
	public void setGrantedAuthorities(Set<String> authorities) {
		
		grantedAuthorities = new ArrayList<GrantedAuthority>(authorities.size());
		
		for (String ruolo : authorities) {
			grantedAuthorities.add(new NivolaGrantedAuthority("ROLE_"+ruolo));
		}
	}

	public AccessTokenResponse getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(AccessTokenResponse accessToken) {
		this.accessToken = accessToken;
	}
	

	
	public SpUser getSpUser() {
		return spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



	/**
	 * Wrapper Spriong Security dei ruoli che un utente ha per il portale
	 */
	class NivolaGrantedAuthority implements GrantedAuthority {
		
		private static final long serialVersionUID = 5793027840985187991L;
		
		private String authority;
		
		public NivolaGrantedAuthority(String authority) {
			this.authority = authority;
		}

		@Override
		public String getAuthority() {
			return authority;
		}
		
	}



	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
