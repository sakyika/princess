package com.sakk.princess.patient.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.patient.model.ChildhoodTruama;

public interface ChildhoodTruamaRepository extends JpaRepository<ChildhoodTruama, Long> {
	
	List<ChildhoodTruama> findDistinctChildhoodTruamaByPatientPatientNumber(Long patientNumber);

}
