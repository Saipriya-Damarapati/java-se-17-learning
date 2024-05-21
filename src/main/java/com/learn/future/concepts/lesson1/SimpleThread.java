package com.learn.future.concepts.lesson1;

import java.util.concurrent.TimeUnit;

public class SimpleThread {
    public static void main(String[] args) {
        Thread threadExample = new ThreadExample("My Simple Thread", 5);
        threadExample.start();
    }
}

class ThreadExample extends Thread {

    private final String name;
    private final int secs;

    public ThreadExample(String name, int secs) {
        this.name = name;
        this.secs = secs;
    }

    @Override
    public void run() {
        System.out.printf("%s : Starting simple thread \n", this.getName());

        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.printf("%s : Ending simple thread \n", this.getName());
    }

}