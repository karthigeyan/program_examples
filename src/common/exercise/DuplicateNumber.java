package common.exercise;

/**
WHAT?
Finds duplicate number in an array of numbers.

HOW?
1. get the input integer array
2. sort the integer array
3. iterate the sorted integer array
		check adjacent elements are equal or not, if equal return that element
4. throw exception if duplicate element not found.
5. done   

*/

public class DuplicateNumber {

	public static int findDuplicateNumber(int[] intArray) {
		int left = 0;
		int right = intArray.length-1;

		quicksort(intArray, left, right);

		for(int i=0; i<intArray.length-1; i++) {
			if( intArray[i] == intArray[i+1]  ) {
				return intArray[i];
			}
		}

		throw new RuntimeException("No such duplicate element");
	}

	public static void quicksort(int[] intArray, int left, int right) {
		int i = left;
		int j = right;
		int pivot = intArray[left + (right-left)/2];

		while( i<= j) {

			for(;intArray[i] < pivot; i++) {
			}
 
			for(; intArray[j] > pivot; j--) {
			}

			if( i <= j) {
				int temp = intArray[j];
				intArray[j] = intArray[i];
				intArray[i] = temp;
				i++;
				j--;
			}
		}

		if( left < j) {
			quicksort(intArray, left, j);
		}
		if( i < right ) {
			quicksort(intArray, i, right);
		}

	}



	public static void main(String[] args ) {
		int[] intary=  { 10, 2, 45, 6, 31, 0, 4};
		
		System.out.println(findDuplicateNumber(intary));
	}
}
