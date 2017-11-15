package com.ex.animal;

import com.ex.alive.Livable;

public abstract class Animal implements Livable {
	public void consume(String... substance){
		System.out.println("All animals eat and breathe ");
		System.out.println("this eats " + substance[0]);
		System.out.println("this breathes by " + substance[1]);
		
	}
	abstract void speak (String speakslike);
	
	
}
