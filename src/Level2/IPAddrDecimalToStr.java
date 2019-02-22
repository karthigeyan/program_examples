package Level2;

/**
WHAT?
Convert IP address from 32bit integer(network byte order) to dotted decimal format in string.
Eg.
33663168 =>"192.168.1.2"
network byte order- 
eg. 192.168.1.2 
192 - 1-8 bits
168 - 9-16 bits
1   - 17-24 bits
2   - 25-32 bits


IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots

Refer : http://en.wikipedia.org/wiki/IP_address

HOW?
1. get IP address as 32 bit integer
2. init char array of size 16
3. get last 8bit ,  converted it into ascii  characters and copy it in char array
4. append '.' except last last bytes
5. shift ip address 8bits to the right
6. goto step 3 and repeat  untill all 4 bytes are converted.
7. print char array
8. done
*/


public class IPAddrDecimalToStr {

	public static String toString(long ipaddr) {

		char[] ipCharAry = new char[16];
		int charCnt = 0;

		for ( int i=0; i<4; i++ ) {
			//ipv4 is 32 bit integer(4 bytes), so each byte is converted into dotted decimal format
			int term = (int)ipaddr >> (8*i) & 0x000000FF;

			int dcount = digitCount(term);
			// get the number of digits and move the index
			charCnt += dcount -1;

			//integer to string conversion
			while ( term > 0 ) { 
				//last digit comes first in array
				ipCharAry[charCnt--] = (char)('0' + term % 10);
				term = term/10;
			}
			//moving index to last 
			charCnt = charCnt + dcount +1;
			ipCharAry[charCnt] = '.';
			charCnt++;
		}
		// stripping last dot
		ipCharAry[charCnt-1] = 0;

		return new String(ipCharAry);
	}

	private static int digitCount(int num) {
		int noOfDigits = 0;
		//finds number of digits in the integer.
		while( num != 0 ) {
			num = num / 10; 
			noOfDigits ++;
		}
		return noOfDigits;
	}

	public static void main(String[] args) {

		System.out.println(toString(33663168));
	}
}
