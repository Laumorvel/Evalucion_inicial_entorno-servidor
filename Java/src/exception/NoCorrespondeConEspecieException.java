package exception;

public class NoCorrespondeConEspecieException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoCorrespondeConEspecieException() {
		super("La especie introducida no se corresponde con ninguna de las especies registradas que trata la clínica.");

	}

}
