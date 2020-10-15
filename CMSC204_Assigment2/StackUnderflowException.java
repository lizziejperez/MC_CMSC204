/**
 * StackUnderflowException Class
 * occurs when a top or pop method is called on an empty stack
 * @author Elizabeth Perez
 *
 */
public class StackUnderflowException extends Exception{
	public StackUnderflowException() {
		super("This should have thrown a StackUnderflowException");
	}
	public StackUnderflowException (String message) {
		super(message);
	}
}
