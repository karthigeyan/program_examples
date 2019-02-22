package common.exercise;

/**
WHAT?
Finds first  1000 prime numbers.

A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself. A natural number greater than 1 that is not a prime number is called a composite number. For example, 5 is prime because 1 and 5 are its only positive integer factors, whereas 6 is composite because it has the divisors 2 and 3 in addition to 1 and 6.

Refer: http://en.wikipedia.org/wiki/Prime_number

HOW?
1. get number of prime numbers need to be printed(PRIME_COUNT)
2. from each number from the range 2....n
3. get number of divisors for that number
4. if number of divisors is equal to 2 then increment COUNT and print the prime number
5. check COUNT is equal to PRIME_COUNT, if not go to step 2
6. done

*/

public class PrimeNumbers {

	public static void findPrimeNumbers(int num) {

		int count = 0;
		
		for(int i=2; count<num; i++ ) {

			int div = 0;
			for(int j=1; j<=i; j++) {

				if( i % j == 0 ) {
					div++;
				}
				//if there are more than 2 divisors then break
				if( div > 2 ) {
					break;
				}
			}
			if( div == 2 ) {
				System.out.print(" " + i);
				count++;
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		findPrimeNumbers(100);
	}

}


