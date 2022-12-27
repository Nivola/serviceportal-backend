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

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.csi.nivola.nivolasp.domain.SpMetricheDichiarate;

public interface SpMetricheDichiarateRepository extends JpaRepository<SpMetricheDichiarate, String> {
	
	@Query("select md from SpMetricheDichiarate md where md.refAccount = :idAccount and md.dataCancellazione is null")
	public List<SpMetricheDichiarate> findMetricheDichiarateAccount(@Param("idAccount") String idAccount);
	
	@Query("select md from SpMetricheDichiarate md where md.refAccount = :idAccount and md.dataCancellazione is null AND (md.dataFineValidita is null OR md.dataFineValidita = "
			+ "(select max(md2.dataFineValidita) from SpMetricheDichiarate md2 where md2.refAccount = :idAccount and md2.dataCancellazione is null group by md2.spDMetriche.id having md2.spDMetriche.id = md.spDMetriche.id))")
	public List<SpMetricheDichiarate> findUltimeMetricheAccount(@Param("idAccount") String idAccount);
	
//	public List<SpMetricheDichiarate> findByRefAccountAndSpDMetricheNomeOrderByDataFineValiditaDescNullsFirst (String refAccount, String nome);
	@Query("select md from SpMetricheDichiarate md where md.refAccount = :idAccount and md.spDMetriche.nome = :nome order by md.dataFineValidita desc nulls first")
	public List<SpMetricheDichiarate> trovaStoricoOrdinato (@Param("idAccount")String refAccount, @Param("nome")String nome);
}
