package com.ex.alive;

public interface Livable {
	int reproduce(int numParties);
	void consume(String... substance);
	int perish(double timeToLive);
	String waste();
	String move();
	default void testingDefault() {
		System.out.println("This will be the case for all living things.");
	}

}
