package com.rev.exceptions;

/*
 *  Custom exception created in case a new user attempts to create an account using an existing username
 */
public class UserNameInUseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameInUseException() {
		System.out.println("\nThe username you provided is already in use. Please try again.");
		System.out.println("\n+--------------------------------------------------+");
	}
	
}
