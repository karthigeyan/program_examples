package common.exercise;

/**
WHAT?
Finds the longest substring with unique characters in O(n) time. 

HOW?
This could be solved in  O(n) by using array of size 256.It is assumed that all characters are ASCII. The array stores the index  of character last visited.

1. get the string and sub string
2. init start and end index 
3. init max start and max end index 
3. init integer array of size 256 to store index of last visited character in the stirng.
4. iterate character array
5. check if character is already present the array
6. if true then get start and end index and compare with max start and max end index
7. else add it to the array
8. goto step 4 till all characters are iterated.
9. print character between max start and max end characters
10. done
*/

public class LongestSubstring {

	public static String subString(String mainStr ){
		int[] charMap = new int[256]; //it is assumed that string contains only ASCII characters.
		// it stores last visited character index
		char[] mainStrChars = mainStr.toCharArray(); 

		int sIdxMax = 1;
		int eIdxMax  = 1;
		
		int sIdx = 1;
		int eIdx = 0;

		int i;

		for(i=0; i< mainStrChars.length;i++ ) {
			int c = mainStrChars[i];

			if( charMap[c] != 0 ) {  // character already present the map
				eIdx = i+1; // 
				if( charMap[c] >= sIdx ) {
					if( eIdx-sIdx >= eIdxMax - sIdxMax) {
						sIdxMax = sIdx;
						eIdxMax = eIdx;
					}
					sIdx = charMap[c]+1; //move start index
				} 	
			}
			charMap[c] = i+1; //store index of next character
		}

		if( i - sIdx >= eIdxMax - sIdxMax ) {
			sIdxMax = sIdx;
			eIdxMax = i+1;
		}
		return new String(mainStrChars, sIdxMax-1, eIdxMax-sIdxMax);
	}

	public static void main(String[] args) {
		System.out.println(subString("abcdbaefhijk"));
		System.out.println(subString("abcd"));
		System.out.println(subString("abcdab"));
		System.out.println(subString("abcdabefhdefomnoasopmnoq"));
		System.out.println(subString("abcdabefghijk"));
	}
}
