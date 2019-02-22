package common.exercise;

/**
WHAT?
convert an integer number into  string  without using any APIs for conversion.
248 = > "248"

Refer : http://en.wikipedia.org/wiki/ASCII

HOW?
1. get the integer number  store it in NUM and also save it NUMSAVE
2. find number of digits in the integer
3. allocate new character array. size of array was calculated in the previous step    
4. FOR EACH digit in NUM
	NUMCHAR[I]  =  '0' + DIGIT; store each digit from the last in the array
	decrement array index I--
5. convert character array NUMCHAR into String 
6. print the string
7. done



*/


public class IntToString {

	public static String toString(int num) {

		int numsave = num;
		int noOfDigits = 0;
		
		//finds number of digits in the integer.
		while( num != 0 ) {
			num = num / 10; 
			noOfDigits ++;
		}


		char[] numchar = new char[noOfDigits]; 
		int i = 0;
		num = numsave;
		while( num != 0 ) {
			int digit = num % 10; // getting last digit by taking modulus
			noOfDigits--;
			numchar[noOfDigits] = (char) ( '0' + digit); //convert the digit to char by adding '0'
			num = num / 10; // truncate last digit
		}
		return new String(numchar);
	}


	public static void main(String[] args) {

		System.out.println(toString(123));
	}
}
