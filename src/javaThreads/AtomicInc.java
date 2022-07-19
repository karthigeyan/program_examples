package javaThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicInc {

    static int i = 5;
    private boolean run = true;

    public AtomicInc() {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        newCachedThreadPool.execute(t1);
        newCachedThreadPool.execute(t2);
        run = false;
        newCachedThreadPool.shutdown();
    }

    private Runnable t1 = new Runnable() {
        @Override
        public void run() {
            while (run) {
                System.out.println("Thread 1 : " + i++);
            }
        }
    };


    private Runnable t2 = new Runnable() {
        @Override
        public void run() {
            while (run) {
                System.out.println("Thread 2 : " + i++);
            }
        }
    };


    public static void main(String[] args) {
        new AtomicInc();
    }

}
