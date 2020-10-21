import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Sorted Double Linked List Class: A generic class for a sorted double linked list of type T
 * @author Elizabeth Perez
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	private Comparator<T> comp;
	
	/**
	 * SortedDoubleLinkedList Constructor
	 * @param comparator
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		super();
		comp = comparator;
	}
	
	/**
	 * Adds data in the correct place in the sorted list
	 * @param data
	 * @return the list
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		// If this is the first entry
		if(head == null) {
			head = tail = new Node(data, null, null);
			size++;
			return this;
		}
		
		// If data is less than or equal to head's data
		if(comp.compare(data, head.data) <= 0) {
			Node n = new Node(data, head, null);
			head.changePrevious(n);
			head = n;
			size++;
			return this;
		}
		
		Node current = head;
		// while data is larger than current data
		while(comp.compare(data, current.data) > 0) {
			// if at tail / data is larger than tail's data
			if(current.next == null) {
				Node n = new Node(data, null, tail);
				tail.changeNext(n);
				tail = n;
				size++;
				return this;
			}
			current = current.next;
		}
		// if data is less than or equal to current's data
		Node n = new Node(data, current, current.previous);
		current.previous.changeNext(n);
		current.changePrevious(n);
		size++;
		return this;
	}
	
	/**
	 * Throws an UnsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Throws an UnsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Returns a list iterator for the list
	 * @return a list iterator
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
		return super.iterator();
	}
	
	/**
	 * Removes an element from the list
	 * @return the list
	 */
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		super.remove(data, comparator);
		return this;
	}
}
