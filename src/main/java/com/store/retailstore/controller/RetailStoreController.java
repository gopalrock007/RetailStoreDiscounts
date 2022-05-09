package com.store.retailstore.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.retailstore.model.Product;
import com.store.retailstore.model.ProductType;
import com.store.retailstore.model.User;
import com.store.retailstore.model.UserType;
import com.store.retailstore.service.CartProducts;
import com.store.retailstore.service.StoreService;

@Component
@RestController
@ComponentScan(basePackages = { "com.store.retailstore.service" })
public class RetailStoreController {

	private static final Logger logger = LoggerFactory.getLogger(RetailStoreController.class);

	@Autowired
	StoreService storeService;

	@GetMapping("/retailstore/amount")
	public String getAmount() {
		logger.debug("RetailStoreController inside getAmount() method...");
		User employee = new User("Rohit", "9876543210", LocalDateTime.now(), UserType.EMPLOYEE);
		Product grocery = new Product("Sugar", 100, ProductType.GROCERY);
		Product bat = new Product("Bat", 1600, ProductType.SPORTS);
		Product tv = new Product("TV", 25000, ProductType.ELECTRONICS);

		CartProducts cart = new CartProducts();
		cart.addProducts(grocery, 1);
		cart.addProducts(bat, 3);
		cart.addProducts(tv, 1);
		return storeService.totalAmount(cart,employee);

	}


}
