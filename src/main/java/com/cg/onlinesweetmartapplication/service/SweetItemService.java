package com.cg.onlinesweetmartapplication.service;


import java.util.List;

import com.cg.onlinesweetmartapplication.entities.SweetItem;
import com.cg.onlinesweetmartapplication.exceptions.SweetItemNotFoundException;
import com.cg.onlinesweetmartapplication.model.SweetItemDTO;

public interface SweetItemService {
	public SweetItemDTO addSweetItem(SweetItem sweetItem);
	public SweetItemDTO updateSweetItem(SweetItem sweetItem) throws SweetItemNotFoundException;
	public SweetItemDTO cancelSweetItem(int orderItemItemId) throws SweetItemNotFoundException;
	public List<SweetItemDTO> showAllSweetItems();
}

