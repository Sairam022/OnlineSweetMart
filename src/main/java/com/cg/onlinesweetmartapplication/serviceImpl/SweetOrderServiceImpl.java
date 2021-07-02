package com.cg.onlinesweetmartapplication.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.entities.SweetItem;
import com.cg.onlinesweetmartapplication.entities.SweetOrder;
import com.cg.onlinesweetmartapplication.exceptions.SweetOrderNotFoundException;
import com.cg.onlinesweetmartapplication.model.SweetOrderDTO;
import com.cg.onlinesweetmartapplication.repository.SweetOrderRepository;
import com.cg.onlinesweetmartapplication.service.SweetOrderService;
import com.cg.onlinesweetmartapplication.utils.SweetOrderUtils;

 @Service
 public  class SweetOrderServiceImpl implements SweetOrderService {
	 
		private static final Logger logger = LoggerFactory.getLogger(SweetOrderServiceImpl.class);

	 @Autowired
    SweetOrderRepository repository;

	@Override
	public SweetOrderDTO addSweetOrder(SweetOrder sweetOrder) {
		logger.info("addSweetOrder() service is initiated");
		logger.info("addSweetOrder() service has executed");
		return SweetOrderUtils.convertToSweetOrderDto(repository.save(sweetOrder));
	}

	@Override
	public SweetOrderDTO updateSweetOrder(SweetOrder sweetOrder) throws SweetOrderNotFoundException {
		logger.info("updateSweetOrder() service is initiated");
		SweetOrderDTO sweetOrderDTO;
		if (sweetOrder == null) {
			sweetOrderDTO = null;
		} else {
			if (repository.existsById(sweetOrder.getSweetOrderId())) {
				logger.info("updateSweetOrder() service has executed");
				sweetOrderDTO = SweetOrderUtils.convertToSweetOrderDto(repository.save(sweetOrder));
			} else {
				throw new SweetOrderNotFoundException();
			}
		}
		return sweetOrderDTO;
	}

	@Override
	public SweetOrderDTO deleteSweetOrder(int sweetOrderId) throws SweetOrderNotFoundException {
		logger.info("deleteSweetOrder() service is initiated");
		SweetOrderDTO sweetOrderDTO;
		SweetOrder sweetOrder = repository.findById(sweetOrderId).orElse(null);
		if (sweetOrder != null) {
			repository.delete(sweetOrder);
			logger.info("deleteSweetOrder() service has executed");
			sweetOrderDTO = SweetOrderUtils.convertToSweetOrderDto(sweetOrder);
		} else {
			throw new SweetOrderNotFoundException();
		}

		return sweetOrderDTO;
	}

	@Override
	public List<SweetOrderDTO> showAllSweetOrders() {
		logger.info("showAllSweetOrders() service is initiated");
		logger.info("showAllSweetOrders() service has executed");
		return SweetOrderUtils.convertToSweetOrderDtoList(repository.findAll());
	}

	/*@Override
	public double calculateTotalCost(int sweetOrderId) {
		double sum = 0.0;
		Long count;
		SweetOrder sweetOrder = repository.findById(sweetOrderId).orElse(null);
		if (sweetOrder != null) {
			Map<Product, Long> groupedProducts = sweetOrder.getGroupedProducts();
			if (groupedProducts != null) {
				Set<Product> keys = groupedProducts.keySet();
				for (Product product : keys) {
					count = groupedProducts.get(product);
					if (count != null) {
						sum += (product.getPrice() * count);
					}
				}
			}

		}
		return sum;
	}*/


	public static boolean validateSweetOrderId(SweetOrder sweetOrder) {
		boolean result;
		if (sweetOrder == null) {
			result = false;
		} else {
			Integer id = sweetOrder.getSweetOrderId();
			if (id != null && id >= 0) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}


	public static boolean validateListItems(SweetOrder sweetOrder) {
		boolean result = false;
		if (sweetOrder != null) {
	        List<SweetItem> items = sweetOrder.getListItems();
			if (items != null && items.size() >= 0) {
				result = true;
			}
		}
		return result;
	}

	public static boolean validateCreatedDate(SweetOrder sweetOrder) {
		boolean result = false;
		if (sweetOrder != null) {
			LocalDate date = sweetOrder.getCreatedDate();
			if (date != null && date.isBefore(LocalDate.now())) {
				result = true;
			}
		}

		return result;
	}

	

}