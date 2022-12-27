# Prodotto
Nivola Service Portal componente BACKEND

# Descrizione della componente
Questa componente è una web application che segue il paradigma "Single Page Application (SPA)", espone servizi REST alla componente "serviceportal-webres" (AngularJS) e si connette al DB (serviceportal-db-scripts-utilities) per le operazioni CRUD.

Si collega al servizio di profilazione utenti trasversale (IRIDE) e al servizio di ticketing del CSI Piemonte

I servizi fruiti usano protocollo HTTP, e sono per lo più REST API.

# Configurazioni iniziali
Da un punto di vista generale, nella fase iniziale occorre adattare i file di properties nella directory buildfiles alla propria configurazione. Una delle cose principali da configurare è il datasource con i dati del DB che si intende utilizzare.


# Getting Started
Una volta prelevata e portata in locale dal repository la componente ("git clone"), procedere con la modifica dei file di configurazione in base al proprio ambiente di deploy e quindi procedere al build.

Moduli dell'applicazione:
- `/batch` contiene le classi per i batch di sistema
- `/web` contiene i REST entrypoints per il frontend
- `/dao` contiene la logica di accesso alla database
- `/cmpapi` contiene le classi generate per l'integrazione con i servizi della CMP
- `/remedyapi` contiene le classi generate per l'integrazione con il sistema di ticketing


# Prerequisiti di sistema
Java 1.8 SDK installed

Occorre per prima cosa predisporre il DB Schema utilizzato da questa componente, e popolarlo con i dati iniziali: si deve quindi prima aver completato installazione e configurazione della componente serviceportal-db.

Per il "build" si è previsto di utilizzare Apache Maven. Nel seguito alcune indicazioni di dettaglio:

Compilazione: mvn clean package .

Nel caso si aggiunga un nuovo profile, esso deve essere referenziato nella sezione `<profiles>` del `pom.xml`, ed il file di `properties` corrispondente deve essere aggiunto nella directory `/profiles`.


# Installazione - Deployment

Installare il file "ear" generato con il build sul proprio ambiente WildFly.

# Esecuzione dei test

Questa componente è stata sottoposta a vulnerability assessment prima del rilascio.

# Versioning

