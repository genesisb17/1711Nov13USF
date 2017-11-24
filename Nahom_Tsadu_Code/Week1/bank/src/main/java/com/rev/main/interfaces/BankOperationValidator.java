package com.rev.main.interfaces;

public interface BankOperationValidator {
	boolean isFirstNameValid(String s);
	boolean isLastNameValid(String s);
	Object isUsernameValid(String s);
	boolean isPasswordValid(String s);
}
