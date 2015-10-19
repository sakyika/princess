package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.ChiropracticExperienceController;
import com.sakk.princess.patient.rest.resource.ChiropracticExperienceListResource;
import com.sakk.princess.patient.rest.resource.ChiropracticExperienceResource;
import com.sakk.princess.patient.service.util.ChiropracticExperienceList;

public class ChiropracticExperienceListResourceAssembler
		extends ResourceAssemblerSupport<ChiropracticExperienceList, ChiropracticExperienceListResource> {

	public ChiropracticExperienceListResourceAssembler() {
		super(ChiropracticExperienceController.class, ChiropracticExperienceListResource.class);
	}

	@Override
	public ChiropracticExperienceListResource toResource(ChiropracticExperienceList chiropracticExperienceList) {

		List<ChiropracticExperienceResource> chiropracticExperienceResourceList = new ChiropracticExperienceResourceAssembler()
				.toResources(chiropracticExperienceList.getChiropracticExperienceList());
		ChiropracticExperienceListResource finalChiropracticListResource = new ChiropracticExperienceListResource();
		finalChiropracticListResource.setChiropracticExperinceListResource(chiropracticExperienceResourceList);

		return finalChiropracticListResource;
	}

}
