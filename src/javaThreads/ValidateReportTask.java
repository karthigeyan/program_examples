package javaThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ValidateReportTask implements Runnable {

    public static void main(String[] args) {

        ValidateReportTask instance= new ValidateReportTask();
        instance.run();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(instance);

        executorService.shutdown();


    }

    @Override
    public void run() {
        System.out.printf("Hi");
    }
}
