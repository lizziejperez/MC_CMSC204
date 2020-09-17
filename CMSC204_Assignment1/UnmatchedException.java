/**
 * UnmatchedException Class
 * @author Elizabeth Perez
 *
 */
public class UnmatchedException extends Exception{
	// constructors
	public UnmatchedException() {
		super("The passwords do not match");
	}
	public UnmatchedException (String message) {
		super(message);
	}
}