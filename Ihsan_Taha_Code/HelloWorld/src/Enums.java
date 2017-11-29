public class Enums {
	public enum Operations
	{
		ADD, SUBTRACT, MULTIPLY, DIVIDE, MOD;

		public double calculate(double x, double y)
		{		
			switch(this)
			{
			case ADD:
				return x + y;
			case SUBTRACT:
				return x - y;
			case MULTIPLY:
				return x * y;
			case DIVIDE:
				return x / y;
			case MOD:
				return x % y;
			default:
				return x;
			}
		}
	}
	
	public static void main(String[] args)
	{	
		double x = 5.0d, y = 10.0d;
		Operations op = Operations.ADD;
		System.out.println(op.calculate(x,y));
	}
}
