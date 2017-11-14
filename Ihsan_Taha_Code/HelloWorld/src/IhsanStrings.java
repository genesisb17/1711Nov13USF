public class IhsanStrings 
{
	public static void main(String args[])
	{
		// Examples of using the String API
		String str1 = "Str 1", str2 = "Str 2", str3 = "Str 3";
	
		char str1FirstLetter = str1.charAt(0);
		
		System.out.println("String 1:\t" + str1);
		System.out.println("String 2:\t" + str2);
		System.out.println("String 3:\t" + str3);
		
		System.out.println("\nFirst Letter in " + str1 + " is " + str1FirstLetter);
		System.out.println("\nThe upper case version string 1 is " + str1.toUpperCase());
	}
}
