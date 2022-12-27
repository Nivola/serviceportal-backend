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
package it.csi.nivola.nivolasp.service.dto;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * A DTO representing a user, with his authorities.
 */
public class UserDTO extends AbstractDTO {

	private static final long serialVersionUID = -3339127100369029241L;

	private Long id;

    @Size(min = 1, max = 50)
    private String login;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 100)
    private String email;

    @Size(max = 256)
    private String imageUrl;

    private boolean attivo = false;

    @Size(min = 2, max = 5)
    private String langKey;

    private BigInteger idAgente;

    private Date dataCreazione;
    
    private Date dataModifica;
    
    private Date dataCancellazione;
    

    private String lastModifiedBy;
    
    private Set<AbilitazioneDTO> elencoAbilitazioni;
    
    private AbilitazioneDTO abilitazioneSelezionata;
    
    private String urlLogout;
    
    private String cmpUsername;
    
    private String codiceFiscale;
    
    private String matricolaCsi;
    
    private Boolean attivoCMP;
    
    private String uuidUtente;
    
    private long marker;
    
	private Boolean usaCredenziali = false;

	private Boolean usaRemedy = false;
    
    public UserDTO () {
    	marker = System.currentTimeMillis();
    }
    
    public Set<AbilitazioneDTO> getElencoAbilitazioni() {
		return elencoAbilitazioni;
	}

	public void setElencoAbilitazioni(Set<AbilitazioneDTO> elencoAbilitazioni) {
		this.elencoAbilitazioni = elencoAbilitazioni;
	}

	private String idProvider;
    
    private String descrizioneRuolo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivod(boolean activated) {
		this.attivo = activated;
	}

	public String getLangKey() {
		return langKey;
	}

	public void setLangKey(String langKey) {
		this.langKey = langKey;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}


	public String getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(String idProvider) {
		this.idProvider = idProvider;
	}

	public String getDescrizioneRuolo() {
		return descrizioneRuolo;
	}

	public void setDescrizioneRuolo(String descrizioneRuolo) {
		this.descrizioneRuolo = descrizioneRuolo;
	}

	public String getUrlLogout() {
		return urlLogout;
	}

	public void setUrlLogout(String urlLogout) {
		this.urlLogout = urlLogout;
	}

	public AbilitazioneDTO getAbilitazioneSelezionata() {
		return abilitazioneSelezionata;
	}

	public void setAbilitazioneSelezionata(AbilitazioneDTO abilitazioneSelezionata) {
		this.abilitazioneSelezionata = abilitazioneSelezionata;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	public Date getDataCancellazione() {
		return dataCancellazione;
	}

	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public BigInteger getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public String getCmpUsername() {
		return cmpUsername;
	}

	public void setCmpUsername(String cmpUser) {
		this.cmpUsername = cmpUser;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getMatricolaCsi() {
		return matricolaCsi;
	}

	public void setMatricolaCsi(String matricolaCsi) {
		this.matricolaCsi = matricolaCsi;
	}

	public Boolean getAttivoCMP() {
		return attivoCMP;
	}

	public void setAttivoCMP(Boolean attivoCMP) {
		this.attivoCMP = attivoCMP;
	}

	public String getUuidUtente() {
		return uuidUtente;
	}

	public void setUuidUtente(String uuidUtente) {
		this.uuidUtente = uuidUtente;
	}

	public long getMarker() {
		return marker;
	}

	public void setMarker(long marker) {
		this.marker = marker;
	}

	public Boolean getUsaCredenziali() {
		return usaCredenziali;
	}

	public void setUsaCredenziali(Boolean usaCredenziali) {
		this.usaCredenziali = usaCredenziali;
	}

	public Boolean getUsaRemedy() {
		return usaRemedy;
	}

	public void setUsaRemedy(Boolean usaRemedy) {
		this.usaRemedy = usaRemedy;
	}

	
}
