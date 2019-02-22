package common.exercise;

/**
WHAT?
Prints first 1000 fibonacci  numbers.
Fibonacci Sequence: 0 1 1 2 3 5 8 13.....
fn = fn-1 + fn-2

Refer: http://en.wikipedia.org/wiki/Fibonacci_number
https://www.ics.uci.edu/~eppstein/161/960109.html

HOW?
1. get number of fibonacci sequence  numbers need to be printed(FIB_COUNT)
2. init F1 = 0, F2=1
3. print F1, F2
4. F = F1 + F2
5. print F
6. F1 = F2
7. F2 = F
8. increment COUNT
8. check COUNT is not equal  to FIB_COUNT,then go to step 4
7. done

*/

public class Fibonacci {

	public static void printFibonacciSequence(int count) {
		int f;
		int f1 = 0;
		int f2 = 1;

		System.out.print(f1 + " " + f2);

		for(int i=0; i<count; i++ ) {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
			System.out.print(" " + f);
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		printFibonacciSequence(1000);
	}

}

