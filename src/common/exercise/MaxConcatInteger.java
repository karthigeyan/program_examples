package common.exercise;

/**
WHAT?
Given an integer array, sort the integer array such that the concatenated integer of the result array is max. e.g. [4, 94, 9, 14, 1] will be sorted to [9,94,4,14,1] where the result integer is 9944141.


HOW?
1. quicksort the array in descending order- while comparing the two integers N1 and N2 in quicksort algorithm , 
   compare concatenated integers like N1N2 > N2N1
   (eg N1=9, N2=94 then 994(N1N2)  > 949(N2N1) )
2. done	

*/

public class MaxConcatInteger {

	public static void  sort(int[]  intArray) {
		int left = 0;
		int right = intArray.length-1;
		quicksort(intArray, left, right);
	}

	private static long concat(int num1, int num2 ) {
		int pow = 10;

		while(num2 >= pow) {
			pow  *=10;
		}
		return num1*pow + num2;
	}

	// while comparing 9 and 94, it will be like 994 < 949	
	private static boolean isLessThan(int a, int b) {
		long x = concat(a, b);
		long y = concat(b, a);
		return x < y ? true:false;
	}

	private static boolean isGreaterThan(int a, int b) {
		long x = concat(a, b);
		long y = concat(b, a);
		return x > y ? true:false;
	}

	private static void quicksort(int[] intArray, int left, int right) {
		int i = left;
		int j = right;
		//middle element from the array is assigned as pivot.
		int pivot = intArray[left + (right-left)/2];

		while( i<= j) {

			// iterate till elements in the left side of the pivot element are less than the pivot
			//for(;intArray[i] < pivot; i++) {
			for(;isGreaterThan(intArray[i] , pivot); i++) {
			}

			//iterate array from the right till elements  in the right side of the pivot are greater than the pivot
			for(; isLessThan(intArray[j] , pivot); j--) {
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

	public static void main(String[] args) {
 		int[] intArray = {4, 94, 9, 14, 1};
		printArray(intArray);
		sort(intArray);
		printArray(intArray);

	}
}
