package com.ex.test;

import com.ex.beans.Product;
import com.ex.dao.hibDao;

public class Test 
{
	public static void main(String[] args)
	{
		hibDao dao = new hibDao();
		Product p = new Product();
		p.setPrice(10.0);
		p.setProdName("Book");
		dao.addProduct(p);
		
	}
}