package common.exercise;

/**
WHAT?
An algorithm that brings all nonzero elements in an integer array to the left of the array and returns the number of 
non zero elements. Shifting is done in the same array.No new array is used.
For example:
Input={1,2,0,5,0,7,0,3,0,8}
Output=6 {1,2,5,7,3,8,0,0,0}

HOW?
1. get input array of integer and store it in INTARRAY
2. init RIGHT_INDEX to length of the array
3. init LEFT_INDEX to zero
4. Iterate array from the  left till you find zero element and mark the index as LEFT_INDEX
5. Iterate array from right till you find non-zero element and mark the index as RIGHT_INDEX
6. swap zero from the left and non-zero element from the right
7. continue the iteration till LEFT_INDEX == RIGHT_INDEX
8. print RIGHT_INDEX that is number of non-zero elements
9. done


*/
public class NonZeroElements {

	public static int  alignArry(int intArray[] ) {

		int right = intArray.length;

		for(int i=0; i<right;  ) {
			
			int j=0;
			//finding next zero element from the left
			for(j=i; j<right && intArray[j] != 0 ; j++) {
			}

			
			if ( right == j  ) { //completed the iteration.
				break;
			}

			int k=0;
			//finding next non-zero element from the right
			for(k=right-1; k >= i &&  intArray[k] == 0 ; k--) {
			}

			//swap zero from the left  and non-zero from the right

			int temp = intArray[k];
			intArray[k] = intArray[j];
			intArray[j] = temp;

			i = j+1;
			right = k;
		}

		for(int i =0; i< intArray.length; i++) {
			System.out.print(intArray[i] + ",");
		}
		System.out.println();

		return right;
	}



	public static void main(String args[]) {
		int[] intArray={1,0,0,0,4,0,4,7,9,8,5,0,6};
//		int[] intArray={1,0,4,0,4,7,9,8,5,0,6};
//	int[] intArray={1,4,4,7,9,8,5,6};

		System.out.println(alignArry(intArray));
	}
}
