package entity;

import java.time.LocalDate;
import java.util.ArrayList;

import database.AutoDAO;
import database.ParcoAutoDAO;

public class EntityParcoAuto {

	
	
	
	
	public int idParcoAuto;
	
	public ArrayList<EntityAuto> cars;
		
	
	
	
	
	
	
	public static ArrayList<EntityAuto> getCars(int segmento){
		
		
		
			//Funzione utilizzata per ritornare una lista di Auto presi nel DB per segmento 
		
		
		ArrayList<EntityAuto> entitaAuto = new ArrayList<>();
		
		
		ParcoAutoDAO parco = new ParcoAutoDAO();
		
		
		ArrayList<AutoDAO> cars = parco.getListaAuto(segmento);
		
		for (AutoDAO autoDAO : cars) {
			
			entitaAuto.add(new EntityAuto(autoDAO));
			
		}
		
		
		return entitaAuto;
		
		
		
		
	}
	
		
	
	
	public static ArrayList<EntityAuto> RicercaAuto(LocalDate dataRitiroAuto , LocalDate dataConsegnaAuto , int segmento ) {	
		
		
		
		//Funzione per la ricerca di Auto nel dB
		
		//C è prima una fase di cariamento nel db delle auto per segmento 
		
		
		ArrayList<EntityAuto> allCars = getCars(segmento);
		ArrayList<EntityAuto> autodisponibili = new ArrayList<>(); 
		
		//Seguita da una fase di controllo della disponibilita ogni singola auto 

		
		for (EntityAuto auto : allCars) {
			
			
			
			if(auto.VerificaDisponiblita(dataRitiroAuto, dataConsegnaAuto)) {
				
				autodisponibili.add(auto);
			}	
			
			
			
		}
		

			
		
		
		
		return autodisponibili ;
	}
	
	
	public static  ArrayList<EntityAuto> getAllCars(){
		
		
		ArrayList<EntityAuto> entitaAuto = new ArrayList<>();
		
		
		ParcoAutoDAO parco = new ParcoAutoDAO();
		
		
		ArrayList<AutoDAO> cars = parco.getListaAuto();
		
		for (AutoDAO autoDAO : cars) {
			
			entitaAuto.add(new EntityAuto(autoDAO));
			
		}
		
		
		return entitaAuto;
		
		
		
	}
	
	
	
	
	
	public static  int  AggiuigiDatiAuto(EntityAuto auto) {
		
		
		//Funzione per il caricamento nel DB di un auto 
		

		
		int result =0;
		
		auto.setIdAuto(AutoDAO.getUniqueID());
		//Creazione di un ID univoco 
		
				
		AutoDAO autoDao = new AutoDAO();
		
		
		
		autoDao.setIdAuto(auto.getIdAuto());
		autoDao.setInServizio(auto.isInServizio());
		autoDao.setNumPostiPasseggeri(auto.getNumPostiPassengeri());
		autoDao.setPotenzaMotore(auto.getPotenzaMotore());
		autoDao.setPriceDay(auto.getPriceDay());
		autoDao.setSegmento(auto.getSegmento());
		autoDao.setTarga(auto.getTarga());
		autoDao.setTipoAlimentazione(auto.tipoAlimentazione);
					
		
				
		result = autoDao.create();	
		
		return result;
		
		
		
	}
	
	public  static int ModificaDatiAuto(EntityAuto auto) {
		//Funzione per la modifica di dai di un auto gia presente all interno del DB 
		
		int result =0;
		
		
		AutoDAO autoDao = new AutoDAO();

		autoDao.setIdAuto(auto.getIdAuto());
		autoDao.setInServizio(auto.isInServizio());
		autoDao.setNumPostiPasseggeri(auto.getNumPostiPassengeri());
		autoDao.setPotenzaMotore(auto.getPotenzaMotore());
		autoDao.setPriceDay(auto.getPriceDay());
		autoDao.setSegmento(auto.getSegmento());
		autoDao.setTarga(auto.getTarga());
		autoDao.setTipoAlimentazione(auto.tipoAlimentazione);
		result = autoDao.update();	
		
		return result;
		
		
		
		
	}

		

		

	

	
	
	
	
	
	
}
