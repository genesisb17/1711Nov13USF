package com.revature.hello;

public class AboutStrings {

	String tester = "hello";
	
	public static void main(String[] args) {
		
		// creates a new String object with the value "hello" and adds it to heap, into the string pool
		String a = "hello";
		
		// creates a new String object with the value "Hello" and adds it to heap, into the string pool
		String b = "Hello";
		
		/* 
		 * although a String object with the value "hello" already exists in the String pool, the 'new'
		 * keyword forcibly creates a new String object with the value "hello" and adds it to heap, 
		 * into the string pool 
		*/
		String c = new String("hello");
		
		// takes a String variable 'd' and makes it reference the memory address of the String 'a' object
		String d = a;
		
		/*
		 * takes a String variable 'e' and makes it reference the memory address of the existing String object
		 * within the string pool with the value "hello"
		 */
		String e = "hello";
		
		// returns true: since .equals() method checks for value equivalence
		System.out.println("1: " + a.equals(c));
		
		// returns false: 'c' references a different String object than 'a' does, though it has the same value
		System.out.println("2: " + (a == c));
		
		// returns true: 'd' and 'a' reference the same object, and therefore have the same value
		System.out.println("3: " + a.equals(d));
		
		// returns true: 'd' and 'a' reference the same object
		System.out.println("4: " + (a == d));
		
		// returns true: since .equalsIgnoreCase() method checks for value equivalence while ignoring casing
		System.out.println("5: " + a.equalsIgnoreCase(b));
		
		// returns true: 'e' and 'a' references the same object
		System.out.println("6: " + (a == e));
		
		
		System.out.println("+----------------------------------------+\n");
		
		/*
		 * calls the user-defined test() method which accepts a String object as a variable, no changes
		 * are made to the String object 'a'
		 */
		System.out.println("Running test() method, but making no changes to 'a'...");
		test(a);
		
		// shows that no changes are made to 'a'
		System.out.println("String 'a' value: " + a);
		
		// reassigns the String 'a' variable to the String object returned by the test() method
		System.out.println("\nAssigning 'a' to the result of the test() method...");
		a = test(a);
		
		// shows that 'a' now references a different String object
		System.out.println("String 'a' value: " + a);
		
		
		System.out.println("+----------------------------------------+\n");
		
		// reset 'a' value back to "hello"
		a = "hello";
		
		// returns the character at a given index location ('e')
		System.out.println(a.charAt(1));
		
		// returns an integer that represents the number of characters in the String (5)
		System.out.println(a.length());
		
		// returns the index location of the first occurrence of the given character in the String (2)
		System.out.println(a.indexOf("l"));
		
		// replaces all occurrences of a given character with a specified replacement (h for j = "jello")
		System.out.println(a.replace('h', 'j'));
		
		// concatenates the original String with a given String
		System.out.println(a.concat(" world"));
		
		// replaces a defined String with a new String ("ll" for "b" = hebo)
		System.out.println(a.replace("ll", "b"));
	}

	
	/*
	 * Parameters: String x
	 * Returns: String
	 */
	static String test(String x) {
		
		/*
		 *  the String object offers a built-in method, substring(), that splices the String object's value
		 *  from a given index location (in this case, 2) 
		 */
		return x.substring(2);
	}
}
