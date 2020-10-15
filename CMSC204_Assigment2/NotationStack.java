import java.util.ArrayList;
/**
 * NotationStack class
 * @author Elizabeth Perez
 *
 * @param <T>
 */
public class NotationStack<T> implements StackInterface<T> {
	private final T[] stack;
	private int top;
	private int arraySize;
	private static final int DEFAULT_SIZE = 10;
	
	/**
	 * Default constructor
	 * uses default as the size of the stack
	 */
	public NotationStack() {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[DEFAULT_SIZE];
		stack = tempStack;
		top = -1;
		arraySize = DEFAULT_SIZE;
	}
	
	/**
	 * Constructor
	 * takes in an int as the size of the stack
	 * @param size
	 */
	public NotationStack(int size) {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[size];
		stack = tempStack;
		top = -1;
		arraySize = size;
	}
	
	/**
	 * Constructor
	 * takes an ArrayList as a parameter, and fills the Stack with the elements of the ArrayList
	 * @param list
	 */
	public NotationStack(ArrayList<T> list) {
		ArrayList<T> listCopy = new ArrayList<T>();
		for(int i = 0; i < list.size(); i++) {
			listCopy.add(list.get(i));
		}
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[listCopy.size()];
		stack = tempStack;
		top = list.size()-1;
		arraySize = listCopy.size();
		for(int i = 0; i < arraySize; i++) {
			stack[i] = listCopy.get(i);
		}
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		if(top == (arraySize-1)) {
			return true;
		} else {
			return false;
		}
	}
	

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	public T pop() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		T element = stack[top];
		stack[top] = null;
		top--;
		return element;
		
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	public T top() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		return stack[top];
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {
		return top+1;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(T e) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		top++;
		stack[top] = e;
		if(stack[top] == e) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		String data = "";
		for(int i = 0; i <= top; i++) {
			data += stack[i];
		}
		return data;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter) {
		String data = "";
		for(int i = 0; i <= top; i++) {
			if(i == top) {
				data += stack[i];
			} else {
				data += stack[i] + delimiter;
			}
		}
		
		return data;
	}
}
