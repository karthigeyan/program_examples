package arrayType.basic;

public class BasicArray {

    public static void main(String[] args) {

        int[] intValue = new int[2];
        long[] longValue = new long[2];
        short[] shortValue = new short[2];
        byte[] byteValue = new byte[2];
        float[] floatValue = new float[2];
        double[] doubleValue = new double[2];
        char[] charValue = new char[2];


        for (int value: intValue ) {
            System.out.println("intValue = " + value);
        }
        for (long value: longValue ) {
            System.out.println("longValue = " + value);
        }
        for (short value: shortValue ) {
            System.out.println("short = " + value);
        }
        for (byte value: byteValue ) {
            System.out.println("byteValue = " + value);
        }

        for (float value: floatValue ) {
            System.out.println("floatValue = " + value);
        }

        for (double value: doubleValue ) {
            System.out.println("doubleValue = " + value);
        }
        for (char value: charValue ) {
            System.out.println("charValue = " + value);
        }

    }
}
