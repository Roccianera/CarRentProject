package entity;

import java.util.Hashtable;

public abstract class EntityAccessorioAuto {
	
	
	public static final String SERVIZIO_ASSICURATIVO ="servizioAssicurativo";
	public static final String OPTIONAL="optionalAuto";
		
	
	public int idAccessorioAuto ;
	public float prezzo ;
	public String descrizioneTestuale;

	
	
	
	
	public int getIdAccessorioAuto() {
		return idAccessorioAuto;
	}
	public void setIdAccessorioAuto(int idAccessorioAuto) {
		this.idAccessorioAuto = idAccessorioAuto;
	}
	
	
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getDescrizioneTestuale() {
		return descrizioneTestuale;
	}
	public void setDescrizioneTestuale(String descrizioneTestuale) {
		this.descrizioneTestuale = descrizioneTestuale;
	}
	

	
	
	public Hashtable<String, String> getAttribute() {
		
		
		Hashtable<String , String > hashtable = new Hashtable<>();
		
		 
		
		
		hashtable.put("price", Float.toString(prezzo));
		hashtable.put("text", descrizioneTestuale);
		hashtable.put("id", Integer.toString(idAccessorioAuto));
		
	
		
		return hashtable;
	}
	
	
	
	
	
	
	
	
	

}
