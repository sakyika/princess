package com.sakk.princess.core.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class UserListResource extends ResourceSupport {

	private List<UserResource> userListResource = new ArrayList<UserResource>();

	public List<UserResource> getUserListResource() {
		return userListResource;
	}

	public void setUserListResource(List<UserResource> userListResource) {
		this.userListResource = userListResource;
	}

}
