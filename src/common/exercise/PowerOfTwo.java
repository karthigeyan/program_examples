package common.exercise;

/**
WHAT?
Finds whether the given number is power of 2 or not.
1, 2, 4, 8, 16, 32 ......

HOW?
1. get the number and store it in NUM
2. init POW2 = 1
3. WHILE POW2 < NUM
	POW2 = POW2 * 2
4. if POW2 == NUM ; then print true else print false
5. done
*/


public class PowerOfTwo {

	public static boolean isPowerOfTwo(int num) {

		int pow2 = 1;
		boolean result = false;

		while ( pow2 < num) {
			pow2 += pow2;
		}
		
		return ( pow2 == num) ? true: false;

	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(16));
		System.out.println(isPowerOfTwo(120));
		System.out.println(isPowerOfTwo(1024));
	}
}
