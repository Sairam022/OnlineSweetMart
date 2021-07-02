package com.cg.onlinesweetmartapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinesweetmartapplication.entities.SweetItem;
@Repository
public interface SweetItemRepository extends JpaRepository<SweetItem,Integer>{

	
}