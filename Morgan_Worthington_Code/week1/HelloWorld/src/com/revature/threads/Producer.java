package com.revature.threads;

import java.util.Random;

public class Producer implements Runnable {


	@Override
	public void run() {

		Random r=new Random();
		while(true) {
			if(ProducerConsumer.q.size()<ProducerConsumer.maxLength) {
				int produced=r.nextInt();
				ProducerConsumer.q.add(produced);
				System.out.println("Produced and added integer "+produced+" to the queue");
			}
		}

	}
}