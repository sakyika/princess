package com.sakk.princess.patient.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.sakk.princess.patient.model.Patient;

@RepositoryRestController
public interface PatientRepository extends JpaRepository<Patient, Long> {

	public Patient findByPatientNumber(Long patientNumber);

}
