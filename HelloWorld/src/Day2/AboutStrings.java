package Day2;
public class AboutStrings {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String a = "hello";
		String b = "Hello";
		String c = new String("hello");
		String d = a;
		String e = "hello";
		
		/*
		System.out.println("1 "+a.equals(c));
		System.out.println("2 "+(a==c));
		System.out.println("3 "+a.equals(e));
		System.out.println("4 "+(c==e));
		System.out.println("5 "+a.equalsIgnoreCase(b));
		*/
		text(a);
		System.out.println(a);

	}
	
	static String text(String x)
	{
		return x.substring(2);
	}
}