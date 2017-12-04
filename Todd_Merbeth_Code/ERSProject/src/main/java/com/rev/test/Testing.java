package com.rev.test;

import com.rev.service.Service;

public class Testing {
	static Service service = new Service();
	public static void main(String[] args) {
		System.out.println(service.getUser("SQLUSER", "SQLPASS"));
		
	}

}
