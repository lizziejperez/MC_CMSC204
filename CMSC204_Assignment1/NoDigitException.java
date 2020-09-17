/**
 * NoDigitException Class
 * @author Elizabeth Perez
 *
 */
public class NoDigitException extends Exception {
	// constructors
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
	public NoDigitException (String message) {
		super(message);
	}
 }
