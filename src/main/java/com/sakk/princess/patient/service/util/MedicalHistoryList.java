package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.MedicalHistory;

public class MedicalHistoryList {
	
	private List<MedicalHistory> medicalHistoryList = new ArrayList<MedicalHistory>();

	public MedicalHistoryList(List<MedicalHistory> medicalHistoryList) {
		this.medicalHistoryList = medicalHistoryList;
	}

	public List<MedicalHistory> getMedicalHistoryList() {
		return medicalHistoryList;
	}

	public void setMedicalHistoryList(List<MedicalHistory> medicalHistoryList) {
		this.medicalHistoryList = medicalHistoryList;
	}

}
