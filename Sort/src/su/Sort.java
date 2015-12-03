/**
 * 
 */
package su;

/**
 * This is a class that sorts arrays in five different variations of sorting methods
 * 
 * @author Glen Su
 *	Dec 3 2015
 */
public class Sort {

	/**
	 * This is a helper method designed to swap two elements in an array
	 * @param array - array to switch elements from
	 * @param first - index of the first element
	 * @param second - index of the second element
	 */
	private static void swap(int[] array, int first, int second){
		int temp = array[first]; 
		array[first] = array[second];
		array[second] = temp;
	}
	
	/**
	 * This is a method that uses selection sort to sort an array
	 * @param array - array to sort
	 */
	public static void selectionSort(int[] array){
		int target;
		int first = 0;
		int second = 0;
		
		for(int j = array.length-1; j >= 0; j--){
			target = array[j];
			for (int i = 0; i <= j; i++){
				first = j;
				if(target <= array[i]){
					target = array[i];
					second = i;
				}
			}			
			swap(array,first, second);
			/*for (int k = 0; k < array.length; k++){
				System.out.print(array[k] + " ");
			}
			System.out.println();*/
		}
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * This is a method that uses insertion sort to sort an array
	 * @param array - array to sort
	 */
	public static void insertionSort(int[] array){
		int first = 0;
		int second = 0;
		if(array.length > 1){
			for (int i = 0; i < array.length; i++){
				for(int j = i; j >= 0; j--){
					if(array[i] < array[j]){
						
						first = i;
						second = first-1;
						swap(array, first, second);
						i--;
					}
				}
				/*for (int k = 0; k < array.length; k++){
					System.out.print(array[k] + " ");
				}
				System.out.println();*/
			}
		}
	}
	
	/**
	 * This is a method that uses (dumb) bubble sort to sort an array
	 * @param array - array to sort
	 */
	public static void bubbleSort(int[] array) {
		for(int i = 0; i < array.length-1; i++){
			for(int j = 0; j < array.length-1; j++){
				if(array[j+1] < array[j]){
					swap(array, j, j+1);
				}
			}
			/*for (int k = 0; k < array.length; k++){
				System.out.print(array[k] + " ");
			}
			System.out.println();*/
		}
	}
	
	/**
	 * This is the main method of quick sort for sorting an array
	 * @param array - array to sort
	 * @param min - starting index of the array
	 * @param max - ending index of the array
	 */
	public static void quickSort(int[] array, int min, int max){
		int index;
		if(min > max){
			return;
		}
		index = partition(array, min, max);
		
		quickSort(array, min, index-1);
		quickSort(array, index+1 , max);
		/*for (int k = 0; k < array.length; k++){
		System.out.print(array[k] + " ");
	}
	System.out.println();*/
	}
	/**
	 * This is the method that uses quick sort to sort an array by sorting their portions respectively
	 * @param array - array to sort
	 * @param min - starting index of the array
	 * @param max - ending index of the array
	 * @return - the pivot point index
	 */
	private static int partition(int[] array,int min, int max){
		int pivot = min;
		int i = min;
		for(int j = min+1; j <= max;j++){
			if(array[pivot] >= array[j]){
				if(j-i > 1)
					swap(array,i+1,j);
				i++;
			}
		}
		swap(array, pivot, i);
		return i;
	}

	/**
	 * This is a portion of the merge method where it sorts a set of elements from the array
	 * @param array - array to sort
	 * @param min - starting index of the array
	 * @param mid - middle index of the array
	 * @param max - ending index of the array
	 */
	private static int[] merge(int[] array, int min, int mid, int max) {
		int sizeL, sizeR;
		sizeL = mid - min+1;
		sizeR = max - mid;

		int[] array1 = new int[sizeL];
		int[] array2 = new int[sizeR];
		int index;
		for(int i = 0; i < sizeL; i++){
			array1[i] = array[min+i];
		}
		for(int i = 0; i < sizeR; i++){
			array2[i] = array[i + mid+ 1];
		}
		for(int i = 0; i < sizeL; i++){
			System.out.print(array1[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < sizeR; i++){
			System.out.print(array2[i] + " ");
		}
		System.out.println();
		index = min;
		int counter1 = 0;
		int counter2 = 0;
		while(counter1 != sizeL && counter2 != sizeR){
			if(array1[counter1] < array2[counter2]){
				array[index] = array1[counter1];
				index++;
				counter1++;
			}
			else if(array1[counter1] >= array2[counter2]){
				array[index] = array2[counter2];
				index++;
				counter2++;
			}			
		}
		
		if(counter1 != array1.length){
			for(int i = counter1; i < array1.length; i++){
				array[index] = array1[i];
				index++;
			}
		}
		else if(counter2 != array2.length){
			for(int i = counter2; i < array2.length; i++){
				array[index] = array2[i];
				index++;
			}
		}
		return array;
	}
	/**
	 * This is the main method of merge sort for sorting an array
	 * @param array - the array to sort
	 * @param min - starting index of the array
	 * @param max - ending index of the array
	 */
	public static void mergeSort(int[] array, int min, int max){
		if(min == max){
			return;
		}
		int mid = ((min+max) / 2);
		
		mergeSort(array,min,mid);
		
		mergeSort(array,mid+1,max);

		array = merge(array, min, mid, max);
		/*for (int k = 0; k < array.length; k++){
		System.out.print(array[k] + " ");
	}
	System.out.println();*/
	}
	
	/**
	 * The main method - testing method
	 * @param args - system-inputed values
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {3,1,4,2,5,7,6,4};
		int[] array2 = {3,2,1,8,5,4,6,2,4};
		int[] array3 = {9,9,6,1,2,2,8,6,7};
		int[] array4 = {10,2,6,3,9,4,8,1,10,7};
		int[] array5 = {6,1,4,2,8,7,6,3};
		
		selectionSort(array1);
		for (int k = 0; k < array1.length; k++){
			System.out.print(array1[k] + " ");
		}
		System.out.println();
		insertionSort(array2);
		for (int k = 0; k < array2.length; k++){
			System.out.print(array2[k] + " ");
		}
		System.out.println();
		bubbleSort(array3);
		for (int k = 0; k < array3.length; k++){
			System.out.print(array3[k] + " ");
		}
		System.out.println();
		mergeSort(array4, 0, array4.length-1);
		for (int k = 0; k < array4.length; k++){
			System.out.print(array4[k] + " ");
		}
		System.out.println();
		quickSort(array5, 0, array5.length-1);
		for (int k = 0; k < array5.length; k++){
			System.out.print(array5[k] + " ");
		}
		System.out.println();
	
		
	}

}
