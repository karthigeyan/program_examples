package bitwise;

/**
WHAT?
Converts 64bit long in big endian format  to 64bit little endian.

Refer: http://en.wikipedia.org/wiki/Endianness

HOW?
1. get the long integer
2. swap first and last byte 
3. continue till all bytes are swapped.
4. print converted long integer
5. done

*/

public class BigEndian {

	public static long toLittleEndian(long number) {
		long  result = 0;
		for(int i=0; i<64; i+=8) {
			result = result << 8;
			result = result | ( number & 0xFF);
			number = number>>8;
		}
		return result;
	}

	public static void main(String[] args) {
		long  num = 0x1122334455667788L;
		System.out.format("%x", toLittleEndian(num));
	}
}
