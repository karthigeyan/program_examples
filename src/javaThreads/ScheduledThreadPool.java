package javaThreads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        executorService.schedule(new Task(), 10, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay( new Task(), 15, 10, TimeUnit.SECONDS);


        System.out.println("Thread Name Task : " + Thread.currentThread().getName());
        executorService.shutdown();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread Name : "+ Thread.currentThread().getName() + " ->  " + Thread.currentThread().getId());
        }
    }
}
