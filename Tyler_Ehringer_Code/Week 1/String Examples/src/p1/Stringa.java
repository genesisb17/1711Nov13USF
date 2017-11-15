package p1;

import java.util.Scanner;

public class Stringa{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String example = s.nextLine();
		System.out.println(example.endsWith("a")); //checks if the string ends with an 'a'
		System.out.println(example.toUpperCase()); // converts string to upper case
		System.out.println(example.replace('e', 'r')); // replaces 'e's with 'r's
		System.out.println(example.length()); // prints the length of the string
		System.out.println(example.concat(example)); //concats the string with itself
		
	}
}
