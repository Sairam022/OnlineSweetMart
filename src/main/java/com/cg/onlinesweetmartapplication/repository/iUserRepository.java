package com.cg.onlinesweetmartapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlinesweetmartapplication.entities.User;

public interface iUserRepository extends JpaRepository<User, Long> {

}
