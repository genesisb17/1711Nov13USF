package day3demo;

public class StringsandThings {
	public static void main(String[] args) {
		String str= "hello";
		StringBuffer buf=new StringBuffer("hello");
		StringBuilder build=new StringBuilder("hello");
		str.concat(" string");
		buf.append(" buff");
		build.append(" build");
		
		System.out.println(str +" " + buf +" " + build +" " );
		
	}

}
