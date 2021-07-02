package com.cg.onlinesweetmartapplication.controller;

import java.util.List;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinesweetmartapplication.entities.Cart;
import com.cg.onlinesweetmartapplication.exceptions.CartNotFoundException;
import com.cg.onlinesweetmartapplication.exceptions.InvalidCartDetailsException;
import com.cg.onlinesweetmartapplication.model.CartDTO;
import com.cg.onlinesweetmartapplication.service.CartService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/osm")
public class CartController {
	private static final Logger LOGGER =	LoggerFactory.getLogger(CartController.class);
	@Autowired
	private CartService cartService;
	
	@PostMapping(value="/addCart")
	public ResponseEntity<CartDTO> addCart(@Valid @RequestBody Cart cart) throws InvalidCartDetailsException
	{
		LOGGER.info("addcart URL is Opened");
		LOGGER.info("addCart() in initiated");
		ResponseEntity<CartDTO> cartResponse;
		CartDTO result = cartService.addCart(cart);
		cartResponse = new ResponseEntity<CartDTO>(result, HttpStatus.ACCEPTED);
		LOGGER.info("addCart() had executed");
		return cartResponse;
		
	}
	
	@GetMapping(value="/viewAllCarts")
	public List<CartDTO> showAllCarts() throws CartNotFoundException
	{
		LOGGER.info("viewAllCarts URL is Opened");
		LOGGER.info("showAllCarts() in initiated");
		LOGGER.info("showAllCarts() had executed");
		return cartService.showAllCarts();
	}
	
	@GetMapping(value="/viewCart/{id}")
	public ResponseEntity<CartDTO> showCartById(@PathVariable int id) throws CartNotFoundException
	{
		LOGGER.info("viewCart By Id URL is Opened");
		LOGGER.info("showCartById() in initiated");
		ResponseEntity<CartDTO> cartResponse;
		CartDTO result = cartService.showAllCartsById(id);
		cartResponse = new ResponseEntity<CartDTO>(result, HttpStatus.ACCEPTED);
		LOGGER.info("showCartsById() has executed");
		return cartResponse;
	}
	
	@PutMapping(value="/updateCart/{id}")
	public ResponseEntity<CartDTO> updateCart(@RequestBody Cart cart, @PathVariable int id) throws CartNotFoundException
	{
		LOGGER.info("updateCart URL is Opened");
	LOGGER.info("updateCart() in initiated");
	
	ResponseEntity<CartDTO> cartResponse;
	CartDTO result = cartService.updateCart(cart, id);
	cartResponse = new ResponseEntity<CartDTO>(result, HttpStatus.ACCEPTED);
	LOGGER.info("updateCart() has executed");
	return cartResponse;
		
	}
	
	@DeleteMapping(value="/deleteCart/{id}")
	public ResponseEntity<CartDTO> deleteCart(@PathVariable int id) throws CartNotFoundException
	{
		LOGGER.info("deleteCart URL is Opened");
		LOGGER.info("deleteCart() in initiated");
		
		ResponseEntity<CartDTO> cartResponse;
		CartDTO result = cartService.deleteCart(id);
		cartResponse = new ResponseEntity<CartDTO>(result, HttpStatus.ACCEPTED);
		LOGGER.info("deletecart() has executed");
		return cartResponse;
		
	}
}