package common.exercise;

/**
WHAT?
Determine if a string has unique characters or not.
Note: Assume that all characters are ASCII only
eg.
Input: "write"
Output: unique

Input: program
Output: not unique(r appears two times)


HOW?
Method 1:
Time complexity for this method is O(N*N). Because each character is compared with all other characters.
This method is less efficient.

1. get the input string and convert it into array of characters
2. take each character from the array 
3. compare that character with all other characters
4. if it matches with any one of the character, then print false
5. goto step 2 till all characters are iterated
6. print true
7 done


Method2:
As mentioned in the program, the characters in the input string are ASCII only. So using additional byte array of size
128, the time complexity will be reduced to O(N).

1. get the input string and convert it into array of characters CHAR_ARY
2. initialize byte array(CHAR_MAP) of size 128 with zero 
3. for each character(CHAR) in the array CHAR_ARY
	check CHAR_MAP[CHAR] != 0 then return false
	else CHAR_MAP[CHAR]++

4. return true
5. done



*/

public class StringUniqChar{
	
	// time complexity - O(N*N)
	// less efficient compared to the hasUniqChars2()  method
	public static boolean hasUniqChars(String str) {
		char[] charArray = str.toCharArray();
		for(int i=0; i<charArray.length; i++ ) {
			for(int j=i+1; j<charArray.length; j++) {
				if( charArray[i] == charArray[j] ) {
					return false;
				}
			}
		}
		return true;
	}
	
	//assumed that characters in the input string  are ASCII only
	//time complexity - O(N) 
	// space complexity -additional  128 bytes needed for character map array
	// this method is efficient one compared to the previous method.
	public static boolean hasUniqChars2(String str) {

		char[] charArray = str.toCharArray();
		byte charMap[]  = new byte[128]; //it is initialized to zero

		for(int i=0; i<charArray.length; i++ ) {
			byte c = (byte)charArray[i];
			if( charMap[c] != 0 ) {
				return false;
			}
			charMap[c]++;
		}
		return true;
	}


	public static void main(String[] args) {
		System.out.println(hasUniqChars2("write"));
		System.out.println(hasUniqChars2("program"));

	}

}
