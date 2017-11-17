package Practice;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class Prod implements Runnable
{
	Random r = new Random();
	static Queue <Integer> q = new ArrayDeque(30);

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			synchronized(q) 
			{
			if(q.size()<30)
			{
				q.add(r.nextInt(100));
				System.out.println(q.poll());
				q.notifyAll();
			}
			else
			{
			       try {
                       System.out.println("Q is full so waiting");
                       q.wait();
                   } catch (InterruptedException ex) {
                       ex.printStackTrace();
                   }
			}
			}
				
		}
	}

}
