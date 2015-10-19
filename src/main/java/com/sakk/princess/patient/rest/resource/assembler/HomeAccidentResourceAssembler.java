package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.HomeAccident;
import com.sakk.princess.patient.rest.controller.HomeAccidentController;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.resource.HomeAccidentResource;
import com.sakk.princess.patient.rest.resource.PatientResource;

public class HomeAccidentResourceAssembler extends ResourceAssemblerSupport<HomeAccident, HomeAccidentResource> {

	public HomeAccidentResourceAssembler() {
		super(HomeAccidentController.class, HomeAccidentResource.class);
	}

	@Override
	public HomeAccidentResource toResource(HomeAccident homeAccident) {

		HomeAccidentResource homeAccidentResource = new HomeAccidentResource(homeAccident);

		homeAccidentResource.add(
				linkTo(methodOn(HomeAccidentController.class).getHomeAccident(homeAccident.getId())).withSelfRel());

		homeAccidentResource.add(linkTo(methodOn(PatientController.class)
				.getPatientByPatientNumber(homeAccident.getPatient().getPatientNumber()))
						.withRel(PatientResource.LINK_NAME_PATIENT));

		return homeAccidentResource;
	}

}
