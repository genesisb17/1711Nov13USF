package day2demo;

public class MyClass {
	int d;

	public MyClass(int d) {
		this.d = d;
		System.out.println("constructor int " + d);
	}

	public MyClass(String str, double y) {
		
		System.out.println(str + y);
		
	}
	
	public static void main(String[] args) {
		int g = 5;
		MyClass my = new MyClass("sss", g);
		my.toString();
	}

}
