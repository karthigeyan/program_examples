package generics;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

//---- My code ----
class Result {


}
//---- End my code ----
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int datesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dates = IntStream.range(0, datesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        // List<String> result = Result.reformatDate(dates);

        /*bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );*/

        bufferedReader.close();
        bufferedWriter.close();
    }
}