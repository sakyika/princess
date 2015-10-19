package com.sakk.princess.patient.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.patient.model.FamilyHistory;

public interface FamilyHistoryRepository extends JpaRepository<FamilyHistory, Long> {
	
	List<FamilyHistory> findByPatientPatientNumber(Long patientNumber);

}
