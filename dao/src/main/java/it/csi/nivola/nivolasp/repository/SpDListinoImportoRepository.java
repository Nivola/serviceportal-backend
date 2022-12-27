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

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpDListinoImporto;
@Repository
public interface SpDListinoImportoRepository extends JpaRepository<SpDListinoImporto, String> {
	
	@Query("select i.importoAnnuo from SpDListinoImporto i where i.spDTipoPrezzo.codice = :tipo "
			+ "AND i.spDListinoDettaglio.spDMetriche.nome = :nome and :data between i.spDListinoDettaglio.spDListino.dataInizioValidita and COALESCE(i.spDListinoDettaglio.spDListino.dataFineValidita, '2999-12-31')")
	public Double costoAnnualeMetricaTipo (@Param("tipo") String tipo, @Param("nome") String nome, @Param("data")Date data);
	
	@Query("select i.importoAnnuo from SpDListinoImporto i where i.spDTipoPrezzo.codice = :tipo "
			+ "AND i.spDListinoDettaglio.spDMetriche.nome = :nome and :data between i.spDListinoDettaglio.spDListino.dataInizioValidita and COALESCE(i.spDListinoDettaglio.spDListino.dataFineValidita, '2999-12-31') "
			+ "AND (i.spDListinoDettaglio.rangeMin IS null OR :quantita between i.spDListinoDettaglio.rangeMin AND i.spDListinoDettaglio.rangeMax)")
	public Double costoAnnualeMetricaPerRange (@Param("tipo") String tipo, @Param("nome") String nome, @Param("data")Date data, @Param("quantita")Double quantita);

	@Query("select i.importoAnnuo from SpDListinoImporto i where i.spDTipoPrezzo.codice = :tipo "
			+ "AND i.spDListinoDettaglio.spDMetriche.nome = :nome AND i.spDListinoDettaglio.qta = :tenant and :data between i.spDListinoDettaglio.spDListino.dataInizioValidita and COALESCE(i.spDListinoDettaglio.spDListino.dataFineValidita, '2999-12-31')")
	public Double costoAnnualeMetricaTipoTenant (@Param("tipo") String tipo, @Param("nome") String nome, @Param("tenant")double tenant, @Param("data")Date data);

	@Query("select i.importoAnnuo from SpDListinoImporto i where i.spDTipoPrezzo.codice = :tipo AND i.spDListinoDettaglio.spDMetriche.nome = :nome "
			+ "and :data between i.spDListinoDettaglio.spDListino.dataInizioValidita and COALESCE(i.spDListinoDettaglio.spDListino.dataFineValidita, '2999-12-31') "
			+ "and :dimensione >= i.spDListinoDettaglio.rangeMin and :dimensione < i.spDListinoDettaglio.rangeMax")
	public Double costoAnnualeStorage (@Param("tipo") String tipo, @Param("nome") String nome, @Param("data")Date data, @Param("dimensione") Double dimensione);

}
