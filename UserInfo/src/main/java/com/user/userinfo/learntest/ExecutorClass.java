package com.user.userinfo.learntest;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorClass {


    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            int taskId = i;

            executor.submit(() -> {

                System.out.println(
                        "Task " + taskId +
                                " running on " +
                                Thread.currentThread().getName()
                );

                for (int j = 0; j < 1000; j++) {
                    count.incrementAndGet();
                }

            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Final Count = " + count.get());

//        for (int i = 0; i < 10; i++) {
//            int taskId=i;
//
//            executor.submit(()->{
//                System.out.println(
//                        "Task " + taskId +
//                                " running on " +
//                                Thread.currentThread().getName()
//                );
//
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        executor.shutdown();


    }

}
