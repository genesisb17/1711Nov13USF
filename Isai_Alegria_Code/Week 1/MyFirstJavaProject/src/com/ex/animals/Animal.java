package com.ex.animals;

import com.ex.alive.Livable;

public abstract class Animal implements Livable {

	void consume(String eat, String breathe) {
		System.out.println("All animals eat and breathe");
		System.out.println("This eats " + eat);
		System.out.println("This breathes by " + breathe);
	}
	
	abstract void speak(String speaks);
	
}
