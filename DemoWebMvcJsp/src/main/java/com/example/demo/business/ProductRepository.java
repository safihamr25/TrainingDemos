package com.example.demo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {
	@Autowired 
	ProductData data;
	
	public List<Product> getProducts(){
		return data.listProducts();
	}
	
	public List<Category> getCategories(){
		return data.listCategories();
	}
	
	public int addProduct(Product p) {
		return data.addProduct(p);
	}
}
