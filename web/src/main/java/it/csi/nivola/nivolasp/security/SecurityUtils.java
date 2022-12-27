/*-
 * ========================LICENSE_START=================================
 * Nivola Web
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import it.csi.nivola.nivolasp.domain.UtenteShibboleth;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.service.dto.AbilitazioneDTO;
import it.csi.nivola.nivolasp.service.dto.UserDTO;

/**
 * Utility class for Spring Security.
*/
public final class SecurityUtils {

    private SecurityUtils() {
    }

    /**
     * Get the login of the current user.
     *
     * @return the login of the current user
     */
    public static String getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String userName = null;
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                userName = springSecurityUser.getUsername();
            } else if (authentication.getPrincipal() instanceof String) {
                userName = (String) authentication.getPrincipal();
            }
        }
        return userName;
    }
    
    /**
     * Restuisce i dettagli dell'utente autenticato.
     * @return
     */
    public static UserDTO getCurrentUser() {
    	return (isAuthenticated() && SecurityContextHolder.getContext().getAuthentication().getDetails() instanceof UserDTO)  ? (UserDTO)SecurityContextHolder.getContext().getAuthentication().getDetails() : null;
    }
    
    /**
     * Restituisce le credenziali complete dell'utente autenticato
     * @return
     */
    public static UtenteShibboleth getUtenteLoggatoCompleto () {
    	return isAuthenticated() ? (UtenteShibboleth)SecurityContextHolder.getContext().getAuthentication() : null;
    }
    
    
    /**
     * Controlla se l'abilitazione selezionata (profilo corrente dell'operatore) è di account e ne restituisce l'id
     * Se l'utente è di tipo BOADMIN forza l'account id specificato
     * @return
     * @throws BusinessException 
     */
    public static String getAccountIdCorrente (String accountId) throws BusinessException {
    	UserDTO utente = getCurrentUser();
    	AbilitazioneDTO abilitazioneSel = utente.getAbilitazioneSelezionata();
    	if (abilitazioneSel == null)
    		throw new BusinessException("Il profilo attivo non valido", "0002", 403);
    	if (StringUtils.isNotEmpty(accountId) && abilitazioneSel.getUserRole().equals(AuthoritiesEnum.BOADMIN.getNomeVisualizzato()))
    		return accountId;
    	if (StringUtils.isEmpty(abilitazioneSel.getAccountUuid()))
    		throw new BusinessException("Il profilo attivo non valido", "0002", 403);
    	return abilitazioneSel.getAccountUuid();
    }
    
    public static String getAccountNameCorrente () throws BusinessException {
    	UserDTO utente = getCurrentUser();
    	AbilitazioneDTO abilitazioneSel = utente.getAbilitazioneSelezionata();
    	if (abilitazioneSel == null)
    		throw new BusinessException("Nessuna abilitazione selezionata per l'utente", "0003", 403);
    	if (StringUtils.isEmpty(abilitazioneSel.getAccountName()))
    		throw new BusinessException("Il profilo attivo non valido", "0002", 403);
    	return abilitazioneSel.getAccountName();
    }
    
    public static boolean isAccount () {
    	UserDTO utente = getCurrentUser();
    	AbilitazioneDTO abilitazioneSel = utente.getAbilitazioneSelezionata();
    	if (abilitazioneSel == null)
    		return false;
    	if (StringUtils.isNotEmpty(abilitazioneSel.getAccountUuid()))
    		return true;
    	return false;
    }
    
    public static boolean isBackOfficeAdmin () {
    	UserDTO utente = getCurrentUser();
    	AbilitazioneDTO abilitazioneSel = utente.getAbilitazioneSelezionata();
    	if (abilitazioneSel == null)
    		return false;
    	if ("BOADMIN".equals(abilitazioneSel.getUserRole()))
    		return true;
    	return false;
    }
    
    /**
     * Controlla se l'abilitazione selezionata (profilo corrente dell'operatore) è di account e ne restituisce l'id
     * altrimenti provoca una risposta FORBIDDEN
     * @return
     * @throws BusinessException 
     */
    public static String getAccountIdCorrente () throws BusinessException {
    	UserDTO utente = getCurrentUser();
    	AbilitazioneDTO abilitazioneSel = utente.getAbilitazioneSelezionata();
    	if (abilitazioneSel == null)
    		throw new BusinessException("Nessuna abilitazione selezionata per l'utente", "0003", 403);
    	if (StringUtils.isEmpty(abilitazioneSel.getAccountUuid()))
    		throw new BusinessException("Il profilo attivo non valido", "0002", 403);
    	return abilitazioneSel.getAccountUuid();
    }
    
    public static List<String> getTuttiAccountIdsUtente () {
    	UserDTO utente = getCurrentUser();
    	List<String> elencoIds = new ArrayList<String>();
    	utente.getElencoAbilitazioni().forEach(abil ->{
    		if (abil.getUserRole().contains("Account"))
    			elencoIds.add(abil.getAccountId());
    	});
    	return elencoIds;
    }
    
    /**
     * Controlla se l'abilitazione selezionata (profilo corrente dell'operatore) è di divisione e ne restituisce l'id
     * altrimenti provoca una risposta FORBIDDEN
     * @return
     * @throws BusinessException 
     */
    public static String getDivisionIdCorrente () throws BusinessException {
    	UserDTO utente = getCurrentUser();
    	AbilitazioneDTO abilitazioneSel = utente.getAbilitazioneSelezionata();
    	if (abilitazioneSel == null)
    		throw new BusinessException("Nessuna abilitazione selezionata per l'utente", "0003", 403);
    	if (!StringUtils.trimToEmpty(abilitazioneSel.getUserRole()).startsWith("Div"))
    		throw new BusinessException("Il profilo attivo non valido", "0002", 403);
    	return abilitazioneSel.getDivUuid();
    }
    
    /**
     * Controlla se l'abilitazione selezionata (profilo corrente dell'operatore) è di organizzazione e ne restituisce l'id
     * altrimenti provoca una risposta FORBIDDEN
     * @return
     * @throws BusinessException 
     */
    public static String getOrganizationIdCorrente () throws BusinessException {
    	UserDTO utente = getCurrentUser();
    	AbilitazioneDTO abilitazioneSel = utente.getAbilitazioneSelezionata();
    	if (abilitazioneSel == null)
    		throw new BusinessException("Nessuna abilitazione selezionata per l'utente", "0003", 403);
    	if (!StringUtils.trimToEmpty(abilitazioneSel.getUserRole()).startsWith("Org"))
    		throw new BusinessException("Il profilo attivo non valido", "0002", 403);
    	return abilitazioneSel.getOrgUuid(); 
    }
    
    public static String getUuidStrutturaOrganizzativaCorrente () throws BusinessException {
    	UserDTO utente = getCurrentUser();
    	AbilitazioneDTO abilitazioneSel = utente.getAbilitazioneSelezionata();
    	
    	if (abilitazioneSel == null)
    		throw new BusinessException("Nessuna abilitazione selezionata per l'utente", "0003", 403);
    	if (StringUtils.trimToEmpty(abilitazioneSel.getUserRole()).startsWith("Org"))
    		return abilitazioneSel.getOrgUuid();
    	if (StringUtils.trimToEmpty(abilitazioneSel.getUserRole()).startsWith("Div"))
    		return abilitazioneSel.getDivUuid();
    	if (StringUtils.isNotEmpty(abilitazioneSel.getAccountUuid()))
    		return abilitazioneSel.getAccountUuid();
    	
    	return null; 
    }
    
    /**
     * Effettua il logout
     */
    public static void logout() {
    	SecurityContextHolder.clearContext();
    }

    /**
     * Controlla sel'utente corrente è autenticato
     * @return true se l'utente è autenticato
     */
    public static boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            return true;
        }
        return false;
    }
    
    
}
