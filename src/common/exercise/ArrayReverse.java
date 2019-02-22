package common.exercise;

/**
WHAT?
Integer  array is reversed in place  without using another array.




HOW?
1. get the  integer array
2. init two indexes. one points from the left(starts with 0) and other index from the right(starts with array.length)
3. swap elements from left and right
4. increment left index and decrement right index
5. goto step 3 till left index < right index
6. done


*/


public class ArrayReverse {

	public static void reverseArray(int[] intary) {
		for(int i = 0; i < intary.length / 2; i++) {
			int temp = intary[i];
			intary[i] = intary[intary.length - 1 - i];
			intary[intary.length - 1 - i] = temp;
		}
	}

	private static void printArray(int[] intary) {
		for(int i : intary) {
			System.out.print(i + ",");
		}
		System.out.println();
	}


	public static void main(String[] args) {

		int[] intary=  { 10, 2, 45, 6, 31, 0, 4};
		printArray(intary);
		reverseArray(intary);
		printArray(intary);
	}
}
