package com.sakk.princess.patient.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.patient.model.HomeAccident;

public interface HomeAccidentRepository extends JpaRepository<HomeAccident, Long> {
	
	List<HomeAccident> findByPatientPatientNumber(Long patientNUmber);

}
