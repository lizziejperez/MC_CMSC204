import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Basic Double Linked List Class: A generic class for a double linked list of type T
 * @author Elizabeth Perez
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {
	/**
	 * Node Class: A double linked node
	 */
	public class Node {
		public T data;
		public Node next;
		public Node previous;
		
		/**
		 * Node Constructor
		 * @param dataEntry
		 * @param nextNode
		 * @param previousNode
		 */
		public Node(T dataEntry, Node nextNode, Node previousNode) {
			data = dataEntry;
			next = nextNode;
			previous = previousNode;
		}
		
		/**
		 * Changes next value of the node
		 * @param n - the new next node
		 */
		public void changeNext(Node n) {
			next = n;
		}
		
		/**
		 * Changes previous value of the node
		 * @param n- the new previous node
		 */
		public void changePrevious(Node n) {
			previous = n;
		}
	}
	
	public Node head; // reference to the first element of the list
	public Node tail; // reference to the last element of the list
	public int size; // size of list
	
	/**
	 * BasicDoubleLinkedList Constructor
	 */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Basic Linked List Iterator Class
	 */
	private class basicLLIterator implements ListIterator<T> {		
		private int cursor;
		private ArrayList<T> list;
		
		/**
		 * basicLLIterator Constructor
		 */
		public basicLLIterator() {
			cursor = 0;
			list = toArrayList();
		}
		
		/**
		 * Returns true if this list iterator has more elements when traversing the list in the forward direction
		 * @return if there is a next element
		 */
		public boolean hasNext() {
			if(cursor < list.size()) {
				return true;
			} else {
				return false;
			}
		}
		
		/**
		 * Returns the next element in the list and advances the cursor position
		 * @return the next element
		 */
		public T next() throws NoSuchElementException{
			if(hasNext()) {
				T element = list.get(cursor);
				cursor++;
				return element;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		/**
		 * Returns true if this list iterator has more elements when traversing the list in the backwards direction
		 * @return if there is a previous element
		 */
		public boolean hasPrevious() {
			if(cursor > 0) {
				return true;
			} else {
				return false;
			}
		}
		
		/**
		 * Returns the previous element in the list and moves the cursor position backwards
		 * @return previous element
		 */
		public T previous() throws NoSuchElementException {
			if(hasPrevious()) {
				cursor--;
				T element = list.get(cursor);
				return element;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		/**
		 * Throws an UnsupportedOperationException
		 */
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		/**
		 * Throws an UnsupportedOperationException
		 */
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		/**
		 * Throws an UnsupportedOperationException
		 */
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		 /**
		  * Throws an UnsupportedOperationException
		  */
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		/**
		 * Throws an UnsupportedOperationException
		 */
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * Add an element to the end of the list
	 * @param data - the data for the Node within the linked list
	 * @return the list
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		if(tail == null) {
			tail = head = new Node(data, null, null);
		} else {
			Node old = tail;
			tail = new Node(data, null, old);
			old.changeNext(tail);
			
		}
		size++;
		return this;
	}
	
	/**
	 * Add an element to the front of the list
	 * @param data
	 * @return the list
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		if(head == null) {
			head = tail = new Node(data, null, null);
		} else {
			Node old = head;
			head = new Node(data, old, null);
			old.changePrevious(head);
		}
		size++;
		return this;
	}
	
	/**
	 * Returns but does not remove the first element from the list
	 * @return the data element or null
	 */
	public T getFirst() {
		return head.data;
	}
	
	/**
	 * Returns but does not remove the last element from the list
	 * @return the data element or null
	 */
	public T getLast() {
		return tail.data;
	}
	
	/**
	 * Returns the size of the list
	 * @return the size of of the linked list
	 */
	public int getSize() {
		return size;
	}
	
	
	/**
	 * Returns a list iterator for the list
	 * @return list iterator
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
		return new basicLLIterator();
	}
	
	/**
	 * Removes the first instance of the targetData from the list
	 * @return the list
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		if(comparator.compare(targetData, head.data) == 0) {
			head = new Node(head.next.data, head.next.next, null);
			size--;
			return this;
		}
		
		Node current = head;
		while(comparator.compare(targetData, current.data) != 0) {
			if(current.next == null) {
				return null;
			} else {
				current = current.next;
			}
		}
		
		if(current.next == null) {
			current.previous.changeNext(null);
			tail = current.previous;
			size--;
			return this;
		}
		
		current.previous.changeNext(current.next);
		current.next.changePrevious(current.previous);
		current = null;
		size--;
		
		return this;
	}
	
	/**
	 * Removes and returns the first element from the list
	 * @return the first element
	 */
	public T retrieveFirstElement() {
		T firstElement = head.data;
		head = new Node(head.next.data, head.next.next, null);
		size--;
		return firstElement;
	}
	
	/**
	 * Removes and returns the last element from the list
	 * @return the last element
	 */
	public T retrieveLastElement() {
		T lastElement = tail.data;
		tail = new Node(tail.previous.data, null, tail.previous.previous);
		size--;
		return lastElement;
	}
	
	/**
	 * Returns an array list of the items in the list from head of list to tail of list
	 * @return array list of the list
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> list = new ArrayList<T>();
		Node n = head;
		while(n.next != null) {
			list.add(n.data);
			n = n.next;
		}
		list.add(tail.data);
		return list;
	}
	
}
