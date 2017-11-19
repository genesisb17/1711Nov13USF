package com.revature.threads;

public class Consumer implements Runnable {

	@Override
	public void run(){
		synchronized(ProducerConsumer.q){
			while(true) {

				if(ProducerConsumer.q.size()>0) {
					int consumed=ProducerConsumer.q.remove();
					System.out.println("consumed integer "+consumed+" from queue");
				}
			}
		}
	}
}
