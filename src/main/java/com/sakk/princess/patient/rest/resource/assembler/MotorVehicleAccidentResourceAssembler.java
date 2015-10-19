package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.MotorVehicleAccident;
import com.sakk.princess.patient.rest.controller.MotorVehicleAccidentController;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.resource.MotorVehicleAccidentResource;
import com.sakk.princess.patient.rest.resource.PatientResource;

public class MotorVehicleAccidentResourceAssembler
		extends ResourceAssemblerSupport<MotorVehicleAccident, MotorVehicleAccidentResource> {

	public MotorVehicleAccidentResourceAssembler() {
		super(MotorVehicleAccidentController.class, MotorVehicleAccidentResource.class);
	}

	@Override
	public MotorVehicleAccidentResource toResource(MotorVehicleAccident motorVehicleAccident) {

		MotorVehicleAccidentResource motorVehicleAccidentResource = new MotorVehicleAccidentResource(
				motorVehicleAccident);

		motorVehicleAccidentResource.add(linkTo(
				methodOn(MotorVehicleAccidentController.class).getMotorVehicleAccident(motorVehicleAccident.getId()))
						.withSelfRel());

		motorVehicleAccidentResource.add(linkTo(methodOn(PatientController.class)
				.getPatientByPatientNumber(motorVehicleAccident.getPatient().getPatientNumber()))
						.withRel(PatientResource.LINK_NAME_PATIENT));

		return motorVehicleAccidentResource;
	}

}
