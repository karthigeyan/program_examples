package javaThreads;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutor {

    public static void main(String[] args) {

        ExecutorService executorService = new java.util.concurrent.ThreadPoolExecutor(2,
                10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(300));

        try {
            for(int i=0 ; i< 100; i++) {
                executorService.execute(new Task());
            }
        } catch (RejectedExecutionException e) {
            System.out.println("Thread E: " + e);
        }

        List<Runnable> tasks = executorService.shutdownNow();

        System.out.println(tasks.size());

        executorService.shutdown();

        System.out.println(executorService.isTerminated());
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread Name : "+ Thread.currentThread().getName() + " ->  " + Thread.currentThread().getId());
        }
    }
}
