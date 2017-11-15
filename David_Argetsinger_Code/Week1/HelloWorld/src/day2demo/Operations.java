package day2demo;

public enum Operations {
	ADD, SUBTRACT , MOD, MULTIPLY, DIVIDE;
	public double calculate(double x , double y){
		switch(this){
		case ADD:
			return x+y;
		case MOD:
			return x%y;
		case SUBTRACT:
			return x-y;
		case MULTIPLY:
			return x*y;
		case DIVIDE:
			return x/y;
		default:
			return 0;
		}
		
		
	}

}
