package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Customer;
import com.revature.intercomm.AccountClient;

@RestController
public class CustomerControllers 
{
	private ArrayList<Customer> customers = new ArrayList();
	
	@Autowired
	private AccountClient ac;
	
	public CustomerControllers()
	{
		customers.add(new Customer(1,"Trent",null));
		customers.add(new Customer(2,"is",null));
		customers.add(new Customer(3,"cool",null));
	}
	
	@GetMapping("{id}")
	public Customer findById(@PathVariable int id)
	{
		Customer customer = customers.parallelStream().filter(cust -> cust.getId()==id).findFirst().get();
		customer.setAccounts(ac.findByCustomerId(customer.getId()));
		return customer;
	}
}
