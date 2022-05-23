package it.manytomanyjpamaven.test;

import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import it.manytomanyjpamaven.dao.EntityManagerUtil;
import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.StatoUtente;
import it.manytomanyjpamaven.model.Utente;
import it.manytomanyjpamaven.service.MyServiceFactory;
import it.manytomanyjpamaven.service.RuoloService;
import it.manytomanyjpamaven.service.UtenteService;

public class ManyToManyTest {

	public static void main(String[] args) {
		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			// inizializzo i ruoli sul db
//			initRuoli(ruoloServiceInstance);
//
//			System.out.println("In tabella Utente ci sono " + utenteServiceInstance.listAll().size() + " elementi.");
//
//			testInserisciNuovoUtente(utenteServiceInstance);
//			System.out.println("In tabella Utente ci sono " + utenteServiceInstance.listAll().size() + " elementi.");
//
//			testCollegaUtenteARuoloEsistente(ruoloServiceInstance, utenteServiceInstance);
//			System.out.println("In tabella Utente ci sono " + utenteServiceInstance.listAll().size() + " elementi.");
//
//			testModificaStatoUtente(utenteServiceInstance);
//			System.out.println("In tabella Utente ci sono " + utenteServiceInstance.listAll().size() + " elementi.");
//
//			testRimuoviRuoloDaUtente(ruoloServiceInstance, utenteServiceInstance);
//			System.out.println("In tabella Utente ci sono " + utenteServiceInstance.listAll().size() + " elementi.");
//
//			System.out.println("In tabella Ruolo ci sono " + ruoloServiceInstance.listAll().size() + " elementi.");
//
//			testAggiornaRuolo(ruoloServiceInstance);
//
//			testRimuoviRuolo(ruoloServiceInstance);
//			
//			testRimuoviUtente(ruoloServiceInstance, utenteServiceInstance);

//			testCercaTuttiQuelliCreatiAGiugno(utenteServiceInstance);
			
//			testContaTuttiGliAdmin(utenteServiceInstance, ruoloServiceInstance);
			
//			testCercaTutteLeDescrizioniDistinteConUtentiAssociati(utenteServiceInstance, ruoloServiceInstance);
			
			testCercaTuttiQuelliConPasswordConMenoDiOttoCaratteri(utenteServiceInstance);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

//	private static void initRuoli(RuoloService ruoloServiceInstance) throws Exception {
//		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN") == null) {
//			ruoloServiceInstance.inserisciNuovo(new Ruolo("Administrator", "ROLE_ADMIN"));
//		}
//
//		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER") == null) {
//			ruoloServiceInstance.inserisciNuovo(new Ruolo("Classic User", "ROLE_CLASSIC_USER"));
//		}
//	}
//
//	private static void testInserisciNuovoUtente(UtenteService utenteServiceInstance) throws Exception {
//		System.out.println(".......testInserisciNuovoUtente inizio.............");
//
//		Utente utenteNuovo = new Utente("pippo.rossi", "xxx", "pippo", "rossi", new Date());
//		utenteServiceInstance.inserisciNuovo(utenteNuovo);
//		if (utenteNuovo.getId() == null)
//			throw new RuntimeException("testInserisciNuovoUtente fallito ");
//
//		System.out.println(".......testInserisciNuovoUtente fine: PASSED.............");
//	}
//
//	private static void testCollegaUtenteARuoloEsistente(RuoloService ruoloServiceInstance,
//			UtenteService utenteServiceInstance) throws Exception {
//		System.out.println(".......testCollegaUtenteARuoloEsistente inizio.............");
//
//		Ruolo ruoloEsistenteSuDb = ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN");
//		if (ruoloEsistenteSuDb == null)
//			throw new RuntimeException("testCollegaUtenteARuoloEsistente fallito: ruolo inesistente ");
//
//		// mi creo un utente inserendolo direttamente su db
//		Utente utenteNuovo = new Utente("mario.bianchi", "JJJ", "mario", "bianchi", new Date());
//		utenteServiceInstance.inserisciNuovo(utenteNuovo);
//		if (utenteNuovo.getId() == null)
//			throw new RuntimeException("testInserisciNuovoUtente fallito: utente non inserito ");
//
//		utenteServiceInstance.aggiungiRuolo(utenteNuovo, ruoloEsistenteSuDb);
//		// per fare il test ricarico interamente l'oggetto e la relazione
//		Utente utenteReloaded = utenteServiceInstance.caricaUtenteSingoloConRuoli(utenteNuovo.getId());
//		if (utenteReloaded.getRuoli().size() != 1)
//			throw new RuntimeException("testInserisciNuovoUtente fallito: ruoli non aggiunti ");
//
//		System.out.println(".......testCollegaUtenteARuoloEsistente fine: PASSED.............");
//	}
//
//	private static void testModificaStatoUtente(UtenteService utenteServiceInstance) throws Exception {
//		System.out.println(".......testModificaStatoUtente inizio.............");
//
//		// mi creo un utente inserendolo direttamente su db
//		Utente utenteNuovo = new Utente("mario1.bianchi1", "JJJ", "mario1", "bianchi1", new Date());
//		utenteServiceInstance.inserisciNuovo(utenteNuovo);
//		if (utenteNuovo.getId() == null)
//			throw new RuntimeException("testModificaStatoUtente fallito: utente non inserito ");
//
//		// proviamo a passarlo nello stato ATTIVO ma salviamoci il vecchio stato
//		StatoUtente vecchioStato = utenteNuovo.getStato();
//		utenteNuovo.setStato(StatoUtente.ATTIVO);
//		utenteServiceInstance.aggiorna(utenteNuovo);
//
//		if (utenteNuovo.getStato().equals(vecchioStato))
//			throw new RuntimeException("testModificaStatoUtente fallito: modifica non avvenuta correttamente ");
//
//		System.out.println(".......testModificaStatoUtente fine: PASSED.............");
//	}
//
//	private static void testRimuoviRuoloDaUtente(RuoloService ruoloServiceInstance, UtenteService utenteServiceInstance)
//			throws Exception {
//		System.out.println(".......testRimuoviRuoloDaUtente inizio.............");
//
//		// carico un ruolo e lo associo ad un nuovo utente
//		Ruolo ruoloEsistenteSuDb = ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN");
//		if (ruoloEsistenteSuDb == null)
//			throw new RuntimeException("testRimuoviRuoloDaUtente fallito: ruolo inesistente ");
//
//		// mi creo un utente inserendolo direttamente su db
//		Utente utenteNuovo = new Utente("aldo.manuzzi", "pwd@2", "aldo", "manuzzi", new Date());
//		utenteServiceInstance.inserisciNuovo(utenteNuovo);
//		if (utenteNuovo.getId() == null)
//			throw new RuntimeException("testRimuoviRuoloDaUtente fallito: utente non inserito ");
//		utenteServiceInstance.aggiungiRuolo(utenteNuovo, ruoloEsistenteSuDb);
//
//		// ora ricarico il record e provo a disassociare il ruolo
//		Utente utenteReloaded = utenteServiceInstance.caricaUtenteSingoloConRuoli(utenteNuovo.getId());
//		boolean confermoRuoloPresente = false;
//		for (Ruolo ruoloItem : utenteReloaded.getRuoli()) {
//			if (ruoloItem.getCodice().equals(ruoloEsistenteSuDb.getCodice())) {
//				confermoRuoloPresente = true;
//				break;
//			}
//		}
//
//		if (!confermoRuoloPresente)
//			throw new RuntimeException("testRimuoviRuoloDaUtente fallito: utente e ruolo non associati ");
//
//		// ora provo la rimozione vera e propria ma poi forzo il caricamento per fare un
//		// confronto 'pulito'
//		utenteServiceInstance.rimuoviRuoloDaUtente(utenteReloaded.getId(), ruoloEsistenteSuDb.getId());
//		utenteReloaded = utenteServiceInstance.caricaUtenteSingoloConRuoli(utenteNuovo.getId());
//		if (!utenteReloaded.getRuoli().isEmpty())
//			throw new RuntimeException("testRimuoviRuoloDaUtente fallito: ruolo ancora associato ");
//
//		System.out.println(".......testRimuoviRuoloDaUtente fine: PASSED.............");
//	}
//
//	private static void testAggiornaRuolo(RuoloService ruoloService) throws Exception {
//		System.out.println("Inizio testAggiornaRuolo");
//		List<Ruolo> elencoRuoliPresenti = ruoloService.listAll();
//		if (elencoRuoliPresenti.isEmpty())
//			throw new RuntimeException("testAggiornaRuolo fallito: non ci sono ruoli a cui collegarci!");
//		Ruolo ruoloDaAggiornare = elencoRuoliPresenti.get(0);
//		ruoloDaAggiornare.setDescrizione("Amministratore");
//		System.out.println(ruoloDaAggiornare);
//		System.out.println("Fine testAggiornareRuolo");
//	}
//
//	private static void testRimuoviRuolo(RuoloService ruoloService) throws Exception {
//		System.out.println("Inizio testRimuoviRuolo");
//		List<Ruolo> elencoRuoliPresenti = ruoloService.listAll();
//		if (elencoRuoliPresenti.isEmpty())
//			throw new RuntimeException("testRimuoviRuolo fallito: non ci sono ruoli a cui collegarci!");
//		ruoloService.rimuovi(5L);
//		System.out.println("Fine testRimuoviRuolo!");
//	}
//
//	private static void testRimuoviUtente(RuoloService ruoloService, UtenteService utenteService) throws Exception {
//		System.out.println("Inizio testRimuoviUtente");
//		List<Utente> elencoUtentiPresenti = utenteService.listAll();
//		if (elencoUtentiPresenti.isEmpty())
//			throw new RuntimeException("testRimuoviUtente fallito: non ci sono utenti a cui collegarci!");
//		utenteService.rimuovi(2L);
//		System.out.println("Fine testRimuoviRuolo!");
//	}
//
//	private static void testCercaTuttiQuelliCreatiAGiugno(UtenteService utenteService) throws Exception {
//		System.out.println("Inizio testCercaTuttiQUelliCreatiAGiugno");
//		List<Utente> elencoUtentiPresenti = utenteService.listAll();
//		if (elencoUtentiPresenti.isEmpty())
//			throw new RuntimeException(
//					"testCercaTuttQuelliCreatiAGiugno fallito: non ci sono utenti a cui collegarci!");
//		System.out.println(utenteService.cercaTuttiQuelliCreatiAGiugno());
//		System.out.println("Fine testCercaTuttiQUelliCreatiAGiugno!");
//	}

//	private static void testContaTuttiGliAdmin(UtenteService utenteService, RuoloService ruoloService)
//			throws Exception {
//		System.out.println("Inizio testContaTuttiGliAdmin");
//		List<Utente> elencoUtentiPresenti = utenteService.listAll();
//		if (elencoUtentiPresenti.isEmpty())
//			throw new RuntimeException("testContaTuttiGliAdmin fallito: non ci sono utenti a cui collegarci!");
//		System.out.println(utenteService.contaTuttiGliAdmin());
//		System.out.println("Fine testContaTuttiGliAdmin!");
//	}
	
//	private static void testCercaTutteLeDescrizioniDistinteConUtentiAssociati(UtenteService utenteService, RuoloService ruoloService) throws Exception {
//		System.out.println("Inizio testCercaTutteLeDescrizioniDistinteConUtentiAssociati");
//		List<Ruolo> elencoRuoliPresenti = ruoloService.listAll();
//		if(elencoRuoliPresenti.isEmpty())
//			throw new RuntimeException("testCercaTutteLeDescrizioniDistinteConUtentiAssociati fallito: non ci sono ruoli a cui collegarci!");
//		System.out.println(ruoloService.cercaTutteLeDescrizioniDistinteConUtentiAssociati());
//		System.out.println("Fine testCercaTutteLeDescrizioniDistinteConUtentiAssociati!");
//	}	
	
	private static void testCercaTuttiQuelliConPasswordConMenoDiOttoCaratteri(UtenteService utenteService) throws Exception {
		System.out.println("Inizio testCercaTuttiQuelliConPasswordConMenoDiOttoCaratteri");
		List<Utente> elencoUtentiPresenti = utenteService.listAll();
		if(elencoUtentiPresenti.isEmpty())
			throw new RuntimeException("testCercaTuttiQuelliConPasswordConMenoDiOttoCaratteri fallito : non ci sono utenti a cui collegarci!");
		System.out.println(utenteService.cercaTuttiQuelliConPasswordConMenoDiOttoCaratteri());
		System.out.println("Fine testCercaTuttiQuelliConPasswordConMenoDiOttoCaratteri!");
	}

}
