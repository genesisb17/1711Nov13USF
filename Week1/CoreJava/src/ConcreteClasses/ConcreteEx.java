package ConcreteClasses;

public class ConcreteEx extends Extendo{
	/* This class extends the abstract class "Extendo".
	 * Since ist an extension of an abstract class, 
	 * the methods of the abstract class have to be implemented
	 * 
	 * The methods will do as follows:
	 * 
	 * 1)Return true if given string contains any uppercase letters, false otherwise
	 * 2)Convert given string to upper case, and return the string with all capital letters
	 * 3)Convert the given string to an int, and add 10 to it. print the output to the 
	 * console
	 */
	
	@Override
	public boolean upperCaseChecker(String input) {
		
		char[] stringArray = new char[input.length()];
		stringArray = input.toCharArray();
		for(int x=0; x<input.length();x++)
		{
			if(Character.isUpperCase(stringArray[x]))
				return true;
		}
		return false;
		
	}

	@Override
	public String lowerToUpperCase(String input) {
		return input.toUpperCase();
	}

	@Override
	public void stringToInt(String number) {
		int num = Integer.parseInt(number);
		System.out.println((num+10));
	}
}
