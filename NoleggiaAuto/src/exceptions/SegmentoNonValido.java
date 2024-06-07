package exceptions;

public class SegmentoNonValido extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3356778675344716031L;
	
	
	public SegmentoNonValido() {
		// TODO Auto-generated constructor stub
		super();
	}
	

	@Override
	public String toString() {
		
		
		return "Codice Segmento non valido : Usare 0-small 1-medium 2-large";
	}
	

}