Per il versionamento del software si usa la tecnica Semantic Versioning (http://semver.org).

# Release History

## Service Portal 3.0.0 (2022-11-04)
#### New

- Gestione attributo «Listino Associato all’Account»
- Evidenziare/segnalare quando un utente chiede di aprire un ticket su un account non correttamente configurato
- Modifica Anagrafica Account - Associazione Account con Listino (specifico)
- Caricamento pannello VM : mettere animazione di attesa
- Caricamento pannello DBAAS : mettere animazione di attesa
- Dettaglio VM : Elenco Restore Points disponibili per la VM
- inserire interfaccia standard frontend per «attesa utente» per «Scarica report csv per servizio vm» e report simili

#### Changed

- Revisione pannello «Edit Account» - Progettazione
- Crea nuova VM : Composizione FQDN VM Windows : non usare acronimo
- non più presente stato provvisorio»BUILDING» dal portale in caso di riavvi e/o operazioni su una VM (PROD e STAGE)

#### Fixed

- Conteggio risorse nella pagina di Dettaglio su Portale tutti valori a 0
- Visualizzazione regole SG : Usare il JSON servizi anche per visualizzare la regola
- Costi account non rendicontati : Correzione date
- (Amm. Backoffice) Dopo Edit Account se clicco su Accounts limita la ricerca alla Divisione dell’ultimo Account
- errore nel ricalcolo costi account specifico
- correzione label in caso di detach di un volume
- report Amministrazione -> Report -> Report / Tipo di report «Per WBS»


## Service Portal 2.8.1 (2022-09-12)
#### New

- Adeguamento evolutivo procedura calcolo costi
- Adeguamento attributi Accounts (billing)
- Gestione attributo «Listino Associato all’Account»
- Gestione attributo «Listino Associato all’Account»
- CDU GESTIONE WBS – ACCOUNT


## Service Portal 2.8.0 (2022-07-30)
#### New

- Elenco Jobs di Backup delle VM per gli account abilitati
- Inserimento nuova associazione WBS - Account
- Memo orari presa in carico / Pop-up disclaimer all’apertura di un nuovo ticket con riferimento numero telefonico per richieste urgenti
- Avviso visivo utente quando l’operazione richiede di attendere

#### Changed

- Aggiunta flag «Accedi Sistema Ticketing» su Autoregistrazione
- Inserita in mail apertura ticket le informazioni «oggetto» e «testo»

#### Fixed

- Salvataggio allegati nelle bozze
- Revoca Associazione WBS
- DBAAS visualizzaione informazioni «Subnet», «security Security Group» e «IP address


## Service Portal 2.7.0 (2022-07-04)

#### New

- Gestione attributo WBS accunt per Operatore di Backoffice
- Evolutive integrazione sistema di troubleticketing - E” ora possibile visualizzare la priorità del ticket e l’assegnatario

#### Changed

- Rimozione TAB gestione utenti per servizio DBAAS
- Miglioramento navigazione e layout sistema di troubleticketing
- integrazione gestione StaaS di tipologia Netapp

#### Fixed

- Download csv Lista Attività / Cronologia


## Service Portal 2.6.2 (2022-06-20)
#### Fixed

- Verifica tipologia rules inserite in Security Group
- Risolto bug download report csv risorse DBAAS

## Service Portal 2.6.1(2022-06-10)
#### Changed

- eliminazione pulsante creazione snapshot con ruolo «viewer di account»
- aggiunto filtro su funzionalità di visualizzazione listino
- Lista e dettaglio Volumi. Inserito il dettaglio del Volume Type

#### Fixed

- Problema con Ruoli CMP Account rimossi (DELETED)
- Pagine integrazione troubleTicketing. Manca Link a documentazione


## Service Portal 2.6.0 (2022-06-01)
#### New

- Aggiunta funzionalità «servizi» per l’inserimento regole Security Group
- Rilascio versione Beta integrazione strumeno di Trouble Ticketing. Visibilità sridotta a utenti Beta Tester

#### Changed

- Revisione etichette scarico Csv
- Abilitazione authoring tramite Token Utente
- Integrazione SP con identity provider stranieri (Beta)

#### Fixed

- Adegamento report costi WBS per Amministratore di BackOffice
- Aumentato il numero massimo di caratteri sul campo «Note aggiuntive»
- Correzione Bug detach volume disco di root
- Lista servizi VM (Amm Backoffice) : Visualizzare tooltip con FQDN VM


## Service Portal 2.5.4 (2022-02-11)
#### Changed

- Adeguamento per rilascio CMP Nivola 1.10.0
- Master/Viewer di Account: visualizzazione tariffe e listino applicato all’Account


## Service Portal 2.5.0 (2021-10-12)

#### New

- Funzionalità di reboot VM
- BackOffice: visualizzazione attributi WBS e Cliente Committente

#### Changed

- Aggiunto ad «Account» attributo Cliente Pagante
- Modifica matriche per licenze sistema operativo
- Modifica csv risorse share/storage
- Integrazione Api DBAAAS V2.0

#### Fixed

- Risoluzione bug creazione DBaaS Mysql
- Risoluzione bug creazione DBaaS SQLServer
- Risoluzione bug modifica flavour VM
- Logout non più funzionante con SPID


## Service Portal 2.4.0 (2021-06-28)
#### New

Gestione completa Volume Service (Beta). La funzionalità comprende:
- Creazione nuovo volume
- Elenco Volumi associati a VM
- Attach volume a VM
- Detach volume a VM
- Delete volume
- Rimozione SG da istanza VM
- Aggiunta SG a istanza VM
- Funzionaità di BackOffice. Possibilità di allegare documenti di offerta e provisioning all’account
- Elenco Shares - Visualizzazione colonna Tags
- Disponibilità Report Csv con le risorse associate all’Account

#### Changed

- Nuova gestione e icone per lo stato risorse
- Ordinamento cronologia attività
- Refactoring per visualizzazione 1366x768
- Lista VM Account - tooltips su nome VM
- Adeguamento interfaccia con aggiunta «Drill-Down» button su menu di navigazione

#### Fixed

- Elenco rendiconti account: mancata internazionalizzazione del mese
- bug visualizzazione dettaglio account
- problema visualizzazione Service Portal
- Lista snapshot «Creation Date» : aggiungere ora e minuti
- Bug Quote STAAS/SNAPSHOT
- Viusalizzazione report mese in corso (Master Account)
- presentazione Costi (Euro) nei report PDF
- allineamento colonne report dettaglio pdf
- Elenco ruoli compare solo voce (ruoli_elenco.Ospite)
- bug tootip menu sinistro


## Service Portal 2.3.0 (2021-04-09)
#### New

Gestione completa delle snapshot VM. La funzionalità comprende:
- Creazione nuova snapshot per VM
- Revert snapshot su VM
- Cancellazione snapshot VM
- Compute Service - Visualizzazione lista Volumi associati all’Account
- Visualizzazione e gestione Notizie con layout grafico
- L’utente di BackOffice può visualizzare le quote relative ai singoli account
- Inserita la nuova sezione Documentazione - SLA
- Primo prototipo versione Inglese del Service Portal

#### Changed

- Modificata la visualizzazione delle Quote di un Account distinguendola per singolo Servizio (Compute, DBaas, Staas)
- Nuova modalità di visualizzazione del menù laterale di navigazione
- Refactoring SP per adeguamento e miglioramento gestione «ruolo Utente»
- Miglioramento presentazione dati report PDF di dettaglio

#### Fixed

- Risolto problema funzionalità di modifica/cambio Security Group
- Risolto problema di inserimento Notizie contenenti TAG HTML
- Le azioni di cambio Flavour VM vengono ora inserite nella cronologia attività account


## Service Portal 2.2.0 (2021-02-17)
#### New

- L’utente Master di account può visualizzare le quote del proprio Account
- Modifica/Cambio Security Group VM per Master di Account.
- Nuova funzionalità di Eliminazione/Rimozione STAAS
- Visualizzazione lista Snapshot Virtual Machine
- integrazione consumi e calcolo costi SQLServer
- Elenco Dbaas, visualizzazione e possibilità di effettuare ricerche per tags
- Lista VM - aggiunta colonna Securiy Group

Inserimento e adeguamento listino 2021
#### Changed

- riorganizzazione report pdf e raggruppamenti Costi e Consumi
- adeguamento presentazione costi e consumi su Service Portal
- creazione SG - Ripristino funzionalità
- Adeguamento strutture dati e gestione listino 2021
- Miglioramento interfaccia presentazione rendiconti costi e consumi

#### Fixed

- Risolto problema bloccante creazione regole Security Group
- Risolto bug campo «Descrizione» in creazione regole SG
- Lista bud presentazione SecurityGroup maggiore di 10
- Bug paginazione visualizzazione servizi account


## Service Portal 2.1.0 (2020-10-14)
#### New

Aggiunta la gestione TAG anche per gli oggetti di tipo STaaS.
Nelll’elenco delle VM per Account viene visualizzata anche la colonna Tag. E” quindi possibile effettuare la ricerca anche su questo campo Tag.
L’utente di Backoffice può visualizzare i Security Group e i VPC degli Account.
E” ora possibile visualizzare i Costi e Consumi anche relativi ad un’Organizzazione
L’utente Master/Viewer di account può consultare l’elenco dei servizi di gestione attivati sulle proprie risorse

#### Changed

Migliorati i report pdf/csv relativi ai Costi e Consumi mensili.
Il report pdf di dettaglio mensile Costi è ora accedibile e scaricabile direttamente dalla voce di menu «Costi e Consumi»

#### Fixed

Risolto bug #1118. La naming convention dei dbaas non prevede caratteri minuscoli.
Migliorata la fruibilità della funzione di add rule per i Security Group (#1113)
I Tag relativi agli oggetti VM, DBaaS, STaaS possono contenere fino a 64 caratteri (#1083)
Risolti bug #1137, #1117, #1114, #1113, #1058, #594

## Service Portal 2.0.0 (2020-07-29)
#### New

Upgrade tecnologico in modo da sfruttare le potenzialità del deploy della CMP su un cluster Kubernates. Maggiore affidabilità e scalabilità del sistema.
In fase di creazione di virtual machine, DBaaS e STaaS è ora possibile avere la previsione del costo mensile delle risorse che si intendono allocare.
Completa gestione dei TAG sugli oggetti VM e DBaaS.
Nuova funzioanlità di autoregistrazione sul SP per gli utenti Csi.
Revisione della funzionalità «Costi e Consumi». E” ora disponibile per tutti i profili con una migliore fruibilità dei dati. Aggiunta la possiblità di avere i costi aggregati per Divisione e Organizzazione.
Integrazione con il sistema di ticketing Remedy per le richieste di supporto sugli oggetti DBaaS effettuate tramite Service Portal.

#### Changed

Migliorata la navigazione all’interno delle procedure guidate di creazione servizi.
Aggiornata la naming convention per i servizi DBaaS.
Aggiunti nuovi tagli per il dimensionamento dei Volumi e dei dischi.
Migliorato il sistema di gestione Errori.
Evoluzione delle procedure di calcolo giornaliero dei costi con generazione di report pdf e csv

#### Fixed

Risolti bug #972 #975 #976 relativo alla corretta presentazione dei servizi per i profili Master di Division e Organization.
Risolto il problema #936 #937 per la visualizzazione liste strutture organizzative.
Issue #1071, #1072 relative alla creazione vm con immagini Microsoft.

## Service Portal 1.9.0 (2020-05-06)
#### New

E” disponibile una nuova funzionalità per l’utente di Backoffice per visualizzare la cronologia delle operazioni effettuate all’interno di ogni Account.
L’utente «Master di Account» adesso può visualizzare lo storico delle operazioni effettuate all’interno del proprio account da parte di quasiasi utente.
E” disponibile la nuova voce di menu «Log Management» che permette di accedere al servizio di gestione log della piattaforma.


#### Changed

Modificata la naming convention per i servizi DBaaS.
Aggiunto un attributo ad ogni account con cui è possibile specificare la data di inizio rendicontazione.
Adeguamento grafico nella presentazione dei pannelli costi e consumi.
Nel pannello di gestione di un DBaaS è ora possibile visualizzare eventuali dischi aggiuntivi.

#### Fixed

Risolto bug #907 relativo alla corretta presentazione dei dati nella dashboard «Servizi attivi Account».
Risolto il problema #929 della visualizzazione dell’elenco utenti per il MAster di Divisione.
I dati presentati nella dashboard «Storage» sono stati corretti #906


## Service Portal 1.8.0 (2020-04-10)
#### New

Rilasciato nuovo ruolo utente «Viewer di Account»: da oggi potranno essere accreditati utenti con il ruolo di Viewer di Account. Per i dettagli operativi del ruolo si rimanda alla sezione Utenti, Ruoli ed Account
l’utente Master di Divisione ha a disposizione una nuova funzionalità in modo da poter accreditare e registare utenti all’interno della propria struttura organizzativa.
l’utente con ruolo Master di Account ha a disposizione una nuova funzionalità con cui può accreditare e revocare accreditamenti all’interno della propria struttura organizzativa.
l’utente con ruolo di BackOffice ha ha disposizione la ossibilità di visualizzare tutti i Servizi istanziati all’intefno di ogni Account.

#### Changed

La form di richiesta utenze su DBAAS è stata aggiornata con la possibilità di richiedere utenze Amministrative
Aggiornata la procedura guidata per la creazione di VM con s.o. Windows in modo da accettare password sicure
La grafica e il contenuto del pannello Costi e Consumi di un Account sono stati rivisti e migliorati.
Nel pannello di gestione di una Vm è ora possibile visualizzare eventuali dischi aggiuntivi.

#### Fixed

Risolto bug #803 sulla creazione di Vm con immagine Oracle Linux.
Adeguati i tagli delle dimensioni degli Share e dei dischi aggiuntivi di VM e DBAAS.
Bux fixing su alcune informazioni contenute nella home page dell’uente Master di Account (#779)


# Copyrights

© Copyright Regione Piemonte – 2022

© Copyright CSI-Piemonte – 2022

Questo stesso elenco dei titolari del software è anche riportato in fix COPYRIGHTS.txt .

# License
Il prodotto software è sottoposto alla licenza EUPL-1.2 o versioni successive.
SPDX-License-Identifier: EUPL-1.2-or-later
