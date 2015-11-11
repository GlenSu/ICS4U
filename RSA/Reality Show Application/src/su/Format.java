/**
 * 
 */
package su;

import java.util.Arrays;

/**
 * This class is used to format strings by changing each letter at the beginning of each word
 * into their capital letter version and change every other letter into their lowercase version.
 * 
 * @author Glen Su
 * Nov 10 2015
 */
public class Format {
	/**
	 * This method is used to format string inputs into proper english formatting
	 * @param word - the word to be formatted
	 * @return - the formatted version of the word
	 */
	public static String genericFormat(String word){
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
	 * @param word - the word to be formatted
	 * @return - the formatted version of the word
	 * @throws InvalidInputException - If word does not contain all letters
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
	/*
	/**
	 * This was a test method
	 * @param word
	 * @return
	 * @throws InvalidInputException
	 */
	/*
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
	*/
}
