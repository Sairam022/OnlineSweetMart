package com.cg.onlinesweetmartapplication.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OrderBill")


public class OrderBill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDERBILL_ID")
	private Integer orderBillId;
	@Column(name = "DATE")
	private LocalDate createdDate;
	
	@Column(name = "GRAND_TOTAL")
	private double total;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "sweetOrderId")
	private List<SweetOrder> listSweetOrder;
	
	
	
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
	public OrderBill(Integer orderBillId, LocalDate createdDate, double total, List<SweetOrder> listSweetOrder) {
		super();
		this.orderBillId = orderBillId;
		this.createdDate = createdDate;
		this.total = total;
		this.listSweetOrder = listSweetOrder;
	}
	public OrderBill() {
		super();
		
	}
	@Override
	public String toString() {
		return "OrderBill [orderBillId=" + orderBillId + ", createdDate=" + createdDate + ", total=" + total
				+ ", listSweetOrder=" + listSweetOrder + "]";
	}
	
}
