package com.ex.alive;

public interface Liveable {
	// prior to java 8, interfaces could not implement methods
	
	default void testingdefault() {
		System.out.println("this will be the case for all living things");
	}//
	
	int reproduce(int numPartiesInvolved);
	void consume(String... substance);
	int perish(double timeToLive);
	String waste();
	String move();
}
