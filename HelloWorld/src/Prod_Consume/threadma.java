package Prod_Consume;

import java.util.ArrayDeque;
import java.util.Queue;

public class threadma 
{
	public static void main(String[] args)
	{
		Thread Consumer = new Thread(new consu());
		Thread Producer = new Thread(new Prod());
		Thread C2 = new Thread(new consu());
		
			Producer.start();
			Consumer.start();

	}

}