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
	public static int linearSearches(int[] a){
		int target = 0;	
		for(int i = 0; i < a.length; i++){	
			
			if(a[i] == target){				
				return(target);
			}
			
		}
		return -1;
	}
	// binary search for an int array
	public static int binarySearches(int[] a){
		int begIndex = 0;
		int endIndex = a.length;
		int midIndex = (begIndex - endIndex) /2;
		int check = 0;
		int target = 0;	
		for(int i = 0; i < a.length; i++){	
			
			if(a[midIndex] == target){				
				return(target);
			}
			
			else if(a[midIndex] < target){
				begIndex = midIndex + 1;
				midIndex = (begIndex - endIndex) /2;
				if(endIndex - begIndex == 0){
					return -1;
				}
			}
			
			else if(a[midIndex] > target){
				endIndex = midIndex - 1;
				midIndex = (begIndex - endIndex) /2;
				if(endIndex - begIndex == 0){
					return -1;
				}
			}
		}
		return -1;
	}
	// linear search for a double array
	public static double linearSearches(double[] a, double target){	
		for(int i = 0; i < a.length; i++){		
			if(a[i] == target){				
				return(target);
			}
		}
		return -1;
	}
	// binary search for a double array
	public static double binarySearches(double[] a, double target){
		int begIndex = 0;
		int endIndex = a.length;
		int midIndex = (begIndex - endIndex) /2;
		for(int i = 0; i < a.length; i++){	
			
			if(a[midIndex] == target){				
				return(target);
			}
			
			else if(a[midIndex] < target){
				begIndex = midIndex + 1;
				midIndex = (begIndex - endIndex) /2;
				if(endIndex - begIndex == 0){
					return -1;
				}
			}
			
			else if(a[midIndex] > target){
				endIndex = midIndex - 1;
				midIndex = (begIndex - endIndex) /2;
				if(endIndex - begIndex == 0){
					return -1;
				}
			}
		}
		return -1;
	}
	// linear search for a string array
	public static String linearSearches(String[] a, String target){
		for(int i = 0; i < a.length; i++){		
			if(a[i].equals(target)){				
				return(target);
			}
		}
		return "-1";
	}
	// binary search for a string array
	public static String binarySearches(String[] a, String target){
		int compareTo = 0;
		int begIndex = 0;
		int endIndex = a.length;
		int midIndex = (begIndex - endIndex) /2;	
		for(int i = 0; i < a.length; i++){	
			compareTo = a[midIndex].compareToIgnoreCase(target);
			if(compareTo == 0){				
				return(target);
			}

			else if(compareTo < 0){
				begIndex = midIndex + 1;
				midIndex = (begIndex - endIndex) /2;
				if(endIndex - begIndex == 0){
					return "-1";
				}
			}
			
			else if(compareTo > 0){
				endIndex = midIndex - 1;
				midIndex = (begIndex - endIndex) /2;
				if(endIndex - begIndex == 0){
					return "-1";
				}
			}
		}
		return "-1";
	}
	
	// linear search for an object
		public static Object linearSearches(ArrayList<?> a, Object target){
			for(int i = 0; i < a.size(); i++){		
				if(a.get(i).equals(target)){				
					return(target);
				}
			}
			return "-1";
		}
		// binary search for an object
		public static Object binarySearches(ArrayList<?> a, Object target){
			int compareTo = 0;
			int begIndex = 0;
			int endIndex = a.size();
			int midIndex = (begIndex - endIndex) /2;	
			for(int i = 0; i < a.size(); i++){	
				compareTo = ((String) a.get(midIndex)).compareTo((String) target);
				if(compareTo == 0){				
					return(target);
				}

				else if(compareTo < 0){
					begIndex = midIndex + 1;
					midIndex = (begIndex - endIndex) /2;
					if(midIndex == 0){
						return "-1";
					}
				}
				
				else if(compareTo > 0){
					endIndex = midIndex - 1;
					midIndex = (begIndex - endIndex) /2;
					if(midIndex == 0){
						return "-1";
					}
				}
			}
			return "-1";
		}
		public static void main(String args){
			Scanner scan = new Scanner(System.in);
			String[] strings = new String[] {"Flavoured","Game","Pie","Table"};
			int[] ints = new int[] {1, 2, 3, 4, 5, 6, 7};
			double[] doubles = new double[] {1.2083, 2.431, 4.596, 5.048, 7.654};		
		}

}
