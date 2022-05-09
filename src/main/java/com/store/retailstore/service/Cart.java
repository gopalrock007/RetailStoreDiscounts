package com.store.retailstore.service;

import java.util.Map;

import com.store.retailstore.model.Product;

public interface Cart {

	void addProducts(Product products, int quantity);
	void removeProducts(Product products, int quantity);
	Map<Product, Integer> getAllCartProductsWithQuantity();

}
