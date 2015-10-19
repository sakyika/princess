package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.Complaint;
import com.sakk.princess.patient.rest.controller.ComplaintController;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.resource.ComplaintResource;
import com.sakk.princess.patient.rest.resource.PatientResource;

public class ComplaintResourceAssembler extends ResourceAssemblerSupport<Complaint, ComplaintResource> {

	public ComplaintResourceAssembler() {
		super(ComplaintController.class, ComplaintResource.class);
	}

	@Override
	public ComplaintResource toResource(Complaint complaint) {

		ComplaintResource complaintResource = new ComplaintResource(complaint);

		complaintResource
				.add(linkTo(methodOn(ComplaintController.class).getComplaint(complaint.getId())).withSelfRel());

		complaintResource.add(linkTo(
				methodOn(PatientController.class).getPatientByPatientNumber(complaint.getPatient().getPatientNumber()))
						.withRel(PatientResource.LINK_NAME_PATIENT));

		return complaintResource;
	}

}
