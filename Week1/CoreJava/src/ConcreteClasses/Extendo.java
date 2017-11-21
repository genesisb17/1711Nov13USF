package ConcreteClasses;

public abstract class Extendo {
	/* this abstract class will have 3 abstract methods that will be 
	 * implemented in a class that extends this class and provide the
	 * methods a body and specific function. The methods will do as follows:
	 * 
	 * 1)Return true if given string contains any uppercase letters, false otherwise
	 * 2)Convert given string to upper case, and return the string with all capital letters
	 * 3)Convert the given string to an int, and add 10 to it. print the output to the 
	 * console
	 */
	
	public abstract boolean upperCaseChecker(String input);
	public abstract String lowerToUpperCase(String input);
	public abstract void stringToInt(String number);
	
	
	
}
