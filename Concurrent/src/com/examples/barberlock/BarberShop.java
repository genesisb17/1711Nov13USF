
package com.examples.barberlock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BarberShop {
    //lock and condition requirement
    private Lock lock;    
    //number of customers
    int customerCount;
    //this boolean checks if the main chair is ready
    private boolean chairReady;
    //condition if barber is working
    private Condition hairCut;
    //arrayblockqueue to keep track of the waiting chair queue
    private ArrayBlockingQueue<Integer> chairQ;
    //constructor class
    public BarberShop(){
        //total of 3 chairs waiting
        chairQ = new ArrayBlockingQueue<>(3);
        lock = new ReentrantLock();
        //no customer yet so initially false and 0
        chairReady = false;
        customerCount = 0;
        hairCut = lock.newCondition();            
    }
    
    public boolean enter(int id) throws InterruptedException{
        //if no available seats, leave and return false
        if(customerCount > 3){
            
            System.out.println("Customer " + id + " leaves without haircut.");
            return false;
            
        }

        else{
            
            lock.lock();
            
            try{
                //increment chair queue and customer count
                chairQ.put(id);
                customerCount++;
                //take from the chair queue in FIFO order
                if(chairQ.size()==3){     
                    
                    chairQ.take();
                            
                }
                //at first, wake the barber
                if(customerCount==1){
                    
                    System.out.println("Customer " + id + " wakes the barber.");

                }
                //then, sit if chair available
                if(customerCount>1){
                    
                    System.out.println("Customer " + id + " sits down and waits.");
                    
                }
                
                //suspend when barber is working
                while(chairReady == true){

                    hairCut.await();

                }  
                //after first thread, suspend until leave() is called
                chairReady = true;                
                //gets the haircut
                System.out.println("Customer " + id + " gets a haircut.");

            }
            //releases the lock and return true
            finally{
                
                lock.unlock();
                
            }
            
            return true;
        }    
    }
    
    public void leave(int id) throws InterruptedException{
        
        lock.lock();
        
        try{
            //decrements the count after thread leaves
            customerCount--;
            //resets the condition of active chair
            chairReady=false;
            System.out.println("Customer " + id + " leaves after haircut.");
            //signal all to release waiting threads
            hairCut.signalAll();
        }
        
        finally{
            
            lock.unlock();
            
        }
        
    }

}
