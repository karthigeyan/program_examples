package common.exercise;

/**
WHAT?
Converts the given number of  base b1 into another number of base b2.

For example,  decimal number(base10) is converted into binary(base2)
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


public class BaseConversion {

	//converts decimal number(base 10)  to binary, octal and hexadecimal
	private static String convertDeciaml(int num, int toBase) {

		int digit = 0;
		char digitAry[] = new char[32]; // integer is 32 bit number.
		int i = 0;
		
		if ( toBase !=2  && toBase != 8 && toBase != 16) {
			throw new NumberFormatException();
		}
		while(num > 0 ) {
			 digit =  num % toBase;
			 if( digit >= 10 && digit <= 15 ) {
				 digitAry[i++] =(char) ('A' + digit - 10);
			 }else {
				 digitAry[i++] = (char) ('0' + digit);
			 }
			 num = num /toBase;
		}

		reverseArray(digitAry);
		return new String(digitAry);

	}

	private static void reverseArray(char[] ary) {
		for(int i = 0; i < ary.length / 2; i++) {
			char temp = ary[i];
			ary[i] = ary[ary.length - 1 - i];
			ary[ary.length - 1 - i] = temp;
		}
	}


	//converts decimal number(base 10)  to binary, octal and hexadecimal
	private static int toDeciaml(String numStr, int toBase) {

		char[] charary= numStr.toCharArray();
		int decimal = 0;
		int digit;

		if ( toBase !=2  && toBase != 8 && toBase != 16) {
			throw new NumberFormatException();
		}

		for(int i=0; i<charary.length; i++ ) {

			if( toBase == 16 && (  (charary[i] >= '0' && charary[i] <='9') 
						|| (charary[i] >= 'A' && charary[i] <= 'F') ||  (charary[i] >= 'a' && charary[i] <= 'f'))) {

				if( charary[i] > 'a' ) {
					digit = charary[i] - 'a' + 10; 
				} else if( charary[i] > 'A' ) {
					digit = charary[i] - 'A' + 10; 
				} else {
					digit = charary[i] - '0'; 
				}

			} else if ( toBase == 8 && ( charary[i] >= '0' && charary[i] <= '7')) {
				digit = charary[i] - '0';

			}else if ( toBase == 2 && ( charary[i] >= '0' && charary[i] <= '1')) {
				digit = charary[i] - '0';

			}else {
				throw new NumberFormatException();
			}

			decimal = decimal * toBase + digit;
		}
		return decimal;
	}


	public static void main(String[] args) {
		System.out.println(convertDeciaml(7,2));
		System.out.println(convertDeciaml(20,8));
		System.out.println(convertDeciaml(30,16));
		System.out.println(toDeciaml("10000000", 2));
		System.out.println(toDeciaml("247", 8));
		System.out.println(toDeciaml("1F", 16));
	}
}
