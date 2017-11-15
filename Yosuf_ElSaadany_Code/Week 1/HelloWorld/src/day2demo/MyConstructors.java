package day2demo;



public class MyConstructors {

	//Instance Variables
	int x;
	int y;
	int a, b;
	
	// Static class variable
	static int z;
	
	public MyConstructors() {
		//Implicitly calls super
		System.out.println("in no args constructor");
	
	}
	
	public MyConstructors(int x) {
		this();
		this.x = x;
		System.out.println("in x constructor");
	}
	
	public MyConstructors(int y, int a, int b) {
		this(10);
		this.y = y;
		this.a = a;
		this.b = b;
		System.out.println("in y a b constructor");
	}
	
	public MyConstructors(String str, int x) {
		
		
	}
	
	public MyConstructors(int x, String str) {
		
		
	}

	public static void main(String[] args) {

	}

}
