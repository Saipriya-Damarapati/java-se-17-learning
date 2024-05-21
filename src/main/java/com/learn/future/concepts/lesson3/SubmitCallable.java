package com.learn.future.concepts.lesson3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SubmitCallable {

    public static void main(String[] args) {
        try {
            ExecutorService service = Executors.newFixedThreadPool(5); // creates a thread pool of 5 threads
            // submit a task to the thread pool executor
            Future<?> future = service.submit(() -> FutureCallable.doTask("MyNewThread", 5, false));
            // do other tasks here
            System.out.println(future.get()); // wait for future to complete; doesn't matter if it is success or not
            // do something else
            service.shutdown(); // to close and shutdown the ExecutorService
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TaskResult {
    private final String name;
    private final int secs;

    public TaskResult(String name, int secs) {
        this.name = name;
        this.secs = secs;
    }

    @Override
    public String toString() {
        return "TaskResult{" +
                "name='" + name + '\'' +
                ", secs=" + secs +
                '}';
    }
}
class FutureCallable {

    public static TaskResult doTask(String name, int secs, boolean fail) {
        System.out.printf("%s , %s : Starting thread from FutureCallable demo \n", name, Thread.currentThread().getName());

        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        if(fail) {
            throw new RuntimeException("Task Failed");
        }

        System.out.printf("%s , %s : Ending thread from FutureCallable demo \n", name, Thread.currentThread().getName());
        return new TaskResult(name, secs);
    }
}

