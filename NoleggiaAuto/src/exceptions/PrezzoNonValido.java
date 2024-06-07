package exceptions;

public class PrezzoNonValido  extends Exception{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6892108007805681438L;




	public PrezzoNonValido() {
	
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Prezzo non valido  inserire una quantita maggiore di >0";
	}
	
	
	
	
	
}
