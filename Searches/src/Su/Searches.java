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
	// linear search for an int array
	public static int linearSearches(int[] a, int target){	
		for(int i = 0; i < a.length; i++){	
			
			if(a[i] == target){				
				return i;
			}
			
		}
		return -1;
	}
	// binary search for an int array
	public static int binarySearches(int[] a, int target){
		int begIndex = 0;
		int endIndex = a.length;
		int midIndex = (endIndex + begIndex) /2;
		for(int i = 0; i < a.length; i++){	
			
			if(a[midIndex] == target){				
				return midIndex;
			}
			
			else if(a[midIndex] < target){
				begIndex = midIndex + 1;
				midIndex = (endIndex + begIndex) /2;
				if(endIndex - begIndex == 0){
					return -1;
				}
			}
			
			else if(a[midIndex] > target){
				endIndex = midIndex - 1;
				midIndex = (endIndex + begIndex) /2;
				if(endIndex - begIndex == 0){
					return -1;
				}
			}
		}
		return -1;
	}
	// linear search for a double array
	public static int linearSearches(double[] a, double target){	
		for(int i = 0; i < a.length; i++){		
			if(a[i] == target){				
				return i;
			}
		}
		return -1;
	}
	// binary search for a double array
	public static int binarySearches(double[] a, double target){
		int begIndex = 0;
		int endIndex = a.length;
		int midIndex = (endIndex + begIndex) /2;
		for(int i = 0; i<a.length; i++){	
			if(a[midIndex] == target){				
				return midIndex;
			}
			
			else if(a[midIndex] < target){
				begIndex = midIndex + 1;
				midIndex = (endIndex + begIndex) /2;
				
			}
			
			else //if(a[midIndex] > target)
			{
				endIndex = midIndex - 1;
				midIndex = (endIndex + begIndex) /2;
			}
			
			if (midIndex >= a.length){
				return -1;
			}
		}
		return -1;
	}
	// linear search for a string array
	public static int linearSearches(String[] a, String target){
		for(int i = 0; i < a.length; i++){		
			if(a[i].equals(target)){				
				return i;
			}
		}
		return -1;
	}
	// binary search for a string array
	public static int binarySearches(String[] a, String target){
		double compareTo = 0;
		double begIndex = 0;
		double endIndex = a.length;
		int midIndex = (int) Math.round((endIndex + begIndex) /2);	
		for(int i = 0; i < a.length; i++){	
			compareTo = a[midIndex].compareToIgnoreCase(target);
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
