package com.ex.beans;

public class Product {
	
	private int id;
	private String prodName;
	private double price;
	
	public Product() {}
	
	public Product(int id, String prodName, double price) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
