package com.cg.onlinesweetmartapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinesweetmartapplication.entities.Cart;

public interface CartRepository extends JpaRepository<Cart ,Integer>{

}
