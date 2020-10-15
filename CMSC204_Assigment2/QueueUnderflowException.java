/**
 * QueueUnderflowException Class
 * occurs when a enqueue method is called on a full queue
 * @author Elizabeth Perez
 *
 */
public class QueueUnderflowException extends Exception{
	public QueueUnderflowException() {
		super("This should have thrown an QueueUnderflowException");
	}
	public QueueUnderflowException (String message) {
		super(message);
	}
}
