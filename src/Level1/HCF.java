package Level1;

/**
WHAT?
The highest common factor (HCF) of two whole numbers is the largest whole number which is a factor of both.
Example
Let us take two number as 12 and 16
Factors for number 12 are : 1, 2, 3, 4, 6, 12
Factors for number 16 are : 1, 2, 4, 8,16
Therefore , the highest common factor of 12 and 16 is 4;

HOW?
1. get input values and store it in NUM1 and NUM2
2. assign minimum of NUM1 and NUM2 in MIN
3. FOR I=1; I<=MIN; I++
	IF NUM1 % I == 0 and NUM2 % I == 0
	THEN FACT=I
4. print FACT
5. done
*/


public class HCF {

	public static int getHCF(int n1, int n2) {

		int min = (n1 < n2)?n1:n2;
		int fact = 1;
		for( int i=1; i<=min; i++ ) {
			if( n1 % i == 0  && n2 % i  == 0 ) {
				fact = i;
			}
		}
		return fact;

	}

	public static void main(String[] args) {

		System.out.println(getHCF(12, 16));
	}
}
