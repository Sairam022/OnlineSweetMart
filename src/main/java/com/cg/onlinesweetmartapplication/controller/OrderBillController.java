package com.cg.onlinesweetmartapplication.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinesweetmartapplication.entities.OrderBill;
import com.cg.onlinesweetmartapplication.exceptions.OrderBillNotFoundException;
import com.cg.onlinesweetmartapplication.model.OrderBillDTO;
import com.cg.onlinesweetmartapplication.service.OrderBillService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/osm")
public class OrderBillController  {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderBillController.class);
	
	@Autowired
	private OrderBillService orderbillService;
	
	@PostMapping(value="/addOrderBill")
	public OrderBillDTO addOrderBill(@RequestBody OrderBill orderbill)
	{
		logger.info("addOrderBill URL is Opened");
		logger.info("addOrderBill() in initiated");
		logger.info("addOrderBill() had executed");
		return orderbillService.addOrderBill(orderbill);
	}
	@GetMapping(value="/viewAllOrderBills")
	public List<OrderBillDTO> showAllOrderBill()
	{
		logger.info("viewAllOrderBills URL is Opened");
		logger.info("showAllOrderBill() in initiated");
		logger.info("showAllOrderBill() had executed");
		return (List<OrderBillDTO>) orderbillService.showAllOrderBills();
	}
	@GetMapping(value="/viewOrderBill/{id}")
	public OrderBillDTO showOrderBillById(@PathVariable int id)
	{
		logger.info("viewOrderBillById URL is Opened");
		logger.info("showOrderBillById() in initiated");
		logger.info("showOrderBillById() had executed");
		return orderbillService.showAllOrderBillsById(id);
	}
	@PutMapping(value="/updateOrderBill")
	public OrderBillDTO updateOrderBill(@RequestBody OrderBill orderbill)  throws OrderBillNotFoundException
	{
		logger.info("updateOrderBill URL is Opened");
		logger.info("updateOrderBill() in initiated");
		logger.info("updateOrderBill() had executed");
		return orderbillService.updateOrderBill(orderbill);
	}
	@DeleteMapping(value="/deleteOrderBill/{id}")
	public OrderBillDTO deleteOrderBill(@PathVariable int id) throws OrderBillNotFoundException
	{
		logger.info("deleteOrderBill URL is Opened");
		logger.info("deleteOrderBill() in initiated");
		logger.info("deleteOrderBill() had executed");
		return orderbillService.cancelOrderBill(id);
	}
}