package com.ex.alive;

public interface Liveable {
	// prior to Java 8, interfaces could not implement methods
	
	default void testingDefault() {
		System.out.println("this will be available to all things liveable");
	}
	int reproduce(int numPartiesInvolved);
	void consume(String... substance);
	int perish(double timeToLive);
	String waste();
	String move();
}
