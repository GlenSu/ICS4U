/**
 * 
 */
package su;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class searches through an int, double, string or object
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
	 * This search method is used to search for a string by using the binary search method. It will 
	 * return the index of the array if the target string is found, otherwise a -1 will be returned. 
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
	 * This search method is used to search for a ContestantInformation object in order from the 
	 * beginning to the end within a ContestantInformation arraylist and returns the index of the 
	 * array if an object with the same information is found, otherwise a negative 1 will be returned.
	 * @param contestants - an arraylist of ContestantInformation objects
	 * @param target - the object to search for
	 * @return - the index of the arraylist or -1 if not found
	 */
	public static int linearSearches(ArrayList<ContestantInformation> contestants, ContestantInformation target){
		for(int i = 0; i < contestants.size(); i++){		
			if(contestants.get(i).equals(target)){				
				return i;
			}
		}
		return -1;
	}
	/**
	 * This search method is used to search for a ContestantInformation object by using the 
	 * binary search method. It will return the index of the array if the target object with 
	 * the same information is found, otherwise a -1 will be returned. 
	 * @param contestants - an arraylist of ordered ContestantInformation objects
	 * @param target - the object to search for
	 * @return - the index of the arraylist or -1 if not found
	 */
		public static int binarySearches(ArrayList<ContestantInformation> contestants, ContestantInformation target){
			int compareTo = 0;
			int begIndex = 0;
			int endIndex = contestants.size();
			int midIndex = (endIndex - begIndex) /2;	
			for(int i = 0; i < contestants.size(); i++){	
				compareTo = ((String) contestants.get(midIndex).getFirstName()).compareToIgnoreCase(target.getFirstName());
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
	 * This search method is used to search for a ContestantInformation object in order from 
	 * the beginning to the end using the first and last names of a contestant within a 
	 * ContestantInformation arraylist and returns the index of the array if an object with 
	 * the same names is found, otherwise a negative 1 will be returned.
	 * @param contestants - an arraylist of ContestantInformation objects
	 * @param firstName - the first name of a contestant
	 * @param lastName - the last name of the same contestant
	 * @return - the index of the arraylist or -1 if not found
	 */
		public static int linearSearches(ArrayList<ContestantInformation> contestants, String firstName, String lastName){
			for(int i = 0; i < contestants.size(); i++){		
				if(contestants.get(i).getFirstName().equals(firstName)){				
					if(contestants.get(i).getLastName().equals(lastName)){
						return i;
					}
				}
			}
			return -1;
		}
	/**
	 * This search method is used to search for a ContestantInformation object through 
	 * the first and last names of a contestant by using the binary search method. It 
	 * will return the index of the array if the target object with the same information 
	 * is found, otherwise a -1 will be returned. 
	 * @param contestants - an arraylist of ordered ContestantInformation objects
	 * @param firstName - the first name of a contestant
	 * @param lastName - the last name of the same contestant
	 * @return - the index of the arraylist or -1 if not found
	 */
	public static int binarySearches(ArrayList<ContestantInformation> contestants, String firstName, String lastName){
		int compareTo = 0;
		int begIndex = 0;
		int endIndex = contestants.size();
		int midIndex = (endIndex - begIndex) /2;	
		for(int i = 0; i < contestants.size(); i++){	
			compareTo = ((String) contestants.get(midIndex).getFirstName()).compareToIgnoreCase(firstName);
			if(compareTo == 0){
				compareTo = ((String) contestants.get(midIndex).getLastName()).compareToIgnoreCase(lastName);
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
	
	/**
	 * This helper method is used to search for a string by using a recursive 
	 * search method. It will return the index of the array if the target 
	 * string is found, otherwise a -1 will be returned. 
	 * @param arrayList - the arraylist to search from
	 * @param target - the string to search for
	 * @return - the index of the arraylist or -1 if not found
	 */
	public static int binarySearch(ArrayList<String> arrayList, String target){
		return binarySearch(arrayList, target, 0, arrayList.size());
	}
	
	/**
	 * This search method is used to search for a ContestantInformation object by 
	 * using information from the helper method. It will return the index of the 
	 * array if the target string is found, otherwise a -1 will be returned. 
	 * @param aL  - the arraylist to search from
	 * @param target - the string to search for
	 * @param begin - the starting index of the arraylist
	 * @param end  - the size of the arraylist
	 * @return - the index of the arraylist or -1 if not found
	 */
	private static int binarySearch(ArrayList<String> aL, String target, int begin, int end) {
		// TODO Auto-generated method stub
		if(begin > end){
			return -1;
		}
		int mid = (begin + end)/2;
		if(aL.get(mid).compareTo(target)==0){
			return mid;
		}
		else if(aL.get(mid).compareTo(target)< 0){
			return binarySearch(aL, target, mid+1, end);
		}
		else{
			return binarySearch(aL, target, begin, mid-1);
		}
	}
	
	
}
