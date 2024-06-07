package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;

import entity.EntityAuto;

import entity.EntityParcoAuto;
import entity.EntityUtenteRegistrato;
import exceptions.EmailUtenteNonValida;
import exceptions.NumeroPassegeriNonValido;
import exceptions.PotenzaMotoreNonValida;
import exceptions.PrezzoNonValido;
import exceptions.SegmentoNonValido;
import exceptions.TargaInvalida;
import exceptions.TipoAlimentazioneNonValido;

import java.text.ParseException;
import java.text.SimpleDateFormat;



public class NoleggiAutoController {
	
	
	
	
	private static NoleggiAutoController uniqueInstance;
	
	
	private NoleggiAutoController() {};
	
	
	public static NoleggiAutoController getInstance() {
		
		if( uniqueInstance == null) {
			uniqueInstance = new NoleggiAutoController();
		}
		
		return uniqueInstance;
		
	}
	
	
	
	
	
	public static void  Registrazione(String nome, String cognome , String email, int annoConseguimentoPatente , int annoScadenzaPatente, String numeroPatente  ) throws Exception {
			
		
		
		if(annoConseguimentoPatente <1900 || annoScadenzaPatente<1900)
			throw new Exception("anno Inserito non valido usare anno >1900");
		
		
		
		if (!(annoConseguimentoPatente<annoScadenzaPatente+10))
				throw new Exception("Anno di scadenza deve essere maggiore +10 di anno di Conseguimento  ");
		
		
		if (!email.contains("@"))
				throw new Exception("Formato email non valido ");
		
		
		if(nome.length()==1 ||  cognome.length()==1)
				throw new Exception("Lunghezza del congome o del nome invalida superare n di carratteri 1 ");

		
		if(numeroPatente.length()!=10)
			throw new Exception("Lunghezza di numero patente invalida inserire 10 caratteri ");
		
		
		
		
		
		
		
		
		
		
		
		
		
		EntityUtenteRegistrato utenteDaRegistrare = new EntityUtenteRegistrato();
		
		utenteDaRegistrare.setCognome(cognome);
		utenteDaRegistrare.setNome(nome);
		utenteDaRegistrare.setEmail(email);
		
		
		utenteDaRegistrare.setAnnoConseguimentoPatente(annoConseguimentoPatente);
		utenteDaRegistrare.setNumeroPatente(numeroPatente);
		utenteDaRegistrare.setAnnoScadenzaPatente(annoScadenzaPatente);
		
		utenteDaRegistrare.Registrazione();
	}
	
	

	public static ControllerUtenteRegistrato Autenticazione(String email) throws EmailUtenteNonValida    {
		
		 
	//Funzione per l autenticazione di un utente registrato che istanzia in caso positivo un controller per l utente registrato 
		
		ControllerUtenteRegistrato controller = ControllerUtenteRegistrato.getIstanceImpl( EntityUtenteRegistrato.Autenteticazione(email));
		
		return controller;
		
	}
	
	

	
	
	
	
	public static ArrayList<Hashtable<String,String>>  VisualizzaParcoAuto() throws Exception {
			
		
		//Funzione per la vista di attributi di auto 
		
		ArrayList<EntityAuto> cars = EntityParcoAuto.getAllCars();
		
		

		
		
			

		
		
		if(cars.isEmpty())
			throw new Exception("Non ci sono auto");
		
		
		
		
		ArrayList<Hashtable<String, String>>  attrCars=  new ArrayList<>();

		for (EntityAuto entityAuto : cars) {
			
			attrCars.add(entityAuto.getAttribute());
			//TODO mettere fare un HasTAble
		}
				
		
		
		
		
		
		
		
		
		return attrCars ;
	}
	
	
	
	
	
	

	
	
