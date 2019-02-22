package common.exercise;

/**
WHAT?
Performs run length encoding on the given string. It basically compresses the string using the number of 
repeated characters.

For example, 
"deeggillmmmm" will become "d1e2g2i1l2m4". If the encoded string is larger  than the original string,it should 
retain the original string.



HOW?
1. get the input string and convert it into character array CHARS
2. create new array ENC_CHARS of size CHARS.LENGTH
3. iterate CHARS 
4. check for consecutive  same characters and increment COUNT
5. copy the CHAR and COUNT in ENC_CHARS array
6. goto step 3 till all characters are iterated
7. if length ENC_CHARS is greather than CHARS then return CHARS else return ENC_CHARS
8. done



*/

public class RunLengthEncoding {

	public static String encode(String str) {
		char chars[] = str.toCharArray();

		char c ;
		int  eIdx = 0;
		char encChars[] = new char[chars.length];
		int count = 0;

		for (int i=0; i<chars.length; i += count  ){
			
			c = chars[i];
			count = 0;


			for(int j=i; j<chars.length && chars[j] == c ; j++,count++) {
			}

			//convert character count into string
			String cntStr = Integer.toString(count);
			int cntStrLen = cntStr.length();

			if( eIdx + cntStrLen + 1  > chars.length ) {
				eIdx += cntStrLen + 1;
				break;
			}

			encChars[eIdx++] = c;
			for(int j=0; j<cntStrLen; j++) {
				encChars[eIdx++] = cntStr.charAt(j);
			}

	//		encChars[eIdx-2] = c;
	//		encChars[eIdx-1] = (char)('0' + count);
		}

		
		if( eIdx > chars.length ) {
			return str;
		} else {
			return new String(encChars);
		}

	}
	

	public static void main(String[] args) {
		System.out.println(encode("abc"));
		System.out.println(encode("aabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcccc"));
	}

}
