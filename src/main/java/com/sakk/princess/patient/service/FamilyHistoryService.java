package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.FamilyHistory;

public interface FamilyHistoryService {
	
	List<FamilyHistory> findAllFamilyHistories();
	
	public FamilyHistory addFamilyHistory(FamilyHistory familyHistory);
	
	public FamilyHistory getFamilyHistory(Long familyHistoryId);
	
	public FamilyHistory updateFamilyHistory(FamilyHistory familyHistory);
	
	public FamilyHistory deleteFamilyHistory(Long familyHistoryId);
	
	public List<FamilyHistory> getFamilyHistories();
	
	public List<FamilyHistory> findByPatientNumber(Long patientNumber);
	
	public List<FamilyHistory> getFamilyHistorySublist(List<Long> familyHistoryIdList);


}
