package day2demo;

public class ConstructorDemo{
	
	int x;
	int y;
	int a, b;
	
	public ConstructorDemo(){
		System.out.println("in no-args constructor");
	}
	
	public ConstructorDemo(int x) throws Exception{
		this();
		this.x = x;
		System.out.println("in x constructor");
	}
	
	public ConstructorDemo(int y, int a, int b) throws Exception{
		this(10);
		this.y = y; 
		this.a = a;
		this.b = b;
		System.out.println("in y a b constructor");
	}

	public ConstructorDemo(int x, int y, int a, int b) {
		super();
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}
	
	
	

}
