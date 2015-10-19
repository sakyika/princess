package com.sakk.princess.core.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.core.rest.controller.PermissionController;
import com.sakk.princess.core.rest.resource.PermissionListResource;
import com.sakk.princess.core.rest.resource.PermissionResource;
import com.sakk.princess.core.service.util.PermissionList;

public class PermissionListResourceAssembler extends ResourceAssemblerSupport<PermissionList, PermissionListResource> {

	public PermissionListResourceAssembler() {
		super(PermissionController.class, PermissionListResource.class);

	}

	@Override
	public PermissionListResource toResource(PermissionList permissionList) {

		List<PermissionResource> permissionsResourceList = new PermissionResourceAssembler()
				.toResources(permissionList.getPermissionList());
		PermissionListResource finalPermissionListResource = new PermissionListResource();
		finalPermissionListResource.setPermissionListResource(permissionsResourceList);

		return finalPermissionListResource;

	}

}
