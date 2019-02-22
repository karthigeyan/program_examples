package common.exercise.bitwise;

/**
WHAT?
Finds whether the given number is power of 2 or not by using bitwise operator
1, 2, 4, 8, 16, 32 ......
For example , number 16
00010000
subtract the given number with 1
here it is 16-1 = 15
00001111

do bitwise AND operations
00010000
&
00001111
it will be zero. so it is power of two. 

When the number which is power of two is subtracted by one, you will get  1's complement of the given number. If you do AND operation, then you will get zero as result.


Refer: http://en.wikipedia.org/wiki/Bitwise_operation
	   http://code.tutsplus.com/articles/understanding-bitwise-operators--active-11301
	   http://www.scs.ryerson.ca/~mth110/Handouts/bitwise.pdf



HOW?
1. get the number and store it in NUM
2. if NUM AND ( NUM-1) is zero  then it is power of zero
   else false
3. done	   
*/


public class PowerOfTwo {

	public static boolean isPowerOfTwo(int num) {
		if ( (num & (num-1) )== 0 ) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(16));
		System.out.println(isPowerOfTwo(120));
		System.out.println(isPowerOfTwo(1024));
	}
}
