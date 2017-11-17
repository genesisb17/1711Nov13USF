
package com.examples.gardenlock;

import java.util.Random;

public class Charles implements Runnable{
    
    Garden garden;
    Random rand = new Random();
    
    public Charles(Garden g) {
        this.garden = g;
    }
    
    public void run() {
        try {
            Thread.sleep(rand.nextInt(1000)); // makes the execution more random
            for (int i = 0; i < 10; i++) {
                garden.waitToPlant();
                garden.plant();
                Thread.sleep(rand.nextInt(500)); // planting
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
            System.exit(1);
        }
    }
}
