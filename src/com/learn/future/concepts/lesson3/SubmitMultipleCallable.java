package com.learn.future.concepts.lesson3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitMultipleCallable {

    /*
    Expected Output:
    ----------------
    All three tasks are submitted to the pool at the same time.
    Task 3 completed first in 1 second, followed by task 2 in 3 seconds, followed by task 1 in 6 secs
    However, while getting result from future, task1Result.get is executed first,
    so task2Result and task3Result have to wait; this future.get() call is sequential

        Task2 , pool-1-thread-2 : Starting thread from FutureCallable demo
        Task1 , pool-1-thread-1 : Starting thread from FutureCallable demo
        Task3 , pool-1-thread-3 : Starting thread from FutureCallable demo
        Task3 , pool-1-thread-3 : Ending thread from FutureCallable demo
        Task2 , pool-1-thread-2 : Ending thread from FutureCallable demo
        Task1 , pool-1-thread-1 : Ending thread from FutureCallable demo
        TaskResult{name='Task1', secs=6}
        TaskResult{name='Task2', secs=3}
        TaskResult{name='Task3', secs=1}

     */

    public static void main(String[] args) {
        try {
            ExecutorService service = Executors.newFixedThreadPool(3); // creates a thread pool of 3 threads
            // submit a task to the thread pool executor
            Future<?> task1Future = service.submit(() -> FutureCallable.doTask("Task1", 6, false));
            Future<?> task2Future = service.submit(() -> FutureCallable.doTask("Task2", 3, false));
            Future<?> task3Future = service.submit(() -> FutureCallable.doTask("Task3", 1, false));
            // do other tasks here

            // handle task1Future.get() will block till task1 completes
            TaskResult task1Result = (TaskResult) task1Future.get();
            System.out.println(task1Result);
            // handle task2Future.get() will block till task2 completes
            TaskResult task2Result = (TaskResult) task2Future.get();
            System.out.println(task2Result);
            // handle task3Future.get() will block till task3 completes
            TaskResult task3Result = (TaskResult) task3Future.get();
            System.out.println(task3Result);

            // do something else
            service.shutdown(); // to close and shutdown the ExecutorService
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
