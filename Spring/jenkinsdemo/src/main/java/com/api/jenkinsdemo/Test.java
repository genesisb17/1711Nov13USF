package com.api.jenkinsdemo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assertdemo(1);
	}
	
	static String rev(String str) {
		int l = str.length();
		String temp = "";
		for (int i = 0; i <l; i++) {
			temp = temp + str.charAt(l-1-i);
		}
		return temp;
	}
	
	static int prod(int x) {
		//if(x<10) return x;
	//	else {
			int prod = 1;
			while(x > 0) {
				prod *= (int)x%10;	
				x=x/10;
			}
			return prod;
	//	}
		
	}
	
	static void assertdemo(int x) {
		/* An assert statement is used to declare an expected boolean 
		 * condition in a program. If the program is running with 
		 * assertions enabled, then the condition is checked at runtime. 
		 * If the condition is false, the Java runtime system throws an AssertionError.
		 * 
		 * Format: assert [expression1]: [expression2]
			expression1 is a boolean that will throw the 
			assertion if it is false. When it is thrown, 
			the assertion error exception is created with 
			the parameter expression2 (if applicable).
			
		 * Must enable assertions
		 * to do so in eclipse: https://stackoverflow.com/questions/5509082/eclipse-enable-assertions
		*/
		assert x > 5 : "assert failed";
	}

}
