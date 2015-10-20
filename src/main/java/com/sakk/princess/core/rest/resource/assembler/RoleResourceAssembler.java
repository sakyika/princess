package com.sakk.princess.core.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.google.common.collect.Lists;
import com.sakk.princess.core.model.Permission;
import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.model.User;
import com.sakk.princess.core.rest.controller.PermissionController;
import com.sakk.princess.core.rest.controller.RoleController;
import com.sakk.princess.core.rest.controller.UserController;
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

			if (!role.getPermissions().isEmpty()) {
				
				List<String> permissionStringList = new ArrayList<String>();
				
				List<Permission> permissionList = Lists.newArrayList(role.getPermissions().iterator());
				
				for(Permission permission : permissionList){
					permissionStringList.add(permission.getPermissionName());
				}
				
				roleResource.add(linkTo(methodOn(PermissionController.class).getPermissionSublist(permissionStringList))
						.withRel(RoleResource.LINK_NAME_PERMISSIONS));
			}

			if (!role.getUserList().isEmpty()) {

				List<String> userStringList = new ArrayList<String>();

				List<User> userList = Lists.newArrayList(role.getUserList().iterator());

				for (User user : userList) {
					userStringList.add(user.getUsername());
				}

				roleResource.add(linkTo(methodOn(UserController.class).getUserSublist(userStringList))
						.withRel(RoleResource.LINK_NAME_USERS));
			}
		} catch (RoleNotFoundException | PermissionNotFoundException | UserNotFoundException e) {
			e.printStackTrace();
		}

		return roleResource;
	}

}
