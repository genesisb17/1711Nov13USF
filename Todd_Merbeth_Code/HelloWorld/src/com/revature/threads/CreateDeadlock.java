package com.revature.threads;

public class CreateDeadlock {
	/*
	 * Deadlock occurs when multiple threads need the same locks but obtain them in
	 * different order. Synchronize causes the block while waiting for the lock.
	 * The threads are waiting for each other. Both threads obtain the first lock
	 * but then cannot obtain the second lock because they are waiting for each 
	 * other to release their lock.
	 */
	private static Object L1 = new Object();
	private static Object L2 = new Object();

	public static void main(String[] args) {
		tRun1 thread1 = new tRun1();
		tRun2 thread2 = new tRun2();
		thread1.start();
		thread2.start();
	}

	private static class tRun1 extends Thread {
		public void run() {
			synchronized (L1) {
				System.out.println("thread1: has L1");
				System.out.println("thread1: waiting for L2");
				synchronized (L2) {  // Deadlock here
					System.out.println("thread1: has both locks");  // Never reached
				}
			}

		}
	}

	private static class tRun2 extends Thread {
		public void run() {
			synchronized (L2) {
				System.out.println("thread2: has L2");
				System.out.println("thread2: waiting for L1");
				synchronized (L1) {  // Deadlock here
					System.out.println("thread2: has both locks");  // Never reached
				}
			}

		}
	}
}
