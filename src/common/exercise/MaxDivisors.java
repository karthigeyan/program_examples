package common.exercise;

/**
WHAT?
Finds a number from the range of  1 to  1000   which has maximum number of divisors.

HOW?
1. get the input range FROM and TO
2. init COUNT, MAX_COUNT, MAX_NUM to zero
2. for each NUM from the range(FROM, TO)
		 for each I from 1 to NUM	
			if NUM % I == 0 then COUNT++
			if COUNT > MAX_COUNT then MAX_COUNT = COUNT, MAX_NUM=NUM

3. print the number MAX_NUM and divisor count MAX_COUNT
4. done
*/

public class MaxDivisors {

	public static void findMaxDivisors(int from, int to) {

		int count = 0;
		int maxNum = 0;
		int maxCount= 0;

		for(int i=from; i<=to; i++ ) {
			count = 0;
			for(int j=1; j<=i; j++) {
				if( i % j == 0 ) {
					count++;
				}
			}
			if( count > maxCount ) {
				maxNum = i;
				maxCount = count;
			}
		}

		System.out.println(maxNum + " has " + maxCount + " divisors");
	}


	public static void main(String[] args) {
		findMaxDivisors(0, 1000);
	}
}
