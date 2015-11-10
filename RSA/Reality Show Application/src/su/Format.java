/**
 * 
 */
package su;

import java.util.Arrays;

/**
 * @author 322124942
 *
 */
public class Format {
	/**
	 * This method is used to format string inputs into proper english formatting
	 * @param word
	 * @return
	 */
	public static String genericFormat(String word) throws InvalidInputException{
		String[] wordList = word.split(" ");
		for(int i=0;i<wordList.length;i++){
			
			wordList[i] = wordList[i].replace(wordList[i].charAt(0), Character.toUpperCase(wordList[i].charAt(0)));
		}
		for(int i=0;i<wordList.length;i++){
			wordList[i] = wordList[i] + " ";
		}
			return (wordList[0]);
	}
	/**
	 * This method is used to format string inputs into proper english formatting
	 * @param word
	 * @return
	 */
	public static String searchFormat(String word) throws InvalidInputException{
		String[] wordList = word.split(" ");
		for(int i=0;i<wordList.length;i++){
			
			if(!Character.isLetter(wordList[i].charAt(i))){
				throw new InvalidInputException("Please enter a proper name.");
			}
			wordList[i] = wordList[i].replace(wordList[i].charAt(0), Character.toUpperCase(wordList[i].charAt(0)));
		}
		for(int i=0;i<wordList.length;i++){
			wordList[0] = wordList[i] + " ";
		}
			return (wordList[0]);
	}
	/**
	 * This was a test method
	 * @param word
	 * @return
	 * @throws InvalidInputException
	 */
	public static String camelCase(String word) throws InvalidInputException{
		String[] wordList = word.split(" ");
		for(int i=0;i<wordList.length;i++){
			
			wordList[i] = wordList[i].replace(wordList[i].charAt(0), Character.toUpperCase(wordList[i].charAt(0)));
		}
		for(int i=0;i<wordList.length;i++){
			wordList[i] = wordList[i] + " ";
		}
			return (wordList[0]);
		
	}
}
