package exceptions;

public class EmailUtenteNonValida extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1496482718354081155L;
	
	
	public EmailUtenteNonValida() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "L' email Selezionata non trova all' interno del sistema ";
	}
	
	

}
