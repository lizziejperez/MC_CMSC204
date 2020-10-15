import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T> {
	private final T[] queue;
	private int frontIndex;
	private int backIndex;
	private int arraySize;
	private static final int DEFAULT_SIZE = 10;
	
	/**
	 * Default constructor
	 * uses default as the size of the queue
	 */
	public NotationQueue(int size) {
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[size];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = 0;
		arraySize = size;
	}
	
	/**
	 * Constructor
	 * takes in an int as the size of the queue
	 * @param size
	 */
	public NotationQueue() {
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[DEFAULT_SIZE];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = 0;
		arraySize = DEFAULT_SIZE;
	}
	
	/**
	 * Constructor
	 * takes an ArrayList as a parameter, and fills the Queue with the elements of the ArrayList
	 * @param list
	 */
	public NotationQueue(ArrayList<T> list) {
		ArrayList<T> listCopy = new ArrayList<T>();
		for(int i = 0; i < list.size(); i++) {
			listCopy.add(list.get(i));
		}
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[listCopy.size()];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = listCopy.size()-1;
		arraySize = listCopy.size();
		for(int i = 0; i < arraySize; i++) {
			queue[i] = listCopy.get(i);
		}
	}
	

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {
		for(int i = 0; i < arraySize; i++) {
			if(queue[i] != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Determines of the Queue is empty
	 * @return
	 */
	public boolean isFull() {
		for(int i = 0; i < arraySize; i++) {
			if(queue[i] == null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T element = queue[frontIndex];
		queue[frontIndex] = null;
		frontIndex = (frontIndex + 1)%arraySize;
		if(queue[frontIndex] == null) {
			queue[backIndex] = null;
		}
		
		return element;
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		
		int size = 1;
		if(frontIndex < backIndex) {
			size += backIndex - frontIndex;
		} else if(frontIndex > backIndex){
			size += arraySize - frontIndex + backIndex;
		}
		return size;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(T e) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		
		if(isEmpty()) {
			queue[frontIndex] = e;
		} else {
			backIndex = (backIndex + 1)%arraySize;
			queue[backIndex] = e;
		}
		
		if(queue[backIndex] == e) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		String data = "";
		
		for(int i = 0; i < size(); i++) {
			data += queue[(frontIndex + i)%arraySize];
		}
		return data;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		String data = "";
		for(int i = 0; i < size()-1; i++) {
			data += queue[(frontIndex + i)%arraySize] + delimiter;
		}
		data += queue[backIndex];
		return data;
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  */
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy = new ArrayList<T>();
		for(int i = 0; i < list.size(); i++) {
			listCopy.add(list.get(i));
		}
		frontIndex = 0;
		backIndex = listCopy.size()-1;
		for(int i = 0; i < arraySize; i++) {
			queue[i] = listCopy.get(i);
		}
	}

}

