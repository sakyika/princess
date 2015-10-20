package com.sakk.princess.core.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.core.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleName(String roleName);
	
	List<Role> findByuserListId(Long userId);
	
}
