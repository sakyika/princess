package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.WorkAccident;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.controller.WorkAccidentController;
import com.sakk.princess.patient.rest.resource.PatientResource;
import com.sakk.princess.patient.rest.resource.WorkAccidentResource;

public class WorkAccidentResourceAssembler extends ResourceAssemblerSupport<WorkAccident, WorkAccidentResource> {

	public WorkAccidentResourceAssembler() {
		super(WorkAccidentController.class, WorkAccidentResource.class);
	}

	@Override
	public WorkAccidentResource toResource(WorkAccident workAccident) {

		WorkAccidentResource workAccidentResource = new WorkAccidentResource(workAccident);

		workAccidentResource.add(
				linkTo(methodOn(WorkAccidentController.class).getWorkAccident(workAccident.getId())).withSelfRel());

		workAccidentResource.add(linkTo(methodOn(PatientController.class)
				.getPatientByPatientNumber(workAccident.getPatient().getPatientNumber()))
						.withRel(PatientResource.LINK_NAME_PATIENT));

		return workAccidentResource;
	}

}
