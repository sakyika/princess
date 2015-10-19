package com.sakk.princess.core.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.core.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUserName(String userName);

}
