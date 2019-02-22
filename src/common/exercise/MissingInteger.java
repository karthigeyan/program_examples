package common.exercise;

/**
WHAT?
You are given an array with integers between 1 and 1,000,000 both inclusive. One integer is missing. Size of the array is 1000000. Numbers are randomly added to the array , but there is one number is missing. The missing slot in the array h
as value of 0.  How can you determine which one? Can you think of a way to do it while iterating through the array only once.  

HOW?
1. get the integer array
2. find actual sum (ACTUAL_SUM) by adding all elements in the array
3. find real sum(SUM) by N*(N+1)/2 where N is size of array.
4. print SUM-ACTUAL_SUM
5. done


*/

public class MissingInteger {

	public static int findMissingInt(int[] intArray){
		//sum of first n natural number is n(n+1)/2		
		int sum = (intArray.length * (intArray.length+1))/2;

		int actualSum = 0;
		for(int i=0; i< intArray.length; i++) {
			actualSum += intArray[i];
		}
		return sum - actualSum;
	}

	public static void main(String[] args ) {
		//for testing, size of array is taken as 10
		// integer range is 1 to 10
		// 8 is missing in the array
		int intArray[] = {4,3,0,10,2,9,7,1,5,6};
		System.out.println(findMissingInt(intArray));
	}
}
