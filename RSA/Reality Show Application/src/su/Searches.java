/**
 * 
 */
package su;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class searches through an int, double, or string
 * array to find and return back to the user
 * 
 * @author Glen Su
 *	Oct 20 2015
 */
public class Searches {
	/**
	 * 
	 * @param a
	 * @param target
	 * @return
	 */
	public static int linearSearches(int[] a, int target){	
		for(int i = 0; i < a.length; i++){	
			
			if(a[i] == target){				
				return i;
			}
			
		}
		return -1;
	}
	/**
	 * 
	 * @param a
	 * @param target
	 * @return
	 */
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
	/**
	 * 
	 * @param a
	 * @param target
	 * @return
	 */
	public static int linearSearches(double[] a, double target){	
		for(int i = 0; i < a.length; i++){		
			if(a[i] == target){				
				return i;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param a
	 * @param target
	 * @return
	 */
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
	/**
	 * 
	 * @param a
	 * @param target
	 * @return
	 */
	public static int linearSearches(String[] a, String target){
		for(int i = 0; i < a.length; i++){		
			if(a[i].equals(target)){				
				return i;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param a
	 * @param target
	 * @return
	 */
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
	/**
	 * 
	 * @param a
	 * @param target
	 * @return
	 */
	public static int linearSearches(ArrayList<ContestantInformation> a, ContestantInformation target){
		for(int i = 0; i < a.size(); i++){		
			if(a.get(i).equals(target)){				
				return i;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param a
	 * @param target
	 * @return
	 */
		public static int binarySearches(ArrayList<ContestantInformation> a, ContestantInformation target){
			int compareTo = 0;
			int begIndex = 0;
			int endIndex = a.size();
			int midIndex = (endIndex - begIndex) /2;	
			for(int i = 0; i < a.size(); i++){	
				compareTo = ((String) a.get(midIndex).getFirstName()).compareToIgnoreCase(target.getFirstName());
				if(compareTo == 0){			
						return compareTo;
				}

				else if(compareTo < 0){
					begIndex = midIndex + 1;
					midIndex = (endIndex - begIndex) /2;
					if(midIndex == 0){
						return -1;
					}
				}

				else if(compareTo > 0){
					endIndex = midIndex - 1;
					midIndex = (endIndex - begIndex) /2;
					if(midIndex == 0){
						return -1;
					}
				}
			}
			return -1;
		}
	/**
	 * 
	 * @param a
	 * @param firstName
	 * @param lastName
	 * @return
	 */
		public static int linearSearches(ArrayList<ContestantInformation> a, String firstName, String lastName){
			for(int i = 0; i < a.size(); i++){		
				if(a.get(i).getFirstName().equals(firstName)){				
					return i;
				}
			}
			return -1;
		}
	/**
	 * 
	 * @param a
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public static int binarySearches(ArrayList<ContestantInformation> a, String firstName, String lastName){
		int compareTo = 0;
		int begIndex = 0;
		int endIndex = a.size();
		int midIndex = (endIndex - begIndex) /2;	
		for(int i = 0; i < a.size(); i++){	
			compareTo = ((String) a.get(midIndex).getFirstName()).compareToIgnoreCase(firstName);
			if(compareTo == 0){
				compareTo = ((String) a.get(midIndex).getLastName()).compareToIgnoreCase(lastName);
				if(compareTo == 0){				
					return compareTo;
				}

				else if(compareTo < 0){
					begIndex = midIndex + 1;
					midIndex = (endIndex - begIndex) /2;
					if(midIndex == 0){
						return -1;
					}
				}

				else if(compareTo > 0){
					endIndex = midIndex - 1;
					midIndex = (endIndex - begIndex) /2;
					if(midIndex == 0){
						return -1;
					}
				}
			}

			else if(compareTo < 0){
				begIndex = midIndex + 1;
				midIndex = (endIndex - begIndex) /2;
				if(midIndex == 0){
					return -1;
				}
			}

			else if(compareTo > 0){
				endIndex = midIndex - 1;
				midIndex = (endIndex - begIndex) /2;
				if(midIndex == 0){
					return -1;
				}
			}
		}
		return -1;
	}
}
