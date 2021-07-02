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

import com.cg.onlinesweetmartapplication.entities.SweetItem;
import com.cg.onlinesweetmartapplication.exceptions.InvalidSweetItemDetailsException;
import com.cg.onlinesweetmartapplication.exceptions.SweetItemNotFoundException;
import com.cg.onlinesweetmartapplication.model.SweetItemDTO;
import com.cg.onlinesweetmartapplication.service.SweetItemService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/osm")
public class SweetItemController {
	
	private static final Logger logger = LoggerFactory.getLogger(SweetItemController.class);
	
	@Autowired
	private SweetItemService sweetitemService;
	
	@PostMapping(value="/addSweetItem")
	public SweetItemDTO addSweetItem(@RequestBody SweetItem sweetitem) throws InvalidSweetItemDetailsException
	{
		logger.info("addSweetItem URL is Opened");
		logger.info("addSweetItem() in initiated");
		logger.info("addSweetItem() had executed");
		return sweetitemService.addSweetItem(sweetitem);
	}
	
	@GetMapping(value="/viewAllSweetItems")
	public List<SweetItemDTO> showAllSweetItems() throws SweetItemNotFoundException
	{
		logger.info("viewAllSweetItems URL is Opened");
		logger.info("showAllSweetItems() in initiated");
		logger.info("showAllSweetItems() had executed");
		return sweetitemService.showAllSweetItems();
	}
	
	
	@PutMapping(value="/updateSweetItem")
	public SweetItemDTO updateSweetItem(@RequestBody SweetItem sweetitem) throws SweetItemNotFoundException, InvalidSweetItemDetailsException
	{
		logger.info("updateSweetItem URL is Opened");
		logger.info("updateSweetItem() in initiated");
		logger.info("updateSweetItem() had executed");
		return sweetitemService.updateSweetItem(sweetitem);
	}
	
	@DeleteMapping(value="/deleteSweetItem/{id}")
	public SweetItemDTO deleteSweetItem(@PathVariable int id) throws SweetItemNotFoundException
	{
		logger.info("deleteSweetItemById URL is Opened");
		logger.info("deleteSweetItem() in initiated");
		logger.info("deleteSweetItem() had executed");
		return sweetitemService.cancelSweetItem(id);
	}
}
