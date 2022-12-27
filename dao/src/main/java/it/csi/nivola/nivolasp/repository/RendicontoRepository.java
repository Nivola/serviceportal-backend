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

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpDTipoRendiconto;
import it.csi.nivola.nivolasp.domain.SpRendiconto;
import it.csi.nivola.nivolasp.service.dto.CostoAccountDTO;
import it.csi.nivola.nivolasp.service.dto.CostoDelMeseRigaDTO;

@Repository
public interface RendicontoRepository  extends JpaRepository<SpRendiconto, Long>{

	/**
	 * Elenco rendiconti mensile sintetico
	 * @param idAccount
	 * @return
	 */
	@Query("select s from SpRendiconto s where s.idAccount = :idAccount and s.tipoRendiconto.codice = 'MA'")
    List<SpRendiconto> trovaRendicontiSintesiAccount(@Param("idAccount") String idAccount);
	
	/**
	 * Elenco rendiconti mensile dettaglio per account
	 * @param idAccount
	 * @return
	 */
	@Query("select s from SpRendiconto s where s.idAccount = :idAccount and s.tipoRendiconto.codice = 'GA'")
    List<SpRendiconto> trovaRendicontiAccountDettaglio(@Param("idAccount") String idAccount);
	

	@Query("SELECT max(dataRendicontoA) FROM SpRendiconto where tipoRendiconto = :tipo and idAccount = :refAccount")
	LocalDate findDataUltimaGenerazione (@Param("refAccount") String refAccount, @Param("tipo") SpDTipoRendiconto tipo);

	@Query(" select s  from  SpRendiconto s "
            + "where s.idDivisione = :idDivisione and s.idAccount is null and s.tipoRendiconto.codice = :tipoRendiconto"
            )
    Page<SpRendiconto> findRendicontiByidDivisione(@Param("idDivisione") String idDivisione,@Param("tipoRendiconto") String tipoRendiconto,Pageable pageable);

	/**
	 * findRendicontiByidAccount
	 * @param idAccount
	 * @param pageable
	 * @return
	 */
	@Query("  select s from  SpRendiconto s "
            + "where s.idOrganizzazione = :idOrganizzazione "
            )
    Page<SpRendiconto> findRendicontiByidOrganizzazione(@Param("idOrganizzazione") String idOrganizzazione,Pageable pageable);



	//PDF
	@Query(" Select s "
			+ "from  SpRendiconto s "
            + "where s.idAccount = :idAccount "
			+ "and s.id = :id"
            )
    Optional<SpRendiconto> findRendicontoByIdAndIdAccount(@Param("idAccount") String idAccount,@Param("id") Long id);

	@Query(" Select s "
			+ "from  SpRendiconto s "
            + "where s.idDivisione = :idDivisione "
			+ "and s.id = :id"
            )
	Optional<SpRendiconto> findRendicontoByIdAndIdDivisione(@Param("idDivisione") String idDivisione,@Param("id") Long id);

	@Query(" Select s "
			+ "from  SpRendiconto s "
            + "where s.idOrganizzazione = :idOrganizzazione "
			+ "and s.id = :id "
            )
	Optional<SpRendiconto> findRendicontoByIdAndIdOrganizzazione(@Param("idOrganizzazione") String idOrganizzazione,@Param("id") Long id);
	
	
	List<SpRendiconto> findByIdAccount (String idAccount);
	
	List<SpRendiconto> findByIdDivisione (String idDivisione);
	
	@Query(" Select new  it.csi.nivola.nivolasp.service.dto.CostoAccountDTO(r.idAccount, '', '', sum(r.importo)) "
			+ "from  SpRendiconto r "
            + "where r.idDivisione = :idDivisione and r.idAccount is not null and (r.dataRendicontoDa between :dataDa and :dataA OR r.dataRendicontoA between :dataDa and :dataA) "
			+ " group by r.idAccount "
            )
	List<CostoAccountDTO> aggregaCostiAccountPerDivisionePeriodo (@Param("idDivisione") String idDivisione, @Param("dataDa") Date dataDa,  @Param("dataA") Date dataA);
	
	
	@Query(" Select new  it.csi.nivola.nivolasp.service.dto.CostoDelMeseRigaDTO(rs.tipoServizio, sum(rs.importo)) "
			+ "from  SpRendiconto r "
			+ "JOIN r.spRendicontoServizios  rs "
			+ "where r.idDivisione = :idDivisione and r.idAccount is not null and :data between r.dataRendicontoDa and  r.dataRendicontoA "
			+ " group by rs.tipoServizio "
			)
	List<CostoDelMeseRigaDTO> aggregaCostiDivisionePerServizio (@Param("idDivisione") String idDivisione, @Param("data") Date data);
	
	
	SpRendiconto findByAnnoAndMeseAndIdAccountAndTipoRendiconto (Integer anno, Integer mese, String idAccount, SpDTipoRendiconto tipoRendiconto);

	

	@Modifying
	@Query("delete from SpRendiconto where idAccount = ?1 and dataRendicontoDa >= ?2")
	public void deleteByRefAccountAndDataAfter (String uuid, java.util.Date dataDa);
	

	@Modifying
	@Query("delete from SpRendiconto where dataRendicontoDa >= ?1")
	public void deleteByDataAfter (java.util.Date dataDa);
	

}
