package Level1;

/**

WHAT?
Finding sum of first 'n' natural numbers. 1+2+3+...+n.

HOW?
1. get the input 'n' and set it in NUM
2. init SUM = 0
3. for I=1; I<=NUM; I++
	SUM = SUM + I
4. print SUM	
5. done
*/


public class SumOfNatNum {

	public static int getSum(int num) {
		
		int sum = 0;
		for(int i = 1; i <= num; i++ ) {
			sum = sum + i;
		}
		return sum;
	}

	public static void main(String[] args) {

		System.out.println( getSum(10));
	}
}
