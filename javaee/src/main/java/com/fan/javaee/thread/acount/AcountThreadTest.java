package com.fan.javaee.thread.acount;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/18
 */
public class AcountThreadTest {

    public static void main(String[] args) {
        Acount xm = new Acount("小明", 10000);
        Thread thread = new Thread(new MyRunnable(xm));
        Thread thread1 = new Thread(new MyRunnable(xm));
        thread.start();
        thread1.start();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(xm.getMoney());
    }
}

class MyRunnable implements Runnable{

    private Acount acount;

    
    public MyRunnable(Acount acount){
        this.acount = acount;
    }
    
    public void run() {
        acount.catchMoney(5000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
