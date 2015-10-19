package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.ChildhoodTruama;
import com.sakk.princess.patient.rest.controller.ChildhoodTruamaController;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.resource.ChildhoodTruamaResource;
import com.sakk.princess.patient.rest.resource.PatientResource;
import com.sakk.princess.patient.service.ChildhoodTruamaService;

public class ChildhoodTruamaResourceAssembler
		extends ResourceAssemblerSupport<ChildhoodTruama, ChildhoodTruamaResource> {

	public ChildhoodTruamaResourceAssembler() {
		super(ChildhoodTruamaController.class, ChildhoodTruamaResource.class);
	}

	@Autowired
	ChildhoodTruamaService childhoodTruamaService;

	@Override
	public ChildhoodTruamaResource toResource(ChildhoodTruama childhoodTruama) {

		ChildhoodTruamaResource childhoodTruamaResource = new ChildhoodTruamaResource(childhoodTruama);

		childhoodTruamaResource
				.add(linkTo(methodOn(ChildhoodTruamaController.class).getChildhoodTruama(childhoodTruama.getId()))
						.withSelfRel());

		childhoodTruamaResource.add(linkTo(PatientController.class).slash(childhoodTruama.getPatient().getPatientNumber())
				.withRel(PatientResource.LINK_NAME_PATIENT));

		return childhoodTruamaResource;

	}

}
