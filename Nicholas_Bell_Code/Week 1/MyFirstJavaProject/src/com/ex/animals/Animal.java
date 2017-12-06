package com.ex.animals;

import com.ex.alive.Livable;
//abstracts don't have to implement all of a interface
public abstract class Animal implements Livable{
		public void consume(String...substance) {
			System.out.println("All animas eat and breathe.");
			System.out.println("This eats " + substance[0]);
			System.out.println("This breathes by " + substance[1]);
		}
		
		void speak(String speakslike) {
			
		}
		
}
