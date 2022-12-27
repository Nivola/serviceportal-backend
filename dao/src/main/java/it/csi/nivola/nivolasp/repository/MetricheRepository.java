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

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpDMetriche;
import it.csi.nivola.nivolasp.domain.SpDSottoservizio;

@Repository
public interface MetricheRepository  extends JpaRepository<SpDMetriche, BigInteger>{

	@Query("from SpDMetriche where tipo = 'CALC'")
	List<SpDMetriche> findCalcolate();
	
	@Query("from SpDMetriche where tipo = 'LISTINO'")
	List<SpDMetriche> findListino();
	
	@Query("from SpDMetriche where tipo = 'CMP'")
	List<SpDMetriche> findCmp();
	
	@Query("from SpDMetriche where spDTipoServizio.nome  = :servizio and tipo in('LISTINO', 'CALC')")
	List<SpDMetriche> findListinoECaloclatePerServizio(@Param("servizio") String servizio);
	
	@Query("from SpDMetriche where spDTipoServizio.nome  = :servizio and tipo in('LISTINO', 'CMP') and visualizzaReport = true")
	List<SpDMetriche> findListinoECmpPerServizio(@Param("servizio") String servizio);
	
	@Query("from SpDMetriche where spDSottoservizio = :sotto AND spDTipoServizio.nome = :servizio AND tipo in('LISTINO', 'CMP') and visualizzaReport = true")
	List<SpDMetriche> findListinoECmpPerServizioSottoServizio(@Param("servizio") String servizio, @Param("sotto")SpDSottoservizio sotto);
	
	@Query("from SpDMetriche where tipo in('LISTINO', 'CMP') order by spDTipoServizio.nome")
	List<SpDMetriche> findListinoECmpOrdinate();
	
	@Query("from SpDMetriche where tipo in('LISTINO', 'CMP') and visualizzaReport = true order by spDTipoServizio.nome")
	List<SpDMetriche> findListinoECmpReport();

	SpDMetriche findByNome(String nome);

}
