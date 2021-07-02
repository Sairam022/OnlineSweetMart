package com.cg.onlinesweetmartapplication.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinesweetmartapplication.entities.Cart;


@RunWith(SpringRunner.class)
@DataJpaTest
class CartRepositoryTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartRepositoryTest.class);

	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@BeforeAll
	public static void init() {
		LOGGER.info("CartRepository Testing Initiated");
	}
	
	@Test
	public void getCartByIdTest()
	{
		LOGGER.info("Testing getCartByIdTest()");
		Cart cart = new Cart();
		cart.setListProduct("Jamoon");
		cart.setProductCount(3);
		cart.setTotal(250.00);
		cart.setGrandTotal(260.00);
		
		Cart saveInDb = testEntityManager.persist(cart);
		
		Cart getFromDb = cartRepo.findById(saveInDb.getCartId()).get();
		assertEquals(getFromDb, saveInDb);
	}
	
	@Test
	public void addCartTest()
	{
		LOGGER.info("Testing addCartTest()");
		Cart cart = new Cart();
		cart.setListProduct("Jalebi");
		cart.setProductCount(3);
		cart.setTotal(250.00);
		cart.setGrandTotal(260.00);
		
		Cart saveToDb = testEntityManager.persist(cart);
		Cart getFromDb = cartRepo.findById(saveToDb.getCartId()).get();
		System.out.println("Product and total is: "+saveToDb.getListProduct()+ " " + saveToDb.getTotal());
		assertEquals(getFromDb, saveToDb);
	}
	
	@Test
	public void getAllCartsTest()
	{
		LOGGER.info("Testing getAllCartsTest()");
		Cart cartOne = new Cart();
		cartOne.setListProduct("Rasamalai");
		cartOne.setProductCount(1);
		cartOne.setTotal(65.0);
		cartOne.setGrandTotal(80.0);
		
		Cart cartTwo = new Cart();
		cartTwo.setListProduct("jamoon");
		cartTwo.setProductCount(2);
		cartTwo.setTotal(105.0);
		cartTwo.setGrandTotal(115.0);
		
		
		testEntityManager.persist(cartOne);
		testEntityManager.persist(cartTwo);
		
		List<Cart> cartsList = cartRepo.findAll();
		assertEquals(2, cartsList.size());
	}
	
	@Test
	public void deleteCartTest()
	{
		LOGGER.info("Testing deleteCartTest()");
		Cart cartOne = new Cart();
		cartOne.setListProduct("Rasamalai");
		cartOne.setProductCount(1);
		cartOne.setTotal(65.0);
		cartOne.setGrandTotal(80.0);
		
		Cart cartTwo = new Cart();
		cartTwo.setListProduct("jamoon");
		cartTwo.setProductCount(2);
		cartTwo.setTotal(105.0);
		cartTwo.setGrandTotal(115.0);
		
		testEntityManager.persist(cartOne);
		testEntityManager.persist(cartTwo);
		
		testEntityManager.remove(cartOne);
		
		List<Cart> carts = cartRepo.findAll();
		assertEquals(1, carts.size());
	}
	
	@Test
	public void updateCartTest()
	{
		LOGGER.info("Testing updateCartTest()");
		Cart cart = new Cart();
		cart.setListProduct("burfi");
		cart.setProductCount(1);
		cart.setTotal(40.0);
		cart.setGrandTotal(50.0);
		
		Cart saveToDb = testEntityManager.persist(cart);
		
		Cart getFromDb = cartRepo.findById(saveToDb.getCartId()).get();

		
	}
	

	@AfterAll
	public static void end() {
		LOGGER.info("CartRepository Testing Terminated");
	}
}