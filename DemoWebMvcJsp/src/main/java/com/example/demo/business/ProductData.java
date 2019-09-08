package com.example.demo.business;
import java.util.List;

public interface ProductData {
	List<Product> listProducts();
	List<Category> listCategories();
	int addProduct(Product p);
}
