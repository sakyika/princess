package com.sakk.princess.core.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.rest.controller.RoleController;
import com.sakk.princess.core.rest.resource.RoleResource;
import com.sakk.princess.core.service.exceptions.PermissionNotFoundException;
import com.sakk.princess.core.service.exceptions.RoleNotFoundException;
import com.sakk.princess.core.service.exceptions.UserNotFoundException;

public class RoleResourceAssembler extends ResourceAssemblerSupport<Role, RoleResource> {

	public RoleResourceAssembler() {
		super(RoleController.class, RoleResource.class);

	}

	@Override
	public RoleResource toResource(Role role) {

		RoleResource roleResource = new RoleResource(role);

		try {
			roleResource.add(linkTo(methodOn(RoleController.class).getRole(role.getId())).withSelfRel());

			if (role.getPermissionList() != null) {

				roleResource.add(linkTo(methodOn(RoleController.class).getRolePermissions(role.getId()))
						.withRel(RoleResource.LINK_NAME_PERMISSIONS));
			}

			if (role.getUserList() != null) {

				roleResource.add(linkTo(methodOn(RoleController.class).getRoleUsers(role.getId()))
						.withRel(RoleResource.LINK_NAME_USERS));
			}
		} catch (RoleNotFoundException | PermissionNotFoundException | UserNotFoundException e) {
			e.printStackTrace();
		}

		return roleResource;
	}

}
