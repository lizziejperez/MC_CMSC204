/**
 * StackOverflowException Class
 * occurs when a push method is called on a full stack
 * @author Elizabeth Perez
 *
 */
public class StackOverflowException extends Exception{
	public StackOverflowException() {
		super("This should have thrown a StackOverflowException");
	}
	public StackOverflowException (String message) {
		super(message);
	}
}
