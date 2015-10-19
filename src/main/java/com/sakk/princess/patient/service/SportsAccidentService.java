package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.SportsAccident;

public interface SportsAccidentService {
	
	List<SportsAccident> findAllSportsAccidents();
	
	public SportsAccident addSportsAccident(SportsAccident sportsAccident);
	
	public SportsAccident getSportsAccident(Long sportsAccidentId);
	
	public SportsAccident updateSportsAccident(SportsAccident sportsAccident);
	
	public SportsAccident deleteSportsAccident(Long sportsAccidentId);
	
	public List<SportsAccident> getSportsAccidents();
	
	public List<SportsAccident> findByPatientNumber(Long patientNumber);
	
	public List<SportsAccident> getSportsAccidentSublist(List<Long> sportsAccidentIdList);

}
