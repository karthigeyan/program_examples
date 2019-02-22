package Level2;

/**
WHAT?
Reverses the given intege number. For example, integer 123 will be converted into 321.

HOW?
1. get the number and store it in NUM
2. init REV=0
3. get the last digit by taking modulus 10
4. multiply REV by 10 and add the last digit:
5. truncate the last digit in NUM by dividing it by 10
6. goto step 3 if NUM is not equal to 0
7. print REV
8. done
*/


public class ReverseNumber {

	public static int getReverse(int num) {

		int rev = 0;
		
		while( num != 0 ) {
			int digit = num % 10; // getting last digit by taking modulus
			rev = rev*10 + digit;
			num = num / 10; // truncate last digit
		}
		return rev;
	}

	public static void main(String[] args) {

		System.out.println(getReverse(541));
	}
}
