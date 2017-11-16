package com.ex.alive;

public interface Livable {

	//prior to Java 8, interfaces could not implement methods
	
	default void testingdefault() {
		//new to Java 8, methods implemented in interfaces must be default
		System.out.println("This will be the ase for all things living");
	}
	
	int reproduce(int numPartiesInvolved);
	void consume(String... substance);
	int perish(double timeToLive);
	String waste();
	String move();
	
	
}
