package entity;


import java.util.ArrayList;
import database.CatalogoDAO;
import database.OptionalAutoDAO;
import database.ServizioAssicurativoDAO;

public class EntityCatalogoAccessori {

	
	
	public int idCatalogo;
	
	public ArrayList<EntityAccessorioAuto> accessoriAuto;

	public int getIdCatalogo() {
		return idCatalogo;
	}

	public void setIdCatalogo(int idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public ArrayList<EntityAccessorioAuto> getAccessoriAuto() {
		return accessoriAuto;
	}

	public void setAccessoriAuto(ArrayList<EntityAccessorioAuto> accessoriAuto) {
		this.accessoriAuto = accessoriAuto;
	}
	
	
	
	public static ArrayList<EntityServizioAssicurativo> getServiziAssicurativi(){
		
		//Funzione che restituisce una lista di servizi Assicurativi da DAO
		
		
		ArrayList<EntityServizioAssicurativo> serviziAssicurativi = new  ArrayList<>();
		
		CatalogoDAO catalogo = new CatalogoDAO();
		
		ArrayList<ServizioAssicurativoDAO> serviziDAO = catalogo.getListaServiziAssicurativi();
		
		for (ServizioAssicurativoDAO servizioAssicurativoDAO : serviziDAO) {
			
			serviziAssicurativi.add(new EntityServizioAssicurativo(servizioAssicurativoDAO));
			
			
		}
		
		
		
		return serviziAssicurativi;
	
		
	}
	
	
	
	public static ArrayList<EntityOptionalAuto> getOptionalAuto(){
		
		//Funzione che restituisce una lista di OptionaAuto da DAO
		
		
		
		ArrayList<EntityOptionalAuto> optionalAuto = new ArrayList<>();
		
		CatalogoDAO catalogo  = new CatalogoDAO();
		
		ArrayList<OptionalAutoDAO> optionalAutoDAOs = catalogo.getListaOptionalAuto();
		
		
		
		for (OptionalAutoDAO optionalAutoDAO : optionalAutoDAOs) {
			
			optionalAuto.add(new EntityOptionalAuto(optionalAutoDAO));
			
			
		}
		
		
		
		
		
		
		return optionalAuto;
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
