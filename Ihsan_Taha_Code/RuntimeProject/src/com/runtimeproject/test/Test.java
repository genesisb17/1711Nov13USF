package com.runtimeproject.test;

import com.runtimeproject.Animal;

public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Class animalClass = Animal.class;
		Animal animal = (Animal)animalClass.newInstance();
		animal.doSomething();
		
		Class animalClass2 = Class.forName("com.runtimeproject.Animal");
		Animal animal2 = (Animal)animalClass.newInstance();
		animal2.doSomething();
	}

}
