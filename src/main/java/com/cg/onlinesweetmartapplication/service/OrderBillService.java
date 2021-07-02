package com.cg.onlinesweetmartapplication.service;

import java.util.List;

import com.cg.onlinesweetmartapplication.entities.OrderBill;
import com.cg.onlinesweetmartapplication.exceptions.OrderBillNotFoundException;
import com.cg.onlinesweetmartapplication.model.OrderBillDTO;

public interface OrderBillService {
	public OrderBillDTO addOrderBill(OrderBill orderbill);
	public OrderBillDTO updateOrderBill(OrderBill orderbill) throws OrderBillNotFoundException;
	public OrderBillDTO cancelOrderBill(int OrderBillId) throws OrderBillNotFoundException;
	public List<OrderBillDTO> showAllOrderBills();
	public OrderBillDTO showAllOrderBillsById(int OrderBillId);

}
