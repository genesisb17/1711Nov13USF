package com.ex.test;

import com.ex.beans.Product;
import com.ex.beans.Student;
import com.ex.dao.HibDao;

public class Test {

	public static void main(String[] args) {
		
		HibDao dao= new HibDao();
		Product p= new Product();
		
		p.setPrice(10.00);
		p.setProdName("Book");
		dao.addProduct(p);
	}
}
