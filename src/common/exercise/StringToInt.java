package common.exercise;

/**
WHAT?
convert a number in  string  to integer without using any APIs for conversion.
"248" = > 248

Refer : http://en.wikipedia.org/wiki/ASCII

HOW?
1. get the number as string store it in STRNUM
2. init INTNUM = 0
3. convert it into character array and store it in  NUMCHAR
4. FOR EACH char in NUMCHAR
	DIGIT = CHAR - '0'
	INTNUM = INTNUM * 10 + DIGIT
5. print INTNUM
6. done


*/


public class StringToInt {

	public static int toInteger(String strnum) {

		char[] numchar = strnum.toCharArray();
		int intnum = 0;
		int digit;

		for(int i=0; i<numchar.length; i++ ) {
			digit = numchar[i] - '0';
			intnum = intnum * 10 + digit;
		}
		return intnum;
	}

	public static int toInteger2(String strnum) {

		char[] numchar = strnum.toCharArray();
		int intnum = 0;
		int digit;
		int i = 0;
		int multi = 1;

		//number could be "+234" ,"-234" or "234"
		if( numchar[0] == '-' || numchar[0] == '+' ){
			multi = numchar[0] == '-' ? -1:1;
			i = 1;
		}

		for(; i<numchar.length; i++ ) {

			// validates whether the characters are in the ranage of '0' to '9',
			// otherwise throws NumberFormatException .
			if ( numchar[i] < '0' ||  numchar[i] > '9' ) {
				throw new NumberFormatException();
			}
			digit = numchar[i] - '0';
			intnum = intnum * 10 + digit;
		}
		return intnum * multi;
	}



	public static void main(String[] args) {

		System.out.println(toInteger("123"));
		System.out.println(toInteger2("-123"));
		System.out.println(toInteger2("A123"));
	}
}
