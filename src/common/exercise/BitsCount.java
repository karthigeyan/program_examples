package common.exercise;

/**
WHAT?
Find number of 1's(binary 1's)  in an integer.
eg 4 -> 100 => there is one 1
   7 -  111 => there are three 1's


Deciaml number can be converted into binary by dividing the decimal by 2 and getting reminder as mentioned below.

      DIV   REM
7/2    3     1
3/2    1     1
1/2    0     1

bits - 111
	   
        DIV   REM
10/2     5     0
5/2      2     1
2/2      1     0
1/2      0     1

bits - 1010


HOW?
1. get the number and store it in NUM
2. divide NUM by 2 and get the reminder 
3. if reminder is one then increment BITCOUNT
4. goto step2  till NUM becomes zero
5. print BITCOUNT
6. done
*/


public class BitsCount {

	public static int bitCount(int num) {
		int bitcnt = 0;
		
		while(num > 0 ) {
			 if ( num % 2 == 1 ) {
				 bitcnt++;
			 }
			 num = num /2;
		}
		return bitcnt;
	}

	public static int bitCount2(int num) {
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
		System.out.println(bitCount(128));
	}
}
