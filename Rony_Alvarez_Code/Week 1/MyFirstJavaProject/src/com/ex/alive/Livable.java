package com.ex.alive;

public interface Livable {
	// prior to java 8, interfaces could not implement methods.
	
	
	
	int reproduce(int numPartiesInvolved);
	void consume(String... substance);
	int perish(double timeToLive);
	String waste();
	String move();
	
	
}
