package common.exercise;

/**
WHAT?
Checks whether the given three digit number is armstrong or not.
A three digit number is armstrong if the sum of cubes of individual digits of a number is equal to the number itself
For example
371 => 3*3*3 + 7*7*7 + 1*1*1 => 371


HOW?
1. get the number and store it in NUM
2. init SUM=0 and assign NUM to NUMSAV
3. get the last digit by taking modulus 10
4. get cube of the last digit and add it to SUM:
5. truncate the last digit in NUM by dividing it by 10
6. goto step 3 if NUM is not equal to 0
7. if SUM == NUMSAV then it is an armstrong number
8. done

*/


public class ArmstrongNum {

	public static boolean isArmstrong(int num) {

		int sum = 0;
		int numsave = num;
		
		while( num != 0 ) {
			int digit = num % 10; // getting last digit by taking modulus
			sum  = sum  + digit * digit * digit; // take cube of the last digit and add it to sum
			num = num / 10; // truncate last digit
		}

		if ( numsave == sum ) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		System.out.println(isArmstrong(371));
		System.out.println(isArmstrong(243));
	}
}
