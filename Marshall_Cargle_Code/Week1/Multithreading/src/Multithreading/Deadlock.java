package Multithreading;

public class Deadlock {

	static String test = "test";
	static String test1 = "test2";
	public static void main(String[] args) {
		Thread1 thread1 =new Thread1();
		Thread2 thread2=new Thread2();
		thread1.start();
		thread2.start();
		System.out.println("no deadlock");
	}
	
	public static class Thread1 extends Thread{
		public void run() {
			synchronized (test) {
				System.out.println("Thread 1: locked resource 1");

				try {Thread.sleep(1000);} 
				catch (Exception e) {}

				synchronized (test1) {
					System.out.println("Thread 1: locked resource 2");
				}
			}
		}
	}
	
	public static class Thread2 extends Thread{
		public void run() {
			synchronized (test1) {
				System.out.println("Thread 2: locked resource 1");

				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}

				synchronized (test) {
					System.out.println("Thread 2: locked resource 2");
				}
			}
		}
	}
}
