package day2demo;

public class MyClass {
	private int x;
	private double y;
	private String name;
	
	public MyClass() {
		// implicitly calls super();
	}
	
	public MyClass(int x) {
		// implicitly calls super();
		this.x = x;
	}
	
	public MyClass(int x, double y) {
		// implicitly calls super();
		this.x = x;
		this.y = y;
	}
	
	public MyClass(int x, double y, String s) {
		// implicitly calls super();
		this.x = x;
		this.y = y;
		this.name = s;
	}
	
	public MyClass(int x, String s) {
		// implicitly calls super();
		this.x = x;
		this.name = s;
	}
	
	public MyClass(double y, String s) {
		// implicitly calls super();
		this.y = y;
		this.name = s;
	}
	
	public MyClass(double y) {
		this.y = y;
		this.name = "";
	}
	
	public MyClass(String s) {
		this.x = 0;
		this.y = 0.0;
		this.name = s;
	}
}
