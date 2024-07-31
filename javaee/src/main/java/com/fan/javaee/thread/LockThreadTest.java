package com.fan.javaee.thread;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/19
 */
public class LockThreadTest {

    public static final Object o1 = new Object();
    public static final Object o2 = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "----给o1上锁");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "----准备给o2上锁");
                    synchronized (o2) {
                        System.out.println(Thread.currentThread().getName() + "----已经给o2上锁");
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "----给o2上锁");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "----准备给o1上锁");
                    synchronized (o1) {
                        System.out.println(Thread.currentThread().getName() + "----已经给o1上锁");
                    }
                }
            }
        });
        
        
        thread.start();
        
        thread1.start();
    }
}
