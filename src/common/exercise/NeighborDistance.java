package common.exercise;

/**
WHAT?
Finds the smallest distance between two neighbouring numbers in an array.It returns the index of the first number.

For example:
In the sequence 4 8 6 1 2 9 4 the minimum distance is 1 (between 1 and 2). 
It should return the index 3 (of number 1).


HOW?
1. get the input integer array
2. init DISTANCE = subtract first two elements in the array and INDEX=0
3. iterate the array from the second the element
4. subtract adjacent elements and compare with DISTANCE, if it is less than DISTANCE
   then assign it in DISTANCE and assign corresponding index to INDEX.
5. goto step 3 till all elements are iterated
6. return INDEX
7. done
*/

public class NeighborDistance {

	public static int findIndex(int[] intArray) {

		int distance =  0;
		int idx = 0;
		int d =  intArray[0] - intArray[1];
		distance  = Math.abs(d);

		for(int i = 1; i < intArray.length-1; i++ ) {
			d =  Math.abs(intArray[i] - intArray[i+1]);
			
			if( d < distance ) {
				distance = d;
				idx = i;
			}
		}
		return idx;
	}


	public static void main(String[] args) {
		int[] intArray = {4, 8, 6, 1, 2, 9, 4};

		System.out.println(findIndex(intArray));

	}
}

