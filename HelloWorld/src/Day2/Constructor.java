package Day2;

public class Constructor 
{
	//a default constructor 
	//is a no args constuctors but not all no 
	//args are default args
	int x,y,a,b;
	public Constructor()
	{
		x = 0;
		y =10;
		a=b=5;
	}
	public Constructor(int var)
	{
		x = var;
	}
  /*public Constructor(int x)
	{
		this.x = x; 
		//this.x is the class variable and
		//x is the function variable
	}*/
	public Constructor(int x, int y,int a,int b)
	{
		super();
		this.x=x;
		this.y=y;
		this.a=a;
		this.b=b;
		System.out.println("In x Constructor");
	}
	public Constructor(int y,int a,int b)
	{//calling anothger constructor
		this(10);
		this.y=y;
		this.a=a;
		this.b=b;
		System.out.println("in y a b Constructor");
	}
	public Constructor(double x)
	{
		
	}
	public Constructor(float y)
	{
		
	}
}
