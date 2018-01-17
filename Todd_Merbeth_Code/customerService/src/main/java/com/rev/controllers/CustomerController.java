package com.rev.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rev.intercomm.AccountClient;
import com.rev.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	private AccountClient ac;

	private List<Customer> customers = new ArrayList<Customer>();

	public CustomerController() {
		customers.add(new Customer(1, "Marshall", null));
		customers.add(new Customer(2, "John", null));
		customers.add(new Customer(3, "Jacob", null));
		customers.add(new Customer(4, "David", null));
		customers.add(new Customer(5, "Matt", null));
		customers.add(new Customer(6, "Jesus", null));
	}

	@GetMapping("{id}")
	public Customer findById(@PathVariable int id) {
		Customer customer = customers.parallelStream().filter(cust -> cust.getId() == id).findFirst().get();
		customer.setAccounts(ac.findByCustomerId(id));
		return customer;
	}
}
