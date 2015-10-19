package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class HealthHabitListResource extends ResourceSupport {
	
	private List<HealthHabitResource> healthHabitResourceList = new ArrayList<HealthHabitResource>();

	public List<HealthHabitResource> getHealthHabitResource() {
		return healthHabitResourceList;
	}

	public void setHealthHabitResource(List<HealthHabitResource> healthHabitResourceList) {
		this.healthHabitResourceList = healthHabitResourceList;
	}

}
