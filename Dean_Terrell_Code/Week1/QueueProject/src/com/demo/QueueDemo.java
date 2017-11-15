package com.demo;
import java.util.*;

public class QueueDemo {

	public static void main(String[] args) {
		PriorityQueue<String> q = new PriorityQueue<String>();
		
		// Add elements
		q.offer("firstElement");
		q.offer("secondElement");
		q.offer("thirdElement");
		
		System.out.printf("%s ", q); // Print out queue
		System.out.println();
		
		System.out.printf("%s ", q.peek()); // Retrieves but does not remove
		System.out.println();
		
		q.poll(); // Removes and returns first elements
		
		String s = q.poll(); // Removes second element and stores it in "s"
		System.out.println(s);  
		
		System.out.printf("%s", q);		
	}
}
