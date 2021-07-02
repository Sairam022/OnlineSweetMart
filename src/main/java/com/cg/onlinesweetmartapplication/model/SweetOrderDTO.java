package com.cg.onlinesweetmartapplication.model;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.entities.SweetItem;

@Component
public class SweetOrderDTO {


	private Integer sweetOrderId;
	private List<SweetItem> listItems;
	private LocalDate createdDate;
	
	public SweetOrderDTO() {
		
	}
	
	public SweetOrderDTO(Integer sweetOrderId, List<SweetItem> listItems, LocalDate createdDate)
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
		   return "SweetOrderDTO[sweetOrderId=" +sweetOrderId + ", listItems="+ listItems +", createdDate=" + createdDate + ", groupedProducts="  +"]";
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
	

