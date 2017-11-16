
package com.examples.gardenlock;

import java.util.Random;


class Jordan implements Runnable {
    Garden garden;
    Random rand = new Random();
    
    public Jordan(Garden g) {
        this.garden = g;
    }
    
    public void run() {
        try {
            Thread.sleep(rand.nextInt(1000)); // makes the execution more random
            for (int i = 0; i < 10; i++) {
                garden.waitToDig();
                garden.dig();
                Thread.sleep(rand.nextInt(100)); // digging
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
            System.exit(1);
        }
    }
}