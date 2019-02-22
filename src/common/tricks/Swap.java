package common.tricks;

public class Swap {

    public static void main(String args[]) {

        int aValue = 21;
        int bValue = 22;

        aValue ^= bValue;
        System.out.println("aValue = " + aValue);
        bValue ^= aValue;
        System.out.println("bValue = " + bValue);
        aValue ^= bValue;

        System.out.println("aValue = " + aValue);


        System.out.println(aValue);
        System.out.println(bValue);

    }
}
