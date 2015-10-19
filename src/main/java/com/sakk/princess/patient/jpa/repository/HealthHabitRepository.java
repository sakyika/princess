package com.sakk.princess.patient.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakk.princess.patient.model.HealthHabit;

public interface HealthHabitRepository extends JpaRepository<HealthHabit, Long> {
	
	List<HealthHabit> findByPatientPatientNumber(Long patientNumber);

}
