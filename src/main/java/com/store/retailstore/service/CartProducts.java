package com.store.retailstore.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.store.retailstore.model.Product;

public class CartProducts implements Cart{

	private static final Logger logger = LoggerFactory.getLogger(CartProducts.class);

	private Map<Product, Integer> productQuantityMap;
	public CartProducts() {
		productQuantityMap = new LinkedHashMap<>();
	}
	
	@Override
	public void addProducts(Product products, int quantity) {
		logger.debug("ProcessingCart inside addProducts(products, quantity) method...");
		int storedQuantity = productQuantityMap.getOrDefault(products, 0);
		productQuantityMap.put(products, storedQuantity + quantity);
	}
	
	@Override
	public void removeProducts(Product products, int quantity) {
		logger.debug("ProcessingCart inside removeProducts(products, quantity) method...");
		if(productQuantityMap.containsKey(products)){
			if( productQuantityMap.get(products)>quantity){
				productQuantityMap.put(products,productQuantityMap.get(products)-quantity);
			}else if( productQuantityMap.get(products)== quantity)
			productQuantityMap.remove(products);
		}
		int storedQuantity = productQuantityMap.getOrDefault(products, 0);
		productQuantityMap.put(products, storedQuantity + quantity);
	}

	public Map<Product, Integer> getAllCartProductsWithQuantity(){
		return productQuantityMap;
	}
}
