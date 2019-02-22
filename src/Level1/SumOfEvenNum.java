package Level1;

/**

WHAT?
Finding sum of first 'n' even numbers. 0 + 2 + 4 +....n

HOW?
1. get the input 'n' and set it in NUM
2. init SUM = 0
3. for I=0; I<NUM; I++
	SUM = SUM + I*2
4. print SUM	
5. done
*/


public class SumOfEvenNum {

	public static int getSum(int num) {
		
		int sum = 0;
		for(int i = 0; i < num; i++ ) {
			sum = sum + i*2;
		}
		return sum;
	}

	public static void main(String[] args) {

		System.out.println( getSum(4));
	}
}
