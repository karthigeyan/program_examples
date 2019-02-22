package recursion;

/**

WHAT? 

In mathematics, the factorial of a non-negative integer n, denoted by n!, is the product of all positive integers less than or equal to n. For example, The value of 0! is 1, according to the convention for an empty product
eg 4! => 4*3*2*1 => 24

HOW?

1. get input NUM
2. check if NUM is zero then return 1
3. call this algorithm recursively  with NUM-1 
4. done
*/



public class FactorialRecursion {

	public static long factorial(int num) {
		if ( num == 0 ) {
			return 1;
		}
		return num * factorial(num-1) ;
	}

	public static void main(String[] args) {
		System.out.println( factorial(4));
	}
}

