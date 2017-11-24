package com.rev.main;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.main.interfaces.BankOperationValidator;
import com.rev.pojos.User;

public class BankOpsValidator implements BankOperationValidator{
	
	private static BankOpsValidator validator = new BankOpsValidator();
	private DAO fdao = new FileDAO();
	
	private BankOpsValidator(){
		
	}
	
	public static BankOpsValidator getInstance(){
		return validator;
	}
	
	@Override
	public boolean isFirstNameValid(String s) {
		if(s.matches(".*\\d+.*")) return false;
		if(s.isEmpty()) return false;
		else return true;
	}

	@Override
	public boolean isLastNameValid(String s) {
		if(s.matches(".*\\d+.*")) return false;
		if(s.isEmpty()) return false;
		else return true;
	}

	@Override
	public Object isUsernameValid(String s) {
		Boolean isValid = true;
		ArrayList<User> userList = fdao.getAllUsers();
		for(User u: userList){
			if(u.getUsername().equalsIgnoreCase(s)){
				return "Sorry this username is already taken. Please try again...";
			}
		}
		if(s.isEmpty()) return false;
		return isValid;
	}

	@Override
	public boolean isPasswordValid(String s) {
		if(s.isEmpty()) return false;
		return true;
	}

}
