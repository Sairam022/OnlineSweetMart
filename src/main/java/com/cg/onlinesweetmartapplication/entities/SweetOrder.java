package com.cg.onlinesweetmartapplication.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SweetOrder {
    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer sweetOrderId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<SweetItem> listItems;
	private LocalDate createdDate;
	
	public SweetOrder() {
		
	}
	
	public SweetOrder(Integer sweetOrderId, List<SweetItem> listItems, LocalDate createdDate)
	{
	super();

	this.sweetOrderId = sweetOrderId;
	this.listItems = listItems;
    this.createdDate = createdDate;
	}
	
	
	public Integer getSweetOrderId() {
		return sweetOrderId;
	}

	public void setSweetOrderId(Integer sweetOrderId) {
		this.sweetOrderId = sweetOrderId;
	}


	public List<SweetItem> getListItems() {
		return listItems;
	}

	public void setListItems(List<SweetItem> listItems) {
		this.listItems = listItems;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	
	@Override
	public String toString() {
		   return "SweetOrder[sweetOrderId=" +sweetOrderId + ", listItems="+ listItems +", createdDate=" + createdDate + "]";
	}
	
	
	public Map<Product,Long> initiateGroupedProducts() {
		
		Map<Product,Long> groupedProducts = new HashMap<Product, Long>();
		if (listItems != null) {
			Product product;
			for (SweetItem item : listItems) {
				product = item.getProduct();
				if (groupedProducts.containsKey(product)) {
					groupedProducts.put(product, groupedProducts.get(product) + 1);
				}else {
					groupedProducts.put(product, 1L);
				}
			}
		}
		return groupedProducts;
	}
	
}