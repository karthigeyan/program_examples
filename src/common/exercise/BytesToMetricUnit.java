package common.exercise;

/**
WHAT?
Converts a given number in bytes into a metric units representation.

A number of bytes given as a integer value should be printed out with at most three digits before the decimal point.

The ouput for four different values:
541 Bytes to 541.0 Bytes
73421 Bytes to 73.421 KBytes
5029000 Bytes to 50.290 MBytes
8245230000 Bytes to 8.245230000 GBytes

HOW?
1. get the input number(NUM) in bytes
2. if NUM < 1000 then print it bytes
3. else if NUM > 1000  && <1000000 then print  NUM/1000 Kbytes
4. else if NUM >=1000000 && <1000000000 then print NUM/1000000 Mbytes
5. else print NUM/1000000000 Gbytes
6. done

*/

public class BytesToMetricUnit {

	public static void toMetric(long bytes) {
		if( bytes/1000 == 0 ) {
			System.out.println(bytes + " Bytes");
		}else  if( bytes/1000000 == 0 ) {
			System.out.println((double)bytes/1000 + " KBytes");
		}else if( bytes/1000000000L == 0 ) {
			System.out.println((double)bytes/1000000+ " MBytes");
		}else {
			System.out.println((double)bytes/1000000000L + " GBytes");
		} 
	}

	public static void main(String[] args ){

		toMetric(541);
		toMetric(73421);
		toMetric(5029000);
		toMetric(8245230000L);
	}
}

