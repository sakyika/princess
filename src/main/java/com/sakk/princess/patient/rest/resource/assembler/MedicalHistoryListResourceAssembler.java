package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.MedicalHistoryController;
import com.sakk.princess.patient.rest.resource.MedicalHistoryListResource;
import com.sakk.princess.patient.rest.resource.MedicalHistoryResource;
import com.sakk.princess.patient.service.util.MedicalHistoryList;

public class MedicalHistoryListResourceAssembler
		extends ResourceAssemblerSupport<MedicalHistoryList, MedicalHistoryListResource> {

	public MedicalHistoryListResourceAssembler() {
		super(MedicalHistoryController.class, MedicalHistoryListResource.class);
	}

	@Override
	public MedicalHistoryListResource toResource(MedicalHistoryList medicalHistoryList) {

		List<MedicalHistoryResource> medicalHistoryResourceList = new MedicalHistoryResourceAssembler()
				.toResources(medicalHistoryList.getMedicalHistoryList());

		MedicalHistoryListResource finalMedicalHistoryListResource = new MedicalHistoryListResource();
		finalMedicalHistoryListResource.setMedicalHistoryListResource(medicalHistoryResourceList);

		return finalMedicalHistoryListResource;
	}

}
