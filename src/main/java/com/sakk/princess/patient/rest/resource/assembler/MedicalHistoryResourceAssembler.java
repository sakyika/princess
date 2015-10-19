package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.MedicalHistory;
import com.sakk.princess.patient.rest.controller.MedicalHistoryController;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.resource.MedicalHistoryResource;
import com.sakk.princess.patient.rest.resource.PatientResource;

public class MedicalHistoryResourceAssembler extends ResourceAssemblerSupport<MedicalHistory, MedicalHistoryResource> {

	public MedicalHistoryResourceAssembler() {
		super(MedicalHistoryController.class, MedicalHistoryResource.class);
	}

	@Override
	public MedicalHistoryResource toResource(MedicalHistory medicalHistory) {

		MedicalHistoryResource medicalHistoryResource = new MedicalHistoryResource(medicalHistory);

		medicalHistoryResource
				.add(linkTo(methodOn(MedicalHistoryController.class).getMedicalHistory(medicalHistory.getId()))
						.withSelfRel());

		medicalHistoryResource.add(linkTo(methodOn(PatientController.class)
				.getPatientByPatientNumber(medicalHistory.getPatient().getPatientNumber()))
						.withRel(PatientResource.LINK_NAME_PATIENT));

		return medicalHistoryResource;
	}

}
