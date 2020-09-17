/**
 * NoLowerAlphaException Class
 * @author Elizabeth Perez
 *
 */
public class NoLowerAlphaException extends Exception{
	// constructors
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}
	public NoLowerAlphaException (String message) {
		super(message);
	}
}