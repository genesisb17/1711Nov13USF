package day3demo;

public class StringsNThings {

	public static void main(String[] args) {
		
	
	String str = "Hello";
	StringBuffer buff   = new StringBuffer("hello");
	StringBuilder build = new StringBuilder("howdy");
	
	str = str.concat(" world");
	buff.append(" buff");
	build.append(" build");
	
	System.out.println(str + " " + buff + " " + build);
	
	System.out.println(buff.reverse());
	}
	
	
	
	
}
