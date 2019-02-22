package Level1;

/**

WHAT?
Calculates sum and average for the given array of numbers.
[0,20,15,10,35]
SUM = 80
AVE = 80/5 = 16

HOW?
1. get the array of integer numbers  and store it in integer array NUMS[]
2. init SUM = 0
   init AVERAGE = 0;	
3. for I=0; I< NO_OF_ELEMENTS_IN_ARRAY ; I++
	SUM = SUM + NUMS[I]
4. AVERAGE = SUM / NO_OF_ELEMENTS_IN_ARRAY
5. print SUM, AVERAGE
6. done
*/


public class SumAverage {

	public static int getSum(int[] nums) {
		
		int sum = 0;
		for(int i = 0; i < nums.length; i++ ) {
			sum = sum + nums[i];
		}
		return sum;
	}

	public static void main(String[] args) {

		int[] nums = {0,20,15,10,35};

		int sum = getSum(nums);
		double average = sum /nums.length ;
		
		System.out.println("SUM = " + sum);
		System.out.println("AVERAGE = " + average);
	}
}
