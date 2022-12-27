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
package it.csi.nivola.nivolasp.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.csi.nivola.nivolasp.domain.SpCostoGiorno;
import it.csi.nivola.nivolasp.service.dto.CostiSottostrutturaDTO;
import it.csi.nivola.nivolasp.service.dto.EstrazioneTotaliMetricaAccountDTO;
import it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO;
import it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiWbsDTO;
import it.csi.nivola.nivolasp.service.dto.ReportServizioDTO;

public interface SpCostoGiornoRepository extends JpaRepository<SpCostoGiorno, Long> {

	/**
	 * Estrazione del costo giornaliero per un account ad una data specificata
	 * @param refAccount
	 * @param data
	 */
	public SpCostoGiorno findByRefAccountAndData (String refAccount, Date data);
	
	/**
	 * Selezione l'ultima data di registrazione dei dati per un account in modo da fare partire il batch dalla data immediatamente successiva
	 * @param refAccount
	 */
	@Query("select max(g.data) from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d where g.refAccount = :refAccount and d.spDMetriche.tipo = 'CMP'")
	public LocalDate findMaxDataPerAccount(@Param("refAccount")String refAccount);
	
	/**
	 * Elenco di tutti i costi di un dato periodo ordinati per account, in modo da collezionarli in map account -> elenco dei suoi costi
	 * @param da
	 * @param a
	 */
	@Query("SELECT e FROM SpCostoGiorno e WHERE e.data BETWEEN :da AND :a order by e.refAccount, e.data")
	public List<SpCostoGiorno> ricercaPerGiornoIntervallo (@Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
	/**
	 * Elenco dei costi di un account ordinati per data
	 * @param da
	 * @param a
	 * @param acc
	 */
	@Query("SELECT e FROM SpCostoGiorno e WHERE refAccount = :acc AND e.data BETWEEN :da AND :a order by e.refAccount, e.data")
	public List<SpCostoGiorno> ricercaPerGiornoIntervalloAccount (@Param("da") java.util.Date da, @Param("a") java.util.Date a, @Param("acc") String acc);
	
	/**
	 * Elenco dei costi di una divisione
	 * @param da
	 * @param a
	 * @param acc
	 */
	@Query("SELECT e FROM SpCostoGiorno e WHERE refDivisione = :div AND e.data BETWEEN :da AND :a order by e.refOrganizzazione, e.refDivisione, e.refAccount, e.data")
	public List<SpCostoGiorno> ricercaPerGiornoIntervalloDivisione (@Param("da") java.util.Date da, @Param("a") java.util.Date a, @Param("div") String div);
	
	
	/**
	 * Elenco dei costi di un'organizzazione 
	 * @param da
	 * @param a
	 * @param acc
	 */
	@Query("SELECT e FROM SpCostoGiorno e WHERE refOrganizzazione = :org AND e.data BETWEEN :da AND :a order by e.refOrganizzazione, e.refDivisione, e.refAccount, e.data")
	public List<SpCostoGiorno> ricercaPerGiornoIntervalloOrganizzazione (@Param("da") java.util.Date da, @Param("a") java.util.Date a, @Param("org") String org);

	/**
	 * Restituisce il costo totale a carico dell'organizzazione specificata ad un giorno preciso, usato nel box dashboard
	 * @param refOrganizzazione
	 * @param giorno
	 */
	@Query("select sum(d.costo) from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d where g.refOrganizzazione = :refOrganizzazione and g.data = :giorno")
	public BigDecimal costiGiornoOrganizzazione(@Param("refOrganizzazione") String refOrganizzazione, @Param("giorno") java.util.Date giorno);
	
	/**
	 * Restituisce il costo totale a carico della divisione specificata ad un giorno preciso, usato nel box dashboard
	 * @param refDivisione
	 * @param giorno
	 */
	@Query("select sum(d.costo) from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d where g.refDivisione = :refDivisione and g.data = :giorno")
	public BigDecimal costiGiornoDivisione(@Param("refDivisione") String refDivisione, @Param("giorno") java.util.Date giorno);
	
	/**
	 * Restituisce il costo totale a carico dell'account specificato ad un giorno preciso, usato nel box dashboard
	 * @param refOrganizzazione
	 * @param giorno
	 */
	@Query("select sum(d.costo) from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d where g.refAccount = :refAccount and g.data = :giorno")
	public BigDecimal costiGiornoAccount(@Param("refAccount") String refAccount, @Param("giorno") java.util.Date giorno);
	
	/**
	 * Elenco di tutti gli account censiti su SpCostoGiorno
	 */
	@Query("SELECT distinct(refAccount) FROM SpCostoGiorno e")
	public List<String> distinctAccount ();
	
	
	/**
	 * 
	 * @param refDivisione
	 * @param da
	 * @param a
	 * @return
	 */
	@Query("select new it.csi.nivola.nivolasp.service.dto.ReportServizioDTO ('', '', sum(d.qta), sum(d.costo), d.spDMetriche.nome) from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d "
			+ "where g.refDivisione = :refDivisione and g.data BETWEEN :da AND :a group by d.spDMetriche.nome")
	public List<ReportServizioDTO> costiRaggruppatiPerMetricaDivisione(@Param("refDivisione")String refDivisione, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
	/**
	 * Somma gli importi di un'organizzazione raggruppati per ciascun account sottostante e servizio
	 * @param refOrganizzazione
	 * @param da
	 * @param a
	 */
	@Query("select new it.csi.nivola.nivolasp.service.dto.ReportServizioDTO ('', '', sum(d.qta), sum(d.costo), d.spDMetriche.nome) from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d "
			+ "where g.refOrganizzazione = :refOrganizzazione and g.data BETWEEN :da AND :a group by d.spDMetriche.nome")
	public List<ReportServizioDTO> costiRaggruppatiPerMetricaOrganizzazione(@Param("refOrganizzazione")String refOrganizzazione, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
	/**
	 * Somma gli importi di ciascun account sottostante e servizio
	 * @param refDivisione
	 * @param da
	 * @param a
	 */
	@Query("select new it.csi.nivola.nivolasp.service.dto.CostiSottostrutturaDTO (g.refAccount, sum(d.costo), sum(d.qta), d.spDMetriche.spDTipoServizio.nome, d.spDMetriche.spDTipoServizio.colore)  from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d "
			+ "where g.refDivisione = :refDivisione and g.data BETWEEN :da AND :a group by g.refAccount, d.spDMetriche.spDTipoServizio.nome, d.spDMetriche.spDTipoServizio.colore order by g.refAccount,  d.spDMetriche.spDTipoServizio.nome")
	public List<CostiSottostrutturaDTO> costiDivisioneRaggruppatiAccountServizio(@Param("refDivisione")String refDivisione, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
	/**
	 * Somma gli importi di un'organizzazione raggruppati per ciascuna divisione sottostante e servizio 
	 * @param refDivisione
	 * @param da
	 * @param a
	 */
	@Query("select new it.csi.nivola.nivolasp.service.dto.CostiSottostrutturaDTO (g.refDivisione, sum(d.costo), sum(d.qta), d.spDMetriche.spDTipoServizio.nome, d.spDMetriche.spDTipoServizio.colore)  from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d "
			+ "where g.refOrganizzazione = :refOrganizzazione and g.data BETWEEN :da AND :a group by g.refDivisione, d.spDMetriche.spDTipoServizio.nome, d.spDMetriche.spDTipoServizio.colore order by g.refDivisione,  d.spDMetriche.spDTipoServizio.nome")
	public List<CostiSottostrutturaDTO> costiOrganizzazioneRaggruppatiDivisioneServizio(@Param("refOrganizzazione")String refOrganizzazione, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
	
	@Query(" Select new  it.csi.nivola.nivolasp.service.dto.EstrazioneTotaliMetricaAccountDTO(g.refAccount,g.refDivisione, g.refOrganizzazione, d.spDMetriche.nome, d.spDMetriche.descrizione, d.spDMetriche.spDTipoServizio.nome,  sum(d.qta), sum(d.costo))"+
			" from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d " + 
			" where g.refAccount = :refAccount and g.data BETWEEN :da AND :a group by g.refAccount, g.refDivisione, g.refOrganizzazione, d.spDMetriche.nome, d.spDMetriche.descrizione, d.spDMetriche.spDTipoServizio.nome order by g.refOrganizzazione, g.refDivisione, g.refAccount,  d.spDMetriche.spDTipoServizio.nome "
    )
	public List<EstrazioneTotaliMetricaAccountDTO> estrazioneCSVCompleto (@Param("refAccount")String refAccount, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	

	@Query(" Select sum(d.costo) "+
			" from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d " + 
			" where g.refAccount = :refAccount and g.data BETWEEN :da AND :a "
    )
	public BigDecimal totaleAccountData (@Param("refAccount")String refAccount, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
	
	@Query("select sum(d.costo) from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d "+
			" where g.refAccount = :refAccount and g.data BETWEEN :da AND :a and d.spDMetriche.nome like 'db_ora_%'")
	public BigDecimal totaleOracleAccountData(@Param("refAccount")String refOrganizzazione, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
	@Modifying
	@Query("delete from SpCostoGiorno where refAccount = ?1 and data >= ?2")
	public void deleteByRefAccountAndDataAfter (String uuid, java.util.Date dataDa);
	
	@Modifying
	@Query("delete from SpCostoGiorno where data >= ?1")
	public void deleteByDataAfter (java.util.Date dataDa);
	
	@Query("select new it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO (d.spDMetriche.spDTipoServizio, sum(d.qta), sum(d.costo)) from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d "
			+ "where g.refAccount = :refAccount and g.data BETWEEN :da AND :a group by d.spDMetriche.spDTipoServizio, d.spDMetriche.spDTipoServizio.ordine order by d.spDMetriche.spDTipoServizio.ordine")
	public List<RaggruppamentoCostiServizioDTO> raggruppaCostiServizioAccount(@Param("refAccount")String refAccount, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
	@Query("select new it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO (d.spDMetriche.spDTipoServizio, sum(d.qta), sum(d.costo)) from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d "
			+ "where g.refDivisione = :refDivisione  and g.data BETWEEN :da AND :a group by d.spDMetriche.spDTipoServizio, d.spDMetriche.spDTipoServizio.ordine order by d.spDMetriche.spDTipoServizio.ordine")
	public List<RaggruppamentoCostiServizioDTO> raggruppaCostiServizioDivisione(@Param("refDivisione")String refAccount, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
	
	@Query("select new it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO (d.spDMetriche.spDTipoServizio, sum(d.qta), sum(d.costo)) from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d "
			+ "where g.refOrganizzazione = :refOrganizzazione  and g.data BETWEEN :da AND :a group by d.spDMetriche.spDTipoServizio, d.spDMetriche.spDTipoServizio.ordine order by d.spDMetriche.spDTipoServizio.ordine")
	public List<RaggruppamentoCostiServizioDTO> raggruppaCostiServizioOrganizzazione(@Param("refOrganizzazione")String refAccount, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
	
	@Query(" Select new it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiWbsDTO(w.spDWb.ewbs, w.spDWb.committente, sum(d.costo)) "+
			" from SpCostoGiorno g JOIN g.spCostoGiornoDettaglios d JOIN g.spCostoGiornoWbs w " + 
			" where g.refAccount = :refAccount and g.data BETWEEN :da AND :a group by w.spDWb.ewbs, w.spDWb.committente"
    )
	public List<RaggruppamentoCostiWbsDTO> totaleAccountDataPerWbs (@Param("refAccount")String refAccount, @Param("da") java.util.Date da, @Param("a") java.util.Date a);
	
}
