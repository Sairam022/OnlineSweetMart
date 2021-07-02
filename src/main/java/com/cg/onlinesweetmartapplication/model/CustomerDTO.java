package com.cg.onlinesweetmartapplication.model;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cg.onlinesweetmartapplication.entities.Cart;
import com.cg.onlinesweetmartapplication.entities.SweetItem;
import com.cg.onlinesweetmartapplication.entities.SweetOrder;

@Component
public class CustomerDTO {

	private Integer userId;
	private String username;
	private Set<SweetOrder> sweetOrders;
	private List<SweetItem> sweetItems;
	private Cart cart;
	
	public CustomerDTO() {
		super();
		
	}

	public CustomerDTO(Integer userId, String username, Set<SweetOrder> sweetOrders, List<SweetItem> sweetItems,
			Cart cart) {
		super();
		this.userId = userId;
		this.username = username;
		this.sweetOrders = sweetOrders;
		this.sweetItems = sweetItems;
		this.cart = cart;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<SweetOrder> getSweetOrders() {
		return sweetOrders;
	}

	public void setSweetOrders(Set<SweetOrder> sweetOrders) {
		this.sweetOrders = sweetOrders;
	}

	public List<SweetItem> getSweetItems() {
		return sweetItems;
	}

	public void setSweetItems(List<SweetItem> sweetItems) {
		this.sweetItems = sweetItems;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CustomerDTO [userId=" + userId + ", username=" + username + ", sweetOrders=" + sweetOrders
				+ ", sweetItems=" + sweetItems + ", cart=" + cart + "]";
	}

	
	
	
	
	
	
	
}
