package day2demo;

public enum Operations {
	
	ADD, SUBTRACT, MULTIPLY, DIVIDE, MOD;
	
	public double calculate(double x, double y){
		switch(this){
		case ADD:
			return x + y; 
		case SUBTRACT:
			return x - y;
		case MULTIPLY:
			return x * y;
		case DIVIDE:
			return x/y;
		case MOD:
			return x%y;
		default:
			return 0;
		}
		
		
	}

}
