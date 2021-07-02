package com.cg.onlinesweetmartapplication.entities;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SweetItem {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private Integer orderItemId;
	@ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    public SweetItem(Integer orderItemId,Product product) {
    	super();
    	this.orderItemId=orderItemId;
    	this.product=product;
    }
   public SweetItem() {
	   super();		
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
		return "SweetItem [orderItemId=" + orderItemId + ", product=" + product + "]";
	}
	 
	
}
