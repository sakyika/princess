package com.sakk.princess.patient.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.patient.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
	
	List<Complaint> findByPatientPatientNumber(Long patientNumber);

}
