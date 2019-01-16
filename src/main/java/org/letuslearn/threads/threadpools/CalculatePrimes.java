package org.letuslearn.threads.threadpools;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class CalculatePrimes {

/*
    How Executors internally creates Threads and manages thread life cycle -- check more
    like how it is re using threads even after completing the task ideally thread should be dead

    Check more about `ThreadPoolExecutor`  at below documentation it has more information about Queuing, Rejection,Hook methods
    https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadPoolExecutor.html
*/

    public static void main(String[] args) {
        /* if you want to change Thread pool name , group and priorities then you should pass `ThreadFactory`
         implementation to Executors
         ThreadFactory is responsible for creating threads on demand*/
        ThreadFactory namedThreadFactory =
                new ThreadFactoryBuilder().setNameFormat("prime-calculation-thread-%d").build();
        ExecutorService eService = Executors.newFixedThreadPool(5, namedThreadFactory);
        Future<Integer>[] results = new Future[5];

        int start = 1;
        int end = 10000;

        for(int i=0; i < 5; i++) {
            /*Callable will return the result to main thread*/
            PrimeCalculator primeCalculator = new PrimeCalculator(start, end);
            start = end;
            end += 10000;
            results[i] = eService.submit(primeCalculator);
        }

        for(int i=0; i < 5; i++) {
            try {
                Integer integer = results[i].get(); // blocks until return values are available
                System.out.println(integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        eService.shutdown();
    }
}
