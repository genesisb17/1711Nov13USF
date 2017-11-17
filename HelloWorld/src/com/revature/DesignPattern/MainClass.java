package com.revature.DesignPattern;

public class MainClass
{
/*
 * SINGLETON
 * must use the getInstance() method
 * to instantiate singleton class
 */
	Singleton single = Singleton.getInstance();
	single.hello();
	System.out.println(single.count);
	
}