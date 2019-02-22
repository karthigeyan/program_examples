package common.exercise.bitwise;

/**
WHAT?
Resets n'th bit of an integer number(whether n'th bit 0 or 1 , make it as 0)

For example, let us take 23, the binary representation is given below.

00010111

to reset 5th bit
shift 1,  4 times to the left 
1<<4  => 00010000
take 1's complement
11101111

and do AND operation

00010111 & 11101111 => 00000111

Refer: http://en.wikipedia.org/wiki/Bitwise_operation
	   http://code.tutsplus.com/articles/understanding-bitwise-operators--active-11301
	   http://www.scs.ryerson.ca/~mth110/Handouts/bitwise.pdf

HOW?
1. get the number (NUM) and bit position( BITPOS)
2. NUM =  NUM AND (ONE's COMPLEMENT OF ( 1 << (BITPOS-1)) )
3. done	   
*/


public class ResetNthBit {

	public static int  resetNthBit(int number, int bitPos) {

		return (number & ~( 1<< (bitPos-1)));
	}

	public static void main(String[] args) {
		System.out.println(resetNthBit(23,5));
	}
}
