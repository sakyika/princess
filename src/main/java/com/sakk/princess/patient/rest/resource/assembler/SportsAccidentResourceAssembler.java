package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.SportsAccident;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.controller.SportsAccidentController;
import com.sakk.princess.patient.rest.resource.PatientResource;
import com.sakk.princess.patient.rest.resource.SportsAccidentResource;

public class SportsAccidentResourceAssembler extends ResourceAssemblerSupport<SportsAccident, SportsAccidentResource> {

	public SportsAccidentResourceAssembler() {
		super(SportsAccidentController.class, SportsAccidentResource.class);
	}

	@Override
	public SportsAccidentResource toResource(SportsAccident sportsAccident) {

		SportsAccidentResource sportsAccidentResource = new SportsAccidentResource(sportsAccident);

		sportsAccidentResource
				.add(linkTo(methodOn(SportsAccidentController.class).getSportsAccident(sportsAccident.getId()))
						.withSelfRel());

		sportsAccidentResource.add(linkTo(methodOn(PatientController.class)
				.getPatientByPatientNumber(sportsAccident.getPatient().getPatientNumber()))
						.withRel(PatientResource.LINK_NAME_PATIENT));

		return sportsAccidentResource;
	}

}
