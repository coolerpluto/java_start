package com.fan.javaee.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/19
 */
public class TyrLockTest {
    
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();


    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        if (lock1.tryLock()) {
                            System.out.println(Thread.currentThread().getName() + "执行lock1代码");
                            try {
                                Thread.sleep(10);
                                if (lock2.tryLock()) {
                                    try {
                                        System.out.println(Thread.currentThread().getName() + "执行lock2代码");
                                        break;
                                    } finally {
                                        lock2.unlock();
                                    }
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        if (lock2.tryLock()) {
                            System.out.println(Thread.currentThread().getName() + "lock2执行代码");
                        }
                        try {
                            Thread.sleep(10);
                            try {
                                if (lock1.tryLock()) {
                                    System.out.println(Thread.currentThread().getName() + "执行lock1代码");
                                }
                            } finally {
                                lock1.unlock();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        });
        
        
        
        
        thread.start();
        thread1.start();
    }
    
    
    
}
