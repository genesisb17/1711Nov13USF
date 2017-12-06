package com.revature.lambda;

public class divideException extends Exception {
	
	private static String message = "you can't divide by 0, dude";

	public String getMessage() {
		return message;
	}	
	

}
