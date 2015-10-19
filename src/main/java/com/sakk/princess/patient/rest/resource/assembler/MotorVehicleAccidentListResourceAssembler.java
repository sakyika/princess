package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.MotorVehicleAccidentController;
import com.sakk.princess.patient.rest.resource.MotorVehicleAccidentListResource;
import com.sakk.princess.patient.rest.resource.MotorVehicleAccidentResource;
import com.sakk.princess.patient.service.util.MotorVehicleAccidentList;

public class MotorVehicleAccidentListResourceAssembler
		extends ResourceAssemblerSupport<MotorVehicleAccidentList, MotorVehicleAccidentListResource> {

	public MotorVehicleAccidentListResourceAssembler() {
		super(MotorVehicleAccidentController.class, MotorVehicleAccidentListResource.class);
	}

	@Override
	public MotorVehicleAccidentListResource toResource(MotorVehicleAccidentList motorVehicleAccidentList) {
		
		List<MotorVehicleAccidentResource> motorVehicleAccidentResourceList = new MotorVehicleAccidentResourceAssembler()
				.toResources(motorVehicleAccidentList.getMotorVehicleAccidentList());
		
		MotorVehicleAccidentListResource finalMotorVehicleAccidentListResource = new MotorVehicleAccidentListResource();
		finalMotorVehicleAccidentListResource.setMotorVehicleAccidentListResource(motorVehicleAccidentResourceList);
		
		return finalMotorVehicleAccidentListResource;
	}

}
