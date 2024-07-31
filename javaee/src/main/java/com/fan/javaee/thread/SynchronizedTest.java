package com.fan.javaee.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/19
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        A a = new A();
        Thread thread1 = new Thread(new ThreadClass(a), "thread1");
        Thread thread2 = new Thread(new ThreadClass(a), "thread2");
        
        thread1.start();
        thread2.start();
    }
}


class ThreadClass implements Runnable{
    
    private A a;
    
    public ThreadClass(A a){
        this.a = a;
    }

    public void run() {
//        A.f1();
//        a.f2();
        a.f3();
    }
}

class A{
    public synchronized static void f1(){
        System.out.println(Thread.currentThread().getName()+"-----start");
        try {
            for (int i = 0; i< 5; i++){
                System.out.println(Thread.currentThread().getName()+"execute---"+i);
                Thread.sleep(1000);
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"------stop");
    }
    
    public void f2(){
        synchronized (A.class){
            System.out.println(Thread.currentThread().getName()+"-----start");
            try {
                for (int i = 0; i< 5; i++){
                    System.out.println(Thread.currentThread().getName()+"execute---"+i);
                    Thread.sleep(1000);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"------stop");
        }
    }

    private Lock lock = new ReentrantLock();
    public void f3(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"-----start");
        try {
            for (int i = 0; i< 5; i++){
                System.out.println(Thread.currentThread().getName()+"execute---"+i);
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"------stop");
        lock.unlock();
    }
}
