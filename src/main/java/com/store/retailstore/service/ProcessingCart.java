package com.store.retailstore.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import com.store.retailstore.model.Product;
import com.store.retailstore.model.ProductType;
import com.store.retailstore.model.User;

@ComponentScan(basePackages = { "com.store.retailstore.constant" })
public class ProcessingCart {

	private static final Logger logger = LoggerFactory.getLogger(StoreService.class);

	private User user;
	private double total;
	private double userDiscount;
	
	public ProcessingCart(User user) {
		this.user = user;
		total=0;
		userDiscount=0;
	}

	public int findDiscountPercentageFromUserType(User user) {
		logger.debug("ProcessingCart inside findDiscountPercentageFromUserType(User user) method...");
		int returnValue;

		switch (user.getUserType()) {
		case EMPLOYEE:
			returnValue = 30;
			break;
		case AFFILIATE:
			returnValue = 10;
			break;
		case GENERAL:
			if (ChronoUnit.YEARS.between(user.getRegistrationDate(), LocalDateTime.now()) >= 2) {
				returnValue = 5;
				break;
			}
		default:
			returnValue = 0;
			break;
		}
		return returnValue;
	}
	
	public double totalAmount(Map<Product, Integer> productQuantityMap) {
		logger.debug("ProcessingCart inside totalAmount() method...");
		total=0;
		productQuantityMap.forEach((k,v)->{
			double productPrice = k.getTotalProductPrice(v);
			if(k.getProductType()==ProductType.GROCERY){
				total += productPrice;
			} else {
				total += (productPrice - (productPrice * findDiscountPercentageFromUserType(user) / 100));
			}
		});
		return total-calculateStoreDiscountOnFinalBill(total);
	}
	
	public double getFinalBillForCartItems(Cart cart){
		return totalAmount(cart.getAllCartProductsWithQuantity());
	}
	
	public double getCartBill(Map<Product, Integer>productAndQuantityMap){
		total=0;
		productAndQuantityMap.forEach((k,v)->{
			double productPrice = k.getTotalProductPrice(v);
			if(k.getProductType()==ProductType.GROCERY){
				total += productPrice;
			} else {
				total += (productPrice - (productPrice * findDiscountPercentageFromUserType(user) / 100));
			}
		});
		return total;
	}
	
	double calculateUserDiscount(User user,CartProducts cart){
		cart.getAllCartProductsWithQuantity().forEach((k,v)->{
			double productPrice = k.getTotalProductPrice(v);
			if(k.getProductType()!=ProductType.GROCERY){
				userDiscount += productPrice * findDiscountPercentageFromUserType(user) / 100;
			}
		});
		return userDiscount;
	}
	
	/**For every $100 on the bill, 
     * there would be a $5 discount	
     * (e.g. for $990,	you	get	$45 as a discount).
     ***/
    public static double calculateStoreDiscountOnFinalBill(double amount) {
    	int storeDiscount=0;

        if(amount >= 100) {
            return ((int)(amount / 100)) * 5;
        }

        return storeDiscount;
    }
}
