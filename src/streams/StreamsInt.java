package streams;

import java.util.stream.IntStream;

public class StreamsInt {

    public static void main(String[] args) {

        int number[] = {22, 8 ,5,6,7,10,};
        System.out.println(IntStream.of(number).min().getAsInt());

    }
}
