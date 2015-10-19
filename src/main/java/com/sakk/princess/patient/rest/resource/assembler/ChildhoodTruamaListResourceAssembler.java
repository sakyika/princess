package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.ChildhoodTruamaController;
import com.sakk.princess.patient.rest.resource.ChildhoodTruamaListResource;
import com.sakk.princess.patient.rest.resource.ChildhoodTruamaResource;
import com.sakk.princess.patient.service.util.ChildhoodTruamaList;

public class ChildhoodTruamaListResourceAssembler
		extends ResourceAssemblerSupport<ChildhoodTruamaList, ChildhoodTruamaListResource> {

	public ChildhoodTruamaListResourceAssembler() {
		super(ChildhoodTruamaController.class, ChildhoodTruamaListResource.class);
	}

	@Override
	public ChildhoodTruamaListResource toResource(ChildhoodTruamaList childhoodTruamaList) {

		List<ChildhoodTruamaResource> childhoodTruamaResourceList = new ChildhoodTruamaResourceAssembler()
				.toResources(childhoodTruamaList.getChildhoodTruamaList());
		ChildhoodTruamaListResource finalChildhoodTruamaListResource = new ChildhoodTruamaListResource();
		finalChildhoodTruamaListResource.setChildhoodTruamaListResource(childhoodTruamaResourceList);

		return finalChildhoodTruamaListResource;
	}

}
