package com.cg.onlinesweetmartapplication.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinesweetmartapplication.entities.Cart;
import com.cg.onlinesweetmartapplication.exceptions.CartNotFoundException;
import com.cg.onlinesweetmartapplication.model.CartDTO;
import com.cg.onlinesweetmartapplication.repository.CartRepository;
import com.cg.onlinesweetmartapplication.service.CartService;
import com.cg.onlinesweetmartapplication.utils.CartUtils;


@Service
public class CartServiceImpl implements CartService {

	private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	private CartRepository cartRepo;

	@Override
	public CartDTO updateCart(Cart cart, int cartId) throws CartNotFoundException {
		logger.info("updateCart() service is initiated");
		Cart cartEntity;
		Cart cartExist = cartRepo.findById(cartId).orElse(null);
		if(cartExist == null)
		{
			throw new CartNotFoundException("Cart Not Available");
		}
		else
		{
			logger.info("updateCart() service has executed");
			cartExist.setGrandTotal(cart.getGrandTotal());
			cartExist.setListProduct(cart.getListProduct());
			cartExist.setProductCount(cart.getProductCount());
			cartExist.setTotal(cart.getTotal());
			cartEntity = cartRepo.save(cartExist);
		}
		return CartUtils.convertToCartDto(cartEntity);
	}

	@Override
	public CartDTO deleteCart(int CartId) throws CartNotFoundException {
		logger.info("deleteCart() service is initiated");
		Cart cartExist = cartRepo.findById(CartId).orElse(null);
		if(cartExist == null)
		{
			throw new CartNotFoundException("cart Id Not Available");
		}
		else
		{
			logger.info("deleteCart() service has executed");
			cartRepo.delete(cartExist);
		}
		return CartUtils.convertToCartDto(cartExist);
	}

	@Override
	public List<CartDTO> showAllCarts() throws CartNotFoundException {
		logger.info("showAllCarts() service is initiated");
		List<Cart> cartList = cartRepo.findAll();
		if(cartList.size() == 0)
		{
			throw new CartNotFoundException("No cart Available");
		}
		else
		{
			logger.info("showAllCarts() service has executed");
		return CartUtils.convertToCartDtoList(cartList);
		}
	}

	@Override
	public CartDTO showAllCartsById(int cartdId) throws CartNotFoundException {
		logger.info("showAllCartsById() service is initiated");		
		Cart cartExist = cartRepo.findById(cartdId).orElseThrow(() -> new CartNotFoundException("No cart Available with given ID"));
		logger.info("showAllCartsById() service has executed");
		return CartUtils.convertToCartDto(cartExist);
	}

	@Override
	public CartDTO addCart(Cart cart) {
		logger.info("addCart() service is initiated");
		Cart cartEntity;
		if(cart == null)
		{
			cartEntity = null;
		}
		else
		{
			logger.info("addCart() service has executed");
			cartEntity = cartRepo.save(cart);
		}
		return CartUtils.convertToCartDto(cartEntity);
	}

}