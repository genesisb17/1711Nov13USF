package com.ex.animals;

import com.ex.alive.Alive;

public abstract class Animal implements Alive{

	public void consume(String... substance){
		System.out.println("This eats: " + substance[0]);
	}
	
	public void speak(String speaksLike){
		System.out.println();
	}
}
