package common.exercise;

/**
WHAT?
Find frequency of characters in a string.(only ASCII caracters).
Hint: use character map array for efficient iteration
Example:
Input : "all is well"
Output:
' ' - 2
a - 1
e - 1
i - 1
l - 4
s - 1
w - 1


HOW?
As mentioned in the program, the characters in the input string are ASCII only. So using additional byte array of size
128, the problem can be solved easily.

1. get the input string and convert it into array of characters CHAR_ARY
2. initialize byte array(CHAR_MAP) of size 128 with zero 
3. for each character(CHAR) in the array CHAR_ARY
	  CHAR_MAP[CHAR]++

4. for each character in CHAR_MAP 
	print character and character frequency

5. done

*/

public class CharacterFrequency{
	
	public static void findCharacterFrequency(String str) {

		char[] charArray = str.toCharArray();
		byte charMap[]  = new byte[128]; //by default, it is initialized to zero

		for(int i=0; i<charArray.length; i++ ) {
			byte c = (byte)charArray[i];
			charMap[c]++;
		}
		for(int i=0; i<charMap.length; i++ ) {
			if( charMap[i] != 0 ) {
				System.out.println((char)i + " : " + charMap[i] );
			}
		}
	}


	public static void main(String[] args) {
		findCharacterFrequency("Hello, I am fine");
	}

}
