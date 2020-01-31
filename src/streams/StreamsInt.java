package streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class StreamsInt {

    public static void main(String[] args) {

        int number[] = {22, 8 ,5,6,7,10,};
        System.out.println(IntStream.of(number).min().getAsInt());
        IntStream.of(number).min().ifPresent(data -> System.out.println(data));
        IntStream.of(number).min().ifPresent(System.out::println);

        IntSummaryStatistics statistics = IntStream.of(number).summaryStatistics();
        System.out.println(statistics);

        IntStream.of(number).distinct().sorted().limit(3).forEach(System.out::print);
        // IntStream.generate()

    }

    /*static void printDistinct(int arr[], int n)
    {
        // Pick all elements one by one
        for (int i = 0; i < n; i++)
        {
            // Check if the picked element
            // is already printed
            int j;
            for (j = 0; j < i; j++)
                if (arr[i] == arr[j])
                    break;

            // If not printed earlier,
            // then print it
            if (i == j)
                System.out.print( arr[i] + " ");
        }
    }

    // Driver program
    public static void main (String[] args)
    {
        int arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10};
        int n = arr.length;
        printDistinct(arr, n);

    }
*/
}
