package arrayType.basic;

public class AsciiTable {

    public static void main(String[] args) {

        int[] asciiTable = new int[128];
        for (int i = 0; i < 128; i++) {
            asciiTable[i] = i;
            System.out.println("(char)asciiTable["+i+"] = " +  Character.valueOf((char)asciiTable[i]));
        }
    }
}
