package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.FamilyHistoryController;
import com.sakk.princess.patient.rest.resource.FamilyHistoryListResource;
import com.sakk.princess.patient.rest.resource.FamilyHistoryResource;
import com.sakk.princess.patient.service.util.FamilyHistoryList;

public class FamilyHistoryListResourceAssembler
		extends ResourceAssemblerSupport<FamilyHistoryList, FamilyHistoryListResource> {

	public FamilyHistoryListResourceAssembler() {
		super(FamilyHistoryController.class, FamilyHistoryListResource.class);
	}

	@Override
	public FamilyHistoryListResource toResource(FamilyHistoryList familyHistoryList) {

		List<FamilyHistoryResource> familyHistoryResourceList = new FamilyHistoryResourceAssembler()
				.toResources(familyHistoryList.getFamilyHistoryList());
		FamilyHistoryListResource finalFamilyHistoryListResource = new FamilyHistoryListResource();
		finalFamilyHistoryListResource.setFamilyHistoryResource(familyHistoryResourceList);

		return finalFamilyHistoryListResource;
	}

}
