package backtojava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

public class TryWithResource  implements AutoCloseable{

    public TryWithResource() {
        System.out.println("Constructor -> AutoCloseableResources_First");
    }

    public void doSomething() {
        System.out.println("Something -> AutoCloseableResources_First");
    }

    private static void  orderOfClosingResources() throws Exception {

        try (TryWithResource af = new TryWithResource();
             AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond()) {

            af.doSomething();
            as.doSomething();
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closed AutoCloseableResources_First");
    }

    public static void main(String[] args) {


        try {
            orderOfClosingResources();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(new File("/work/study/java/program_examples/src/backtojava/one.txt"));
             PrintWriter writer = new PrintWriter(new File("/work/study/java/program_examples/src/backtojava/two.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

 class AutoCloseableResourcesSecond implements AutoCloseable {

    public AutoCloseableResourcesSecond() {
        System.out.println("Constructor -> AutoCloseableResources_Second");
    }

    public void doSomething() {
        System.out.println("Something -> AutoCloseableResources_Second");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closed AutoCloseableResources_Second");
    }
}
