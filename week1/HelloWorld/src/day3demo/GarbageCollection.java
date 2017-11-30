package day3demo;

public class GarbageCollection {
	
	public static void main(String[] args) {
		String a = "hi";
		String b = new String("hi");
		String c = "hello";
		String d = a;
		a = "";
		b = null;
		
		System.out.println(a + b );
		
		// finalize
		//system.gc
		
	}
	
	

}