	public  static ArrayList<Hashtable<String, String>>  RicercaAuto(String dataRitiro , String dataConsegna , int segmento ) throws Exception {

		//Funzione che restituisce un lista di attributi di auto 
		
		
		if(segmento < 0 || segmento>2)
			throw new Exception("Segmento non valido");
		
		if(!isValidDate(dataConsegna)|| !isValidDate(dataRitiro)) {
			throw new Exception("Formato data non valida  yyyy-mm-dd");
		}
				
	
		LocalDate  dataR =parsingDate(dataRitiro);
		LocalDate  dataC= parsingDate(dataConsegna);
		
		
		
		if(dataR.isAfter(dataC)|| dataR.isEqual(dataC))
			throw new Exception("Intervallo non valido");
		
		 
		ArrayList<EntityAuto> autoDisponibili= EntityParcoAuto.RicercaAuto(dataR, dataC, segmento);
		
		
		if(autoDisponibili.size()==0)
			throw new Exception("Auto Non disponibili");
		
		ArrayList<Hashtable<String, String>>  attrCars=  new ArrayList<>();

		for (EntityAuto entityAuto : autoDisponibili) {
			
			attrCars.add(entityAuto.getAttribute());
			//TODO mettere fare un HasTAble
		}
				
		return attrCars ;
		
				
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static LocalDate parsingDate(String date) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 
		LocalDate newData =  LocalDate.parse(date, formatter);
		 
		
		return newData;
		

	}


	public static int ModificaDatiAuto(int idAuto , String targa, int numPostiPassengeri , float priceForDay ,
											String tipoDiAlimentazione, int potenzaMotore,int segmento, boolean InServizio) throws Exception {
		
		
		
		
		//funzione per la modifica Dati di un auto 
		
		
		
		if(targa.length()>=10 || targa.length() <0)
			throw  new TargaInvalida(targa);
		
		
		if(numPostiPassengeri<0)
			throw new NumeroPassegeriNonValido();
		
		if(priceForDay<0)
			throw new PrezzoNonValido();
		
		if(!(tipoDiAlimentazione.equals("benzina")|| tipoDiAlimentazione.equals("gasolio")))
			throw new TipoAlimentazioneNonValido();
			
		if(potenzaMotore<0)
			throw new PotenzaMotoreNonValida();
		
		if(segmento<0 || segmento>2)
			throw new SegmentoNonValido();
		
		
		
		
		
		
		
		
		
		
		
		
		
		EntityAuto auto = new EntityAuto();
		
		auto.setIdAuto(idAuto);
		auto.setInServizio(InServizio);
		auto.setSegmento(segmento);
		auto.setTarga(targa);
		auto.setPriceDay(priceForDay);
		auto.setNumPostiPassengeri(numPostiPassengeri);
		auto.setTipoAlimentazione(tipoDiAlimentazione);
		auto.setPotenzaMotore(potenzaMotore);
		
		return EntityParcoAuto.ModificaDatiAuto(auto);
	}
	
	
	
	
	
	
	public static  int AggiunggiDatiAuto(String targa, int numPostiPassengeri , float priceForDay , String tipoDiAlimentazione, int potenzaMotore,int segmento) throws Exception {
		
		
		//Funzione per l inserimento di dati 
		
		
		if(targa.length()>=10 || targa.length() <0)
			throw  new TargaInvalida(targa);
		
		
		if(numPostiPassengeri<0)
			throw new NumeroPassegeriNonValido();
		
		if(priceForDay<0)
			throw new PrezzoNonValido();
		
		if(!(tipoDiAlimentazione.equals("benzina")|| tipoDiAlimentazione.equals("gasolio")))
			throw new TipoAlimentazioneNonValido();
			
		if(potenzaMotore<0)
			throw new PotenzaMotoreNonValida();
		
		if(segmento<0 || segmento>2)
			throw new SegmentoNonValido();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		EntityAuto auto = new EntityAuto();
		
		auto.setInServizio(true);
		auto.setSegmento(segmento);
		auto.setTarga(targa);
		auto.setPriceDay(priceForDay);
		auto.setNumPostiPassengeri(numPostiPassengeri);
		auto.setTipoAlimentazione(tipoDiAlimentazione);
		auto.setPotenzaMotore(potenzaMotore);
				
		return EntityParcoAuto.AggiuigiDatiAuto(auto);
	}
	
	private static boolean isValidDate(String date ) {
		
		//Funzione di supporto per la validazione del formato di una data 
		
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        sdf.setLenient(false);

	        try {
	            sdf.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
		
	         }
	}
	  

}
