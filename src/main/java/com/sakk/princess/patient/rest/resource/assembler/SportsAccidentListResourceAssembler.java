package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.SportsAccidentController;
import com.sakk.princess.patient.rest.resource.SportsAccidentListResource;
import com.sakk.princess.patient.rest.resource.SportsAccidentResource;
import com.sakk.princess.patient.service.util.SportsAccidentList;

public class SportsAccidentListResourceAssembler
		extends ResourceAssemblerSupport<SportsAccidentList, SportsAccidentListResource> {

	public SportsAccidentListResourceAssembler() {
		super(SportsAccidentController.class, SportsAccidentListResource.class);
	}

	@Override
	public SportsAccidentListResource toResource(SportsAccidentList sportsAccidentList) {
		
		List<SportsAccidentResource> sportsAccidentResourceList = new SportsAccidentResourceAssembler()
				.toResources(sportsAccidentList.getSportsAccidentList());
		
		SportsAccidentListResource finalportsAccidentListResource = new SportsAccidentListResource();
		finalportsAccidentListResource.setSportsAccidentListResource(sportsAccidentResourceList);
		return finalportsAccidentListResource;
	}

}
