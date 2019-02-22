package common.exercise;

/**
WHAT?
Calculates  sum of two largest integer in an array .
For example
Input= {20, 8, 45, 10, 32, 9, 3};
Output = 77

HOW?

Medthod 1 : 
Time complexity for this method is O(N).

1. get the input integer array INT_ARRAY
2. initialize MAX1= INT_ARRAY[0], MAX2=INT_ARRAY[0]
3. iterate the integer array
		check  INT > MAX2 then 
		  	check if INT > MAX1 then MAX2=MAX1 and MAX1 = INT
			else MAX2=INT

4. print MAX1 + MAX2
5. done

Method 2 :
Time complexity for this method will be  O(NlogN) if quick sort algorithm is used. 

1. get the input integer array INT_ARRAY
2. sort the array in descending order using quick sort
3. sum top two elements
4. done


*/

public class SumOfTwoLargeInt {

	public static int sum(int[] intArray) {

		int max1 = intArray[0];
		int max2 = intArray[0]; 

		//find max and min and repective indexes.
		for(int i = 0; i < intArray.length; i++ ) {
			//find max element and respective index
			if( intArray[i] > max2 ) {
				if( intArray[i] > max1 ) {
					max2 = max1;
					max1 = intArray[i];
				} else {
					max2 = intArray[i];
				}
			}
		}
		
		return max1 + max2;
	}


	public static void main(String args[]) {

		int[] intArray = {20, 8, 45, 10, 32, 9, 3};
		System.out.println(sum(intArray));
	}
}
