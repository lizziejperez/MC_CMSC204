/**
 * NoUpperAlphaException Class
 * @author Elizabeth Perez
 *
 */
public class NoUpperAlphaException extends Exception{
	// constructors
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
	public NoUpperAlphaException (String message) {
		super(message);
	}
}