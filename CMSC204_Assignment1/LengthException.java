/**
 * LengthException Class
 * @author Elizabeth Perez
 *
 */
public class LengthException extends Exception{
	// constructors
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
	public LengthException (String message) {
		super(message);
	}
}
