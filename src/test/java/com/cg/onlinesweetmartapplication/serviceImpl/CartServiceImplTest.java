package com.cg.onlinesweetmartapplication.serviceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.cg.onlinesweetmartapplication.entities.Cart;
import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.exceptions.CartNotFoundException;
import com.cg.onlinesweetmartapplication.exceptions.InvalidCartDetailsException;


import com.cg.onlinesweetmartapplication.model.CartDTO;

import com.cg.onlinesweetmartapplication.repository.CartRepository;
import com.cg.onlinesweetmartapplication.service.CartService;
import com.cg.onlinesweetmartapplication.utils.CartUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceImplTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImplTest.class);

	@MockBean
	private CartRepository cartRepo;
	
	@Autowired
	private CartService cartService;
	
	@BeforeAll
	public static void init() {
		LOGGER.info("CartServiceImplTest Testing Initiated");
	}
	
	@Test
	public void addCartTest() throws InvalidCartDetailsException
	{
		LOGGER.info("Testing addCartTest()");
		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setListProduct("Mysorepak");
		cart.setProductCount(2);
		cart.setTotal(200.00);
		cart.setGrandTotal(210.00);
		
		Mockito.when(cartRepo.save(cart)).thenReturn(cart);
		CartDTO CartDTO = CartUtils.convertToCartDto(cart);
		assertEquals(CartDTO.getProductCount(),2);
	}
	
	@Test
	public void showCartByIdTest() throws CartNotFoundException, InvalidCartDetailsException
	{
		LOGGER.info("Testing showCardByIdTest()");
		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setListProduct("Kala Jamoon");
		cart.setProductCount(5);
		cart.setTotal(200.00);
		cart.setGrandTotal(210.00);
		
		Mockito.when(cartRepo.save(cart)).thenReturn(cart);
		assertEquals(cart.getCartId(),1);
	}
	
	@Test
	public void showAllCartsTest() throws CartNotFoundException
	{
		LOGGER.info("Testing showAllCartsTest()");
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
		
		List<Cart> cartsList = new ArrayList<>();
		cartsList.add(cartOne);
		cartsList.add(cartTwo);
		Mockito.when(cartRepo.findAll()).thenReturn(cartsList);
		List<CartDTO> dto =CartUtils.convertToCartDtoList(cartsList);
		assertSame(cartService.showAllCarts().size(),2);
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
		
		Mockito.when(cartRepo.save(cartOne)).thenReturn(cartOne);
		cartRepo.deleteById(cartOne.getCartId());
		assertNotEquals(cartOne, new Product());
		
		
	}
	
	
	
	@Test
	public void updateCartTest()
	{
		LOGGER.info("Testing updateCartTest()");
		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setListProduct("rasmalai");
		cart.setProductCount(2);
		cart.setTotal(200.00);
		cart.setGrandTotal(210.00);
		
		cartRepo.save(cart);
	
		Mockito.when(cartRepo.save(cart)).thenReturn(cart);
		assertEquals(cart.getGrandTotal(), 210.00);
	}
	

	@AfterAll
	public static void end() {
		LOGGER.info("CartServiceImplTest Testing Terminated");
	}
}