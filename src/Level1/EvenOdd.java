package Level1;

/**

WHAT?
Checking the given number as odd or even by dividing the number by 2 . If remidner is zero , then it is even number.
modulus operation(%) can be used to get the reminder.

HOW?
1. get the input number and set it in NUM
2. if NUM % 2 == 0 then true 
3. else false
4. done

*/
public class EvenOdd {

	public static boolean isEven(int num) {

		if ( num %2 == 0 ) {
			return true;
		} else { 
			return false;
		}
	}

	public static void main(String[] args) {

		System.out.println(isEven(10));
		System.out.println(isEven(7));
	}
}
