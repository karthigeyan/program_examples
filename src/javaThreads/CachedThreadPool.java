package javaThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i= 0; i<100 ; i++) {
            executorService.execute(new FixedSizeThreadPool.Task());
        }
        System.out.println("Thread Name Task : " + Integer.MAX_VALUE);
        executorService.shutdown();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread Name : "+ Thread.currentThread().getName() + " ->  " + Thread.currentThread().getId());
        }
    }
}
