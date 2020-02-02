package javaThreads;

public class ThreadSample {

    public static void main(String[] args) {

        Thread thread = new Thread( new Task());
        thread.start();
        for(int i=0 ; i<100 ; i++) {
            Thread thread1 = new Thread(new Task1());
            thread1.start();
        }
        Thread thread2 = new Thread( new Task2());
        thread2.start();

        System.out.println("Thread Name : "+ Thread.currentThread().getName());
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread Runnable Name : "+ Thread.currentThread().getName());
        }
    }

    static class Task1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread 1 Runnable Name : "+ Thread.currentThread().getName());
        }
    }

    static class Task2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread 2 Runnable Name : "+ Thread.currentThread().getName());
        }
    }
}
