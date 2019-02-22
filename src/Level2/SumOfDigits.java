package Level2;

/**
WHAT?
Calculates sum of digits for the given number. For example, sum of digits for the number 123 will be 6(1+2+3).

HOW?
1. get the number and store it in NUM
2. init SUM=0
3. get the last digit by taking modulus 10
4. add the last digit to SUM
5. truncate the last digit in NUM by dividing it by 10
6. goto step 3 if NUM is not equal to 0
7. print SUM
8. done
*/


public class SumOfDigits {

	public static int getSum(int num) {

		int sum = 0;
		
		while( num != 0 ) {
			int digit = num % 10; // getting last digit by taking modulus
			sum  = sum + digit;
			num = num / 10; // truncate last digit
		}
		return sum;
	}

	public static void main(String[] args) {

		System.out.println(getSum(541));
	}
}
