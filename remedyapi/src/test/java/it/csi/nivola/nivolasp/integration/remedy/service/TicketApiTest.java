/*-
 * ========================LICENSE_START=================================
 * Api Remedy
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.integration.remedy.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.nivola.nivolasp.integration.remedy.model.InfoNotaAttachments;
import it.csi.nivola.nivolasp.integration.remedy.model.InfoNotaWLog;
import it.csi.nivola.nivolasp.integration.remedy.model.LavorazioneTicket;
import it.csi.nivola.nivolasp.integration.remedy.model.RichiedenteTicket;
import it.csi.nivola.nivolasp.integration.remedy.model.Ticket;
import it.csi.nivola.nivolasp.integration.remedy.model.TicketExpo;
import it.csi.nivola.nivolasp.integration.remedy.model.TicketSnapshot;

/**
 * API tests for TicketApi
 */
public class TicketApiTest extends AbstractTest {

	@Autowired
    TicketApi api;

    
    /**
     * aggiorna le informazioni allegate alla service request
     *
     * Aggioramento delle informazioni richieste al richiedente per la lavorazione della service request
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addWorkinfoTicketTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String ticketId = null;
        String riepilogo = null;
        String tipologia = null;
        String note = null;
        String nomeAllegato1 = null;
        File customKey = null;
        InfoNotaWLog response = api.addWorkinfoTicket(xRequestID, xForwardedFor, ticketId, riepilogo, tipologia, note, nomeAllegato1, customKey);

        log.debug("\n"+response);
    }
    
    /**
     * crea un ticket e ritorna il suo ID
     *
     * Permette di inserire un ticket a sistema e ne restituisce l&#39;identificativo per successive consultazioni e aggiornamenti
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createTicketTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        Ticket ticket = null;
        Ticket response = api.createTicket(xRequestID, xForwardedFor, ticket);

        log.debug("\n"+response);
    }
    
    /**
     * restituisce un allegato associato alla info nota di una service request
     *
     * Consultazione delle informazioni allegate dal richiedente per la lavorazione della service request
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAttachmentTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String ticketId = null;
        String logId = null;
        Integer attachId = null;
        File response = api.getAttachment(xRequestID, xForwardedFor, ticketId, logId, attachId);

        log.debug("\n"+response);
    }
    
    /**
     * ritorna gli ultimi ticket registrati a sistema con categorizzazione &#39;1L -&#39; da qualsiasi fonte
     *
     * ritorna i ticket registrati negli ultimi 10 gg a sistema con categorizzazione &#39;1L -&#39; da qualsiasi fonte
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getLastRegisteredTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String filter = null;
        String sort = null;
        Integer offset = null;
        Integer limit = null;
        List<TicketExpo> response = api.getLastRegistered(xRequestID, xForwardedFor, filter, sort, offset, limit);

        log.debug("\n"+response);
    }
    
    /**
     * ritorna gli ultimi ticket modificati
     *
     * Ritorna le service request che siano state modificate entro x ore dall&#39;ultimo controllo
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getLastUpdatedTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String filter = null;
        String sort = null;
        Integer offset = null;
        Integer limit = 100;
        List<TicketSnapshot> response = api.getLastUpdated(xRequestID, xForwardedFor, filter, sort, offset, limit);

        log.debug("\n"+response);
    }
    
    /**
     * ritorna l&#39;anagrafica del richiedente della service request
     *
     * Ritorna il richiedente della service request
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getUserTicketTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String ticketId = "INC000003439058";
        RichiedenteTicket response = api.getUserTicket(xRequestID, xForwardedFor, ticketId);

        log.debug("\n"+response);
    }
    
    /**
     * ritorna le informazioni sulla lavorazione della service request
     *
     * Ritorna le info lavorazione della service request
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getWorkinfoTicketTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        /*String [] elencoTicketChiusi = new String[] {"INC000006190806", "INC000006205210", "INC000006205388", "INC000006205308", "INC000006205586", "INC000006205670", "INC000006205784", "INC000006205794", "INC000006205917", "INC000006205938", "INC000006206015", "INC000006206218", "INC000006259795", "INC000006260796", "INC000006260908", "INC000006261060", "INC000006262310", "INC000006262886", "INC000006263025", "INC000006262993", "INC000006263039", "INC000006264702", "INC000006265063", "INC000006266003", "INC000006266047", "INC000006269143", "INC000006272405", "INC000006272489", "INC000006272506", "INC000006276543", "INC000006278302", "INC000006278689", "INC000006279624", "INC000006280323", "INC000006284800", "INC000006286095", "INC000006286628", "INC000006287420", "INC000006291654", "INC000006292958", "INC000006293179", "INC000006293382", "INC000006295348", "INC000006296777", "INC000006297359", "INC000006299141", "INC000006300705", "INC000006319097", "INC000006319098", "INC000006319102", "INC000006319594", "INC000006326632", "INC000006326636", "INC000006329815", "INC000006360519", "INC000006361264", "INC000006361372", "INC000006377376", "INC000006377482", "INC000006380850", "INC000006384134", "INC000006384156", "INC000006385021", "INC000006384982", "INC000006389819", "INC000006390271", "INC000006393519", "INC000006394839", "INC000006394859", "INC000006394893", "INC000006395256", "INC000006395360", "INC000006396270", "INC000006396409", "INC000006396822", "INC000006400450", "INC000006401882", "INC000006402926", "INC000006404311", "INC000006405475", "INC000006406337", "INC000006406496", "INC000006406602", "INC000006170869", "INC000006407274", "INC000006407561", "INC000006408604", "INC000006409291", "INC000006410329", "INC000006410460", "INC000006410536", "INC000006410747", "INC000006410713", "INC000006411621", "INC000006413589", "INC000006415786", "INC000006415893", "INC000006416734", "INC000006420059", "INC000006420474", "INC000006420813", "INC000006420912", "INC000006422016", "INC000006422381", "INC000006422873", "INC000006423758", "INC000006423678", "INC000006423688", "INC000006424038", "INC000006425596", "INC000006425801", "INC000006425848", "INC000006427290", "INC000006427632", "INC000006427981", "INC000006428212", "INC000006428507", "INC000006428692", "INC000006428768", "INC000006428894", "INC000006428932", "INC000006429157", "INC000006429386", "INC000006429490", "INC000006429493", "INC000006429506", "INC000006429941", "INC000006431502", "INC000006431952", "INC000006433038", "INC000006169111", "INC000006433578", "INC000006433698", "INC000006433700", "INC000006433842", "INC000006434777", "INC000006434811", "INC000006436762", "INC000006437600", "INC000006437730", "INC000006439106", "INC000006439324", "INC000006439302", "INC000006439516", "INC000006441086", "INC000006441176", "INC000006441818", "INC000006442153", "INC000006443488", "INC000006443917", "INC000006443979", "INC000006444675", "INC000006445892", "INC000006448617", "INC000006448991", "INC000006450205", "INC000006451269", "INC000006452658", "INC000006452742", "INC000006454347", "INC000006454492", "INC000006454674", "INC000006454675", "INC000006454749", "INC000006454818", "INC000006454940", "INC000006456194", "INC000006458788", "INC000006458913", "INC000006459480", "INC000006462612", "INC000006463081", "INC000006463817", "INC000006464128", "INC000006464078", "INC000006464976", "INC000006467468", "INC000006467970", "INC000006468610", "INC000006468848", "INC000006468855", "INC000006469880", "INC000006470588", "INC000006470820", "INC000006470825", "INC000006470835", "INC000006474159", "INC000006474359", "INC000006474482", "INC000006474763", "INC000006475023", "INC000006479673", "INC000006480290", "INC000006481520", "INC000006481510", "INC000006481671", "INC000006481675", "INC000006482099", "INC000006483129", "INC000006483680", "INC000006485441"};
        Arrays.asList(elencoTicketChiusi).forEach(ticketId -> {
        	LavorazioneTicket response = api.getWorkinfoTicket(xRequestID, xForwardedFor, ticketId);
        	if (StringUtils.isNotEmpty(response.getAssegnatario()))
        		log.warn("TROVATO ASSEGNATARIO VALORIZZATO PER TICKET " + ticketId);
        	if (response.getCloseDate() != null)
        		log.warn("TROVATO CLOSE DATE VALORIZZATO PER TICKET " + ticketId);
            log.debug("\n"+response);
        });*/
        String ticketId = "INC000006446979";
        LavorazioneTicket response = api.getWorkinfoTicket(xRequestID, xForwardedFor, ticketId);

        log.debug("\n"+response);
    }
    
    /**
     * consulta una specifica info nota allegata alla service request
     *
     * Consultazione delle informazioni allegate dal richiedente per la lavorazione della service request
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getWorklogTicketTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String ticketId = "INC000003438487";
        String logId = null;
        InfoNotaAttachments response = api.getWorklogTicket(xRequestID, xForwardedFor, ticketId, logId);

        log.debug("\n"+response);
    }
    
    /**
     * consulta le informazioni allegate alla service request
     *
     * Consultazione delle informazioni allegate dal richiedente per la lavorazione della service request
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getWorklogsTicketTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String ticketId = "INC000003438487";
        String filter = null;
        String sort = null;
        Integer offset = null;
        Integer limit = null;
        List<InfoNotaAttachments> response = api.getWorklogsTicket(xRequestID, xForwardedFor, ticketId, filter, sort, offset, limit);

        log.debug("\n"+response);
    }
    
}
