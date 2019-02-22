package Level2;

/**
WHAT?
Sorts array of integers in ascending order using quick sort.

Refer: http://en.wikipedia.org/wiki/Quicksort
	   http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html

HOW?
1. get the input integer array
2. take middle element from the array as pivot
3. reorder the array so that all elements with value less than the pivot placed before the pivot and all the elements
   with greater than the pivot placed after the pivot
4. recursively apply the above steps to the left(elements less than pivot)  and 
   right sub array(elements greater than pivot.
5. done   

*/

public class QuickSort {

	public static void quicksort(int[] intArray, int left, int right) {
		int i = left;
		int j = right;
		//middle element from the array is assigned as pivot.
		int pivot = intArray[left + (right-left)/2];

		while( i<= j) {

			// iterate till elements in the left side of the pivot element are less than the pivot
			for(;intArray[i] < pivot; i++) {
			}
 
			//iterate array from the right till elements  in the right side of the pivot are greater than the pivot
			for(; intArray[j] > pivot; j--) {
			}

			if( i <= j) {
				//found an element greather the pivot in the left side
				//similarly an an element has been found on the right side of element  is less than pivot
				//swap these element 
				int temp = intArray[j];
				intArray[j] = intArray[i];
				intArray[i] = temp;
				i++;
				j--;
			}
		}

		//sort left array recursively
		if( left < j) {
			quicksort(intArray, left, j);
		}
		//sort right array recursively
		if( i < right ) {
			quicksort(intArray, i, right);
		}

	}

	private static void printArray(int[] intary) {
		for(int i : intary) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	public static void main(String[] args ) {
		int[] intary=  { 10, 2, 45, 6, 31, 0, 4};
		
		printArray(intary);

		int left = 0;
		int right = intary.length-1;
		quicksort(intary, left, right);

		printArray(intary);
	}
}
