
public class Strings {
	public static void main(String[] args)
	{
		String a = "hello";
		String b = "Hello";
		String c = new String("hello");
		String d = a;
		String e = "hello";
		
		System.out.println("1 " + a.equals(c));
		System.out.println("2 " + (a==c));
		System.out.println("3 " + a.equals(e));
		System.out.println("4 " + (a==d));
		System.out.println("5 " + a.equalsIgnoreCase(b));
		System.out.println("6 " + (c==e));
		
		System.out.println(test(a));
		System.out.println(a);
		test2(a);
		System.out.println(a);
	}
	
	static String test(String x)
	{
		return x.substring(2);
	}
	
	static void test2(String x)
	{
		System.out.println(x.substring(2));
	}
}
