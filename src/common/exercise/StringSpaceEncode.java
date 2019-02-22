package common.exercise;

/**
WHAT?
Replaces all spaces in a string with '%20'. You may assume that the string has sufficient space at
the end of the string to hold the additional characters, and that you are given the true length of
the string. (Use a character array so that you can  perform this operation in place)

For example,
Input: "I am fine    "
Outout: "I%20am%20fine"

HOW?
1. get the input string and convert it into character array
2. find true length of string by ignoring trailing spaces
3. iterate character array in reverse from real length
4. check if charactear is non space then copy that character to the last in array.(array has enough space in the end) 
5. check if charactear is space then and add '%', '2', '0' to the array
6. go to step 3 till all characters are iterated.
*/

public class StringSpaceEncode {


	public static void spaceEncode(char[] charArray, int realLength) {
		
		int j = charArray.length-1;

		for(int i=realLength-1; i>=0; i--) {

			if( charArray[i] == ' ') {
				charArray[j--] = '0';
				charArray[j--] = '2';
				charArray[j--] = '%';
			} else {
				charArray[j--] = charArray[i];
			}
		}

	}


	public static void main(String[] args) {
		String str = "I am fine    ";
		char[] charArray = str.toCharArray();
		int i=0;

		// finding real length of the string by ignoring traling spaces.
		for(i=charArray.length-1; i>=0 && charArray[i]==' '; i--) {
		}
		int realLength = i+1;

		spaceEncode(charArray, realLength);
		
		System.out.println(new String(charArray));


	}
}
