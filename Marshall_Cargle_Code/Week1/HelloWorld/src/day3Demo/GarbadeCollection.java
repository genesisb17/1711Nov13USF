package day3Demo;

public class GarbadeCollection {
	public static void main(String[] args) {
		String a = "hi";
		String b = new String("hi");
		String c = "hello";
		String d = a;
		a = null;
		b = null;
		System.out.println(a + "\n" + b + "\n" + c + "\n" + d);
	}
}