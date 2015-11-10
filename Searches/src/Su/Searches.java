/**
 * 
 */
package Su;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class searches through an int, double, or string
 * array to find and return back to the user
 * 
 * @author Glen Su
 *	Oct 13 2015
 */
public class Searches {
	/**
	 * This search method is used to search for an integer number in order from the beginning to 
	 * the end within an integer array and returns the index of the array if the integer is found,
	 * otherwise a negative 1 will be returned  
	 * @param linearArray
	 * @param target
	 * @return
	 */
	public static int linearSearches(int[] linearSearch, int target){	
		for(int i = 0; i < linearSearch.length; i++){	
			
			if(linearSearch[i] == target){				
				return i;
			}
			
		}
		return -1;
	}
	/**
	 * This search method is used to search for an integer number by using the binary search method. 
	 * It will return the index of the array if the integer is found, otherwise a -1 will be returned. 
	 * @param binaryArray
	 * @param target
	 * @return
	 */
	public static int binarySearches(int[] binarySearch, int target){
		int begIndex = 0;
		int endIndex = binarySearch.length;
		int midIndex = (endIndex + begIndex) /2;
		for(int i = 0; i < binarySearch.length; i++){	
			
			if(binarySearch[midIndex] == target){				
				return midIndex;
			}
			
			else if(binarySearch[midIndex] < target){
				begIndex = midIndex + 1;
				midIndex = (endIndex + begIndex) /2;
				if(endIndex - begIndex == 0){
					return -1;
				}
			}
			
			else if(binarySearch[midIndex] > target){
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
	 * This search method is used to search for an double number in order from the beginning to 
	 * the end within a double array and returns the index of the array if the double is found,
	 * otherwise a negative 1 will be returned  
	 * @param linearArray
	 * @param target
	 * @return
	 */
	public static int linearSearches(double[] linearSearch, double target){	
		for(int i = 0; i < linearSearch.length; i++){		
			if(linearSearch[i] == target){				
				return i;
			}
		}
		return -1;
	}
	/**
	 * This search method is used to search for an double number by using the binary search method. 
	 * It will return the index of the array if the double is found, otherwise a -1 will be returned. 
	 * @param binarySeach
	 * @param target
	 * @return
	 */
	public static int binarySearches(double[] binarySeach, double target){
		int begIndex = 0;
		int endIndex = binarySeach.length;
		int midIndex = (endIndex + begIndex) /2;
		for(int i = 0; i<binarySeach.length; i++){	
			if(binarySeach[midIndex] == target){				
				return midIndex;
			}
			
			else if(binarySeach[midIndex] < target){
				begIndex = midIndex + 1;
				midIndex = (endIndex + begIndex) /2;
				
			}
			
			else //if(a[midIndex] > target)
			{
				endIndex = midIndex - 1;
				midIndex = (endIndex + begIndex) /2;
			}
			
			if (midIndex >= binarySeach.length){
				return -1;
			}
		}
		return -1;
	}
	/**
	 * This search method is used to search for an string in order from the beginning to 
	 * the end within a string array and returns the index of the array if the string is found,
	 * otherwise a negative 1 will be returned  
	 * @param linearArray
	 * @param target
	 * @return
	 */
	public static int linearSearches(String[] linearSearch, String target){
		for(int i = 0; i < linearSearch.length; i++){		
			if(linearSearch[i].equals(target)){				
				return i;
			}
		}
		return -1;
	}
	/**
	 * This search method is used to search for an string number by using the binary search method. 
	 * It will return the index of the array if the string is found, otherwise a -1 will be returned. 
	 * @param binarySearch
	 * @param target
	 * @return
	 */
	public static int binarySearches(String[] binarySearch, String target){
		double compareTo = 0;
		double begIndex = 0;
		double endIndex = binarySearch.length;
		int midIndex = (int) Math.round((endIndex + begIndex) /2);	
		for(int i = 0; i < binarySearch.length; i++){	
			compareTo = binarySearch[midIndex].compareToIgnoreCase(target);
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
	 * @param args
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
