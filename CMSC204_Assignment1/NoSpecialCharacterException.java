/**
 * NoSpecialCharacterException Class
 * @author Elizabeth Perez
 *
 */
public class NoSpecialCharacterException extends Exception{
	// constructors
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
	public NoSpecialCharacterException (String message) {
		super(message);
	}
}
