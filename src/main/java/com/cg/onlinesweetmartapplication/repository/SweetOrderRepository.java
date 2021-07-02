package com.cg.onlinesweetmartapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinesweetmartapplication.entities.SweetOrder;



public interface SweetOrderRepository extends JpaRepository<SweetOrder, Integer> {

	
}
