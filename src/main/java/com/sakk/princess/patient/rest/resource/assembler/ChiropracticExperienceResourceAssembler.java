package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.ChiropracticExperience;
import com.sakk.princess.patient.rest.controller.ChiropracticExperienceController;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.resource.ChiropracticExperienceResource;
import com.sakk.princess.patient.rest.resource.PatientResource;

public class ChiropracticExperienceResourceAssembler
		extends ResourceAssemblerSupport<ChiropracticExperience, ChiropracticExperienceResource> {

	public ChiropracticExperienceResourceAssembler() {
		super(ChiropracticExperienceController.class, ChiropracticExperienceResource.class);
	}

	@Override
	public ChiropracticExperienceResource toResource(ChiropracticExperience chiropracticExperience) {

		ChiropracticExperienceResource chiropracticExperienceResource = new ChiropracticExperienceResource(
				chiropracticExperience);

		chiropracticExperienceResource.add(linkTo(methodOn(ChiropracticExperienceController.class)
				.getChiropracticExperience(chiropracticExperience.getId())).withSelfRel());

		chiropracticExperienceResource.add(linkTo(methodOn(PatientController.class)
				.getPatientByPatientNumber(chiropracticExperience.getPatient().getPatientNumber()))
						.withRel(PatientResource.LINK_NAME_PATIENT));

		return chiropracticExperienceResource;

	}

}
