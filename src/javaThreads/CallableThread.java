package javaThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future> allFutures = new ArrayList<>();
        for(int i=0; i<100; i++ ) {
            Future<Integer> feature =  executorService.submit(new Task());
            allFutures.add(feature);
        }

        //Perform Other operations

        System.out.println("Future works");
        for(int i=0; i<100; i++ ) {
            Future<Integer> future = allFutures.get(i);
            Integer result = future.get();
            System.out.println("Result of future # " + i + " : " + result);
        }
        executorService.shutdown();
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000 );
            return new Random().nextInt();
        }
    }
}
