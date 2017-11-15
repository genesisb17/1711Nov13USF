package day3;

public class StringsandThings {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		str.concat(" str");
		buff.append(" buff");
		build.append(" build");
		
		System.out.println(str+" "+buff+" "+build);
		//builder and buffer append affects the actual string
	}

}
