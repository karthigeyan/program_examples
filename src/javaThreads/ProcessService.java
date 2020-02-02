package javaThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessService {

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        for(int i=0; i<100 ; i++ ) {
            executorService.execute(new CpuIntensiveTask());
        }

        executorService.shutdown();
    }

    static class CpuIntensiveTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread Name : "+ Thread.currentThread().getId());
        }
    }
}
