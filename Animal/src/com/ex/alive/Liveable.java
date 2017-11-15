package com.ex.alive;

public interface Liveable {
	//prior to Java 8, interfaces could not implement methods
	
	
	default void testingdefault() {
		
		System.out.println("this will be the case for all things liveable");
		//new to java 8;
		
	}
	int reproduce(int partiesInvolved);
	
	void consume(String... substance);
	
	int perish(double timeToLive);
	
	String waste();
	
	String move();
	
	
}
