package exceptions;

public class PotenzaMotoreNonValida extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1908336834847879768L;

	
	public PotenzaMotoreNonValida() {
	
		super();
		
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Potenza motore non valida inserire una quantita >0";
	}
	
	
	
	
	
	
	
}
