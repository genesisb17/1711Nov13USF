
package com.examples.gardenlock;

import java.util.Random;


public class Tracy implements Runnable{
    
    Garden garden;
    Random rand = new Random();
    
    public Tracy(Garden g) {
        this.garden = g;
    }
    
    public void run() {
        try {
            Thread.sleep(rand.nextInt(1000)); // makes the execution more random
            for (int i = 0; i < 10; i++) {
                garden.waitToFill();
                garden.fill();
                Thread.sleep(rand.nextInt(500)); // filling
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
            System.exit(1);
        }
    }
    
}
