package com.learn.future.concepts.lesson3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SubmitRunnable {

    public static void main(String... args) {

        try {
            ExecutorService service = Executors.newSingleThreadExecutor();
            // submit a task to a single thread executor
            Future<?> future = service.submit(() -> FutureTask.doSimpleTask()); // using lambda expression
            //Future<?> future = service.submit(FutureTask :: doSimpleTask); // Using method reference
            // do other tasks here
            System.out.println(future.get()); // wait for future to complete; doesn't matter if it is success or not
            // do something else
            service.shutdown(); // to close and shutdown the ExecutorService
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class FutureTask {

    public static void doSimpleTask() {
        System.out.printf("%s : Starting thread from FutureTask demo \n", Thread.currentThread().getName());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.printf("%s : Ending thread from FutureTask demo \n", Thread.currentThread().getName());
    }
}

