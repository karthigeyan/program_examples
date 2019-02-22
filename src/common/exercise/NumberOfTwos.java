package common.exercise;

/**
WHAT?
Counts the number of 2' that appear in all the numbers between 0 and n.
eg.
Input: 25
Output: 9 (2, 12,20,21,22,23,24,25. note: 22 counts for two 2's)


HOW?
1. get the number and store it in NUM
2. init COUNT=0
3. iterate loop from 1 to NUM
4. assign each number in TEMPNUM
5. get the last digit of TEMPNUM by taking modulus 10
6. if last digit is two then increment COUNT
7. truncate the last digit in TEMPNUM by dividing it by 10
8. goto step 5 if TMPNUM is not equal to 0
9. goto step 3 till all numbers between 1 and NUM are iterated
10.print COUNT
11.done
*/


public class NumberOfTwos {

	public static int countTwos(int num) {

		int count = 0;
		
		for(int i=1; i<=num; i++ ) {

			int tempNum = i;
			while( tempNum != 0 ) {
				if ( tempNum % 10 == 2 ) { // getting last digit by taking modulus
					count++;
				}
				tempNum = tempNum / 10; // truncate last digit
			}
		}
		return count;
	}

	public static void main(String[] args) {

		System.out.println(countTwos(25));
	}
}
