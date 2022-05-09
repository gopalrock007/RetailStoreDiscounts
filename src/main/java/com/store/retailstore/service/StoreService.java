package com.store.retailstore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.store.retailstore.model.User;

@Service
public class StoreService {
	private static final Logger logger = LoggerFactory.getLogger(StoreService.class);

	public String totalAmount(CartProducts cart, User user) {
		logger.debug("StoreService inside totalAmount(Cart cart) method...");
		ProcessingCart ProcessingCart=new ProcessingCart(user);
		double amountToPay = ProcessingCart.totalAmount(cart.getAllCartProductsWithQuantity());
		return "Total Amount To Be Paid: " + amountToPay;
	}

}
