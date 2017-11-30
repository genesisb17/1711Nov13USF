package com.ex.animals;

import com.ex.alive.Livable;

public abstract class Animal implements Livable{ 
	
	public void consume(String... substance){
		System.out.println("All animals eat and breathe");
		System.out.println("This eats " + substance[0]);
		System.out.println("This breathes by " + substance[1]);
	}
	
	abstract void speak(String speakslike);
}
