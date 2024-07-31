package com.fan.javaee.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/19
 */
public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        while (true){
            
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer");
            }
        }, 1000);
        }

    }
}
