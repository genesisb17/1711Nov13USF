
package com.examples.gardenlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


public class Garden {
    
    int unfilled, planted, filled, amountDug, amountPlanted, amountFilled;
    private final Lock lock;
    private final Condition canDig, canFill, canPlant;
    
    
    public Garden(){
        unfilled = 0;
        planted = 0;
        filled = 0;
        amountDug =0;
        amountPlanted = 0;
        amountFilled = 0;
        lock = new ReentrantLock();
        canDig = lock.newCondition();
        canFill = lock.newCondition();
        canPlant = lock.newCondition();
        
    
    }
    
    public void waitToDig() throws InterruptedException{
        lock.lock();
        try{
            while(unfilled >= 5){
                System.out.println("Jordan is waiting to dig a hole");
                canDig.await();
            }
            canFill.signalAll();
            canPlant.signalAll();    
        }
        finally{
           lock.unlock();
        }
        
    }
    
    public void dig()throws InterruptedException{
        lock.lock();
        try{
            unfilled++;
            amountDug++;
            canFill.signalAll();
            canPlant.signalAll();
            System.out.println("Jordan dug a hole." + "\t" + "\t" + "\t" 
                    + "\t" + "\t" + "\t"+ amountDug);  
        }
        finally{
            lock.unlock();
        }
        
    }
    
    public void waitToPlant()throws InterruptedException{
        lock.lock();
        try{
            while(unfilled <= 0){
                System.out.println("Charles is waiting to plant a hole");
                canPlant.await();
            }
            canDig.signalAll();
            canFill.signalAll();      
        }
        finally{
            lock.unlock();
        }
        
    }
    
    public void plant()throws InterruptedException{
        lock.lock();
        try{
            unfilled--;
            planted++;
            amountPlanted++;
            canDig.signalAll();
            canFill.signalAll();
            System.out.println("Charles planted a hole." +"\t"+"\t"+"\t"+"\t"+amountPlanted);
            
        }
        finally{
            lock.unlock();
        }
        
    }
    
    public void waitToFill()throws InterruptedException{
        lock.lock();
        try{
            while((planted<=0) || (filled==amountPlanted)){
                System.out.println("Tracy is waiting to fill a hole");
                canFill.await();
            }
            
            canDig.signalAll();
            canPlant.signalAll();
            
        }
        finally{
            lock.unlock();
        }
        
    }
    
    public void fill()throws InterruptedException{
        lock.lock();
        try{
            planted--;
            filled++;
            amountFilled++;
            canDig.signalAll();
            canPlant.signalAll();
            canFill.signalAll();
            System.out.println("Tracy filled a hole." +"\t"+"\t"+"\t"+"\t"+"\t"+ amountFilled);
            
        }
        finally{
            lock.unlock();
        }
        
    }
    

    
    public static void main(String[] args) 
        throws InterruptedException {
        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        Garden garden=new Garden();
        threadExecutor.execute(new Jordan(garden));
        threadExecutor.execute(new Charles(garden));
        threadExecutor.execute(new Tracy(garden));
        threadExecutor.shutdown();
        threadExecutor.awaitTermination(30, TimeUnit.SECONDS);
    }
    
}
