/*
 * This program demonstrates the use of string methods
 */
public class Strings {
	public static void main(String[] args)
	{
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
		
		System.out.println("\n");
		
		printString(i, s1, c);
		printString(4, s4);
		printString(s1, s2, f);
		printString(s1, s5, t);
		printString(s1, s2, s6);
		printString(cArray, s7);
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
}
