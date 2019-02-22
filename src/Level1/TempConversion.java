package Level1;

/**

WHAT?
Converts the given temperature in fahrenheit to celcius.
Celsius = (Fahrenheit - 32) / 1.8


HOW?
1. get temperature in fahrenheit and set it in FAR.
2. CEL = (FAR - 32 ) / 1.8
3. print CEL
4. done
*/


public class TempConversion {

	public static double toCelcius(double farh) {
		return (farh - 32 ) /1.8;
	}

	public static void main(String[] args) {

		System.out.println(toCelcius(98.6));
	}
}
