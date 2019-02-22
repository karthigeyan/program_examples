package common.exercise;

/**
WHAT?

Finds the largest sum of contiguous integers in the array
Example: 
if the input is (-10, 2, 3, -2, 0, 5, -15), the largest sum is 8(2,3,-2,0,5)

HOW?
1.get the input integer array
2. init SUM=0
3. iteragte the integer array
		iterate the same array with starting index from the outer loop index
		sum integers progressively(TEMP_SUM) and if the TEMP_SUM is greather than SUM , then SUM=TEMP_SUM
4. print SUM
5. done
*/

public class SumOfContiguousInt {

	public static int sum(int[] intArray) {

		int sum =  0;

		for(int i = 0; i < intArray.length; i++ ) {
			int tempSum = 0;
			for(int j=i; j< intArray.length;j++) {
				 tempSum += intArray[j];
				 if( tempSum > sum ) {
					 sum = tempSum;
				 }
			}
		}
		
		return sum;
	}


	public static void main(String args[]) {

		int[] intArray ={-10, 2, 3, -2, 0, 5, -15};
		System.out.println(sum(intArray));
	}
}
