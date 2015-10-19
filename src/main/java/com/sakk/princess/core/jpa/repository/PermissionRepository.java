package com.sakk.princess.core.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.core.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

	Permission findByPermissionName(String permissionName);

}
