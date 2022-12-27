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
package it.csi.nivola.nivolasp.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import it.csi.nivola.nivolasp.domain.SpLogAccessoShib;
import it.csi.nivola.nivolasp.domain.SpLogAccessoUser;
import it.csi.nivola.nivolasp.domain.SpLogAzione;
import it.csi.nivola.nivolasp.domain.SpLogInvocazioniCmp;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.repository.SpLogAccessoShibRepository;
import it.csi.nivola.nivolasp.repository.SpLogAccessoUserRepository;
import it.csi.nivola.nivolasp.repository.SpLogAzioneRepository;
import it.csi.nivola.nivolasp.repository.SpLogInvocazioniCmpRepository;
import it.csi.nivola.nivolasp.service.LoggingAccessiService;
import it.csi.nivola.nivolasp.service.dto.ExportCSV;
import it.csi.nivola.nivolasp.service.dto.LogAzioneDTO;
import it.csi.nivola.nivolasp.service.mapper.LogsMapper;

/**
 * Service Implementation for managing AnnouncementCategory.
 */
@Service
@Transactional
public class LoggingAccessiServiceImpl implements LoggingAccessiService{

    private final Logger log = LoggerFactory.getLogger(LoggingAccessiServiceImpl.class);
    private final Logger logAccesso = LoggerFactory.getLogger("accesso");
    
    private static final String SEP = ";";
	
	private static final String N_LINE = "\r\n";
	
	SimpleDateFormat formatoGiorno = new SimpleDateFormat("dd/MM/yyyy");
    
    @Autowired
    SpLogAccessoShibRepository spLogAccessoShibRepository;
    
    @Autowired
    SpLogInvocazioniCmpRepository spLogInvocazioniCmpRepository;
    
    @Autowired
    SpLogAccessoUserRepository spLogAccessoUserRepository;
    
    @Autowired
    SpLogAzioneRepository spLogAzioneRepository;
    
    @Autowired
    LogsMapper logsMapper;


	@Override
	public SpLogAccessoShib save(SpLogAccessoShib accesso) {
		log.debug("Salvataggio accesso Shibboleth", accesso);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = "";
		String email = "";
		Enumeration<String> enumer = request.getHeaderNames();
//		logAccesso.info("PROVA HEADERS");
		while(enumer.hasMoreElements()) {
			String nextElement = enumer.nextElement();
			if ("X-Forwarded-For".equals(nextElement))
				ip = request.getHeader(nextElement);
			if ("Shib-Email".equals(nextElement))
				email = request.getHeader(nextElement);
//			logAccesso.info(nextElement + ": " + request.getHeader(nextElement));
		}
		logAccesso.info("nome={}, cognome={}, cf={}, comunita={}, data={}, ip={}, email={}", accesso.getNome(), accesso.getCognome(), accesso.getCodiceFiscale(), accesso.getComunitaShib(), accesso.getDataAccesso().toLocalDateTime(), ip, email);
//		return accesso = spLogAccessoShibRepository.save(accesso);
		return accesso;
	}
	
