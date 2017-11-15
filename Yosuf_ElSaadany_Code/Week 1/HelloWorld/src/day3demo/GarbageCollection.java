package day3demo;

public class GarbageCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "hi";
		String b = new String("hi");
		String c = "hello";
		String d = a;
		String e = b;
		a = null; // to get rid of reference
		b = null;
		
		
		System.out.println(a + "\n" + b + "\n" + c + "\n" + d +"\n" + e);
	}

}
