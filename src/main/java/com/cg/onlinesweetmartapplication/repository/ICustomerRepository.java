package com.cg.onlinesweetmartapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinesweetmartapplication.entities.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{

}
