package com.store;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.store.retailstore.model.Product;
import com.store.retailstore.model.ProductType;
import com.store.retailstore.model.User;
import com.store.retailstore.model.UserType;
import com.store.retailstore.service.PrintFinalBill;
import com.store.retailstore.service.CartProducts;

@SpringBootApplication
@ComponentScan(basePackages = {"com.store.retailstore"})
public class TheRetailStoreDiscountsApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TheRetailStoreDiscountsApplication.class, args);
	
		User user = new User("Rohit", "9876543210", LocalDateTime.now(), UserType.EMPLOYEE);
		Product grocery = new Product("Rise", 200, ProductType.GROCERY);
		Product cloth = new Product("Shirt", 800, ProductType.CLOTHING);

		CartProducts productCard = new CartProducts();
		productCard.addProducts(grocery, 2);
		productCard.addProducts(cloth, 1);

		PrintFinalBill bill = new PrintFinalBill();
		bill.printBill(productCard,user);
	}
}
