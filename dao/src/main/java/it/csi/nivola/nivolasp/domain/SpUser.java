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
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_user database table.
 * 
 */
@Entity
@Table(name="sp_user")
@NamedQuery(name="SpUser.findAll", query="SELECT s FROM SpUser s")
public class SpUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean attivo;

	private Boolean attivoCMP;

	@Column(name="cmp_username")
	private String cmpUsername;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	private String cognome;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	private String email;

	@Column(name="id_agente")
	private BigInteger idAgente;

	@Column(name="matricola_csi")
	private String matricolaCsi;

	private String nome;

	@Column(name="secret_key")
	private String secretKey;

	private String stato;

	private String username;

	@Column(name="uuid_utente")
	private String uuidUtente;

	//bi-directional many-to-one association to SpDReadTheDocsMapping
	@OneToMany(mappedBy="spUser")
	private List<SpDReadTheDocsMapping> spDReadTheDocsMappings;

	//bi-directional many-to-one association to SpDivisioneAttributo
	@OneToMany(mappedBy="spUser")
	private List<SpDivisioneAttributo> spDivisioneAttributos;

	//bi-directional many-to-one association to SpLogAccessoUser
	@OneToMany(mappedBy="spUser")
	private List<SpLogAccessoUser> spLogAccessoUsers;

	//bi-directional many-to-one association to SpLogInvocazioniCmp
	@OneToMany(mappedBy="spUser")
	private List<SpLogInvocazioniCmp> spLogInvocazioniCmps;

	//bi-directional many-to-one association to SpMailRichiesta
	@OneToMany(mappedBy="spUser")
	private List<SpMailRichiesta> spMailRichiestas;

	//bi-directional many-to-one association to SpNewsUser
	@OneToMany(mappedBy="spUser")
	private List<SpNewsUser> spNewsUsers;

	//bi-directional many-to-one association to SpOrganizzazioneAttributo
	@OneToMany(mappedBy="spUser")
	private List<SpOrganizzazioneAttributo> spOrganizzazioneAttributos;

	//bi-directional many-to-one association to SpStatoRichiesta
	@OneToMany(mappedBy="spUser")
	private List<SpStatoRichiesta> spStatoRichiestas;

	//bi-directional many-to-one association to SpUserRuolo
	@OneToMany(mappedBy="spUser", fetch=FetchType.EAGER)
	private List<SpUserRuolo> spUserRuolos;
	
	@Column(name="usa_credenziali")
	private Boolean usaCredenziali = true;

	@Column(name="usa_remedy")
	private Boolean usaRemedy = false;

	public SpUser() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAttivo() {
		return this.attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public Boolean getAttivoCMP() {
		return this.attivoCMP;
	}

	public void setAttivoCMP(Boolean attivoCMP) {
		this.attivoCMP = attivoCMP;
	}

	public String getCmpUsername() {
		return this.cmpUsername;
	}

	public void setCmpUsername(String cmpUsername) {
		this.cmpUsername = cmpUsername;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Timestamp getDataCancellazione() {
		return this.dataCancellazione;
	}

	public void setDataCancellazione(Timestamp dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Timestamp getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Timestamp getDataModifica() {
		return this.dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public String getMatricolaCsi() {
		return this.matricolaCsi;
	}

	public void setMatricolaCsi(String matricolaCsi) {
		this.matricolaCsi = matricolaCsi;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSecretKey() {
		return this.secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getStato() {
		return this.stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUuidUtente() {
		return this.uuidUtente;
	}

	public void setUuidUtente(String uuidUtente) {
		this.uuidUtente = uuidUtente;
	}

	public List<SpDReadTheDocsMapping> getSpDReadTheDocsMappings() {
		return this.spDReadTheDocsMappings;
	}

	public void setSpDReadTheDocsMappings(List<SpDReadTheDocsMapping> spDReadTheDocsMappings) {
		this.spDReadTheDocsMappings = spDReadTheDocsMappings;
	}

	public SpDReadTheDocsMapping addSpDReadTheDocsMapping(SpDReadTheDocsMapping spDReadTheDocsMapping) {
		getSpDReadTheDocsMappings().add(spDReadTheDocsMapping);
		spDReadTheDocsMapping.setSpUser(this);

		return spDReadTheDocsMapping;
	}

	public SpDReadTheDocsMapping removeSpDReadTheDocsMapping(SpDReadTheDocsMapping spDReadTheDocsMapping) {
		getSpDReadTheDocsMappings().remove(spDReadTheDocsMapping);
		spDReadTheDocsMapping.setSpUser(null);

		return spDReadTheDocsMapping;
	}

	public List<SpDivisioneAttributo> getSpDivisioneAttributos() {
		return this.spDivisioneAttributos;
	}

	public void setSpDivisioneAttributos(List<SpDivisioneAttributo> spDivisioneAttributos) {
		this.spDivisioneAttributos = spDivisioneAttributos;
	}

	public SpDivisioneAttributo addSpDivisioneAttributo(SpDivisioneAttributo spDivisioneAttributo) {
		getSpDivisioneAttributos().add(spDivisioneAttributo);
		spDivisioneAttributo.setSpUser(this);

		return spDivisioneAttributo;
	}

	public SpDivisioneAttributo removeSpDivisioneAttributo(SpDivisioneAttributo spDivisioneAttributo) {
		getSpDivisioneAttributos().remove(spDivisioneAttributo);
		spDivisioneAttributo.setSpUser(null);

		return spDivisioneAttributo;
	}

	public List<SpLogAccessoUser> getSpLogAccessoUsers() {
		return this.spLogAccessoUsers;
	}

	public void setSpLogAccessoUsers(List<SpLogAccessoUser> spLogAccessoUsers) {
		this.spLogAccessoUsers = spLogAccessoUsers;
	}

	public SpLogAccessoUser addSpLogAccessoUser(SpLogAccessoUser spLogAccessoUser) {
		getSpLogAccessoUsers().add(spLogAccessoUser);
		spLogAccessoUser.setSpUser(this);

		return spLogAccessoUser;
	}

	public SpLogAccessoUser removeSpLogAccessoUser(SpLogAccessoUser spLogAccessoUser) {
		getSpLogAccessoUsers().remove(spLogAccessoUser);
		spLogAccessoUser.setSpUser(null);

		return spLogAccessoUser;
	}

	public List<SpLogInvocazioniCmp> getSpLogInvocazioniCmps() {
		return this.spLogInvocazioniCmps;
	}

	public void setSpLogInvocazioniCmps(List<SpLogInvocazioniCmp> spLogInvocazioniCmps) {
		this.spLogInvocazioniCmps = spLogInvocazioniCmps;
	}

	public List<SpMailRichiesta> getSpMailRichiestas() {
		return this.spMailRichiestas;
	}

	public void setSpMailRichiestas(List<SpMailRichiesta> spMailRichiestas) {
		this.spMailRichiestas = spMailRichiestas;
	}

	public SpMailRichiesta addSpMailRichiesta(SpMailRichiesta spMailRichiesta) {
		getSpMailRichiestas().add(spMailRichiesta);
		spMailRichiesta.setSpUser(this);

		return spMailRichiesta;
	}

	public SpMailRichiesta removeSpMailRichiesta(SpMailRichiesta spMailRichiesta) {
		getSpMailRichiestas().remove(spMailRichiesta);
		spMailRichiesta.setSpUser(null);

		return spMailRichiesta;
	}

	public List<SpNewsUser> getSpNewsUsers() {
		return this.spNewsUsers;
	}

	public void setSpNewsUsers(List<SpNewsUser> spNewsUsers) {
		this.spNewsUsers = spNewsUsers;
	}

	public SpNewsUser addSpNewsUser(SpNewsUser spNewsUser) {
		getSpNewsUsers().add(spNewsUser);
		spNewsUser.setSpUser(this);

		return spNewsUser;
	}

	public SpNewsUser removeSpNewsUser(SpNewsUser spNewsUser) {
		getSpNewsUsers().remove(spNewsUser);
		spNewsUser.setSpUser(null);

		return spNewsUser;
	}

	public List<SpOrganizzazioneAttributo> getSpOrganizzazioneAttributos() {
		return this.spOrganizzazioneAttributos;
	}

	public void setSpOrganizzazioneAttributos(List<SpOrganizzazioneAttributo> spOrganizzazioneAttributos) {
		this.spOrganizzazioneAttributos = spOrganizzazioneAttributos;
	}

	public SpOrganizzazioneAttributo addSpOrganizzazioneAttributo(SpOrganizzazioneAttributo spOrganizzazioneAttributo) {
		getSpOrganizzazioneAttributos().add(spOrganizzazioneAttributo);
		spOrganizzazioneAttributo.setSpUser(this);

		return spOrganizzazioneAttributo;
	}

	public SpOrganizzazioneAttributo removeSpOrganizzazioneAttributo(SpOrganizzazioneAttributo spOrganizzazioneAttributo) {
		getSpOrganizzazioneAttributos().remove(spOrganizzazioneAttributo);
		spOrganizzazioneAttributo.setSpUser(null);

		return spOrganizzazioneAttributo;
	}

	public List<SpStatoRichiesta> getSpStatoRichiestas() {
		return this.spStatoRichiestas;
	}

	public void setSpStatoRichiestas(List<SpStatoRichiesta> spStatoRichiestas) {
		this.spStatoRichiestas = spStatoRichiestas;
	}

	public SpStatoRichiesta addSpStatoRichiesta(SpStatoRichiesta spStatoRichiesta) {
		getSpStatoRichiestas().add(spStatoRichiesta);
		spStatoRichiesta.setSpUser(this);

		return spStatoRichiesta;
	}

	public SpStatoRichiesta removeSpStatoRichiesta(SpStatoRichiesta spStatoRichiesta) {
		getSpStatoRichiestas().remove(spStatoRichiesta);
		spStatoRichiesta.setSpUser(null);

		return spStatoRichiesta;
	}

	public List<SpUserRuolo> getSpUserRuolos() {
		return this.spUserRuolos;
	}

	public void setSpUserRuolos(List<SpUserRuolo> spUserRuolos) {
		this.spUserRuolos = spUserRuolos;
	}

	public SpUserRuolo addSpUserRuolo(SpUserRuolo spUserRuolo) {
		getSpUserRuolos().add(spUserRuolo);
		spUserRuolo.setSpUser(this);

		return spUserRuolo;
	}

	public SpUserRuolo removeSpUserRuolo(SpUserRuolo spUserRuolo) {
		getSpUserRuolos().remove(spUserRuolo);
		spUserRuolo.setSpUser(null);

		return spUserRuolo;
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
