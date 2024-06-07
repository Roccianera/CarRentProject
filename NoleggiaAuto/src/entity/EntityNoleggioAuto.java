package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import database.NoleggioAutoDAO;
import database.OptionalAutoDAO;
import database.ServizioAssicurativoDAO;
import database.UtenteRegistratoDAO;

public class EntityNoleggioAuto {
	
	
	
	public int       idNoleggioAuto;
	
	public LocalDate dataRitiroAuto;
	public LocalDate dataConsengnaAuto;
	
	public float     prezzoTotaleNoleggio;
	
	public EntityAuto auto;
	
	public EntityUtenteRegistrato noleggiatore;
	public EntityUtenteRegistrato guidatoreSupplementare;
	
	public EntityServizioAssicurativo servizioAssicurativo;
	public ArrayList<EntityOptionalAuto> optionalsAuto;
	
	
	
	
	public EntityNoleggioAuto () {
		
		super();
		
		this.optionalsAuto = new ArrayList<>();
		guidatoreSupplementare= null;
		
		
		//Costruttore per istanziare un noleggio da salvare 
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public EntityNoleggioAuto(NoleggioAutoDAO noleggioAutoDAO) {
		
		//Costruttore per leggere dal DAO noleggi effettuati 
		
		guidatoreSupplementare= null;
		
		
		this.optionalsAuto= new ArrayList<>();
		
		this.dataConsengnaAutoFormattazione(noleggioAutoDAO.getDataConsegna());
		this.dataRitiroAutoFormattazione(noleggioAutoDAO.getDataRitiro());
		this.prezzoTotaleNoleggio= noleggioAutoDAO.getPrezzo();
		this.idNoleggioAuto= noleggioAutoDAO.getIdAuto();
		this.noleggiatore= new EntityUtenteRegistrato(noleggioAutoDAO.getIdUtente());
		this.auto = new EntityAuto(noleggioAutoDAO.getIdAuto());
		this.servizioAssicurativo= new EntityServizioAssicurativo(new ServizioAssicurativoDAO(noleggioAutoDAO.getIdServizioAssicurativo()) );
		
		noleggioAutoDAO.getListaOptionalAuto();
		
		caricaOptionalAuto(noleggioAutoDAO);
		
		
	}
	
	private void caricaOptionalAuto(NoleggioAutoDAO noleggioAutoDAO) {
		
		
		//Caricamento di optionAuto di un  noleggio auto 
		
		
		ArrayList<OptionalAutoDAO> optionalsDB = noleggioAutoDAO.getOptionalAuto();
		
		
		for (OptionalAutoDAO optionalAutoDAO : optionalsDB) {
			
			this.optionalsAuto.add(new EntityOptionalAuto(optionalAutoDAO));
			
		}
		
		
		
		
		
	}

	private void dataRitiroAutoFormattazione(String dataRitiro) {
		
		//Metodo per Convertire una Stringa in un LocalDate
		
		
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     this.dataRitiroAuto = LocalDate.parse(dataRitiro, formatter);
		
		
	}

	private void dataConsengnaAutoFormattazione(String dataConsegna) {
		//Metodo per Convertire una Stringa in un LocalDate
		
		
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    this.dataConsengnaAuto = LocalDate.parse(dataConsegna, formatter);
		
	}


	
	
	
	
	
	public int ConfermaNoleggio() {
		
		//Funzione per il caricamento di noleggia Auto nel DB
		
		
		int result =0;
		
		NoleggioAutoDAO noleggioDaSalvare = new NoleggioAutoDAO();
		
		
	
	
		this.idNoleggioAuto = NoleggioAutoDAO.getUniqueID();
		
	
			
		noleggioDaSalvare.setIdNoleggio(idNoleggioAuto);
		
	
	
		//Se non è presente un guidatore supplementare non inserirlo nel DAO
		
		if(this.guidatoreSupplementare!=null)
			noleggioDaSalvare.setIdGuidatoreSupplementare(this.guidatoreSupplementare.getIdUtenteRegistrato());
		
		
		
		
		noleggioDaSalvare.setIdUtente(this.noleggiatore.getIdUtenteRegistrato());
		noleggioDaSalvare.setPrezzo(CalcolaPrezzo());
		noleggioDaSalvare.setDataConsegna(dataConsengnaAuto.toString());
		noleggioDaSalvare.setDataRitiro(dataRitiroAuto.toString());
		noleggioDaSalvare.setIdAuto(this.auto.getIdAuto());
		noleggioDaSalvare.setIdServizioAssicurativo(this.servizioAssicurativo.getIdAccessorioAuto());
	

		
		
		 result = noleggioDaSalvare.create();
		//Se La creazione  è andata a buon fine 
		if(result !=-1) {
			//Assocazione di Optional  Auto di un noleggio 
			
			for (EntityOptionalAuto entityOptionalAuto : optionalsAuto) {
				
				noleggioDaSalvare.associaOptionalAutoNoleggio(entityOptionalAuto.getIdAccessorioAuto());
				
			}
			
			
			
		}
		
	
		
		
		return result;
	}
	
	
	public void  AggiungiGuidatore(String email) throws Exception{

		
		
		//Fumzione per il carimanento di un guidatore 
		if(!UtenteRegistratoDAO.checkEmail(email)) {
			throw  new Exception("Email guidatore supplementare non esistente ");
		}
		

		
		this.guidatoreSupplementare=new EntityUtenteRegistrato(email);
				
	
	}
	
	
	public float  CalcolaPrezzo() {
		
		//Funzione per il calcolo di prezzoTotale di un noleggio Auto 
		
		
		
		float prezzoNoleggio=0;
		
		//Calcolo della quantita di giorni prentotati per il noleggio 
		long  totalDaysNoleggio = this.dataRitiroAuto.until(dataConsengnaAuto, ChronoUnit.DAYS);	
		
		prezzoNoleggio+= this.auto.getPriceDay()*totalDaysNoleggio;
		
		
		for (EntityOptionalAuto optionalAuto : optionalsAuto) {
			
				prezzoNoleggio+=optionalAuto.getPrezzo();
		}
		
	
		
		
		return prezzoNoleggio;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getIdNoleggioAuto() {
		return idNoleggioAuto;
	}
	public void setIdNoleggioAuto(int idNoleggioAuto) {
		this.idNoleggioAuto = idNoleggioAuto;
	}
	
	public LocalDate getDataRitiroAuto() {
		return dataRitiroAuto;
	}
	public void setDataRitiroAuto(LocalDate dataRitiroAuto) {
		this.dataRitiroAuto = dataRitiroAuto;
	}
	
	public LocalDate getDataConsengnaAuto() {
		return dataConsengnaAuto;
	}
	public void setDataConsengnaAuto(LocalDate dataConsengnaAuto) {
		this.dataConsengnaAuto = dataConsengnaAuto;
	}
	
	public float getPrezzoTotaleNoleggio() {
		return prezzoTotaleNoleggio;
	}
	public void setPrezzoTotaleNoleggio(float prezzoTotaleNoleggio) {
		this.prezzoTotaleNoleggio = prezzoTotaleNoleggio;
	}
	
	public EntityAuto getAuto() {
		return auto;
	}
	public void setAuto(EntityAuto auto) {
		this.auto = auto;
	}
	
	public EntityUtenteRegistrato getNoleggiatore() {
		return noleggiatore;
	}
	public void setNoleggiatore(EntityUtenteRegistrato noleggiatore) {
		this.noleggiatore = noleggiatore;
	}
	
	public EntityUtenteRegistrato getGuidatoreSupplementare() {
		return guidatoreSupplementare;
	}
	public void setGuidatoreSupplementare(EntityUtenteRegistrato guidatoreSupplementare) {
		this.guidatoreSupplementare = guidatoreSupplementare;
	}
	
	public EntityServizioAssicurativo getServizioAssicurativo() {
		return servizioAssicurativo;
	}
	public void setServizioAssicurativo(EntityServizioAssicurativo servizioAssicurativo) {
		this.servizioAssicurativo = servizioAssicurativo;
	}
	
	public ArrayList<EntityOptionalAuto> getOptionalsAuto() {
		return optionalsAuto;
	}
	public void setOptionalsAuto(ArrayList<EntityOptionalAuto> optionalsAuto) {
		this.optionalsAuto = optionalsAuto;
	}
	
	

	
	
	
	
	
	
	

}
