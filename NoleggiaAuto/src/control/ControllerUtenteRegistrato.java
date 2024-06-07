package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;

import entity.EntityAuto;
import entity.EntityCatalogoAccessori;
import entity.EntityNoleggioAuto;
import entity.EntityOptionalAuto;
import entity.EntityServizioAssicurativo;
import entity.EntityUtenteRegistrato;
import exceptions.EmailUtenteNonValida;

import exceptions.FormatoEmailNonValido;

public class ControllerUtenteRegistrato {
	
	//TODO Rendere Singleton
	
	
	
	private static ControllerUtenteRegistrato uniqueController;
	private EntityUtenteRegistrato utente ;
	private EntityNoleggioAuto noleggioAuto;
	
	
	
	
	
	
	
	
	
	
	
	public static ControllerUtenteRegistrato getIstanceImpl(EntityUtenteRegistrato utente) {
		
		
		//Funzione per la creazione di un istanza di controller utente registrato 
		
		
			uniqueController = new ControllerUtenteRegistrato(utente);
			
			
			return uniqueController;
				
		
	}
	
	
	


	public static ControllerUtenteRegistrato getIstance() {
		
		//Funzione per il l ' ottenimento di un istanza
		
			
		
		return uniqueController;
			
	
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private ControllerUtenteRegistrato(EntityUtenteRegistrato utente ) {
		// TODO Auto-generated constructor stub
		
		
		
		
			this.utente=utente;
			this.noleggioAuto= null;
		
	}
	
	public void IniziaNoleggio(	String dataRitiro , String dataConsegna ) {
		
		
		//Funzione per l ' inizializzazione di un noleggio Auto da salvare o cancellare 
		
		

		LocalDate  dataR =parsingDate(dataRitiro);
		LocalDate  dataC= parsingDate(dataConsegna);
		
		
		this.noleggioAuto = utente.IniziaNoleggio(dataR,dataC);
	
		
		
	}
	
	
	
	
	
	
	
	
	
	public   void SpecificServizioAssicurativo(int idServizioAssicurativo) {
		
		
		//Funzione per la specifica di un Servizio Assicurativo  nell istanza di noleggio auto 
		
		
		this.noleggioAuto.setServizioAssicurativo(new EntityServizioAssicurativo(idServizioAssicurativo));
		
		
	}
	
	
	public  void SpecificaOptionalAuto( int[] idOptional ) {
		//Funzione per la specifica di Optional Auto   nell istanza di noleggio auto 
		
		
		ArrayList<EntityOptionalAuto> optional =new ArrayList<>();
		
		
		
		System.out.println(idOptional.length);
		
		
		
		
		
		for (int id : idOptional) {
			
			optional.add(new EntityOptionalAuto(id));
		}
		
		
		
		
		
		
		
		this.noleggioAuto.setOptionalsAuto(optional);
			
		
			
	}
	
	
	
	
	
	
	
	
	public   void AggiungiGuidatore(String email ) throws FormatoEmailNonValido, EmailUtenteNonValida {
		//Funzione per l ' aggiunta di un guidatore controlla se l ' email è effettivamente registrata nel sistema 
		// in caso positivo vengono inseriti i dati in noleggia auto 
		
		
		if(!email.contains("@"))
			throw new FormatoEmailNonValido();
		
		
	
		
		EntityUtenteRegistrato guidatore =   EntityUtenteRegistrato.ControllaEsistenzaEmail(email);
		
		this.noleggioAuto.setGuidatoreSupplementare(guidatore);
		

	}
	
	
	
	
	public ArrayList<Hashtable<String, String>>  getOptionalsAuto() {
		//Restituisci una  una lista di attributi di optionalAuto  
		
		
			ArrayList<Hashtable<String, String>> accessoriHashtables = new ArrayList<>();
			
			
			ArrayList<EntityOptionalAuto>  catalogo =   EntityCatalogoAccessori.getOptionalAuto();
			
			
			
			for (EntityOptionalAuto entityOptionalAuto : catalogo) {
				
				
				accessoriHashtables.add(entityOptionalAuto.getAttribute());
				
				
				
				
				
				
			}
			
			
			
			
			
		
		
			return accessoriHashtables;
		
	}
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Hashtable<String, String>>  getServiziAssicurativi() {
		
		
		//Restituisci una  una lista di attributi di un servizio assicurativo 
		
		
		
		
		
		
			ArrayList<Hashtable<String, String>> accessoriHashtables = new ArrayList<>();
			
			
			ArrayList<EntityServizioAssicurativo>  catalogo =   EntityCatalogoAccessori.getServiziAssicurativi();
			
			
			
			for (EntityServizioAssicurativo entityServizioAssicurativo : catalogo) {
				
				
				accessoriHashtables.add(entityServizioAssicurativo.getAttribute());
				
				
				
				
			}
						
		
			return accessoriHashtables;
		
	}
	
	
	
	
	
	
	
	
	
	public void SpecificaAuto(int idAuto ) {
		
		//Crea un funzione  che collega al noleggio auto identificata con idAuto
		
		this.noleggioAuto.setAuto(new EntityAuto(idAuto));
	}
	

	
	public float CalcolaPrezzoNoleggio() {

		
		return this.noleggioAuto.CalcolaPrezzo();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public   void  ConfermaNoleggiaAuto() {
		
		
			//Funzione per la conferma di un noleggio Auto nel DB

			noleggioAuto.ConfermaNoleggio();
			noleggioAuto=null;
	
		
		
		
	}
	
	


	private static LocalDate parsingDate(String date) {
		
		//Converte una stringa in un tipo piu comodo 
	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 
		LocalDate newData =  LocalDate.parse(date, formatter);
		 
		
		return newData;
		

	}
	
	
	public   void CancellaNoleggiaAuto() {
		

		
		
			noleggioAuto=null;
	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
