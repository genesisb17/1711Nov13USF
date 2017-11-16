package com.revature.designpatterns;

public class Singleton {
	int count=0;
	private static Singleton singLeton= new Singleton();
	/*
	 *create a private constructor , this prevents other classes from calling it 
	 *and instansiating an object of the class ! 
	 *
	 * you're making your own instance and own handler! 
	 * static says I don't need an instance of this class for the entity
	 * 
	 */
	private Singleton(){}
	public static Singleton getInstance(){
		return singLeton;
	}
	public void hello(){
		System.out.println("hey singleton");
	}
}
