package com.ex.service;
import java.util.List;
import com.ex.model.User;


public interface BankService {
	public void addUser(User u);
	public List<User> findAllUsers();
	public User findUserById(Integer id);
	public void updateUser(User user);
	public List<User> login(User user);
	public void deposit(User user);
	public void withdraw(User user);
	public List<User> findUserByEmail(String email);
	
}

