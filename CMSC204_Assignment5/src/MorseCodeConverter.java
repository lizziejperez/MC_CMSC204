import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Morse Code Converter
 * @author Elizabeth Perez
 *
 */
public class MorseCodeConverter {
	private static MorseCodeTree tree;
	
	/**
	 * 
	 */
	public MorseCodeConverter() {
		tree = new MorseCodeTree();
	}
	
	/**
	 * Converts a file of Morse code into English
	 * @param codeFile
	 * @return the English translation
	 */
	public static String convertToEnglish(File codeFile) {
		String output = "";
		String word = "";
		
		try {
			Scanner input = new Scanner(codeFile);
			
			while(input.hasNext()) {
				String code = "";
				Character c = input.next().charAt(0);
				
				switch(c) {
					case ' ':
						word += tree.fetch(code);
						break;
					case '/':
						output += word;
						output += " ";
						break;
					default:
						code += c.toString();
						break;
				}
			}
			
			input.close();
		} catch(FileNotFoundException e) {
			System.out.println("File was not found");
		}
		
		return output;
		
	}
	
	/**
	 * Converts Morse code into English
	 * @param code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String output = "";
		String word = "";
		
		for(int i = 0; i < code.length(); i++) {
			String letter = "";
			Character c = code.charAt(i);
			
			switch(c) {
				case ' ':
					word += tree.fetch(letter);
					break;
				case '/':
					output += word;
					output += " ";
					break;
				default:
					letter += c.toString();
					break;
			}
		}
		
		return output;
	}
	
	/**
	 * Returns a string with all the data in the tree in LNR order with a space in between them
	 * @return
	 */
	public static String printTree() {
		ArrayList<String> list = tree.toArrayList();
		String s = "";
		
		for(int i = 0; i < list.size(); i++) {
			s += list.get(i);
			s += " ";
		}
		
		return s;
	}
}
