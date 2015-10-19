package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.HomeAccidentRepository;
import com.sakk.princess.patient.model.HomeAccident;
import com.sakk.princess.patient.service.HomeAccidentService;

@Service
@Transactional
public class HomeAccidentServiceImpl implements HomeAccidentService {
	
	static Logger logger = LoggerFactory.getLogger(ChildhoodTruamaServiceIml.class);

	@Autowired
	HomeAccidentRepository homeAccidentRepository;

	@Override
	public List<HomeAccident> findAllComplaints() {
		return getHomeAccidents();
	}

	@Override
	public HomeAccident addHomeAccident(HomeAccident homeAccident) {
		return homeAccidentRepository.save(homeAccident);
	}

	@Override
	public HomeAccident getHomeAccident(Long homeAccidentId) {
		return homeAccidentRepository.getOne(homeAccidentId);
	}

	@Override
	public HomeAccident updateHomeAccident(HomeAccident homeAccident) {
		
		HomeAccident homeAccidentToUpdate = getHomeAccident(homeAccident.getId());
		
		if(homeAccidentToUpdate != null){
/*			homeAccidentToUpdate.setBriefAccount(homeAccident.getBriefAccount());
			homeAccidentToUpdate.setBodyPartInjured(homeAccident.getBodyPartInjured());
			homeAccidentToUpdate.setCareGivenByDoctor(homeAccident.getCareGivenByDoctor());
			homeAccidentToUpdate.setCareTypeGiven(homeAccident.getCareTypeGiven());
			homeAccidentToUpdate.setHomeAccident(homeAccident.isHomeAccident());
			homeAccidentToUpdate.setHomeAccidentDate(homeAccident.getHomeAccidentDate());
			homeAccidentToUpdate.setId(homeAccident.getId());
			homeAccidentToUpdate.setInjuryResolved(homeAccident.isInjuryResolved());
			homeAccidentToUpdate.setMedicalCareReceived(homeAccident.isMedicalCareReceived());
			homeAccidentToUpdate.setPatientInfo(homeAccident.getPatientInfo());	*/
			
			homeAccidentRepository.saveAndFlush(homeAccident);
		}
		
		
		return homeAccidentToUpdate;
	}

	@Override
	public HomeAccident deleteHomeAccident(Long homeAccidentId) {
		
		HomeAccident homeAccidentToDelete = getHomeAccident(homeAccidentId);
		
		if(homeAccidentToDelete != null){
			homeAccidentRepository.delete(homeAccidentToDelete);
		}
		
		return homeAccidentToDelete;
	}

	@Override
	public List<HomeAccident> getHomeAccidents() {
		return homeAccidentRepository.findAll();
	}
	
	@Override
	public List<HomeAccident> findByPatientNumber(Long patientNumber){
		return homeAccidentRepository.findByPatientPatientNumber(patientNumber);
	}

	@Override
	public List<HomeAccident> getHomeAccidentSublist(List<Long> homeAccidentIdList) {
		
		List<HomeAccident> homeAccidentList = new ArrayList<HomeAccident>();
		
		for(Long homeAccidentId : homeAccidentIdList){
			homeAccidentList.add(getHomeAccident(homeAccidentId));
		}
		
		return homeAccidentList;
	}

}
