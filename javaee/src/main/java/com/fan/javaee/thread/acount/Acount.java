package com.fan.javaee.thread.acount;

import lombok.Data;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/18
 */
@Data
public class Acount {
    private String accountName;
    
    private int money;
    
    public Acount(String accountName, int money){
        this.accountName = accountName;
        this.money = money;
    }
    
    
    public void catchMoney(int money){
        int before = getMoney();
        System.out.println(accountName+"取之前余额："+before);
        int after = before - money;
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        setMoney(after);
        System.out.println(accountName+"取之后余额："+after);
    }
}
