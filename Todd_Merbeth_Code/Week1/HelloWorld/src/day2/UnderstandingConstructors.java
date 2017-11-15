package day2;

public class UnderstandingConstructors {

	int x;
	int y;
	int a, b;
	
	//ConstructorDemo cd = new ConstructorDemo();
	public UnderstandingConstructors(){
		//implicitly calls super();
		x=0;
		y=10;
		a=b=5;
		System.out.println("in 1");
	}
	public UnderstandingConstructors(int x){
		this();
		this.x = x;
		System.out.println("in 2");
	}
	public UnderstandingConstructors(int y, int a, int b){
		this(10);
		this.y = y;
		this.a = a;
		this.b = b;
		System.out.println("in 3");
	}
	public UnderstandingConstructors(String str, int x){
		
	}
	public UnderstandingConstructors(int x, String str){
		
	}

}
