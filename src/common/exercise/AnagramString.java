package common.exercise;

/**
WHAT?
Checks two strings if one is an anagram of the other.

What is Anagram?
A word can be formed from another word by rearranging its letters.
For example,
"silent" which can be rearranged to "listen"

HOW?
1.get two input strings and convert into respective character array
2.check length of the two string. if not equal print false
3.sort first array  using quick sort
4.sort second array  using quick sort
5.compare two arrays. if not equal print false else print true.
6.done
*/

public class AnagramString {

	public static boolean isAnagram(String str1, String str2) {
		char[]  cArray1 = str1.toCharArray();
		char[]  cArray2 = str2.toCharArray();

		if( cArray1.length != cArray2.length) {
			return false;
		}

		//sort string 1
		int left = 0;
		int right = cArray1.length-1;
		quicksort(cArray1, left, right);

		//sort string 2
		left = 0;
		right = cArray2.length-1;
		quicksort(cArray2, left, right);

		//compare two string if equal return true else return false
		for (int i=0; i<cArray1.length; i++) {
			if( cArray1[i] != cArray2[i] ) {
				return false;
			}
		}
		return true;
	}

	public static void quicksort(char[] charArray, int left, int right) {
		int i = left;
		int j = right;
		char pivot = charArray[left + (right-left)/2];

		while( i<= j) {

			for(;charArray[i] < pivot; i++) {
			}
 
			for(; charArray[j] > pivot; j--) {
			}

			if( i <= j) {
				char temp = charArray[j];
				charArray[j] = charArray[i];
				charArray[i] = temp;
				i++;
				j--;
			}
		}

		if( left < j) {
			quicksort(charArray, left, j);
		}
		if( i < right ) {
			quicksort(charArray, i, right);
		}

	}

	public static void main(String[] args ) {
		
		String str1 = "photo";
		String str2 = "hootp";
		System.out.println(isAnagram(str1, str2));

	}
}
