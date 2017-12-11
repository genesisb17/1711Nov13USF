package com.rev.test;

import java.util.ArrayList;

import com.rev.pojos.R_Type;
import com.rev.service.Service;

public class Testing {
	static Service service = new Service();
	public static void main(String[] args) {
		System.out.println(service.getAllReimbursements());
	}
}
