package common.exercise.bitwise;

/**
WHAT?
Find number of 1's(binary 1's)  in an integer using bitwise operator.
eg 4 -> 100 => there is one 1
   7 -  111 => there are three 1's
  
take for same example 8bit integer 23 (00010111)

shift 1 to the left side one time and do bitwise AND operation with the given number
00010111  &  00000001  != 0 then increment bitcount
shift 1 to the left  two times
10010111 &   00000010  != 0 then increment bitcount

continue above the steps till all 8 bits are checked. Likewise , for 32bit integer above steps should be done for 32 times.

Refer: http://en.wikipedia.org/wiki/Bitwise_operation
	   http://code.tutsplus.com/articles/understanding-bitwise-operators--active-11301
	   http://www.scs.ryerson.ca/~mth110/Handouts/bitwise.pdf



HOW?
1. get the number and store it in NUM
2. take each bit from the number and check whether it is one or zero
3. left shift 1  and do bitwise AND  with the given number
4. if it is	non zero , then increment BITCOUNT
5. goto step step 3 till all the bits are checked
6. print BITCOUNT
7. done
*/


public class BitsCount {


	public static int bitCount(int num) {
		int bitcnt = 0;

		for(int i=0; i<32; i++ ) {
			if ( (num & (1<<i)) != 0 ) {
				bitcnt++;
			}
		}
		return bitcnt;
	}

	public static void main(String[] args) {
		System.out.println(bitCount(15));
	}
}
