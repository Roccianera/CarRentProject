

package exceptions;







public class NumeroPatenteInvalido extends Exception {

	private static final long serialVersionUID = -4125845383690590818L;
	
	private String numeroPatente;
	
	//costruttore
	public NumeroPatenteInvalido(String numeroPatente) {
		this.numeroPatente=numeroPatente;
	}
	
	
	//metodo che mostra un messaggio di errore mostrando anche la targa che genera l'eccezione
	@Override
	public String toString() {
			return "Numero patente "+this.numeroPatente+" non valido!";
	}
	
	/*Facoltativamente
	 * TODO inserire poi un controllo non qui ma nel package controller che controlla che 
	 * il numero di patente sia del tipo : U1 + 7 caratteri alfanumerici + un carattere alfabetico di controllo
	 */

}
