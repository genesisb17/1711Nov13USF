package Multithreading;

import java.util.ArrayList;

import Multithreading.Deadlock.Thread1;

public class ProducerConsumer {
	static ArrayList<String> array=new ArrayList<>();
	public static void main(String[] args) {
		Thread thread1 =new Thread() {
			public void run() {
				while(true) {
					if(array.size()==5)
						try {
							System.out.println("Producer is waiting");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					else
						System.out.println("Producer: "+array.size());
						array.add("number");
				}
			}
		};
		Thread thread2 =new Thread() {
			public void run() {
				while(true) {
					if(array.size()==0)
						try {
							System.out.println("Consumer is waiting");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					else
						System.out.println("Consumer: "+array.size());
						array.remove(0);
				}
			}
		};
		thread1.start();
		thread2.start();
		
	}
}
