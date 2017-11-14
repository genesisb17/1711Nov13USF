package com.ex.animals;

import com.ex.alive.Liveable;

public abstract class Animal implements Liveable {
	public void consume(String... substance) {
		/*
		 * first parameter is what it eats 
		 * second is what it breaths
		 */
		System.out.println("All animals eat and breathe");
		System.out.println("This eats " + substance[0]);
		System.out.println("This breathes by " + substance[1]);
	}
	
	abstract void speak(String speaksLike);
}
