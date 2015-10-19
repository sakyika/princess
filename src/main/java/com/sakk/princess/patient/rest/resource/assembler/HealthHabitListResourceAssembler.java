package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.HealthHabitController;
import com.sakk.princess.patient.rest.resource.HealthHabitListResource;
import com.sakk.princess.patient.rest.resource.HealthHabitResource;
import com.sakk.princess.patient.service.util.HealthHabitList;

public class HealthHabitListResourceAssembler
		extends ResourceAssemblerSupport<HealthHabitList, HealthHabitListResource> {

	public HealthHabitListResourceAssembler() {
		super(HealthHabitController.class, HealthHabitListResource.class);
	}

	@Override
	public HealthHabitListResource toResource(HealthHabitList healthHabit) {

		List<HealthHabitResource> healthHabitResourceList = new HealthHabitResourceAssembler()
				.toResources(healthHabit.getHealthHabitList());

		HealthHabitListResource finalHealthHabitListResource = new HealthHabitListResource();
		finalHealthHabitListResource.setHealthHabitResource(healthHabitResourceList);

		return finalHealthHabitListResource;
	}

}
