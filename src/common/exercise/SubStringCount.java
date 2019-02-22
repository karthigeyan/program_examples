package common.exercise;

/**
WHAT?
Find the number of occurances of a substring in a given string.
Input String : This is a test string
Substring    : is
Count: 2

HOW?
1. get the string and sub string
2. iterate each character in the main string
3. compare with substrig characters
4. if substring characters match characters in the main string then increment counter
5. goto step2 till all characters are iterated
6. print sub string count
7. done
*/

public class SubStringCount {

	public static int subString(String mainStr, String subStr){
		char[] mainStrChars = mainStr.toCharArray(); 
		char[] subStrChars = subStr.toCharArray(); 
		int subStrCnt = 0;

		for(int i=0; i< mainStrChars.length; ) {
			
			int j = 0;
			//compare main string with sub string
			for(j=0; j<subStrChars.length && mainStrChars[i+j] == subStrChars[j] ; j++) {
			}

			if( j == subStrChars.length) { // substring found
				subStrCnt++;
				i = i+j;
			}else {
				i++;
			}

		}
		return subStrCnt;
	}

	public static void main(String[] args) {
		System.out.println(subString("This is a test string", "st"));
	}
}
