package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.FamilyHistory;

public class FamilyHistoryList {
	
	private List<FamilyHistory> familyHistoryList = new ArrayList<FamilyHistory>();

	public FamilyHistoryList(List<FamilyHistory> chiropracticExperienceList) {
		this.familyHistoryList = chiropracticExperienceList;
	}

	public List<FamilyHistory> getFamilyHistoryList() {
		return familyHistoryList;
	}

	public void setFamilyHistoryList(List<FamilyHistory> familyHistoryList) {
		this.familyHistoryList = familyHistoryList;
	}

}
