package com.cg.onlinesweetmartapplication.model;

import org.springframework.stereotype.Component;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.entities.SweetOrder;
@Component
public class SweetItemDTO  {
	    private Integer orderItemId;
	    private Product product;
	    public SweetItemDTO()
	    {
	    	super();
	    }
	    public SweetItemDTO(Integer orderItemId,Product product) {
	    	super();
	    	this.orderItemId=orderItemId;
	    	this.product=product;
	    }
		public Integer getOrderItemId() {
			return orderItemId;
		}
		public void setOrderItemId(Integer orderItemId) {
			this.orderItemId = orderItemId;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		@Override
		public String toString() {
			return "SweetItemDTO [orderItemId=" + orderItemId + ", product=" + product + "]";
		}
		
		
	}

