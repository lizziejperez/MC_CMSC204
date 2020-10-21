import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BDLL_STUDENT_Test {
	BasicDoubleLinkedList<String> one;
	BasicDoubleLinkedList<Double> two;
	
	StringComparator compOne;
	DoubleComparator compTwo;
	
	@BeforeEach
	void setUp() throws Exception {
		one = new BasicDoubleLinkedList<String>();
		one.addToEnd("yes");
		one.addToEnd("no");
		compOne = new StringComparator();
		
		two = new BasicDoubleLinkedList<Double>();
		two.addToEnd(10.0);
		two.addToEnd(20.0);
		compTwo = new DoubleComparator();
	}

	@AfterEach
	void tearDown() throws Exception {
		one = null;
		two = null;
		compOne = null;
		compTwo = null;
	}
	
	@Test
	public void testGetSize() {
		assertEquals(2, one.getSize());
		assertEquals(2, two.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		one.addToEnd("maybe");
		assertEquals("maybe", one.getLast());
		
		two.addToEnd(30.0);
		assertEquals(30.0, two.getLast());
	}
	
	@Test
	public void testAddToFront() {
		one.addToFront("so");
		assertEquals("so", one.getFirst());
		
		two.addToFront(5.0);
		assertEquals(5.0, two.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("yes", one.getFirst());
		assertEquals(10.0, two.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("no", one.getLast());
		assertEquals(20.0, two.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<String> list;
		one.addToFront("so");
		one.addToEnd("maybe");
		list = one.toArrayList();
		assertEquals("so",list.get(0));
		assertEquals("yes",list.get(1));
		assertEquals("no",list.get(2));
		assertEquals("maybe",list.get(3));
	}
	
	@Test
	public void testRemove() {
		one.remove("no", compOne);
		assertEquals(1, one.getSize());
		assertEquals("yes", one.getLast());
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals("yes", one.retrieveFirstElement());
		assertEquals(10.0, two.retrieveFirstElement());
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("no", one.retrieveLastElement());
		assertEquals(20.0, two.retrieveLastElement());
	}
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}

}
