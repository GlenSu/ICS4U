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
	public static String wordFormat(String word) throws InvalidInputException{
		char[] letters = new char[word.length()];
		String newWord = "";
		for (int i = 0; i< word.length(); i++){
			if (Character.isSpaceChar(word.charAt(i))){
				letters[i] = Character.toUpperCase(word.charAt(i+1));
			}
			else if(i< word.length() && Character.isLetterOrDigit(word.charAt(i))){
				letters[i] = Character.toLowerCase(word.charAt(i));
			}
			else
			{
			   throw new InvalidInputException("An error has occured.");
			}
		}
		return newWord;
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
