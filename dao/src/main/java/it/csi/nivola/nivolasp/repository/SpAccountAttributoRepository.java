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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpAccountAttributo;
@Repository
public interface SpAccountAttributoRepository extends JpaRepository<SpAccountAttributo, String> {

	public SpAccountAttributo findBySpDTipoPrezzoCodice(String codicePrezzo);

	public SpAccountAttributo findBySpDTipoPrezzoCodiceAndRefAccount(String codicePrezzo, String account);
	
	public SpAccountAttributo findByRefAccount(String account);
	
	@Query(nativeQuery=true, value="SELECT dic.qta tenant, d.descrizione descrizione FROM sp_metriche_dichiarate dic , sp_account_attributo acc, sp_d_metriche metr, sp_d_listino_dettaglio d, sp_d_listino l WHERE now() between l.data_inizio_validita and ifnull(l.data_fine_validita, now()+1) and l.id = d.id_listino and metr.id = d.id_metrica and dic.qta = d.qta AND TRIM(dic.ref_account) = TRIM(acc.ref_account) AND dic.ref_account = :refAccount AND dic.id_metrica = metr.id AND (dic.data_fine_validita IS NULL OR dic.data_fine_validita <= now()) AND dic.data_cancellazione is null AND metr.nome = 'tenant_liv_gest'")
	public Object[] recuperaTenantDiAccount(@Param("refAccount") String refAccount);
	
}
