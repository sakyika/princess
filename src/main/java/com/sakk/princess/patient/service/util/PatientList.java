package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.Patient;

public class PatientList {
	
	private List<Patient> patientList = new ArrayList<Patient>();

	public PatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

}
