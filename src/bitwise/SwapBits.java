package bitwise;

/**
WHAT?
Swap odd and even bits in an integer with as few instructions as possible
For example, bit 0 and bit 1 are swapped, bit 2 and bit3 are swapped, and so on.

For example, let us take 23, the binary representation is given below.
00010111
==>
00101011



Refer: http://en.wikipedia.org/wiki/Bitwise_operation
	   http://code.tutsplus.com/articles/understanding-bitwise-operators--active-11301
	   http://www.scs.ryerson.ca/~mth110/Handouts/bitwise.pdf

HOW?
1. get the number (NUM) 
2. get all odd bits by  ANDing NUM with 0x55555555
3. get all even bits by ANDing NUM with 0xAAAAAAAA
4. shift odd bits to the left by 1
5. shift even bits to the right by 1
6. NUM = odd bits | even bits
7. print NUM
8. done	   
*/


public class SwapBits {

	public static int swapBits(int number) {
		int oddBits = 0;
		int evenBits = 0;

		oddBits = number & 0x55555555;
		evenBits = number & 0xAAAAAAAA;
		
		oddBits = oddBits<<1;
		evenBits  = evenBits >>1;

		return oddBits | evenBits;
	}
   
   //inefficient method
	public static int  swapBits2(int number) {
		int oddBit = 0;
		int evenBit = 0;

		for(int i=0; i<32; i+=2) {
			oddBit = (number & (1<<i)) != 0 ? 1 : 0  ;
			evenBit = (number & (1<<(i+1))) != 0 ? 1 : 0;
			//reset nth and n+1th bit 
			number = number & ~(1<<i);
			number = number & ~(1<<(i+1));

			//swap  nth and n+1th bit 
			number = number | (evenBit<<i);
			number = number | (oddBit<<(i+1));
			
		}
		return number;
	}

	public static void main(String[] args) {
		System.out.println(swapBits(23));
	}
}
