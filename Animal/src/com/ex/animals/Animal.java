package com.ex.animals;

import com.ex.alive.Liveable;

public abstract class Animal implements Liveable {
	
	
	public void consume(String... substance) {
		
		System.out.println("All animals breathe and eat.");
		System.out.println("This eats" + substance[0] + "and breathes" + substance[1]);
		
	}
	
	abstract void speak(String speaksLike);
	
}
