package com.sakk.princess.core.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.core.rest.controller.RoleController;
import com.sakk.princess.core.rest.resource.RoleListResource;
import com.sakk.princess.core.rest.resource.RoleResource;
import com.sakk.princess.core.service.util.RoleList;

public class RoleListResourceAssembler extends
		ResourceAssemblerSupport<RoleList, RoleListResource> {

	public RoleListResourceAssembler() {
		super(RoleController.class, RoleListResource.class);

	}

	@Override
	public RoleListResource toResource(RoleList roleList) {

		List<RoleResource> roleResourceList = new RoleResourceAssembler().toResources(roleList.getRoleList());
		RoleListResource finalRoleResourceList = new RoleListResource();
		finalRoleResourceList.setRoleListResource(roleResourceList);

		return finalRoleResourceList;

	}

}
