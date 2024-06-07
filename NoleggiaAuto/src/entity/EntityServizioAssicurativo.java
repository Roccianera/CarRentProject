package entity;

import database.ServizioAssicurativoDAO;

public class EntityServizioAssicurativo extends EntityAccessorioAuto {

	public EntityServizioAssicurativo(ServizioAssicurativoDAO servizio) {

		this.idAccessorioAuto = servizio.getId();
		this.prezzo= servizio.getPrezzoPrefissato();
		this.descrizioneTestuale =servizio.getDescrizione();
		
	}
	public EntityServizioAssicurativo(int id ) {
		
		ServizioAssicurativoDAO servizio = new ServizioAssicurativoDAO(id);
		this.idAccessorioAuto = servizio.getId();
		this.prezzo= servizio.getPrezzoPrefissato();
		this.descrizioneTestuale =servizio.getDescrizione();
		
		
		
	}


}
