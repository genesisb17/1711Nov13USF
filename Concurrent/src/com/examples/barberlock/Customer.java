
package com.examples.barberlock;

import java.util.*;
public class Customer implements Runnable{
    private int id;
    private BarberShop barberShop;
    private Random rand = new Random();
    
        public Customer(int id, BarberShop barberShop) {
            this.id = id;
            this.barberShop = barberShop;
        }
        
    public void run() {
        try {
            // this sleep has nothing to do with the logics
            // it is to make the execution more random
            Thread.sleep(500 + rand.nextInt(500));
        } catch (InterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
            System.exit(1);
        }
        
        try {
            if (barberShop.enter(id)) {
                // this sleep indicates the time for hair cut
                Thread.sleep(rand.nextInt(500));
                barberShop.leave(id);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
            System.exit(1);
        }
    }
    

}