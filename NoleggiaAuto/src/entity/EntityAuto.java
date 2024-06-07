package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;

import database.AutoDAO;
import database.NoleggioAutoDAO;


public class EntityAuto {
	
	
	public static final int SMALL_SEGMENTO=0;
	public static final int MEDIUM_SEGMENTO=1;
	public static final int LARGE_SEGMENTO=2;
			
	
	public int    idAuto;
	public String targa;
	public int    numPostiPassengeri;
	public float  priceDay;
	public String tipoAlimentazione;
	public int    potenzaMotore;
	public boolean isInServizio;
	public int segmento;

		
	
	public EntityAuto() {
		super();
		

	}
	
		
	
	
	public EntityAuto(int  idAuto) {

		
		//Costruttore per la lettura di un auto dal DB
		
		AutoDAO auto= new AutoDAO(idAuto);
		

		
		this.idAuto =auto.getIdAuto();
		this.targa= auto.getTarga();
		this.numPostiPassengeri= auto.getNumPostiPasseggeri();
		this.isInServizio = auto.isInServizio();
		this.potenzaMotore= auto.getPotenzaMotore();
		this.tipoAlimentazione = auto.getTipoAlimentazione();
		this.priceDay = auto.getPriceDay();
		this.segmento = auto.getSegmento();

						
	
	}
	
	
	public EntityAuto(AutoDAO auto) {
		
		//Costruttore per la lettura di un auto dal DB
		
		
		this.idAuto =auto.getIdAuto();
		this.targa= auto.getTarga();
		this.numPostiPassengeri= auto.getNumPostiPasseggeri();
		this.isInServizio = auto.isInServizio();
		this.potenzaMotore= auto.getPotenzaMotore();
		this.tipoAlimentazione = auto.getTipoAlimentazione();
		this.priceDay = auto.getPriceDay();
		this.segmento = auto.getSegmento();

		
	
		
	}
	
		
	
	
	

	
	private ArrayList<EntityNoleggioAuto> caricaNoleggiAuto(AutoDAO auto) {
		
		
		//Funzione che si occupa di fare una richiesta al corrispodente DAO per Avere il piano di noleggi di un auto 


		auto.readNoleggiAuto();
		ArrayList<NoleggioAutoDAO> noleggiDB = auto.getNoleggiAuto();
	
		ArrayList<EntityNoleggioAuto> noleggiAuto = new  ArrayList<>();
	
	
		
		
		
		
		for (NoleggioAutoDAO noleggioAutoDAO : noleggiDB) {
			
				noleggiAuto.add(new EntityNoleggioAuto(noleggioAutoDAO));
				
			
		}
		
				
		return noleggiAuto;
		
	}
	
	
	
	
	
	public boolean  VerificaDisponiblita(LocalDate dataRitiro , LocalDate dataConsegna) {
		
		
		
		//Funzione che verifica la disponibilita di un auto nell intervallo di tempo scelto dall utente 
		
		
		
		if(isInServizio==false)
				return false;
		
		
		
		ArrayList<EntityNoleggioAuto> noleggiAuto =  caricaNoleggiAuto(new AutoDAO(idAuto));
		
		
		
		
		
		//Dopo avere caricato i noleggi dell ' auto controllo per ogni noleggio previsto se quest ultimo si sovrappone all' intevallo interssato 
					
		
		for (EntityNoleggioAuto noleggio : noleggiAuto) {
			
			
			LocalDate dataRitiroNoleggio = noleggio.getDataRitiroAuto();
			LocalDate dataConsegnaNoleggio = noleggio.getDataConsengnaAuto();
			
			if(!(   dataConsegnaNoleggio.isBefore(dataRitiro)       ||  dataRitiroNoleggio.isAfter(dataConsegna)   )) {
				
				return false;
				
				}
			
			}	
		
			
		return true ;
					
			
		
		
		
	}
	
	






	public int getSegmento() {
		return segmento;
	}
	public void setSegmento(int segmento) {
		this.segmento = segmento;
	}
	
	public int getIdAuto() {
		return idAuto;
	}
	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}
	
	
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	
	public int getNumPostiPassengeri() {
		return numPostiPassengeri;
	}
	public void setNumPostiPassengeri(int numPostiPassengeri) {
		this.numPostiPassengeri = numPostiPassengeri;
	}
	
	
	
	public float getPriceDay() {
		return priceDay;
	}
	public void setPriceDay(float priceDay) {
		this.priceDay = priceDay;
	}
	
	
	public String getTipoAlimentazione() {
		return tipoAlimentazione;
	}
	public void setTipoAlimentazione(String tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}
	
	
	
	public int getPotenzaMotore() {
		return potenzaMotore;
	}
	public void setPotenzaMotore(int potenzaMotore) {
		this.potenzaMotore = potenzaMotore;
	}
	
	
	public boolean isInServizio() {
		return isInServizio;
	}
	public void setInServizio(boolean isInServizio) {
		this.isInServizio = isInServizio;
	}
	
	


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " [idAuto: " + Integer.toString(idAuto)+" , targa: " +targa +", Passengeri Trasportabili : " +numPostiPassengeri +
				
				",Prezzo Giornaliero : "+ priceDay +", Potenza del motore : "+ Integer.toString(potenzaMotore) +" , Segmento: " + Integer.toString(segmento)
				
					+",In Servizio : "+isInServizio+" ]";
	}
	
	
	public Hashtable<String, String> getAttribute(){
		
		
		//Funzione che restituisce un hashteble in modo tale dal potere selezionare gli attributti interssati 
		
		Hashtable<String, String> attr = new Hashtable<>();
		
		
		attr.put("idAuto", Integer.toString(idAuto));
		attr.put("targa", targa);
		attr.put("tipoAlimentazione", tipoAlimentazione);
		attr.put("prezzo", Float.toString(this.priceDay));
		attr.put("isInServizio", Boolean.toString(isInServizio));
		attr.put("potenzaMotore", Integer.toString(this.potenzaMotore));
		attr.put("numeroPostiPassengeri", Integer.toString(numPostiPassengeri));
		attr.put("segmento",Integer.toString(segmento));
		
		
		
		return attr;
		
		
		
		
		
		
	}
	
	
	

	

}
