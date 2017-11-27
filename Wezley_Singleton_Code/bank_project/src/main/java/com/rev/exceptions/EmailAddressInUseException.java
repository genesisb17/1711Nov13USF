package com.rev.exceptions;

public class EmailAddressInUseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmailAddressInUseException() {
		System.out.println("\nThe email address you provided is already in use. Please try again.");
		System.out.println("\n+--------------------------------------------------+");
	}

}
