package com.fan.javaee.thread;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/18
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Athread("thread1"));
        Thread thread2 = new Thread(new Athread("thread2"));
        
        
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(10000);
            thread1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    
    
}

class Athread implements Runnable{
    
    private String threadname;
    
    public Athread(String threadname){
        this.threadname = threadname;
    }

    @Override
    public void run() {
        System.out.println(threadname+"线程开启");
        try {
            for (int i = 0; i < 5; i ++){
                System.out.println("====="+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

            System.out.println(threadname+"睡眠中断");
        }
        System.out.println(threadname+"线程终止");
        
        return ;
    }
}
