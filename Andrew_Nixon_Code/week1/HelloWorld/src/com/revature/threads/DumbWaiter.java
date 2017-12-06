package com.revature.threads;

public class DumbWaiter{
	
	private String name;
	public DumbWaiter(String name) {
		this.name = name;
	}
	
	public synchronized void hi(DumbWaiter dw) {
		System.out.println("How is your food, " + dw.name + "?" );
		System.out.println(dw.Response(this) + "? Great to hear!");
		
	}

	private String Response(DumbWaiter dumbWaiter) {
		System.out.println("How is your food, " + dumbWaiter.name + "?" );
		System.out.println(dumbWaiter.Response(this) + "? Great to hear!");
		
		return "Good";
	}

}
