package com.ex.beans;

public class Product {

	private int id;
	private String prodName;
	private double price;
	public Product(int id, String prodname, double price) {
		super();
		this.id = id;
		this.prodName = prodname;
		this.price = price;
	}
	public Product() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodname) {
		this.prodName = prodname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	};
	
}
