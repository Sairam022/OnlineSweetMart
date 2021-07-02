package com.cg.onlinesweetmartapplication.service;

import java.util.List;

import com.cg.onlinesweetmartapplication.entities.Customer;
import com.cg.onlinesweetmartapplication.exceptions.CustomerNotFoundException;
import com.cg.onlinesweetmartapplication.model.CustomerDTO;

public interface ICustomerService {

	public CustomerDTO addCustomer(Customer customer);
	public CustomerDTO updateCustomer(Customer customer) throws CustomerNotFoundException;
	public CustomerDTO cancelCustomer(int customerId) throws CustomerNotFoundException;
	public List<CustomerDTO> showAllCustomers();
	public List<CustomerDTO> showAllCustomers(int customerdId);
	}