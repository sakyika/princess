package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.MedicalHistory;

public interface MedicalHistoryService {
	
	List<MedicalHistory> findAllMedicalHistories();
	
	public MedicalHistory addMedicalHistory(MedicalHistory medicalHistory);
	
	public MedicalHistory getMedicalHistory(Long medicalHistoryId);
	
	public MedicalHistory updateMedicalHistory(MedicalHistory medicalHistory);
	
	public MedicalHistory deleteMedicalHistory(Long medicalHistoryId);
	
	public List<MedicalHistory> getMedicalHistories();
	
	public List<MedicalHistory> findByPatientNumber(Long patientNumber);
	
	public List<MedicalHistory> getMedicalHistorySublist(List<Long> medicalHistoryIdList);

}
