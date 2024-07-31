package com.fan.javaee.thread;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/22
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        Milk milk = new Milk();
        ProduceMilk produceMilk = new ProduceMilk(milk);

        ExpendMilk expendMilk = new ExpendMilk(milk);

        Thread thread = new Thread(produceMilk);
        Thread thread1 = new Thread(expendMilk);
        
        thread.start();
        
        thread1.start();
    }
    
}



class ProduceMilk implements Runnable{

    private Milk milk;
    
    public ProduceMilk(Milk milk){
        this.milk = milk;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            milk.produce(i);   
        }
    }
}



class ExpendMilk implements Runnable{

    private Milk milk;
    
    public ExpendMilk(Milk milk){
        this.milk = milk;
    }
    
    @Override
    public void run() {
        while (true) {

            milk.expend();   
        }
    }
}

class Milk{
    
    private int milkAmount;
    
    private boolean hasMilk = false;
    
    
    public synchronized void produce(int milkAmount){
        if (hasMilk){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.milkAmount = milkAmount;

        System.out.println("生产牛奶第" + milkAmount + "瓶");

        this.hasMilk = true;
        
        notifyAll();
    }
    
    
    
    public synchronized void expend(){
        if (!hasMilk){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("消耗了第" + this.milkAmount + "瓶牛奶");

        this.hasMilk = false;
        
        notifyAll();
    }
    
    
}
