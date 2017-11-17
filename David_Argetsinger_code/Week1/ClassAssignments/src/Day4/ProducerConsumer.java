package Day4;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * to solve the issue of producer consumer, make sure the producer
 * doesn't produce if it has a full 
 * using a threadsafe queue would work as well 
 */


public class ProducerConsumer {

		static LinkedBlockingQueue<Integer> resource = new LinkedBlockingQueue<Integer>();
		//linkedblockingqueue manages the resource in such a way that producer and consumer methods
		// cannot overbound or deadlock or fill
		private static class Producer extends Thread{
			public void run(){
					while (true){
					//grab from array 
					
					try{resource.put(30); 
					System.out.println("Producer Produced in block " + resource.size());}
					catch(InterruptedException e)
					{e.printStackTrace();}
				}
			}
		}

		private static class Consumer extends Thread{
			public void run(){while (true){
				//grab from array 
				try{resource.take(); 
				System.out.println("Consumer took, Total size of resource: " + resource.size());}
				catch(InterruptedException e)
				{e.printStackTrace();}
				}
			}
		}
		public static void main(String[] args) {
			//deadlocks are situations where two or more threads are blocked
			//waiting for eachother (usually on a resource)
		      Producer T1 = new Producer();
		      Consumer T2 = new Consumer();
		      T1.start();
		      T2.start();

		}

	}
	
