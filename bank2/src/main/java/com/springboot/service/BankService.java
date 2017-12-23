package com.springboot.service;

import java.util.List;
import com.springboot.model.Users;


public interface BankService {
	

	public void addBank(Users u);
	public List<Users> findAllBank();
	public Users findBankByUsername(String Username);	


}
