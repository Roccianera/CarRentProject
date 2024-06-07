package exceptions;



public class FormatoDataNonValido extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1657602556576124666L;
	
	
	public FormatoDataNonValido() {
		super();
	}


	@Override
	public String toString() {
		
		
		return "Formato data non valito usa il formato :  YYYY-MM-DD";
	}
	
	
	

}
