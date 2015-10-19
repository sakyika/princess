package com.sakk.princess.patient.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.patient.model.SportsAccident;

public interface SportsAccidentRepository extends JpaRepository<SportsAccident, Long> {
	
	List<SportsAccident> findByPatientPatientNumber(Long patientNumber);

}
