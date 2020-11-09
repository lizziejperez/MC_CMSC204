import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * This is a JUnit test for the CourseDBManager class
 * @author Elizabeth Perez
 */
class CourseDBManager_STUDENT_Test {
	private CourseDBManager manager;

	@BeforeEach
	void setUp() throws Exception {
		manager = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		manager = null;
	}

	@Test
	void testAdd() {
		try {
			manager.add("CMSC204",21582,4,"SC450","Khandan Monshi");
			manager.add("MATH284",22905,4,"DL","Mary Wall");
			manager.add("ASLP100",23779,3,"HB107","Daniel Frame");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	void testGet() {
		manager.add("CMSC204",21582,4,"SC450","Khandan Monshi");
		manager.add("MATH284",22905,4,"DL","Mary Wall");
		manager.add("ASLP100",23779,3,"HB107","Daniel Frame");
		try {
			manager.get(21582);
			manager.get(22905);
			manager.get(23779);
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	
	@Test
	void testReadFile() {
		try {
			File inputFile = new File("Test.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 21582 4 SC450 Khandan Monshi");
			inFile.println("MATH284 22905 4 DL Mary Wall");
			inFile.println("ASLP100 23779 3 HB107 Daniel Frame");
			inFile.close();
			manager.readFile(inputFile);
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	
	@Test
	void testShowAll() {
		manager.add("CMSC204",21582,4,"SC450","Khandan Monshi");
		manager.add("MATH284",22905,4,"DL","Mary Wall");
		manager.add("ASLP100",23779,3,"HB107","Daniel Frame");
		ArrayList<String> list = manager.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:21582 Credits:4 Instructor:Khandan Monshi Room:SC450");
		assertEquals(list.get(1),"\nCourse:MATH284 CRN:22905 Credits:4 Instructor:Mary Wall Room:DL");
		assertEquals(list.get(2),"\nCourse:ASLP100 CRN:23779 Credits:3 Instructor:Daniel Frame Room:HB107");
	}

}
