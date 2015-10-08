/**
 * 
 */
package Su;

import java.util.Scanner;

/**
 * This class searches through an int, double, or string
 * array to find and return back to the user
 * 
 * @author Glen Su
 *	Oct 8 2015
 */
public class Searches {
	// int search
	public int linearSearches(int[] a){
		int target = 0;	
		for(int i = 0; i < a.length; i++){	
			
			if(a[i] == target){				
				return(target);
			}
			
		}
		return -1;
	}
	
	public int binarySearches(int[] a){
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
	// double search
	public double linearSearches(double[] a, double target){	
		for(int i = 0; i < a.length; i++){		
			if(a[i] == target){				
				return(target);
			}
		}
		return -1;
	}
	
	public double binarySearches(double[] a, double target){
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
	// string search
	public String linearSearches(String[] a, String target){
		for(int i = 0; i < a.length; i++){		
			if(a[i].equals(target)){				
				return(target);
			}
		}
		return "-1";
	}
	
	public String binarySearches(String[] a, String target){
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
	
	public static void main(String args){
		Scanner scan = new Scanner(System.in);
		String[] strings = new String[] {"Table","Game","Pie","Flavoured"};
		int[] ints = new int[] {1, 2, 3, 4, 5, 6, 7};
		double[] doubles = new double[] {1.2083, 2.431, 4.596, 5.048, 7.654};		
	}

}
