/**
 * 
 */
package su;

import java.util.Scanner;

/**
 * This class searches through an int, double, or string
 * array to find and return back to the user
 * 
 * @author Glen Su
 * Nov 10 2015
 */
public class Searches {
	/**
	 * This search method is used to search for an integer number in order from the beginning to 
	 * the end within an integer array and returns the index of the array if the integer is found,
	 * otherwise a negative 1 will be returned  
	 * @param linearArray - an array of ints
	 * @param target - the int value to search for
	 * @return - the index of the array or -1 if not found
	 */
	public static int linearSearches(int[] linearArray, int target){	
		for(int i = 0; i < linearArray.length; i++){	
			
			if(linearArray[i] == target){				
				return i;
			}
			
		}
		return -1;
	}
	/**
	 * This search method is used to search for an integer number by using the binary search method. 
	 * It will return the index of the array if the target integer is found, otherwise a -1 will be returned. 
	 * @param binaryArray - an array of ordered ints
	 * @param target - the int value to search for
	 * @return - the index of the array or -1 if not found
	 */
	public static int binarySearches(int[] binaryArray, int target){
		int begIndex = 0;
		int endIndex = binaryArray.length;
		int midIndex = (endIndex + begIndex) /2;
		for(int i = 0; i < binaryArray.length; i++){	
			
			if(binaryArray[midIndex] == target){				
				return midIndex;
			}
			
			else if(binaryArray[midIndex] < target){
				begIndex = midIndex + 1;
				midIndex = (endIndex + begIndex) /2;
				if(endIndex - begIndex == 0){
					return -1;
				}
			}
			
			else if(binaryArray[midIndex] > target){
				endIndex = midIndex - 1;
				midIndex = (endIndex + begIndex) /2;
				if(endIndex - begIndex == 0){
					return -1;
				}
			}
		}
		return -1;
	}
	/**
	 * This search method is used to search for a double number in order from the beginning to 
	 * the end within a double array and returns the index of the array if the double is found,
	 * otherwise a negative 1 will be returned  
	 * @param linearArray - an array of doubles
	 * @param target - the double value to search for
	 * @return - the index of the array or -1 if not found
	 */
	public static int linearSearches(double[] linearArray, double target){	
		for(int i = 0; i < linearArray.length; i++){		
			if(linearArray[i] == target){				
				return i;
			}
		}
		return -1;
	}
	/**
	 * This search method is used to search for a double number by using the binary search method. 
	 * It will return the index of the array if the target double is found, otherwise a -1 will be returned. 
	 * @param binaryArray - an array of ordered doubles
	 * @param target - the double value to search for
	 * @return - the index of the array or -1 if not found
	 */
	public static int binarySearches(double[] binaryArray, double target){
		int begIndex = 0;
		int endIndex = binaryArray.length;
		int midIndex = (endIndex + begIndex) /2;
		for(int i = 0; i<binaryArray.length; i++){	
			if(binaryArray[midIndex] == target){				
				return midIndex;
			}
			
			else if(binaryArray[midIndex] < target){
				begIndex = midIndex + 1;
				midIndex = (endIndex + begIndex) /2;
				
			}
			
			else //if(a[midIndex] > target)
			{
				endIndex = midIndex - 1;
				midIndex = (endIndex + begIndex) /2;
			}
			
			if (midIndex >= binaryArray.length){
				return -1;
			}
		}
		return -1;
	}
	/**
	 * This search method is used to search for a string in order from the beginning to 
	 * the end within a string array and returns the index of the array if the string is found,
	 * otherwise a negative 1 will be returned  
	 * @param linearArray - an array of strings
	 * @param target - the string value to search for
	 * @return - the index of the array or -1 if not found
	 */
	public static int linearSearches(String[] linearArray, String target){
		for(int i = 0; i < linearArray.length; i++){		
			if(linearArray[i].equals(target)){				
				return i;
			}
		}
		return -1;
	}
	/**
	 * This search method is used to search for a string by using the binary search method. 
	 * It will return the index of the array if the target string is found, otherwise a -1 will be returned. 
	 * @param binaryArray - an array of ordered strings
	 * @param target - the string value to search for
	 * @return - the index of the array or -1 if not found
	 */
	public static int binarySearches(String[] binaryArray, String target){
		double compareTo = 0;
		double begIndex = 0;
		double endIndex = binaryArray.length;
		int midIndex = (int) Math.round((endIndex + begIndex) /2);	
		for(int i = 0; i < binaryArray.length; i++){	
			compareTo = binaryArray[midIndex].compareToIgnoreCase(target);
			if(compareTo == 0){				
				return midIndex;
			}

			else if(compareTo < 0){

				begIndex = midIndex + 1;
				midIndex = (int) Math.round((endIndex + begIndex) /2);
				
			}
			
			else if(compareTo > 0){

				endIndex = midIndex - 1;
				midIndex = (int) Math.round((endIndex + begIndex) /2);
				
			}
		}
		return -1;
	}
	/**
	 * This is the main testing method for the search methods by giving test arrays
	 * @param args - an array with string values from the predefined string array
	 */
		public static void main(String[] args){
			Scanner scan = new Scanner(System.in);
			String[] strings = new String[] {"Black","Blue","Brown","Cyan", "Green", "Grey", "Pink", "Red", "Yellow"};
			int[] ints = new int[] {1, 2, 3, 4, 5, 6, 7};
			double[] doubles = new double[] {1.2083, 2.431, 4.596, 5.048, 7.654};	
			System.out.println(linearSearches(ints, 4));
			System.out.println(linearSearches(ints, 8));
			System.out.println(linearSearches(doubles, 2.431));
			System.out.println(linearSearches(doubles, 9.324));
			System.out.println(linearSearches(strings, "Cyan"));
			System.out.println(linearSearches(strings, "Void"));
			System.out.println("");
			System.out.println(binarySearches(ints, 4));
			System.out.println(binarySearches(ints, 8));
			System.out.println(binarySearches(doubles, 2.431));
			System.out.println(binarySearches(doubles, 9.324));
			System.out.println(binarySearches(strings, "Cyan"));
			System.out.println(binarySearches(strings, "Dirt"));
		}

}
