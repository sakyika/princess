package com.sakk.princess.patient.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.patient.model.ChiropracticExperience;

public interface ChiropracticExperienceRepository extends JpaRepository<ChiropracticExperience, Long> {

	List<ChiropracticExperience> findByPatientPatientNumber(Long patientNumber);

}
