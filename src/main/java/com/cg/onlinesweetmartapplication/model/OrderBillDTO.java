package com.cg.onlinesweetmartapplication.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.onlinesweetmartapplication.entities.SweetOrder;

@Component
public class OrderBillDTO {
	
	private Integer orderBillId;
	private LocalDate createdDate;
	private double total;
	private List<SweetOrder> listSweetOrder;
	
	public OrderBillDTO()  {
		super();
	}
	public OrderBillDTO( Integer orderBillId , LocalDate createdDate , double totalCost, List<SweetOrder> listSweetOrder ) {
		super();
		this.orderBillId = orderBillId;
		this.createdDate = createdDate;
		this.total = totalCost;
		this.listSweetOrder = listSweetOrder;
		
	}	
	public Integer getOrderBillId() {
		return orderBillId;
	}
	public void setOrderBillId(Integer orderBillId) {
		this.orderBillId = orderBillId;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<SweetOrder> getListSweetOrder() {
		return listSweetOrder;
	}
	public void setListSweetOrder(List<SweetOrder> listSweetOrder) {
		this.listSweetOrder = listSweetOrder;
	}
	@Override
	public String toString() {
		return "OrderBillDTO [orderBillId=" + orderBillId + ", createdDate=" + createdDate + ", total=" + total
				+ ", listSweetOrder=" + listSweetOrder + "]";
	}

	
}
