package com.ex.alive;

public interface Livable {
	 // prior to Java 8, interfaces could not implement methods
	
	default void testingdefault(){
		System.out.println("this will be the case for all things living");
		//new to Java 8. methods implemented in interfaces must be default
	}
	
	int reproduce(int numPartiesInvolved);
	void consume(String... substance);
	int perish(double timeToLive);
	String waste();
	String move();

}
