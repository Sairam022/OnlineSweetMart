package com.cg.onlinesweetmartapplication.service;

import java.util.List;

import com.cg.onlinesweetmartapplication.entities.Cart;
import com.cg.onlinesweetmartapplication.exceptions.CartNotFoundException;
import com.cg.onlinesweetmartapplication.exceptions.InvalidCartDetailsException;
import com.cg.onlinesweetmartapplication.model.CartDTO;

public interface CartService {
	public CartDTO addCart(Cart cart) throws InvalidCartDetailsException;
	public CartDTO updateCart(Cart cart, int cartId) throws CartNotFoundException;
	public CartDTO deleteCart(int cartId) throws CartNotFoundException;
	public List<CartDTO> showAllCarts() throws CartNotFoundException;
	public CartDTO showAllCartsById(int cartId) throws CartNotFoundException;
	

}
