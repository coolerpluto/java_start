package com.fan.javaee.thread;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/18
 */
public class PriorityThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable2("t1"));
        Thread t2 = new Thread(new MyRunnable2("t2"));
        Thread t3 = new Thread(new MyRunnable2("t3"));
        
        
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        
        t1.start();
        
        t2.start();
        
        t3.start();
    }
}

class MyRunnable2 implements Runnable{

    private String name;
    
    public MyRunnable2(String name){
        this.name = name;
    }
    
    
    @Override
    public void run() {
        for (int i = 0; i <10; i++){
            System.out.println(name+"-----"+i);
        }
    }
}
