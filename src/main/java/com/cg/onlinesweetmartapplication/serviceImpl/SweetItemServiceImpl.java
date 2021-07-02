package com.cg.onlinesweetmartapplication.serviceImpl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.entities.SweetItem;
import com.cg.onlinesweetmartapplication.entities.SweetOrder;
import com.cg.onlinesweetmartapplication.exceptions.SweetItemNotFoundException;
import com.cg.onlinesweetmartapplication.model.SweetItemDTO;
import com.cg.onlinesweetmartapplication.repository.SweetItemRepository;
import com.cg.onlinesweetmartapplication.service.SweetItemService;
import com.cg.onlinesweetmartapplication.utils.SweetItemUtils;

@Service
public class SweetItemServiceImpl implements SweetItemService {
	
	private static final Logger logger = LoggerFactory.getLogger(SweetItemServiceImpl.class);
	 @Autowired 
	 SweetItemRepository repo;
	@Override
	public SweetItemDTO addSweetItem(SweetItem sweetItem) {	
		logger.info("addSweetItem() service is initiated");
		if (sweetItem == null)
			return  null;
		logger.info("addSweetItem() service has executed");
		return  SweetItemUtils. convertToSweetItemDto( repo.save(sweetItem));
	}
	@Override
	public SweetItemDTO updateSweetItem(SweetItem sweetItem) throws SweetItemNotFoundException {
		logger.info("updateSweetItem() service is initiated");
		if (sweetItem == null)
			return  null;
		SweetItem existingSweetItem = repo.findById(sweetItem.getOrderItemId()).orElse(null);
		if (existingSweetItem == null) {
			throw new SweetItemNotFoundException("invalid ID");
		}
		else {
			logger.info("updateSweetItem() service has executed");
			return SweetItemUtils.convertToSweetItemDto(repo.save(sweetItem));
		}
	}	
	@Override
	public SweetItemDTO cancelSweetItem(int ordertItemId) throws SweetItemNotFoundException {
		logger.info("cancelSweetItem() service is initiated");
		SweetItem existingSweetItem = repo.findById(ordertItemId).orElse(null);
		if (existingSweetItem == null) {
			throw new SweetItemNotFoundException("Invalid ID");
		}
		else {
			repo.delete(existingSweetItem);
			logger.info("cancelSweetItem() service has executed");
			return SweetItemUtils.convertToSweetItemDto(existingSweetItem);
		}
	}
	@Override
	public List<SweetItemDTO> showAllSweetItems() {
		logger.info("showAllSweetItems() service is initiated");
		List<SweetItem> listSweetItems = repo.findAll();
		logger.info("showAllSweetItems() service has executed");
		return SweetItemUtils.convertToSweetItemDtoList(listSweetItems);
	}	
	

public static boolean validateSweetItem(SweetItem sweetItem) {
		boolean flag;
		if (sweetItem == null  ) {
			flag = false;
		}
		else if (!(validateSweetItemProduct(sweetItem) && validateSweetItemOrderItemId(sweetItem) )) {
			flag = false;
		}
		else {
			flag = true;
		}
		return flag;
	}
public static boolean validateSweetItemProduct(SweetItem sweetItem) {
	boolean flag = true;
	Product product = sweetItem.getProduct();
	if (product == null)
		flag = false;
	return flag;
}

public static boolean validateSweetItemOrderItemId(SweetItem sweetItem) {
	boolean flag = true;
	Integer id = sweetItem.getOrderItemId();
	SweetItemServiceImpl service = new SweetItemServiceImpl();
	if (id == null||  !service.repo.existsById(id))
		flag = false;
	return flag;
}
}
	
