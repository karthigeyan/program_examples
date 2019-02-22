package Level2;

/**
WHAT?
Sorts array of integers in ascending order using bubble sort.

Refer: http://en.wikipedia.org/wiki/Bubble_sort

HOW?
1. get the input integer array
2. iterate array
3. for each element compare with all other element
4. if it is greater than other element then swap elements in the array
5. goto step 2 till all elements are iterated and compared.
6. done


*/

public class BubbleSort {

	public static void sort(int[] intArray) {
		int temp ;

		for(int i = 0; i < intArray.length-1; i++ ) {

			for(int j=i; j< intArray.length;j++) {
				if( intArray[j] < intArray[i]) {
					temp = intArray[j];
					intArray[j] = intArray[i];
					intArray[i] = temp;
				}
			}
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
		sort(intary);
		printArray(intary);
	}
}
