package com.revature.deadlock;

public class TestThread {
	
	public static String str1 = new String();
	public static String str2 = new String();
	
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();

	}
	
	private static class Thread1 extends Thread{
		public void run() {
			synchronized(str1) {
				System.out.println("Thread1 str1");
			
				synchronized (str2) {
					System.out.println("Thread1 str1 & 2");
				}
			}
		}
	}
	
	private static class Thread2 extends Thread {
		public void run() {
			synchronized (str2) {
				System.out.println("Thread2 str2");

				synchronized (str1) {
					System.out.println("Thread2 str1 & 2");
				}
			}
		}
	}
}
