
package com.examples.barberlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Assignment5_3380 {

    private static int customernum = 10;
    
    public static void main(String[] args) throws InterruptedException {
        //calls barbershop monitor
		BarberShop barberShop = new BarberShop();
                //counter for number of customers
                int id = 0;
        //uses a thread pool to start running customer threads
        ExecutorService executor = Executors.newFixedThreadPool(customernum);
                //simple for loop for number of threads
		for(int i = 0; i < customernum; i++){
                    id = i;
                    //executes the threads
                    System.out.println("Starting thread #" + i);
                    Runnable cis = new Customer(id, barberShop);
                    executor.execute(cis);
                    
		}
                //after executing, shut down
                executor.shutdown();
                executor.awaitTermination(50, TimeUnit.SECONDS);
                //the barber sleeps
                System.out.println("Barber goes to sleep.");
    }
       
}
