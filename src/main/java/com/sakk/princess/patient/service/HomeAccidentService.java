package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.HomeAccident;

public interface HomeAccidentService {
	
	List<HomeAccident> findAllComplaints();
	
	public HomeAccident addHomeAccident(HomeAccident homeAccident);
	
	public HomeAccident getHomeAccident(Long homeAccidentId);
	
	public HomeAccident updateHomeAccident(HomeAccident homeAccident);
	
	public HomeAccident deleteHomeAccident(Long homeAccidentId);
	
	public List<HomeAccident> getHomeAccidents();
	
	public List<HomeAccident> findByPatientNumber(Long patientNumber);
	
	public List<HomeAccident> getHomeAccidentSublist(List<Long> homeAccidentIdList);

}
