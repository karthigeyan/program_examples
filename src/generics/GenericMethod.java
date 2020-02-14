package generics;

public class GenericMethod {

    public static <E>void printArray(E[] datas){
        for(E data: datas) {
            System.out.printf("%s ",  data);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intData = {1, 2, 3, 4, 5};
        Double[] doubleData = {1.2, 2.5, 3.2, 4.5, 5.7};
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        String[] stringArray = { "Hsdsd", "E", "L", "L", "O" };

        printArray(intData);
        printArray(doubleData);
        printArray(charArray);
        printArray(stringArray);
    }
}
