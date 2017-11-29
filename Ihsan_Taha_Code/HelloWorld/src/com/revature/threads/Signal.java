package com.revature.threads;

public class Signal {

	private String signalName;
	
	public Signal(String S) {
		signalName = S;
	}
	
	public String getName()
	{
		return signalName;
	}
	
	public synchronized void sendSignal(Signal S)
	{
		System.out.println(this.getName() + " is sending a signal to " + S.getName());
		S.sendSignalBack(this);
	}
	
	public synchronized void sendSignalBack(Signal S)
	{
		System.out.println(this.getName() + " is sending a signal back to " + S.getName());
		S.sendSignal(this);
	}	
	
}
