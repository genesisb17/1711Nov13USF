package ReverseString;

public class ReverseString {
	
	public static void main(String[] args) {
		/*
		 * This program reverses a string without using a temporary variable,
		 * nor using the reverse() method
		 */
			String name = "Felix Abreu";
			System.out.println("Name before revese call: " + name);
			String reverseName = reverseIt(name);
			System.out.println("Name after reverse call: " + reverseName);

	}
	static String reverseIt(String input) {
		/*implementation of reverse string function without
		 * using the function itself, but rather hard-coding it
		 */
		int size = input.length();
		int x= 0; // counter to index placement of letters reversed into new char array
		char[] newName = new char[size];
		char[] firstName = input.toCharArray();
		for(int i=size-1; i>=0;i--) {
				newName[x] = firstName[i];
				x++;
		}
		String finalName = new String(newName); //cast char array to a string
		return finalName;

	}
	
	
}

	
	
	
	