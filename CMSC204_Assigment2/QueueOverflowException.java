/**
 * QueueOverflowException Class
 * occurs when a dequeue method is called on an empty queue
 * @author Elizabeth Perez
 *
 */
public class QueueOverflowException extends Exception{
	public QueueOverflowException() {
		super("This should have thrown an QueueOverflowException");
	}
	public QueueOverflowException (String message) {
		super(message);
	}
}
