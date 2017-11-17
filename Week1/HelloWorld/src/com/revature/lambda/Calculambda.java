package com.revature.lambda;

public class Calculambda {

	public static void main(String[] args) {

		
		

		Calculable add = (a, b) -> {
			if(a < 0){
				throw new Exception();
			}
			else{
				return a + b;
			}
		};

		try {
			System.out.println(add.calculate(3,  4));
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

}

@FunctionalInterface
interface Calculable {
	double calculate(int a, int b) throws Exception;
}
