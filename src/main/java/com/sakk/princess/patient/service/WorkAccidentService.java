package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.WorkAccident;

public interface WorkAccidentService {
	
	List<WorkAccident> findAllWorkAccident();
	
	public WorkAccident addWorkAccident(WorkAccident workAccident);
	
	public WorkAccident getWorkAccident(Long workAccidentId);
	
	public WorkAccident updateWorkAccident(WorkAccident workAccident);
	
	public WorkAccident deleteWorkAccident(Long workAccidentId);
	
	public List<WorkAccident> getWorkAccidents();
	
	public List<WorkAccident> findByPatientNumber(Long patientNumber);
	
	public List<WorkAccident> getWorkAccidentSublist(List<Long> workAccidentIdList);

}
