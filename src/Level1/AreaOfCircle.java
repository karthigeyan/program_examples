package Level1;

/**
What?
Area of a circle for the given radius (R)  is calculated by (22/7) * R * R.


How?
1. get input value radius and set it in R
2. AREA =  3.141 * R * R
3. done

*/

public class AreaOfCircle {

	public static double area(double radius) {

		if ( radius < 0 ) {
			System.out.println("Invalid input: radius is negative");
			return 0;
		}

		double area = 3.141 * radius * radius;
		return  area;
	}

	public static void main(String[] args) {
		
		System.out.println( area(7) );

	}
}
