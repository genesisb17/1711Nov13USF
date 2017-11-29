import java.util.StringTokenizer;

/*
 * This program demonstrates the use of string methods
 */
public class Strings {
	public static void main(String[] args)
	{
		// CODE 1 FOR ASSIGNMENT - String method examples
		System.out.println("CODE 1: Displays the results of strings from string methods");
		String s1 = "str1", s2 = "str2", s3 = "str3";
		
		// 1. Returns the char at the given index
		char c = s1.charAt(0);
			
		// 2. Returns the substring of the string starting from the given index to the end
		int i = 1;
		String s4 = s1.substring(i);
		
		// 3. Returns an int based on whether the given strings are equal
		String s5 = s1;
		int f = s1.compareTo(s2), t = s1.compareTo(s5);
		
		// 4. Returns the concatenation of the given strings
		String s6 = s1.concat(s2);
		
		// 5. Returns a string based on the copied char array
		char[] cArray = {'c','h','a','r',' ','a','r','r','a','y'};
		String s7 = String.copyValueOf(cArray);
		
		
		// Prints the results of all given methods
		printString(1, s1);
		printString(2, s2);
		printString(3, s3);
		
		System.out.println();
		
		printString(i, s1, c);
		printString(4, s4);
		printString(s1, s2, f);
		printString(s1, s5, t);
		printString(s1, s2, s6);
		printString(cArray, s7);
		
		
		
		// CODE 2 FOR ASSIGNMENT - Parses a string with delimeters and displays them line by line
		String categories = "health:mana:strength:defense:weapons:armor:accessories";

		System.out.print("\n\nCODE 2: Parses a string with delimeters and displays them line by line" +
		"\nInitial String:\n" + categories + "\n\nTokenized Values:\n");
		
		StringTokenizer st = new StringTokenizer(categories, ":");
		while (st.hasMoreTokens())
		{
			System.out.print(st.nextToken() + "   ");
		}
		
		System.out.println();
		
		
		
		// CODE 3 FOR ASSIGNMENT - Adds two numbers from string objects
		String number1 = "15", number2 = "5";
		System.out.println("\n\nCODE 3: Adds two numbers from string objects and stores the result into " +
		"a string object\n" + number1 + " + " + number2 + " = " + addStringNumbers(number1, number2));
		
		
		
		// CODE 5 FOR ASSIGNMENT - Create Runtime Object
		
	}
	
	
	
	// Overloaded method for displaying results of the string methods
	public static void printString(int i, String s, char c)
	{
		System.out.println("The char at index " + (i-1) + " of " + s + " is: " + c);
	}
	
	public static void printString(int i, String str)
	{
		System.out.println("String " + i + ":\t" + str);
	}
	
	public static void printString(String s1, String s2, int i)
	{
		System.out.println("Strings " + s1 + " and " + s2 + " are equal? " + i);
	}
	
	public static void printString(String s1, String s2, String sConcat)
	{
		System.out.println("The concatenation of " + s1 + " and " + s2 + " is: " + sConcat);
	}
	
	public static void printString(char[] cArray, String s)
	{
		System.out.println("The string of the char array '" + getString(cArray) + "' is: " + s);
	}
	
	public static String getString(char[] cArray)
	{
		String s = "";
		for (int i = 0; i < cArray.length; i++)
		{
			s += cArray[i];
		}
		
		return s;
	}
	
	
	
	// Adds two strings with number values (assumes valid input and subject to update)
	public static String addStringNumbers(String num1, String num2)
	{
		String result = Integer.toString(Integer.parseInt(num1) + Integer.parseInt(num2));
		
		// CODE 4 FOR ASSIGNMENT - Enforced Garbage Collector
		System.gc();
		
		return result;
	}
}