	@Override
	@Async
	public SpLogInvocazioniCmp logInvocazioneCmp(HttpRequest request, byte[] body, ClientHttpResponse response,  SpUser user) {
		/*
		SpLogInvocazioniCmp invocazione = new SpLogInvocazioniCmp();
		
		try {
			if (user == null) {
				user = new SpUser();
				user.setId(2L);
			}
			invocazione.setSpUser(user);
	    	invocazione.setDataInvocazione(new Timestamp(System.currentTimeMillis()));
	    	invocazione.setServizioInvocato(""+request.getURI());
	    	invocazione.setMetodo(""+request.getMethod());
	    	invocazione.setHeadersRichiesta(headersToString(request.getHeaders()));
	    	invocazione.setBodyRichiesta(new String(body, StandardCharsets.UTF_8));
	    	invocazione.setHttpCode(String.valueOf(response.getRawStatusCode())); 
	    	invocazione.setHttpCodeDescription(response.getStatusText());
	    	invocazione.setHeadersRisposta(headersToString(response.getHeaders()));
	    	invocazione.setBodyRisposta(bodyToString(response.getBody()));
	    	invocazione.setEsito("KO");
	    	HttpStatus idCodiceStato = HttpStatus.valueOf(response.getRawStatusCode());
	    	if (idCodiceStato == HttpStatus.NO_CONTENT || idCodiceStato.is2xxSuccessful())
	    		invocazione.setEsito("OK");
	    	invocazione = spLogInvocazioniCmpRepository.saveAndFlush(invocazione);
			
		} catch (IOException e) {
			log.error("IMPOSSIBILE LEGGERE BODY", e);
		}
		return invocazione; */
		return null;
	}
	/*
	private String headersToString(HttpHeaders headers) {
        StringBuilder builder = new StringBuilder();
        for(Entry<String, List<String>> entry : headers.entrySet()) {
            builder.append(entry.getKey()).append("=[");
            for(String value : entry.getValue()) {
                builder.append(value).append(",");
            }
            builder.setLength(builder.length() - 1); // Get rid of trailing comma
            builder.append("],");
        }
        builder.setLength(builder.length() - 1); // Get rid of trailing comma
        return builder.toString();
    }
    
    private String bodyToString(InputStream body) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(body, StandardCharsets.UTF_8));
        String line = bufferedReader.readLine();
        while (line != null) {
            builder.append(line).append(System.lineSeparator());
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return StringUtils.abbreviate(builder.toString(), 65535);
    }
	*/
	@Override
	public SpLogAccessoShib findOne(Long id) {
		return null;
	}

	@Override
	public Page<SpLogAccessoShib> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public void delete(Long id) {
		
	}

	@Override
	public SpLogAccessoUser logAccesso(SpUser utente) {
		/*SpLogAccessoUser entity = new SpLogAccessoUser();
		entity.setDataAccesso(new Timestamp(System.currentTimeMillis()));
		entity.setSpUser(utente);
		return spLogAccessoUserRepository.saveAndFlush(entity);*/
		return null;
	}
	
	@Override
	public SpLogAzione logAzione(SpLogAzione azione) {
		
		return spLogAzioneRepository.saveAndFlush(azione);
	}
	
	@Override
	public List<LogAzioneDTO> elencoPerAccount (String accountName) {
		return logsMapper.toLogAzioneDtoList(spLogAzioneRepository.findByAccount(accountName));
	}
	
	@Override
	public List<LogAzioneDTO> elencoLogAzioneCompleto() {
		return logsMapper.toLogAzioneDtoList(spLogAzioneRepository.findAll());
	}

	@Override
	public ExportCSV csvPerAccount(LogAzioneDTO filtro) {
		List<LogAzioneDTO> dati;
		if(filtro == null || StringUtils.isEmpty(filtro.getAccount()))
    		dati = elencoLogAzioneCompleto();
    	else
    		dati = elencoPerAccount(filtro.getAccount());
    	
		StringBuilder sb = new StringBuilder();
		sb.append("Data").append(SEP)
		.append("Utente").append(SEP)
		.append("Oggetto").append(SEP)
		.append("Descrizione").append(SEP)
		.append("Parametri").append(SEP) //TODO REPLACEEEEEEEEE
		.append("Ip").append(SEP)
		.append("Ruolo utente").append(SEP).append(N_LINE);
		// 7 colonne
		dati.forEach(riga -> sb.append(mappaRiga(riga)));
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(sb);
		risposta.setFilename("Azioni"+LocalDate.now()+".csv");
		return risposta;
	}

	private StringBuilder mappaRiga(LogAzioneDTO riga) {
		StringBuilder sb = new StringBuilder();
		sb.append(formatoGiorno.format(riga.getDataAzione())).append(SEP)
				.append(riga.getNome()).append(SEP)
				.append(riga.getOggetto()).append(SEP)
				.append(riga.getDescrizione()).append(SEP)
				.append(riga.getParametri().replaceAll(";", "-").replace("\n", " ")).append(SEP)
				.append(riga.getIndirizzoIp()).append(SEP)
				.append(riga.getRuolo()).append(SEP).append(N_LINE);
		return sb;
	}
}
