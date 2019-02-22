package common.exercise;

/**
WHAT?
Convert IP address into 32bit integer(network byte order).
Eg.
"192.168.1.2" => 33663168
network byte order- 
eg. 192.168.1.2 
192 - 1-8 bits
168 - 9-16 bits
1   - 17-24 bits
2   - 25-32 bits


IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots

Refer : http://en.wikipedia.org/wiki/IP_address

HOW?
1. get IP address as string 
2. init IPDECIMAL = 0 and I = 0
3. split  IP string by dot
4. for  each decimal term, convert it into integer(DECIMAL)
5. IPDECIMAL = IPDECIMAL |   DECIMAL << 8 * I
6. increment I
7. goto step 4 till all  decimal terms are converted
8. print IPDECIMAL
9. done
*/


public class IPAddrStrToDecimal {

	public static long toDecimal(String ipStr) {

		char[] ipCharAry = ipStr.toCharArray();
		long intnum = 0;
		long ipDecimal = 0;
		int termCount = 0; 

		for(int i=0; i<ipCharAry.length && termCount < 4; i++ ) {

			//validating ip address
			if (! ( (ipCharAry[i] >= '0' &&  ipCharAry[i] <= '9') || (ipCharAry[i] == '.' ))) {
				throw new  NumberFormatException();
			}

			//converting each decimal term into integer
			if ( ipCharAry[i] >= '0' && ipCharAry[i] <= '9') {
				intnum = intnum * 10 + ipCharAry[i] - '0';
			}

			//combining  decimal terms 
			if ( ipCharAry[i] == '.'  || i == ipCharAry.length -1) {

				if( intnum > 255 || intnum < 0 ) { // decimal part range is from 0 to 255.
					throw  new NumberFormatException();
				}
				//network byte order- 
				ipDecimal = ipDecimal | ( intnum << termCount*8);

				intnum = 0;  
				termCount++;
			}  
		}


		if( termCount != 4 ) { //  there should be 4 decimal parts in ip address
			throw  new NumberFormatException();
		}

		return ipDecimal;
	}

	public static void main(String[] args) {

		System.out.println(toDecimal("192.168.1.2"));
	}
}
