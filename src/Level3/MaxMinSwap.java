package Level3;

/**
WHAT?
Swap the maximum and minimum elements in an integer array.
For example
Input= {20, 8, 45, 10, 32, 9, 3};

Output= {20, 8, 3, 10, 32, 9, 45};


HOW?
1. get the input integer array INT_ARRAY
2. initialize MAX= INT_ARRAY[0], MIN=INT_ARRAY[0]
3. initialize max and min indexes: MAX_INDEX=0, MIN_INDEX=0
4. iterate the integer array
		check  INT > MAX then MAX=INT and MAX_INDEX=INDEX
		check  INT < MIN then MIN=INT and MIN_INDEX=INDEx
5. swap max and min
6. done
*/

public class MaxMinSwap {

	public static void swapMaxMin(int[] intArray) {

		int max = intArray[0];
		int min = intArray[0]; 
		int maxIdx = 0;
		int minIdx = 0;

		//find max and min and repective indexes.
		for(int i = 0; i < intArray.length; i++ ) {
			//find max element and respective index
			if( intArray[i] > max ) {
				max = intArray[i];
				maxIdx = i;
			}
			//find min element and respective index
			if( intArray[i] < min  ) {
				min = intArray[i];
				minIdx = i;
			}
		}

		//swap max and min
		int temp = intArray[minIdx];
		intArray[minIdx] = intArray[maxIdx];
		intArray[maxIdx] = temp;
	}

	public static void printArray(int[] intArray) {
		for(int i = 0; i < intArray.length; i++ ) {
			System.out.print(intArray[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {

		int[] intArray = {20, 8, 45, 10, 32, 9, 3};
		printArray(intArray);
		swapMaxMin(intArray);
		printArray(intArray);

	}
}
