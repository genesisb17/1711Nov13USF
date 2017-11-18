package com.revature.Lists;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
	    public static void main (String[] args) {
	    	// Create List of type Object
	    	List<Object> linkedList = new LinkedList<Object>();
	        
	    	// Add String
	    	String s = "Hello";
	        linkedList.add(s);
	        
	        // Add Integer
	        linkedList.add(new Integer(100));
	        
	        // Add String
	        linkedList.add("World");
	        
	        // Concatenate String then add it
	        linkedList.add(s+s);
	        
	        // Print List size and elements
	        System.out.println("linked list size = " + linkedList.size());
	        System.out.println("linked list contains: " + linkedList);
	        
	        // Remove element at specific index
	        linkedList.remove(0);
	        
	        // Print List size and elements
	        System.out.println("linked list size = " + linkedList.size()); 
	        System.out.println("linked list contains: " + linkedList);
	        
	        // Return list as object
	        Object[] x = linkedList.toArray();
	        
	        // Print elements of returned array of Objects
	        for(int i = 0; i < linkedList.size(); i++)
	        	System.out.println(x[i]);      
	    }
	}

