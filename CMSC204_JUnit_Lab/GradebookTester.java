import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	GradeBook g1;
	GradeBook g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(80);
		g1.addScore(50);
		g1.addScore(75);
		g2 = new GradeBook(5);
		g2.addScore(60);
		g2.addScore(90);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("80.0 50.0 75.0"));
		assertTrue(g2.toString().equals("60.0 90.0"));
		
		assertEquals(3, g1.getScoreSize());
		assertEquals(2, g2.getScoreSize());
	}
	
	@Test
	void testSum() {
		assertEquals(205, g1.sum(), .0001); 
		assertEquals(150, g2.sum(), .0001);
	}
	
	@Test
	void testMinimum() {
		assertEquals(50, g1.minimum(), .001);
		assertEquals(60, g2.minimum(), .001);
	}
	
	@Test
	void testFinalScore() {
		assertEquals(155, g1.finalScore(), .001);
		assertEquals(90, g2.finalScore(), .001);
	}

}
