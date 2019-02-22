package common.exercise;

/**
WHAT?
You are given an array with integers between 1 and 1,000,000 both inclusive. One integer is in the array twice. Size of
array could be anything from 1, 1000000, but integers in the array will be within range of 1 and 1000000.  How can you determine which one? Can you think of a way to do it using  extra memory.
For example
{101, 455, 30 6001, 30, 10000}
all the elements are within in the range of 1 to 1000000. 30 present in the array twice.

HOW?
1. get the input integer array
2. allocate byte array of size 1000000/8 for bitmap
3. iterate the array
4. check if number is already present in the bitmap , if yes then return that number
5. else set the corresponding  bit in the bitmap
6. goto step 3 till are elements are iterated.
7. done

*/

public class TwiceInArray {

	public static int findDuplicate(int[] intArray) {
		//bitmap for remembering the integers present in the array. 
		//each bit remember its number corresponding to the position in the bit map.
		//for number 13, 5th  bit in the second byte(5+8) of bitmap array will be set.
		byte[] bitmap = new byte[1000000/8];

		for(int i=0; i<intArray.length; i++) {
			int num = intArray[i]-1;
			int byteOffset = num / 8;
			int bit = num % 8;
			if( isBitSet(bitmap[byteOffset], bit) ) {
				return intArray[i];
			} else {
				bitmap[byteOffset] |=  1<<bit;
			}
		}
		return 0;
	}

	private static boolean isBitSet(byte b, int bitPos) {
		if ( ( b & (1<<bitPos)  ) != 0 ) {
			return true;
		}else {
			return false;
		}
	}



	public static void main(String[] args) {
		int[] intArray = {101, 455, 30, 6001, 30, 10000};
		System.out.println(findDuplicate(intArray));
	}
}
