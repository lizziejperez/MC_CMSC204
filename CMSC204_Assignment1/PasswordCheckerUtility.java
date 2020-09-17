import java.util.ArrayList;
/**
 * PasswordCheckerUtility Class
 * @author Elizabeth Perez
 *
 */
public class PasswordCheckerUtility {
	/**
	 * Compare equality of two passwords
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if(!comparePasswordsWithReturn(password, passwordConfirm)) {
			throw new UnmatchedException(); 
		}
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password
	 * @param passwordConfirm
	 * @return boolean
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)	{
		if(password.equals(passwordConfirm)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Reads a file of passwords and the passwords that failed the check will be added to an invalidPasswords with the reason
	 * @param passwords
	 * @return invalidPasswords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		String s;
		for(int x = 0; x < passwords.size(); x++) {
			s = passwords.get(x);
			try {
				isValidPassword(s);
			} catch (LengthException e) {
				invalidPasswords.add(s + " -> " + e.getMessage());
				//e.printStackTrace();
			} catch (NoUpperAlphaException e) {
				invalidPasswords.add(s + " -> " + e.getMessage());
			} catch (NoLowerAlphaException e) {
				invalidPasswords.add(s + " -> " + e.getMessage());
			} catch (NoDigitException e) {
				invalidPasswords.add(s + " -> " + e.getMessage());
			} catch (NoSpecialCharacterException e) {
				invalidPasswords.add(s + " -> " + e.getMessage());
			} catch (InvalidSequenceException e) {
				invalidPasswords.add(s + " -> " + e.getMessage());
			}	
		}
		return invalidPasswords;
	}
	
	/**
	 * Weak password length check - Password contains 6 to 9 characters , still considers valid, just weak
	 * @param password
	 * @return boolean
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		int x = password.length();
		if(x >= 6 && x <= 9) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks the password Digit requirement - Password must contain a numeric character
	 * @param password
	 * @return boolean
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		int l = password.length();
		for(int x = 0; x < l; x++) {
			char n = password.charAt(x);
			if(n >= 48 && n <= 57) {
				return true;
			}
		}
		throw new NoDigitException();
		
	}
	
	/**
	 * Checks the password lowercase requirement - Password must contain a lowercase alpha character
	 * @param password
	 * @return boolean
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		int l = password.length();
		for(int x = 0; x < l; x++) {
			char n = password.charAt(x);
			if(n >= 97 && n <= 122) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	
	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password
	 * @return boolean
	 * @throws InvalidSequenceException
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		int l = password.length();
		int count = 0;
		char last;
		for(int x = 1; x < l; x++) {
			char n = password.charAt(x);
			last = password.charAt(x-1);
			if(n == last) {
				count++;
				if(count == 2) {
					throw new InvalidSequenceException();
				}
			} else {
				count = 0;
			}
		}
		return false;
	}
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password
	 * @return boolean
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		int l = password.length();
		for(int x = 0; x < l; x++) {
			char n = password.charAt(x);
			if(n >= 32 && n <= 47) {
				return true;
			}
			if(n >= 58 && n <= 64) {
				return true;
			}
			if(n >= 91 && n <= 96) {
				return true;
			}
			if(n >= 123 && n <= 126) {
				return true;
			}
		}
		throw new NoSpecialCharacterException();
	}
	
	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password
	 * @return boolean
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		int l = password.length();
		for(int x = 0; x < l; x++) {
			char n = password.charAt(x);
			if(n >= 65 && n <= 90) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks the password length requirement - – The password must be at least 6 characters long
	 * @param password
	 * @return boolean
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException {
		int x = password.length();
		if(x >= 6) {
			return true;
		} else {
			throw new LengthException();
		}
	}
	
	/**
	 * Return true if valid password (follows all rules from above), returns false if an invalid password
	 * @param password
	 * @return boolean
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, 
	NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		isValidLength(password);
		hasUpperAlpha(password);
		hasLowerAlpha(password);
		hasSpecialChar(password);
		hasDigit(password);
		hasSameCharInSequence(password);
		
		return true;
	}
	
	/**
	 * Checks if password is valid but between 6-9 characters
	 * @param password
	 * @return boolean
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		return hasBetweenSixAndNineChars(password);
	}
 }
