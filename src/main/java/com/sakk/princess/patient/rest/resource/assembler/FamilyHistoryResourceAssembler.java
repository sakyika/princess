package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.FamilyHistory;
import com.sakk.princess.patient.rest.controller.FamilyHistoryController;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.resource.FamilyHistoryResource;
import com.sakk.princess.patient.rest.resource.PatientResource;

public class FamilyHistoryResourceAssembler extends ResourceAssemblerSupport<FamilyHistory, FamilyHistoryResource> {

	public FamilyHistoryResourceAssembler() {
		super(FamilyHistoryController.class, FamilyHistoryResource.class);
	}

	@Override
	public FamilyHistoryResource toResource(FamilyHistory familyHistory) {

		FamilyHistoryResource familyHistoryResource = new FamilyHistoryResource(familyHistory);

		familyHistoryResource.add(
				linkTo(methodOn(FamilyHistoryController.class).getFamilyHistory(familyHistory.getId())).withSelfRel());

		familyHistoryResource.add(linkTo(methodOn(PatientController.class)
				.getPatientByPatientNumber(familyHistory.getPatient().getPatientNumber()))
						.withRel(PatientResource.LINK_NAME_PATIENT));

		return familyHistoryResource;
	}

}
