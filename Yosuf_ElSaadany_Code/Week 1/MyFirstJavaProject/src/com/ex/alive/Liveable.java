package com.ex.alive;

public interface Liveable {
	// prior to java 8, interface could not implement methods
	
	default void testingdefault() {
		System.out.println("this will be the case for all living");
		// new to Java 8. methods implemented in the interface must 
	}
	
	int reproduce(int numPartiesInvloved);
	void consume(String... substance);
	int perish(double TimeToLive);
	String waste();
	String move();
	
}
	