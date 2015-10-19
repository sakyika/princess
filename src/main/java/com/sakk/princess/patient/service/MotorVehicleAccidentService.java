package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.MotorVehicleAccident;

public interface MotorVehicleAccidentService {
	
	List<MotorVehicleAccident> findAllMotorVehicleAccidents();
	
	public MotorVehicleAccident addMotorVehicleAccident(MotorVehicleAccident motorVehicleAccident);
	
	public MotorVehicleAccident getMotorVehicleAccident(Long motorVehicleAccidentId);
	
	public MotorVehicleAccident updateMotorVehicleAccident(MotorVehicleAccident motorVehicleAccident);
	
	public MotorVehicleAccident deleteMotorVehicleAccident(Long motorVehicleAccidentId);
	
	public List<MotorVehicleAccident> getMotorVehicleAccidents();
	
	public List<MotorVehicleAccident> findByPatientNumber(Long patientNumber);
	
	public List<MotorVehicleAccident> getMotorVehicleAccidentSublist(List<Long> motorVehicleAccidentIdList);

}
