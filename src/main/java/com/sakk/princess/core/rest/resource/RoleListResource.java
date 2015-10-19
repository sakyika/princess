package com.sakk.princess.core.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Resources;

public class RoleListResource extends Resources<RoleResource> {
	
	private List<RoleResource> roleListResource = new ArrayList<RoleResource>();

	public List<RoleResource> getRoleListResource() {
		return roleListResource;
	}

	public void setRoleListResource(List<RoleResource> roleListResource) {
		this.roleListResource = roleListResource;
	}

}
