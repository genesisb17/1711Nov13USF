package com.revature.day2;

public enum Operations {
	ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULO;
	
	public double calculate(double x, double y) {
		switch (this) {
		case ADD:
			return x + y;
		case SUBTRACT:
			return x - y;
		case MULTIPLY:
			return x * y;
		case DIVIDE:
			return x / y;
		case MODULO:
			return x % y;
		default: 
			return 0;
		}
	}
}
