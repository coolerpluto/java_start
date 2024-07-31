package com.fan.javaee.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/22
 */
public class ThreadPoolTest {
    
    private static int a = 0;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(200);
        for (int i = 0; i <100; i++){
            
            
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    a++;
                    System.out.println(a);
                    countDownLatch.countDown();
                }
            });
        }

        
        
        executorService.shutdown();
        countDownLatch.await();


        System.out.println("====="+a);
    }
}
