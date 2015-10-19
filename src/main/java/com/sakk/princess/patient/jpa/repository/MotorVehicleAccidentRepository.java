package com.sakk.princess.patient.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.patient.model.MotorVehicleAccident;

public interface MotorVehicleAccidentRepository extends JpaRepository<MotorVehicleAccident, Long> {
	
	List<MotorVehicleAccident> findByPatientPatientNumber(Long patientNumber);
}
