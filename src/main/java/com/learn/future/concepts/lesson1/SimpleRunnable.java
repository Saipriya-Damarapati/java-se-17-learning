package com.learn.future.concepts.lesson1;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SimpleRunnable {

    public static void main(String... args) {
        RunnableExample runnableExample = new RunnableExample("My Simple Runnable", 5);
        Thread thread = new Thread(runnableExample);
        thread.start();
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
