package com.examples.barberlock;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


public class BarberShop2 {
    private Lock lock;
    private Lock lock2;
    boolean barberIsSleeping;
    boolean barberChairOccupied;
    int customersInShop;
    private Condition barberAvailable;
    private Condition customerCanLeave;
    private final ArrayBlockingQueue<Integer> buffer;
    
    public BarberShop2(){
        lock2 = new ReentrantLock();
        buffer = new ArrayBlockingQueue<>(3);
        lock = new ReentrantLock();
        barberIsSleeping = true;
        barberChairOccupied = false;
        customersInShop = 0;
        barberAvailable = lock.newCondition();
        customerCanLeave = lock.newCondition();
        
    }
    
    public boolean enter(int num) throws InterruptedException{
        if(customersInShop >= 4){
            System.out.println("Customer " + num + " leaves without haircut");
            return false;
        }
        
        else{
            lock.lock();
            try{
                while(barberChairOccupied){
                    buffer.put(num);
                    customersInShop++;
                    System.out.println("Customer " +num+ " sits down and waits");
                    barberAvailable.await();
                }
                barberChairOccupied = true;
                if(customersInShop==0){
                    System.out.println("Customer " + num + " wakes the barber and get a haircut");
                    customersInShop++;
                }
                else{
                    System.out.println("Customer " +num+ " gets a haircut");
                    if(buffer.size()==3){
                        buffer.take(); 
                    }
                }
                
            }
            finally{
                lock.unlock();
            }
            return true;
        }    
    }
    
    public void leave(int num) throws InterruptedException{
        lock.lock();
        try{
            barberChairOccupied=false;
            System.out.println("Customer " +num+ " leaves after haircut");
            customersInShop--;
            //if(buffer.size()==3){
              // buffer.take(); 
            //}
            barberAvailable.signalAll();
            
        }
        finally{
            lock.unlock();
        }
    }
}
