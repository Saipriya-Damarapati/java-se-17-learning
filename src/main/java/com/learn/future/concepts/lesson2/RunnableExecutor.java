package com.learn.future.concepts.lesson2;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunnableExecutor {

    public static void main(String[] args) {
        try {
            ExecutorService service = Executors.newSingleThreadExecutor();
            RunnableExample task1 = new RunnableExample("Task1", 5);
            RunnableExample task2 = new RunnableExample("Task2", 5);
            RunnableExample task3 = new RunnableExample("Task3", 5);

            Thread thread1 = new Thread(task1);
            Thread thread2 = new Thread(task2);
            Thread thread3 = new Thread(task3);

            Future<?> task1Future = service.submit(() -> thread1.start());
            Future<?> task2Future = service.submit(() -> thread2.start());
            Future<?> task3Future = service.submit(() -> thread3.start());

            service.shutdown(); // Service will shutdown after all submitted tasks will be executed, no new tasks are accepted
            //service.shutdownNow(); // Service will shutdown immediately even before the submitted tasks completed execution

            System.out.println(thread1.getState());
            System.out.println(thread2.getState());
            System.out.println(thread3.getState());

            TimeUnit.SECONDS.sleep(6);

            System.out.println(thread1.getState());
            System.out.println(thread2.getState());
            System.out.println(thread3.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RunnableExample implements Runnable {

    private final String name;
    private final int secs;

    public RunnableExample(String name, int secs) {
        this.name = name;
        this.secs = secs;
    }

    @Override
    public void run() {
        System.out.printf("%s : Starting thread from runnable interface \n", this.name);

        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.printf("%s : Ending thread from runnable interface\n", this.name);
    }
}