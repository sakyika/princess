package com.sakk.princess.core.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class PermissionListResource extends ResourceSupport {
	
	private List<PermissionResource> permissionListResource = new ArrayList<PermissionResource>();

	public List<PermissionResource> getPermissionListResource() {
		return permissionListResource;
	}

	public void setPermissionListResource(List<PermissionResource> permissionListResource) {
		this.permissionListResource = permissionListResource;
	}
	

}
