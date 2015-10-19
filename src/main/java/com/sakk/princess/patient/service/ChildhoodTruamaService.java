package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.ChildhoodTruama;

public interface ChildhoodTruamaService {
	
	List<ChildhoodTruama> findAllChildhoodTruamas();
	
	public ChildhoodTruama addChildhoodTruama(ChildhoodTruama childhoodTruama);
	
	public ChildhoodTruama getChildhoodTruama(Long childhoodTruamaId);
	
	public ChildhoodTruama updateChildhoodTruama(ChildhoodTruama childhoodTruama);
	
	public ChildhoodTruama deleteChildhoodTruama(Long childhoodTruamaId);
	
	public List<ChildhoodTruama> getChildhoodTruamas();
	
	public List<ChildhoodTruama> findByPatientNumber(Long patientNumber);
	
	public List<ChildhoodTruama> getChildhoodTruamaSublist(List<Long> childhoodTruamaIdList);

}
