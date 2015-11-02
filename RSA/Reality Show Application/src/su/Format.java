/**
 * 
 */
package su;

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
	public static String wordFormatting(String word) throws InvalidInputException{
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
	public static String searchFormatting(String word) throws InvalidInputException{
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
}
