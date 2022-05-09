package com.store.retailstoreService;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.store.retailstore.model.Product;
import com.store.retailstore.model.ProductType;
import com.store.retailstore.model.User;
import com.store.retailstore.model.UserType;
import com.store.retailstore.service.CartProducts;
import com.store.retailstore.service.ProcessingCart;

public class TestRestoreWithoutDiscounts {

	private ProcessingCart processingCart;
	private Product products;
	@Before
	public void setUp() {
		User user = new User("Rohit", "9876543210",LocalDateTime.now(), UserType.GENERAL);
		processingCart = new ProcessingCart( user);
		products = new Product("something", 9, ProductType.SPORTS);
	}

	@Test
	public void testEmptyCartCostsZero() {
		CartProducts cart = new CartProducts();
		
		assertEquals(0, processingCart.totalAmount(cart.getAllCartProductsWithQuantity()), 0.01);
	}

	@Test
	public void testSingleItemCostsUnitPrice() {
		CartProducts cart = new CartProducts(); 
		cart.addProducts(products, 1);
		assertEquals(products.getProductUnitPrice(), processingCart.totalAmount(cart.getAllCartProductsWithQuantity()), 0.01);
	}

	@Test
	public void testMultipleBasicItemsCost() {
		int quantity = 3;
		CartProducts cart = new CartProducts();
		cart.addProducts(products, quantity);
		assertEquals(quantity * products.getProductUnitPrice(), processingCart.totalAmount(cart.getAllCartProductsWithQuantity()), 0.01);
	}

	@Test
	public void testSeparatelyAdd() {
		int quantity = 3;
		CartProducts cart = new CartProducts();
		for (int i = quantity; i > 0; i--) {
			cart.addProducts(products, 1);
		}
		assertEquals(quantity * products.getProductUnitPrice(), processingCart.totalAmount(cart.getAllCartProductsWithQuantity()), 0.01);
	}
}
