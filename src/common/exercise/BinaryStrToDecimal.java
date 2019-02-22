package common.exercise;

/**
WHAT?
Converts binary string into a decimal value without using any conversion APIs.
eg. "111" => 7



HOW?
1. get the binary number as a string and store it in BINSTR
2. init DECIMAL = 0
3. convert BINSTR into character array and store it in  BITCHARS
4. FOR EACH char in  BITCHARS
	DIGIT = CHAR - '0'
	DECIMAL = DECIMAL * 2 + DIGIT
5. print DECIMAL
6. done


*/


public class BinaryStrToDecimal {

	public static int toDeciaml(String binStr) {

		char[] bitchars = binStr.toCharArray();
		int decimal = 0;
		int digit;

		for(int i=0; i<bitchars.length; i++ ) {
			digit = bitchars[i] - '0';
			decimal = decimal * 2 + digit;
		}
		return decimal;
	}

	//this methods validates the given input 
	// NumberFormatException will be thrown for invalid input
	public static int toDeciaml2(String binStr) {

		char[] bitchars = binStr.toCharArray();
		int decimal = 0;
		int digit;

		for(int i=0; i<bitchars.length; i++ ) {
			digit = bitchars[i] - '0';
			if( digit != 1 && digit != 0 ) {
				throw new NumberFormatException();
			}
			decimal = decimal * 2 + digit;
		}
		return decimal;
	}



	public static void main(String[] args) {

		System.out.println(toDeciaml("1010"));
	}
}
