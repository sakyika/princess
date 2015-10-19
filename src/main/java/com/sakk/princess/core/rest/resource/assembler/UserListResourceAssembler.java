package com.sakk.princess.core.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.core.rest.controller.UserController;
import com.sakk.princess.core.rest.resource.UserListResource;
import com.sakk.princess.core.rest.resource.UserResource;
import com.sakk.princess.core.service.util.UserList;

public class UserListResourceAssembler extends ResourceAssemblerSupport<UserList, UserListResource> {

	public UserListResourceAssembler() {
		super(UserController.class, UserListResource.class);
	}

	@Override
	public UserListResource toResource(UserList userList) {

		List<UserResource> userResourceList = new UserResourceAssembler().toResources(userList.getUserList());
		UserListResource finalUserListResource = new UserListResource();
		finalUserListResource.setUserListResource(userResourceList);

		return finalUserListResource;
	}

}
