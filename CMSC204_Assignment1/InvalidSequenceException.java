/**
 * InvalidSequenceException Class
 * @author Elizabeth Perez
 *
 */
public class InvalidSequenceException extends Exception{
	// constructors
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
	public InvalidSequenceException (String message) {
		super(message);
	}
}