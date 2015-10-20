package com.sakk.princess.core.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.core.model.Role;

public class RoleResource extends Resource<Role> {
	
	public static final String LINK_NAME_PERMISSIONS = "permissions";
	public static final String LINK_NAME_USERS = "users";
	
	RoleResource(){
		super(new Role());
	}

	public RoleResource(Role role) {
		super(role);
	}
	
	public Role toRole(){
		Role role = new Role();
		
		role.setRolename(super.getContent().getRolename());
		role.setPermissionSet(super.getContent().getPermissions());
		role.setUserList(super.getContent().getUserList());
		
		return role;
	}

}
