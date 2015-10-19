package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;


public class MotorVehicleAccidentListResource extends ResourceSupport {
	
	private List<MotorVehicleAccidentResource> motorVehicleAccidentResourceList = new ArrayList<MotorVehicleAccidentResource>();

	public List<MotorVehicleAccidentResource> getMotorVehicleAccidentListResource() {
		return motorVehicleAccidentResourceList;
	}

	public void setMotorVehicleAccidentListResource(List<MotorVehicleAccidentResource> motorVehicleAccidentResourceList) {
		this.motorVehicleAccidentResourceList = motorVehicleAccidentResourceList;
	}

}
