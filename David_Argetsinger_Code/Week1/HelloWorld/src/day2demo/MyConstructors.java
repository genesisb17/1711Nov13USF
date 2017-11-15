package day2demo;

public class MyConstructors {
	int x , y , a, b;
	
	//MyConstructors cd = new MyConstructors();
	
	public MyConstructors()
	{//implicitly calls super();   known as superclass.this
//		x=0;
//		y=10;
//		a=b=5;
	}
	public MyConstructors(int x, int y)
	{
		System.out.println(" in no args constructor ");
	}
	
	public MyConstructors(int x)
	{
		this();
		this.x= x;
		System.out.println(" in x constructor ");
	} // this being the class 
	
	public MyConstructors( int y, int a , int b)
	{
		this(10);
		this.y = y;
		this.a = a;
		this.b = b;
		System.out.println(" in y a b constructor");
	}
	public MyConstructors(int x, int y, int a, int b) {
		super();
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}
	
	
	
	
}
