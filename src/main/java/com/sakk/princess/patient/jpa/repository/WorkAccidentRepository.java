package com.sakk.princess.patient.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.patient.model.WorkAccident;

public interface WorkAccidentRepository extends JpaRepository<WorkAccident, Long> {
	
	List<WorkAccident> findByPatientPatientNumber(Long patientNumber);

}
