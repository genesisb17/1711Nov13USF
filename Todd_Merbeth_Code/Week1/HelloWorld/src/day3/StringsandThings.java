package day3;

public class StringsandThings {

	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
		str.concat(" world"); // basically does nothing
		str = str.concat(" world"); // will create new string in string pool, old one is then garbage unless something else points
		buff.append(" world");
		
		
		build.append(" world");
		System.out.println(build);
		System.out.println(build.charAt(4) + " " + build.charAt(7));
		System.out.println(build.capacity()); // original length + 16
		System.out.println(build.substring(6));
		
		
		
//		System.out.println(str + " " + buff + " " + build);
//		System.out.println(buff.reverse());
	}
//	Create a StringBuilder object. Use at least three methods to manipulate the String.
//	Create a new String with delimited tokens, such as “pickles:ketchup:mustard:onion” 
//	and use StringTokenizer to parse out and print each token.
//	Create two String objects with number values (i.e. “20). Write a method that adds the two.
//	Request garbage collection in your method.
//	Create a Runtime object and note at least three methods. Imagine how you would use them.
}
