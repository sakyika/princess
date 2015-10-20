package com.sakk.princess.core.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.core.model.User;
import com.sakk.princess.core.rest.controller.RoleController;
import com.sakk.princess.core.rest.controller.UserController;
import com.sakk.princess.core.rest.resource.UserResource;
import com.sakk.princess.core.service.exceptions.RoleNotFoundException;
import com.sakk.princess.core.service.exceptions.UserNotFoundException;

public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource> {
	
	public UserResourceAssembler() {
		super(UserController.class, UserResource.class);
	}

	@Override
	public UserResource toResource(User user) {

		UserResource userResource = new UserResource(user);

		try {
			userResource.add(linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel());
/*
			if (user.getRole() != null) {
				userResource.add(linkTo(methodOn(RoleController.class).getRole(user.getRole().getId()))
						.withRel(UserResource.LINK_NAME_ROLE));
			}
			
			
*/
			
			userResource.add(linkTo(methodOn(RoleController.class).getRoleUsers(user.getId())).withRel(UserResource.LINK_NAME_ROLE));
			

		} catch (UserNotFoundException | RoleNotFoundException e) {
			e.printStackTrace();
		}

		return userResource;
	}

}
