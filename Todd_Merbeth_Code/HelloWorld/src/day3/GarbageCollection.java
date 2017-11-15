package day3;

public class GarbageCollection {

	public static void main(String[] args) {
		String a = "hi";
		String b = new String("hi");
		String c = "hello";
		String d = a;
//		System.out.println(a==b); // false
//		System.out.println(a==d); // true
		a = null;
		b = null;

	}

}
