package Level1;

/**

WHAT? 

In mathematics, the factorial of a non-negative integer n, denoted by n!, is the product of all positive integers less than or equal to n. For example, The value of 0! is 1, according to the convention for an empty product
eg 4! => 4*3*2*1 => 24

HOW?

1. get  input value and set it in NUM
2. if NUM is less than zero , print error message and go to step 6
3. set FACT equal to 1
4. for I = 0; I <= N; I++
		FACT = FACT * I
5. print FACT
6. done

*/



public class Factorial {

	public static long factorial(int num) {

		if ( num < 0 ) {
			System.out.println("Invalid input: number is negative");
			return 0;
		}

		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}

		return fact;
	}

	public static void main(String[] args) {
		System.out.println( factorial(4));
	}
}

