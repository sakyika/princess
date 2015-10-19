package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.HomeAccidentController;
import com.sakk.princess.patient.rest.resource.HomeAccidentListResource;
import com.sakk.princess.patient.rest.resource.HomeAccidentResource;
import com.sakk.princess.patient.service.util.HomeAccidentList;

public class HomeAccidentListResourceAssembler
		extends ResourceAssemblerSupport<HomeAccidentList, HomeAccidentListResource> {

	public HomeAccidentListResourceAssembler() {
		super(HomeAccidentController.class, HomeAccidentListResource.class);
	}

	@Override
	public HomeAccidentListResource toResource(HomeAccidentList homeAccidentList) {

		List<HomeAccidentResource> homeAccidentResourceList = new HomeAccidentResourceAssembler()
				.toResources(homeAccidentList.getHomeAccidentList());
		HomeAccidentListResource finalHomeAccidentListResource = new HomeAccidentListResource();
		finalHomeAccidentListResource.setHomeAccidentResource(homeAccidentResourceList);

		return finalHomeAccidentListResource;
	}

}
