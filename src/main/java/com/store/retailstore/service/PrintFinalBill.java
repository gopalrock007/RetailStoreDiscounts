package com.store.retailstore.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.store.retailstore.model.Product;
import com.store.retailstore.model.User;

public class PrintFinalBill {
	private static final Logger logger = LoggerFactory.getLogger(PrintFinalBill.class);

	public void printBill(CartProducts products, User user) {
    	logger.debug("PrintFinalBill inside printBill(cart) method...");
    	Map<Product, Integer>productAndQuantityMap=products.getAllCartProductsWithQuantity();
		ProcessingCart processingCart =new ProcessingCart(user);
		System.out.println("-------------------------------------------------------");
    	System.out.println("Hello Mr/Mrs/Miss: "+ user.getUserName());
    	System.out.println("");
    	productAndQuantityMap.forEach((k,v)->{
    		 System.out.println("\t"+k.getProductName() + "\t"+ k.getProductType() + "\t" 
     				+ k.getProductUnitPrice() + "\t" 
     				+ v + ":\t" 
     				+ k.getTotalProductPrice(v));
		});
    	System.out.println("-------------------------------------------------------");
    	System.out.println("User Discount\t\t\t\t:\t"+processingCart.calculateUserDiscount(user, products));
    	System.out.println("Store Discount on Final Bill\t\t:\t"+ProcessingCart.calculateStoreDiscountOnFinalBill((processingCart.getCartBill(productAndQuantityMap))));
    	System.out.println("-------------------------------------------------------");
    	System.out.println("Total Amount After Discount\t\t:\t " + processingCart.totalAmount(productAndQuantityMap));
    	System.out.println("-------------------------------------------------------");
	}
}
