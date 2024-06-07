package exceptions;

public class FormatoEmailNonValido extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1523646135434361168L;



	public FormatoEmailNonValido() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Formato dell' email non valida usa formato : example@gmail.com ";
	
	}

}
