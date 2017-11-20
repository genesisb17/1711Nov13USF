package com.rev.exceptions;

public class UserNameInUseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameInUseException() {
		System.out.println("The username you provided is already in use. Please try again.\n");
		System.out.println("\n+--------------------------------------------------+");
	}
	
}
