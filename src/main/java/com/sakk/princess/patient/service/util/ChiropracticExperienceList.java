package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.ChiropracticExperience;

public class ChiropracticExperienceList {
	
	private List<ChiropracticExperience> chiropracticExperienceList = new ArrayList<ChiropracticExperience>();

	public ChiropracticExperienceList(List<ChiropracticExperience> chiropracticExperienceList) {
		this.chiropracticExperienceList = chiropracticExperienceList;
	}

	public List<ChiropracticExperience> getChiropracticExperienceList() {
		return chiropracticExperienceList;
	}

	public void setChiropracticExperienceList(List<ChiropracticExperience> patientList) {
		this.chiropracticExperienceList = patientList;
	}

}
