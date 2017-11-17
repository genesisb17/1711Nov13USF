package com.revature.threads;

/**
 * 
 * Ihsan Taha
 * 
 * Steps:
 * 1- Create a class C with a state S (with getters and setters as needed) and two synchronized void methods.
 * 2- In the first method M1, perform the desired function and call the second synchronized method M2 within it back on M1 (this).
 * 3- In the main method, create two new objects A & B of class C.
 * 4- Then create two new Runnable objects R1 and R2 where R1's run method contains object A calling M1 with object B as its argument, 
 *    in which object B in the M1 method will call M2 back on object A (this), and vice versa for R2.  
 * 5- Create two new threads T1 and T2 that take in R1 and R2 respectively and call the start method.
 *
 */
public class DeadLockSample {
	
	public static void main(String[] args)
	{
		Signal signalA = new Signal("Signal A");
		Signal signalB = new Signal("Signal B");
		Runnable runnableA = new Runnable() {public void run() {signalA.sendSignal(signalB);}};
		Runnable runnableB = () -> { signalB.sendSignal(signalA);};
		Thread threadA = new Thread(runnableA);
		Thread threadB = new Thread(runnableB);
		threadA.start();
		threadB.start();
	}
}
