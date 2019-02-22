package common.exercise;

/**
WHAT?
Checks wether the given string palindrome string or not.
A string is called palindrome  if it is symmetric. String remains same if its characters are reversed.
eg "malayalam"




HOW?
1. get the  character array(string converted into character array)
2. init two indexes. one points from the left(starts with 0) and other index from the right(starts with array.length)
3. compare characters from left and right
4. if characters are not same, string is not palindrom and break from loop
5. else increment left and rigth index and continue to step3
6. done


*/


public class PalindromeString {

	public static boolean isPalindrome(String str) {

		char[] charary = str.toCharArray();
		int i = 0;
		
		for(i = 0; i < charary.length / 2; i++) {
			if (charary[i] !=  charary[charary.length - 1 - i]) {
				break;
			}
		}

		if( i == charary.length/2) {
			return true;
		} else { 
			return false;
		}
	}


	public static void main(String[] args) {
		String str = "malayalam";
		System.out.println(isPalindrome(str));
	}
}
