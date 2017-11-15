package com.ex.alive;

public interface Livable {
	//prior to java 8 , interfaces couldn't implement methods 
	//it's imlicit that they will be blank
	default void testingdef(){
	System.out.println("this will be the case for all things living ");
	//new to java 8 methods implemted in interaces  must be def 
	}
	
	int reproduce(int numPartiesInvolved);
	void consume(String... substance);
	int perish(double timeToLive);
	String waste();
	String move();
}
