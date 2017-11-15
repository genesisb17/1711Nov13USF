package com.ex.animals;

import com.ex.alive.*;

public abstract class Animal implements Liveable {
	
	public void consume(String... consume) {
		System.out.println("All animals eat and breathe");
		System.out.println("This eats " + consume[0]);
		System.out.println("This breathes by " + consume[1]);
		
	}
	
	abstract void speak(String speakslike);

}
