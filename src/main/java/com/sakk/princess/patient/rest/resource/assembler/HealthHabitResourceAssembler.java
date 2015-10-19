package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.HealthHabit;
import com.sakk.princess.patient.rest.controller.HealthHabitController;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.resource.HealthHabitResource;
import com.sakk.princess.patient.rest.resource.PatientResource;

public class HealthHabitResourceAssembler extends ResourceAssemblerSupport<HealthHabit, HealthHabitResource> {

	public HealthHabitResourceAssembler() {
		super(HealthHabitController.class, HealthHabitResource.class);
	}

	@Override
	public HealthHabitResource toResource(HealthHabit healthHabit) {

		HealthHabitResource healthHabitResource = new HealthHabitResource(healthHabit);

		healthHabitResource
				.add(linkTo(methodOn(HealthHabitController.class).getHealthHabit(healthHabit.getId())).withSelfRel());

		healthHabitResource.add(linkTo(methodOn(PatientController.class)
				.getPatientByPatientNumber(healthHabit.getPatient().getPatientNumber()))
						.withRel(PatientResource.LINK_NAME_PATIENT));

		return healthHabitResource;
	}

}
