package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.MotorVehicleAccident;

public class MotorVehicleAccidentResource extends Resource<MotorVehicleAccident> {

	MotorVehicleAccidentResource() {
		super(new MotorVehicleAccident());
	}

	public MotorVehicleAccidentResource(MotorVehicleAccident motorVehicleAccident) {
		super(motorVehicleAccident);
	}

	public MotorVehicleAccident toMotorVehicleAccident(){
		
		MotorVehicleAccident motorVehicleAccident = new MotorVehicleAccident();
		
		motorVehicleAccident.setCareGivenByDoctor(super.getContent().getCareGivenByDoctor());
		motorVehicleAccident.setCareGivenType(super.getContent().getCareGivenType());
		motorVehicleAccident.setAccidentDate(super.getContent().getAccidentDate());
		motorVehicleAccident.setDriverOrPassenger(super.getContent().getDriverOrPassenger());
		motorVehicleAccident.setId(super.getContent().getId());
		motorVehicleAccident.setInjuriesResolved(super.getContent().isInjuriesResolved());
		motorVehicleAccident.setInjuriesSustained(super.getContent().getInjuriesSustained());
		motorVehicleAccident.setLossConsciousness(super.getContent().isLossConsciousness());
		motorVehicleAccident.setMedicationGiven(super.getContent().isMedicationGiven());
		motorVehicleAccident.setMotorVehicleAccident(super.getContent().isMotorVehicleAccident());
		motorVehicleAccident.setPatient(super.getContent().getPatient());
		motorVehicleAccident.setSentToHospital(super.getContent().isSentToHospital());
		motorVehicleAccident.setStrikeHead(super.getContent().isStrikeHead());
		motorVehicleAccident.setVehicleCollisionPart(super.getContent().getVehicleCollisionPart());
		motorVehicleAccident.setWearingSeatBelt(super.getContent().isWearingSeatBelt());
		motorVehicleAccident.setXrayTaken(super.getContent().isXrayTaken());
		
		return motorVehicleAccident;
		
	}
	
}
