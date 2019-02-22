package Level1;

/**

WHAT?
Calculating simple interest for the given principal amount, interest rate and period.
SI = PRI * RATE * PERIOD / 100 

HOW?
1. get the principal amount, interest rate and period , and set those values in PRI, RATE and PERIOD respectively.
2. SI = ( PRI * RATE * PERIOD ) / 100 
3. print SI	
4. done
*/


public class SimpleInterest {

	public static void main(String[] args) {
	
		int pri = 3000000; // Rs 10,0000
		double rate = 10.5; // 10.5%
		int period = 3; // 3 years

		double simpleInt = (pri * rate * period) /100 ;

		System.out.println(simpleInt);

	}
}
