package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Customer;
import com.revature.intercomm.AccountClient;

@RestController
public class CustomerController {
	private List<Customer> customers = new ArrayList<>();
	
	@Autowired
	private AccountClient ac;
	
	public CustomerController() {
		customers.add(new Customer(1, "Marshall", null));
		customers.add(new Customer(2, "John", null));
		customers.add(new Customer(3, "Marshall", null));
		customers.add(new Customer(4, "John", null));
		customers.add(new Customer(5, "Marshall", null));
		customers.add(new Customer(6, "John", null));
	}
	
	@GetMapping("{id}")
	public Customer findById(@PathVariable int id) {
		Customer customer = customers.parallelStream().filter(cust -> cust.getId() == id)
				.findFirst().get();
		customer.setAccounts(ac.findByCustomerId(id));
		return customer;
	}
}
