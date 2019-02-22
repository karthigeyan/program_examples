package common.exercise;

/**
WHAT?
String as character array is reversed in place  without using another array.




HOW?
1. get the  character array(string converted into character array)
2. init two indexes. one points from the left(starts with 0) and other index from the right(starts with array.length)
3. swap characters from left and right
4. increment left index and decrement right index
5. goto step 3 till left index < right index
6. done


*/


public class StringReverse {

	public static void reverseString(char[] charary) {
		for(int i = 0; i < charary.length / 2; i++) {
			char temp = charary[i];
			charary[i] = charary[charary.length - 1 - i];
			charary[charary.length - 1 - i] = temp;
		}
	}


	public static void main(String[] args) {
		String str = "Hello";
		char[] charary = str.toCharArray();

		reverseString(charary);

		System.out.println(new String(charary));
	}
}
