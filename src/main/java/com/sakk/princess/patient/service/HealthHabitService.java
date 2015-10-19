package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.HealthHabit;

public interface HealthHabitService {
	
	List<HealthHabit> findAllChildhoodTruama();
	
	public HealthHabit addHealthHabit(HealthHabit healthHabit);
	
	public HealthHabit getHealthHabit(Long healthHabitId);
	
	public HealthHabit updateHealthHabit(HealthHabit healthHabit);
	
	public HealthHabit deleteHealthHabit(Long healthHabitId);
	
	public List<HealthHabit> getHealthHabits();
	
	public List<HealthHabit> findByPatientNumber(Long patientNumber);
	
	public List<HealthHabit> getHealthHabitSublist(List<Long> healthHabitIdList);


}
