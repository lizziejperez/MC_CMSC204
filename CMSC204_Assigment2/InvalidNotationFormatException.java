/**
 * InvalidNotationFormatException Class
 * occurs when a Notation format is incorrect
 * @author Elizabeth Perez
 *
 */
public class InvalidNotationFormatException extends Exception{
	public InvalidNotationFormatException() {
		super("This should have thrown an InvalidNotationFormatException");
	}
	public InvalidNotationFormatException (String message) {
		super(message);
	}
}
