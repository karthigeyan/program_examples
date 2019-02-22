package common.exercise;

/**
WHAT?
Converts the given decimal number into binary.
For example
7 => 0111
10=> 1010
15 => 1111

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
2. divide NUM by 2 and get the reminder and print it
3. continue step2  till NUM becomes zero
4. done
*/


public class DecimalToBinary {

	public static void toBinary(int num) {
		int bit = 0;
		int bitary[] = new int[32]; // integer is 32 bit number.
		int i = 0;
		
		while(num > 0 ) {
			 bit =  num % 2;
			 bitary[i++] = bit;
			 num = num /2;
		}

		for( int j = i-1; j>=0; j--) {
			System.out.print(bitary[j]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		toBinary(7);
		toBinary(10);
		toBinary(0);
		toBinary(128);
	}
}
