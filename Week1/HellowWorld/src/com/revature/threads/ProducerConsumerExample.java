package com.revature.threads;
import java.lang.Runnable;
import java.util.LinkedList;

public class ProducerConsumerExample {
	/*
	 * This program illustrates a solution to the known
	 * multithreading producer-consumer problem. Since I love food,
	 * I decided to model an example on how to approach the producer-consumer
	 * problem oriented around having food on a counter and then eating the food that 
	 * is on the counter. I cant eat until there is food on the counter :)
	 */
	public static void main(String[] args) throws InterruptedException {
		final foodRoutine fr = new foodRoutine();
		
		
		Thread one = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					fr.placeFood();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}); 
	
		Thread two = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try{
					fr.eatFood();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	
		one.start();
		two.start();
		
		one.join();
		two.join();
	}
	public static class foodRoutine{
		/* in this class, I am creating the placeFood and eat
		 * food methods that will be used by the threads to 
		 * illustrate the concept of the producer consumer
		 * problem
		 */
		LinkedList<Integer> list = new LinkedList<>();
		int counterCapacity = 3;
		
		public void placeFood() throws InterruptedException{
			int value = 0;
			/* by creating an infinite while loop, this ensures that the thread continues 
			 * to run, waiting on the eatFood function that is being run
			 * by the other thread to notify the thread that will be running the placeFood
			 * function
			 */
			while(true) {
				synchronized (this) {
					while(list.size()==counterCapacity)
						/* if the stack is full, wait on the 
						 * thread running eatFood to remove from the
						 * counter to allow the thread running this function to add
						 * 
						 */
						wait();
					
						System.out.println("Amount of food mom put on counter: " + value);
						
						list.add(value++); // places food on counter at home
						
						notify(); // notifies other thread running that there is now food on counter
						
						Thread.sleep(1000); // this makes the thread running the placeFood function sleep while eatFood runs and removes from the queue
						
					
				}
			}
		}
		public void eatFood() throws InterruptedException{
		while(true)
		{
			synchronized(this){
				while(list.size() == 0)
					/*if the stack is empty, you cant
					 * eat food, so wait till there is food
					 */
					wait(); 
				
				int total = list.removeFirst();
				System.out.println("I ate " + total);
				
				notify(); // inform thread running placeFood I removed from counter
				
				Thread.sleep(1000); // sleep and allow thread running place food to place food
			}
		}
	}
		}

		
		
}