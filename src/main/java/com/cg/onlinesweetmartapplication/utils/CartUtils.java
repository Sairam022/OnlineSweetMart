package com.cg.onlinesweetmartapplication.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.onlinesweetmartapplication.entities.Cart;
import com.cg.onlinesweetmartapplication.model.CartDTO;



public class CartUtils {
	
	private CartUtils()
	{
		
	}
	
	public static CartDTO convertToCartDto(Cart cart)
	{
		CartDTO dto = new CartDTO();
		dto.setCartId(cart.getCartId());
		dto.setGrandTotal(cart.getGrandTotal());
		dto.setListProduct(cart.getListProduct());
		dto.setProductCount(cart.getProductCount());
		dto.setTotal(cart.getTotal());
		return dto;
	}
	
	public static List<CartDTO> convertToCartDtoList(List<Cart> cart)
	{
		List<CartDTO> dtoList = new ArrayList<>();
		for(Cart Cartlist : cart)
			dtoList.add(convertToCartDto(Cartlist));
		return dtoList;
	}
	
	public static Cart convertToCart(CartDTO cartDTO)
	{
		Cart cart = new Cart();
		cart.setCartId(cartDTO.getCartId());
		cart.setGrandTotal(cartDTO.getGrandTotal());
		cart.setListProduct(cartDTO.getListProduct());
		cart.setProductCount(cartDTO.getProductCount());
		cart.setTotal(cartDTO.getGrandTotal());
		return cart;
	}


}
