package Level3;

/**
WHAT?
Finds the given number is  in the given sorted integer array using  binary search.
boolean hasNumber(int ary[], int num);
Input: ary - sorted array
       num - number to be searched in the array.

Output: should return true if num is in the array  else return false.

Refer: http://en.wikipedia.org/wiki/Binary_search_algorithm

HOW?
1. get the input integer array and the number to be found in the array
2. init left index to zero and right index to array length -1
3. find middle index( left + (right-left)/2)
4. check the given number  is at middle index, if it is return true
5. if number is less than middle element, then  assign right  = middle-1
6. if number is  greather middle element , then assign left = middle+1
7. go to step 3 till left is less than or equal to right
8. return false
9. done   

*/

public class BinarySearch {

	public static boolean hasNumber(int[] intArray, int num) {
		int left = 0;
		int right = intArray.length-1;
		int middle = left + (right-left)/2 ;

		while( left <= right) {
			middle = left + (right-left)/2 ;

			if( intArray[middle] == num) {
				return true;
			}

			if( num < intArray[middle] ) {
				right = middle-1;
			}
			if ( num > intArray[middle] ) {
				left = middle+1;
			}
		}
		return false;
	}

	public static void main(String[] args ) {
		int[] intary=  { 10, 20, 30, 40, 50, 60, 70};

		System.out.println(hasNumber(intary, 3));
		
	}
}
