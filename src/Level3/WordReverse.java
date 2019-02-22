package Level3;

/**
WHAT?
Reverse each word in a sentence stored in a character array. The sentence will be given as input.
Eg:  all is well -> lla si llew
Note: Do not use any java api, also do not  use another array





HOW?
1. get the  character array(string converted into character array)
2. iterate the array till space is found and ignore consecutive spaces
3. find the start and end index of the word in the array
4. reverse the word in-place  using start and end index.(swapping characters)
5. goto step2 for the next word and till all characters are iterated.
6. print the reversed the string
7. done

*/


public class WordReverse {
	
	public static void reverseWords(char[] charArray) {

		int low = 0;
		int high = 0;
		for(int i=0; i<charArray.length; i++)  {

			
			if( charArray[i] == ' ' ) { 
				high = i;//word ends here
				reverseString(charArray, low, high);
				//ignoring consecutive spaces
				for(;charArray[i] == ' '; i++) {
				}
				//next word starts here	
				low = i;
			}
		}

		// reverse last word
		reverseString(charArray, low, charArray.length);

	}

	public static void reverseString(char[] charary,int low , int high) {
		int middle = low + (high-low)/2;

		for(int i = low; i < middle && high>=0; i++, high--) {
			char temp = charary[i];
			charary[i] = charary[high - 1 ];
			charary[high - 1 ] = temp;
		}
	}



	public static void main(String[] args) {
		String str = "All is well";
		char[] charary = str.toCharArray();
//		reverseString(charary, 0, charary.length);
		reverseWords(charary);

		System.out.println(new String(charary));
	}
}
