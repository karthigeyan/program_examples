package common.exercise.bitwise;

/**
WHAT?
Sets n'th bit of an integer number(whether n'th bit 0 or 1 , make it as 1)

For example, let us take 23, the binary representation is given below.

00010111

to set 6 bit as 1,
shift 1,  5 times to the left 
1<<5  => 00100000
and do OR operation

00010111 | 00100000 => 00110111

Refer: http://en.wikipedia.org/wiki/Bitwise_operation
	   http://code.tutsplus.com/articles/understanding-bitwise-operators--active-11301
	   http://www.scs.ryerson.ca/~mth110/Handouts/bitwise.pdf

HOW?
1. get the number (NUM) and bit position( BITPOS)
2. NUM =  NUM OR ( 1 << (BITPOS-1)) 
3. done	   
*/


public class SetNthBit {

	public static int  setNthBit(int number, int bitPos) {

		return (number | ( 1<< (bitPos-1)));
	}

	public static void main(String[] args) {
		System.out.println(setNthBit(16,3));
	}
}
