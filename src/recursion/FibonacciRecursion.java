package recursion;

/**
WHAT?
Finds the n th fibonacci number using recursion.
Fibonacci Sequence: 0 1 1 2 3 5 8 13.....
fn = fn-1 + fn-2

Refer: http://en.wikipedia.org/wiki/Fibonacci_number
https://www.ics.uci.edu/~eppstein/161/960109.html

HOW?
1. get input N
2. check if N less or equal to 2  then return 1
3. call this algorithm recursively  fibonacci( N-1) + fibonacci(N-2)
4. print the N th fibonacci number
5. done
*/

public class FibonacciRecursion {

	public static int fibonacci(int num) {
		if( num <=2 ) {
			return 1;
		}

		return fibonacci(num-1) + fibonacci(num-2);
	}


	public static void main(String[] args) {
		System.out.println(fibonacci(10));
	}

}

