package Collections;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionDemo {

	public static void main(String[] args) {
		//Created an object called GenericDemo that is a Generic Object that takes in any object.
		GenericDemo<String> stringTest = new GenericDemo<String>("Marshall"); //Generic object created as a String
		GenericDemo<Integer> intTest = new GenericDemo<Integer>(5);//Generic object created as a Integer
		GenericDemo<Double> doubleTest = new GenericDemo<Double>(10.5);//Generic object created as a Double
		
		//Created an ArrayList of the type GenericDemo, which is of a Generic type
		ArrayList<GenericDemo> ourList = new ArrayList<>();
		
		//Added our Generic values to the ArrayList
		ourList.add(intTest);
		ourList.add(stringTest);
		ourList.add(doubleTest);
		
		//Printed our the list we made
		System.out.println(ourList);
		
		//Used the Collections methods to reverse the order of our list
		Collections.reverse(ourList);
		System.out.println(ourList);
		
		//Used the Collections methods to shuffle the order of our list
		Collections.shuffle(ourList);
		System.out.println(ourList);
	}

}
