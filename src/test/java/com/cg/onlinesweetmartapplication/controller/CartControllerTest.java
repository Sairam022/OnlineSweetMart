package com.cg.onlinesweetmartapplication.controller;

import static org.junit.jupiter.api.Assertions.*;

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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.onlinesweetmartapplication.entities.Cart;
import com.cg.onlinesweetmartapplication.service.CartService;
import com.cg.onlinesweetmartapplication.utils.CartUtils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CartController.class )
public class CartControllerTest {
	private static final Logger LOGGER =	LoggerFactory.getLogger(CartControllerTest.class);
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CartService cartService;
	
	@BeforeAll
	public static void init() {
		LOGGER.info("CartController Testing Initiated");
	}
	
	@Test
	public void testNewCart() throws Exception
	{
		LOGGER.info("Testing testNewCart()");
		String URI = "/api/osm/addCart";
		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setListProduct("jalebi");
	    cart.setProductCount(2);
		cart.setTotal(200.00);
		cart.setGrandTotal(210.00);
		String jsonInput = this.convertToJson(cart);
		
		Mockito.when(cartService.addCart(Mockito.any(Cart.class))).thenReturn(CartUtils.convertToCartDto(cart));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertEquals(jsonInput, jsonOutput);
		assertEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());	}
	
	@Test
	public void testGetCartById() throws Exception
	{
		LOGGER.info("Testing testGetCartById()");
		String URI = "/api/osm/viewCart/{id}";
		Cart cart = new Cart();
		cart.setCartId(3);
		cart.setListProduct("Jamoon");
		cart.setProductCount(3);
		cart.setTotal(250.00);
		cart.setGrandTotal(260.00);
		String jsonInput = this.convertToJson(cart);
		
		Mockito.when(cartService.showAllCartsById(Mockito.anyInt())).thenReturn(CartUtils.convertToCartDto(cart));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 3).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		
		assertEquals(jsonInput, jsonOutput);
		assertEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetAllCarts() throws Exception
	{
		LOGGER.info("Testing testGetAllCarts()");
		String URI = "/api/osm/viewAllCarts";
		Cart cartOne = new Cart();
		cartOne.setCartId(3);
		cartOne.setListProduct("Jamoon");
		cartOne.setProductCount(3);
		cartOne.setTotal(250.00);
		cartOne.setGrandTotal(260.00);
		
		Cart cartTwo = new Cart();
		cartTwo.setCartId(4);
		cartTwo.setListProduct("rosgulla");
		cartTwo.setProductCount(3);
		cartTwo.setTotal(200.00);
		cartTwo.setGrandTotal(210.00);
		
		List<Cart> cartsList = new ArrayList<>();
		cartsList.add(cartOne);
		cartsList.add(cartTwo);
		
		String jsonInput = this.convertToJson(cartsList);
		Mockito.when(cartService.showAllCarts()).thenReturn(CartUtils.convertToCartDtoList(cartsList));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse =mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		System.out.println(jsonOutput);
		assertEquals(jsonInput, jsonOutput);
	}
	@Test
	public void testDeleteCart() throws Exception
	{
		LOGGER.info("Testing testDeleteCart()");
		String URI = "/api/osm/deleteCart/{id}";
		Cart cart = new Cart();
		cart.setCartId(3);
		cart.setListProduct("Carrot halwa");
		cart.setProductCount(3);
		cart.setTotal(150.00);
		cart.setGrandTotal(40.0);
		
		Mockito.when(cartService.deleteCart(Mockito.anyInt())).thenReturn(CartUtils.convertToCartDto(cart));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 3).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	/*@Test
	public void testUpdateCart() throws Exception
	{
		LOGGER.info("Testing testUpdateCart()");
		String URI = "/api/osm/updateCart";
		Cart cart = new Cart();
		cart.setCartId(5);
		cart.setListProduct("ladoo");
		cart.setProductCount(3);
		cart.setTotal(150.00);
		cart.setGrandTotal(40.0);
		
		Mockito.when(cartService.updateCart(Mockito.any())).thenReturn(CartUtils.convertToCartDto(cart));
		
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, "ladoo").accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertNotSame(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}*/
	

	@AfterAll
	public static void end() {
		LOGGER.info("CartController Testing Terminated");
	}
	
	private String convertToJson(Object Cart) throws JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(Cart);
	}

}