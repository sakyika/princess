package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.MotorVehicleAccident;

public class MotorVehicleAccidentList {
	
	private List<MotorVehicleAccident> motorVehicleAccidentList = new ArrayList<MotorVehicleAccident>();

	public MotorVehicleAccidentList(List<MotorVehicleAccident> motorVehicleAccidentList) {
		this.motorVehicleAccidentList = motorVehicleAccidentList;
	}

	public List<MotorVehicleAccident> getMotorVehicleAccidentList() {
		return motorVehicleAccidentList;
	}

	public void setMotorVehicleAccidentList(List<MotorVehicleAccident> motorVehicleAccidentList) {
		this.motorVehicleAccidentList = motorVehicleAccidentList;
	}

}
