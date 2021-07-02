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

import com.cg.onlinesweetmartapplication.entities.SweetOrder;
import com.cg.onlinesweetmartapplication.exceptions.InvalidSweetOrderInputException;
import com.cg.onlinesweetmartapplication.exceptions.SweetOrderNotFoundException;
import com.cg.onlinesweetmartapplication.model.SweetOrderDTO;
import com.cg.onlinesweetmartapplication.service.SweetOrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/osm")
public class SweetOrderController {
	private static final Logger logger = LoggerFactory.getLogger(SweetOrderController.class);
	
	@Autowired
	private SweetOrderService sweetorderService;
	
	@PostMapping(value="/addSweetOrder")
	public SweetOrderDTO addSweetOrder(@RequestBody SweetOrder sweetorder) throws InvalidSweetOrderInputException
	{
		logger.info("addSweetOrder URL is Opened");
		logger.info("addSweetOrder() in initiated");
		logger.info("addSweetOrder() had executed");
		return sweetorderService.addSweetOrder(sweetorder);
	}
	
	@GetMapping(value="/viewAllSweetOrders")
	public List<SweetOrderDTO> showAllSweetOrders() throws SweetOrderNotFoundException
	{
		logger.info("viewAllSweetOrders URL is Opened");
		logger.info("showAllSweetOrders() in initiated");
		logger.info("showAllSweetOrders() had executed");
		return sweetorderService.showAllSweetOrders();
	}
	
	
	@PutMapping(value="/updateSweetOrder")
	public SweetOrderDTO updateSweetOrder(@RequestBody SweetOrder sweetorder) throws SweetOrderNotFoundException, InvalidSweetOrderInputException
	{
		logger.info("updateSweetOrder URL is Opened");
		logger.info("updateSweetOrder() in initiated");
		logger.info("updateSweetOrder() had executed");
		return sweetorderService.updateSweetOrder(sweetorder);
	}
	
	@DeleteMapping(value="/deleteSweetOrder/{id}")
	public SweetOrderDTO deleteSweetOrder(@PathVariable int id) throws SweetOrderNotFoundException
	{
		logger.info("deleteSweetOrder URL is Opened");
		logger.info("deleteSweetOrder() in initiated");
		logger.info("deleteSweetOrder() had executed");
		return sweetorderService.deleteSweetOrder(id);
	}
}
