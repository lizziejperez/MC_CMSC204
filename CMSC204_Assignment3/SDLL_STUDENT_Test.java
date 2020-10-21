import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SDLL_STUDENT_Test {
	SortedDoubleLinkedList<String> one;
	SortedDoubleLinkedList<Double> two;
	
	StringComparator compOne;
	DoubleComparator compTwo;
	
	@BeforeEach
	void setUp() throws Exception {
		compOne = new StringComparator();
		one = new SortedDoubleLinkedList<String>(compOne);
		
		compTwo = new DoubleComparator();
		two = new SortedDoubleLinkedList<Double>(compTwo);
	}

	@AfterEach
	void tearDown() throws Exception {
		compOne = null;
		compTwo = null;

		one = null;
		two = null;
	}
	
	@Test
	public void testAdd() {
		one.add("B");
		one.add("A");
		one.add("C");
		assertEquals(3, one.getSize());
		ArrayList<String> listOne = one.toArrayList();
		assertEquals("A", listOne.get(0));
		assertEquals("B", listOne.get(1));
		assertEquals("C", listOne.get(2));
		
		two.add(3.0);
		two.add(2.5);
		two.add(1.3);
		assertEquals(3, two.getSize());
		ArrayList<Double> listTwo = two.toArrayList();
		assertEquals(1.3, listTwo.get(0));
		assertEquals(2.5, listTwo.get(1));
		assertEquals(3.0, listTwo.get(2));
	}
	
	@Test
	public void testIterator() {
		one.add("B");
		one.add("A");
		one.add("C");
		ListIterator<String> iteratorOne = one.iterator();
		assertEquals(true, iteratorOne.hasNext());
		assertEquals("A", iteratorOne.next());
		assertEquals("B", iteratorOne.next());
		assertEquals(true, iteratorOne.hasPrevious());
		assertEquals("B", iteratorOne.previous());
		
		two.add(3.0);
		two.add(2.5);
		two.add(1.3);
		ListIterator<Double> iteratorTwo = two.iterator();
		assertEquals(true, iteratorTwo.hasNext());
		assertEquals(1.3, iteratorTwo.next());
		assertEquals(2.5, iteratorTwo.next());
		assertEquals(3.0, iteratorTwo.next());
		assertEquals(true, iteratorTwo.hasPrevious());
		assertEquals(3.0, iteratorTwo.previous());
	}
	
	@Test
	void testRemove() {
		one.add("B");
		one.add("A");
		one.add("C");
		assertEquals(3, one.getSize());
		one.remove("B", compOne);
		assertEquals(2, one.getSize());
		ArrayList<String> listOne = one.toArrayList();
		assertEquals("A", listOne.get(0));
		assertEquals("C", listOne.get(1));
		
		two.add(3.0);
		two.add(2.5);
		two.add(1.3);
		assertEquals(3, two.getSize());
		two.remove(3.0, compTwo);
		ArrayList<Double> listTwo = two.toArrayList();
		assertEquals(1.3, listTwo.get(0));
		assertEquals(2.5, listTwo.get(1));
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
