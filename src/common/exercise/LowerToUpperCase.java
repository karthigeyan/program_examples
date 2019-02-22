package common.exercise;

/**
WHAT?
Converts lowercase letters in a string to uppercase letters.

Refer : http://en.wikipedia.org/wiki/ASCII
'A' - 65
'B' - 66
 .
 .
'Z' - 90

'a' - 97
'b' - 98
.
.
.
'z' - 122

How 'b' can be converted to 'B'?
'A' + 'b' - 'a'
65 +  98 - 97
65 +1
66
'B'

HOW?
1. get the string to be converted 
2. convert it into character array and store it in  CHARARY
3. FOR EACH char in CHARARY
	IF char is in 'a' to 'z' range ; then convert it into uppercase
	CHARARY[I] = 'A' + ( CHARARY[I] - 'a' )
4. convert CHARARY to string
5. print string
6. done


*/


public class LowerToUpperCase {

	public static String toUpper(String str) {

		char[] charary = str.toCharArray();

		for(int i=0; i<charary.length; i++ ) {
			if(charary[i] >= 'a' && charary[i] <= 'z')  {
			//	charary[i] = 'A' + charary[i] - 'a';
			}
		}
		return new String(charary);
	}



	public static void main(String[] args) {

		System.out.println(toUpper("Hello World"));
	}
}
