package entity;


import database.OptionalAutoDAO;

public class EntityOptionalAuto  extends EntityAccessorioAuto {

	public EntityOptionalAuto(OptionalAutoDAO optionalAutoDAO) {
		//Costruttore per il caricamento del Dao 
		this.idAccessorioAuto = optionalAutoDAO.getId();
		this.prezzo= optionalAutoDAO.getPrezzoPrefissato();
		this.descrizioneTestuale =optionalAutoDAO.getDescrizione();
	}
	
	public EntityOptionalAuto(int id ) {
		
		//Costruttore per il caricamento del Dao 
		
		OptionalAutoDAO optionalAutoDAO = new OptionalAutoDAO(id);


		this.idAccessorioAuto = optionalAutoDAO.getId();
		this.prezzo= optionalAutoDAO.getPrezzoPrefissato();
		this.descrizioneTestuale =optionalAutoDAO.getDescrizione();
		
	}



}
