package common.exercise;

/**
WHAT?
check  if the value of a binary number (passed as a string) equals the hexadecimal representation of a string.
eg. "01001111" == "4F"

HOW?
1. get the input binary string and hexa string
2. convert binary string into decimal
3. convert hexa string into decimal
4. check for equal 
5. done

*/

public class HexaBinaryString{
	

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

		String binStr = "01001111";
		String hexStr = "4F";

		int dec1 = toDeciaml(binStr, 2);
		int dec2 = toDeciaml(hexStr, 16);
		if( dec1 == dec2 ) {
			System.out.println(binStr + " == " + hexStr);
		} else {
			System.out.println(binStr + " == " + hexStr);
		}
	}
}
