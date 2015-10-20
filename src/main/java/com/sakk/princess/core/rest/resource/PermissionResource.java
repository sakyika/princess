package com.sakk.princess.core.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.core.model.Permission;

public class PermissionResource extends Resource<Permission> {
	
	public static final String LINK_NAME_ROLES = "roles";
	
	PermissionResource(){
		super(new Permission());
	}

	public PermissionResource(Permission permission) {
		super(permission);
	}
	
	public Permission toPermission(){
		Permission permission = new Permission();
		
		permission.setPermissionName(super.getContent().getPermissionName());
		permission.setRoleList(super.getContent().getRoleList());
		
		return permission;
	}

}
