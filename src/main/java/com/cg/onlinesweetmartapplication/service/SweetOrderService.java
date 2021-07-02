package com.cg.onlinesweetmartapplication.service;

import java.util.List;

import com.cg.onlinesweetmartapplication.entities.SweetOrder;
import com.cg.onlinesweetmartapplication.exceptions.InvalidSweetOrderInputException;
import com.cg.onlinesweetmartapplication.exceptions.SweetOrderNotFoundException;
import com.cg.onlinesweetmartapplication.model.SweetOrderDTO;


public interface SweetOrderService  {

	public SweetOrderDTO addSweetOrder(SweetOrder sweetorder);
	public SweetOrderDTO updateSweetOrder(SweetOrder sweetorder) throws SweetOrderNotFoundException, InvalidSweetOrderInputException;
	public SweetOrderDTO deleteSweetOrder(int sweetorderId) throws SweetOrderNotFoundException;
	public List<SweetOrderDTO> showAllSweetOrders();
//	public double calculateTotalCost(int sweetOrderId);
	
}
