package com.fan.javaee.thread;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/18
 */
public class MyThreadTest{
    
    private class b{
        
    }
    
    private static class cb{
        
    }
    
    public void b(){
        
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        
        
        class a{
            
        }

        Thread thread1 = new MyRunnable();
        thread1.setName("thread1");
        Thread thread2 = new MyRunnable();
        thread1.setName("thread2");
        Thread thread3 = new MyRunnable();
        thread1.setName("thread3");


        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    System.out.println(Thread.currentThread().getName() + "-" + i);
                }
            }
        }, "thread4");
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
//        thread1.run();
//        thread2.run();
//        thread3.run();
//        thread4.run();
    }


}



class MyRunnable extends Thread{

    @Override
    public void run() {
        
        for (int i = 0; i < 50; i++){
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }
}