package Level1;

/**
WHAT?
Checks whether the given year is leap year or not. A year is leap year if it is divisible by 4 and not by 100 , or 
divisible by 400.
Refer : http://en.wikipedia.org/wiki/Leap_year

HOW?
1. get the year and set it in YEAR
2. IF( ( ( YEAR % 4 == 0 ) AND (YEAR % 100 != 0 ) ) OR (YEAR %400 == 0 ) )
   THEN print  true
   ELSE  print false
3. done
*/


public class LeapYear {

	public static boolean isLeapYear(int year) {

		if( (year % 4 == 0 && year % 100 != 0 ) || (year % 400 == 0 ) ) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		System.out.println(isLeapYear(2000));
		System.out.println(isLeapYear(1900));
		System.out.println(isLeapYear(2014));
	}
}
