import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Elizabeth Perez
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	
	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		// case 1
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Wonderful"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",true);
		}
		
		// case 2
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Gam3?"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		// case 1
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("Bored"));
		} catch (NoUpperAlphaException e) {
			e.printStackTrace();
		}
		
		// case 2
		try {
			assertFalse(PasswordCheckerUtility.hasUpperAlpha("bored"));
		} catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		// case 1
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("Bored"));
		} catch (NoLowerAlphaException e) {
			e.printStackTrace();
		}
		
		// case 2
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("BORED"));
		} catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		// case 1
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword("oneTwoThree"));
		} catch (WeakPasswordException e) {
			e.printStackTrace();
		}
		
		// case 2
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("oneTwo"));
		} catch (WeakPasswordException e) {
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		// case 1
		try {
			assertFalse(PasswordCheckerUtility.hasSameCharInSequence("nononono"));
		} catch (InvalidSequenceException e) {
			e.printStackTrace();
		}
		
		// case 2
		Throwable exception = assertThrows(InvalidSequenceException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSameCharInSequence("LLLiz");
			}			
		});
		assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		// case 1
		try {
			assertTrue(PasswordCheckerUtility.hasDigit("wow4fun"));
		} catch (NoDigitException e) {
			e.printStackTrace();
		}
		
		// case 2
		Throwable exception = assertThrows(NoDigitException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasDigit("notFound");
			}			
		});
		assertEquals("The password must contain at least one digit", exception.getMessage());
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		// case 1
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Wow4!real"));
		}
		catch(Exception e)
		{
			fail("Gave exception");
		}
		
		// case 2
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Night9L#"));
		}
		catch(Exception e)
		{
			fail("Gave exception");
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		passwords.add("Wow4fun");
		passwords.add("Night9L#");
		passwords.add("LLL!77z");
		
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(results.size(), 2);
		assertEquals(results.get(0), "Wow4fun -> The password must contain at least one special character");
		assertEquals(results.get(1), "LLL!77z -> The password cannot contain more than two of the same character in sequence");
	}
	
}