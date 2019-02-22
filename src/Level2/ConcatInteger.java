package Level2;

/**
WHAT?
Concatenates two integers.
     eg 234 + 11 => 23411

HOW?
1. get two integer numbers NUM1 and NUM2
2. calculate power of 10 (POW)  based on number of digits in the second number(2 digit -100, 3 digit - 1000...)
3. print NUM1*POW + NUM2
4. done

*/
public class ConcatInteger {

	public static long concat(int num1, int num2 ) {
		int pow = 10;

		while(num2 >= pow) {
			pow  *=10;
		}
		return num1*pow + num2;
	}

	public static void main(String[] args) {
		System.out.println(concat(234, 11));
	}

}
