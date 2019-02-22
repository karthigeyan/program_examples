package common.tricks;

import java.math.BigInteger;

public class CheckPrimeNo {

    public static void main(String args[]) {
        System.out.println( BigInteger.valueOf(2).isProbablePrime(1));
        System.out.println( BigInteger.valueOf(7678686).isProbablePrime(1));
    }
}
