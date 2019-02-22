package Level1;

/**
WHAT?
The lowest common multiple (LCM) of two whole numbers is the smallest whole number which is a multiple of both

Example
Let us take two number as 12 and 16
Multiples of 12 are : 12, 24, 36, 48, ...
Multiple of 16 are : 16, 32, 48, 64,...
Therefore , the lowest common multiple of 12 and 16 is 48.

HOW?
1. get input values and store it in NUM1 and NUM2
2. assign NUM1 in MUL1
3. assign NUM2 in MUL2
4. WHILE MUL1 != MUL2
		IF MUL1 < MUL2
			THEN multiply NUM1 as MUL1 = MUL1 + NUM1
		ELSE MUL1 > MUL2
			THEN multiply NUM2 as MUL2 = MUL2 + NUM1
5. print MUL1 or MUL2
6. done
*/


public class LCM {

	public static int getLCM(int num1, int num2) {

		int mul1= num1;
		int mul2 = num2;

		while ( mul1 != mul2) { // continue the loop till multiple of num1 and num2 are same

			if (mul1 < mul2 ) {
				mul1 += num1; // multiply num1 if multiple of num1 is less than multiple of num2
			}else if (mul1 > mul2 ) {
				mul2 += num2; // multiply num2 if multiple of num2 is less than multiple of num1
			}
		}
		return mul1;
	}

	public static void main(String[] args) {

		System.out.println(getLCM(12, 16));
	}
}
