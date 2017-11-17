package day3demo;

public class StringsAndThings {

	public static void main(String[] args) {
		
		String str = "hello";
		
		// StringBuffer and StringBuilder objects must be instantiated using the 'new' keyword
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
		// does not change the 'str' String since we do not assign the result of this line to 'str'
		str.concat(" world");
		buff.append(" buff");
		build.append(" build");
		
		System.out.println(str + " " + buff + " " + build);
		
		// reverse() method is an easy way of reversing a StringBuilder or StringBuffer objects
		System.out.println(build.reverse());
		
		// use toString() to convert an object to its String equivalent
		testBuild(build.toString());
	}
	
	static String testBuild(String sb) {
		return sb;
	}
	
}
