package common.exercise;

/**

WHAT?
Finding largest number among the given three numbers.

HOW?
1. get three input numbers and set it NUM1, NUM2 and NUM3
2. if NUM1 >  NUM2 and NUM1 > NUM3  then return NUM1
3. else if NUM2 > NUM1 and NUM2 > NUM3 then return NUM2
4. else return NUM 3
5. done

*/


public class MaxOfThree {

	public static int getMax(int n1, int n2, int n3 ) {

		if ( n1 > n2 && n1 > n3 ) {
			return n1;
		} else if ( n2 > n1 && n2 > n3 ) {
			return n2;
		} else  {
			return n3;
		}
	
	}

	public static void main(String[] args) {

		System.out.println( getMax(10, 15, 5));
	}
}
