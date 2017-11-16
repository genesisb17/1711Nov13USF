package com.revature.lambda;

public class Calculambda {

	public static void main(String[] args) {
		Calculable add = (hello,world)-> {return hello+world;};
		// don't need return if one line 
		// works in any package.
	Calculable multiply = (hello,world)-> hello*world;	
	Calculable divide = (hello,world)-> {
		if(world == 0) throw new DivisionException();
		return hello/world;};
	
	}
}
@FunctionalInterface
interface Calculable{
	double calculate(int a, int b)throws DivisionException;
}