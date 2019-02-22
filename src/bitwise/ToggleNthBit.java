package bitwise;

/**
WHAT?
Toggles n'the bit of an integer number(if n'th bit is 0 , make it as 1 vice versa)

For example, let us take 23, the binary representation is given below.
00010111

to toggle 4th  bit ,
shift 1,  3 times to the left 
1<<3  => 00001000
and do XOR operation

00010111 ^ 00001000 => 00011111

Refer: http://en.wikipedia.org/wiki/Bitwise_operation
	   http://code.tutsplus.com/articles/understanding-bitwise-operators--active-11301
	   http://www.scs.ryerson.ca/~mth110/Handouts/bitwise.pdf

HOW?
1. get the number (NUM) and bit position( BITPOS)
2. NUM =  NUM XOR ( 1 << (BITPOS-1)) 
3. done	   
*/


public class ToggleNthBit {

	public static int  toggleNthBit(int number, int bitPos) {

		return (number ^ ( 1<< (bitPos-1)));
	}

	public static void main(String[] args) {
		System.out.println(toggleNthBit(23,4));
	}
}
