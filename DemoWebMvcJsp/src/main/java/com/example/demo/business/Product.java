package com.example.demo.business;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private int categoryid;
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String make) {
		this.name = make;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public Product(int id, String make, double price, int categoryid, String category) {
		super();
		this.id = id;
		this.name = make;
		this.price = price;
		this.categoryid = categoryid;
		this.category = category;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s) costs %.2f ",name,category,price);
	}
}
