import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Elizabeth Perez
 *
 */
class MorseCodeTree_STUDENT_Test {
	MorseCodeTree tree;
	ArrayList<String> LNRtree;

	@BeforeEach
	void setUp() throws Exception {
		tree = new MorseCodeTree();
		LNRtree = new ArrayList<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToArrayList() {
		// String correctResult = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		//System.out.println(tree.toArrayList().get(0));
		
		assertEquals("h", tree.toArrayList().get(0));
		assertEquals("s", tree.toArrayList().get(1));
		assertEquals("v", tree.toArrayList().get(2));
		assertEquals("i", tree.toArrayList().get(3));
		assertEquals("f", tree.toArrayList().get(4));
		assertEquals("u", tree.toArrayList().get(5));
		assertEquals("e", tree.toArrayList().get(6));
		assertEquals("l", tree.toArrayList().get(7));
		assertEquals("r", tree.toArrayList().get(8));
		assertEquals("a", tree.toArrayList().get(9));
		assertEquals("p", tree.toArrayList().get(10));
		assertEquals("w", tree.toArrayList().get(11));
		assertEquals("j", tree.toArrayList().get(12));
		assertEquals(" ", tree.toArrayList().get(13));
		assertEquals("b", tree.toArrayList().get(14));
		assertEquals("d", tree.toArrayList().get(15));
		assertEquals("x", tree.toArrayList().get(16));
		assertEquals("n", tree.toArrayList().get(17));
		assertEquals("c", tree.toArrayList().get(18));
		assertEquals("k", tree.toArrayList().get(19));
		assertEquals("y", tree.toArrayList().get(20));
		assertEquals("t", tree.toArrayList().get(21));
		assertEquals("z", tree.toArrayList().get(22));
		assertEquals("g", tree.toArrayList().get(23));
		assertEquals("q", tree.toArrayList().get(24));
		assertEquals("m", tree.toArrayList().get(25));
		assertEquals("o", tree.toArrayList().get(26));
		
	}

}
