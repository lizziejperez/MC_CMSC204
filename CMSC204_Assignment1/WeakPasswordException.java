/**
 * WeakPasswordException Class
 * @author Elizabeth Perez
 *
 */
public class WeakPasswordException extends Exception{
	// constructors
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
	public WeakPasswordException (String message) {
		super(message);
	}
}