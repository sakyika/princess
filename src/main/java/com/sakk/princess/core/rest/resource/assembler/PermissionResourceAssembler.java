package com.sakk.princess.core.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.google.common.collect.Lists;
import com.sakk.princess.core.model.Permission;
import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.rest.controller.PermissionController;
import com.sakk.princess.core.rest.controller.RoleController;
import com.sakk.princess.core.rest.resource.PermissionResource;
import com.sakk.princess.core.service.exceptions.PermissionNotFoundException;
import com.sakk.princess.core.service.exceptions.RoleNotFoundException;

public class PermissionResourceAssembler extends ResourceAssemblerSupport<Permission, PermissionResource> {

	public PermissionResourceAssembler() {
		super(PermissionController.class, PermissionResource.class);

	}

	@Override
	public PermissionResource toResource(Permission permission) {

		PermissionResource permissionResource = new PermissionResource(permission);

		try {
			permissionResource
					.add(linkTo(methodOn(PermissionController.class).getPermission(permission.getId())).withSelfRel());

			if (!permission.getRoleSet().isEmpty()) {

				List<String> roleListString = new ArrayList<String>();

				List<Role> roleList = Lists.newArrayList(permission.getRoleSet().iterator());

				for (Role role : roleList) {
					roleListString.add(role.getRolename());
				}

				permissionResource.add(linkTo(methodOn(RoleController.class).getRoleSublist(roleListString))
						.withRel(PermissionResource.LINK_NAME_ROLES));
			}
		} catch (PermissionNotFoundException | RoleNotFoundException e) {
			e.printStackTrace();
		}

		return permissionResource;
	}

}
