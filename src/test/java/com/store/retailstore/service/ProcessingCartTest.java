package com.store.retailstore.service;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import com.store.retailstore.model.Product;
import com.store.retailstore.model.ProductType;
import com.store.retailstore.model.User;
import com.store.retailstore.model.UserType;

@ExtendWith(MockitoExtension.class)
@ComponentScan(basePackages = { "com.store.retailstore.service", "com.store.retailstore.model" })
public class ProcessingCartTest {
	private static final Logger logger = LoggerFactory.getLogger(ProcessingCartTest.class);

	@Mock
	ProcessingCart processingCart;

	@Mock
	StoreService storeService;

	@Mock
	Cart cart;
	@Mock
	Product groceryItem;
	@Mock
	Product otherItem;
	@Mock
	User employee;
	@Mock
	User affiliate;
	@Mock
	User simpleUser;
	@Mock
	User simpleUserWith2Years;


	@Before
	public void setUp() {
		employee = new User("Rohit", "9876543210", LocalDateTime.now(), UserType.EMPLOYEE);
		affiliate = new User("Virat", "9988776655", LocalDateTime.now(), UserType.AFFILIATE);
		simpleUser = new User("Rishabh", "9898989898", LocalDateTime.now(), UserType.GENERAL);
		simpleUserWith2Years = new User("Raju", "9876512345", LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30),
				 UserType.GENERAL);

		groceryItem = new Product("Soap", 20, ProductType.GROCERY);
		otherItem = new Product("TV", 5000, ProductType.ELECTRONICS);// 222
	}

	@Test
	public void testCheckUserTypeAndGetDiscountsWithEmployee() {
		logger.debug("ProcessingCartTest inside test_employeeWithGrocery() method...");
		ProcessingCart processingCart = new ProcessingCart(employee);
		int actualValue = processingCart.findDiscountPercentageFromUserType(employee);
		Assert.assertEquals(30, actualValue);
	}

	@Test
	public void testCheckUserTypeAndGetDiscountsWithAffiliate() {
		logger.debug("ProcessingCartTest inside test_employeeWithGrocery() method...");
		ProcessingCart processingCart = new ProcessingCart(affiliate);
		int actualValue = processingCart.findDiscountPercentageFromUserType(affiliate);
		Assert.assertEquals(10, actualValue);
	}

	@Test
	public void testCheckUserTypeAndGetDiscountsWithGeneral() {
		logger.debug("ProcessingCartTest inside test_employeeWithGrocery() method...");
		ProcessingCart processingCart = new ProcessingCart(simpleUser);
		int actualValue = processingCart.findDiscountPercentageFromUserType(simpleUser);
		Assert.assertEquals(0, actualValue);
	}

}
