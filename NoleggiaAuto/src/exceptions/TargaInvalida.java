package exceptions;



public class TargaInvalida extends Exception{

	private static final long serialVersionUID = -5985520402913406303L;
	
	private String targa;
	
	//costruttore che prende in ingresso la targa fonte dell'errore
	public TargaInvalida(String targa) {
		this.targa=targa;
	}
	
	//metodo che mostra un messaggio di errore mostrando anche la targa che genera l'eccezione
	@Override
	public String toString() {
		return "Targa "+this.targa+" non valida";
	}
	
}
