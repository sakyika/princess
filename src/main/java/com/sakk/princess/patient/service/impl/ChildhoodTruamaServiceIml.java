package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.ChildhoodTruamaRepository;
import com.sakk.princess.patient.model.ChildhoodTruama;
import com.sakk.princess.patient.service.ChildhoodTruamaService;
import com.sakk.princess.patient.service.exception.PatientNotFoundException;

@Service
@Transactional
public class ChildhoodTruamaServiceIml implements ChildhoodTruamaService {
	
	static Logger logger = LoggerFactory.getLogger(ChildhoodTruamaServiceIml.class);

	@Autowired
	ChildhoodTruamaRepository childhoodTruamaRepository;
			
	@Override
	public List<ChildhoodTruama> findAllChildhoodTruamas() {
		return getChildhoodTruamas();
	}

	@Override
	public ChildhoodTruama addChildhoodTruama(ChildhoodTruama childhoodTruama) {
		return childhoodTruamaRepository.saveAndFlush(childhoodTruama);
	}

	@Override
	public ChildhoodTruama getChildhoodTruama(Long childhoodTruamaId) {
		return childhoodTruamaRepository.findOne(childhoodTruamaId);
	}

	@Override
	public ChildhoodTruama updateChildhoodTruama(ChildhoodTruama childhoodTruama) {
		
		ChildhoodTruama childhoodTruamaToUpdate = getChildhoodTruama(childhoodTruama.getId());
		
		if(childhoodTruamaToUpdate != null){
/*			childhoodTruamaToUpdate.setBodyPartInjured(childhoodTruama.getBodyPartInjured());
			childhoodTruamaToUpdate.setBriefAccountOfAccident(childhoodTruama.getBriefAccountOfAccident());
			childhoodTruamaToUpdate.setCareGivenBy(childhoodTruama.getCareGivenBy());
			childhoodTruamaToUpdate.setCareTypeGiven(childhoodTruama.getCareTypeGiven());
			childhoodTruamaToUpdate.setChildhoodTruama(childhoodTruama.isChildhoodTruama());
			childhoodTruamaToUpdate.setChildhoodTruamaDate(childhoodTruama.getChildhoodTruamaDate());
			childhoodTruamaToUpdate.setId(childhoodTruama.getId());
			childhoodTruamaToUpdate.setInjuryResolved(childhoodTruama.isInjuryResolved());
			childhoodTruamaToUpdate.setMedicalCareReceived(childhoodTruama.isMedicalCareReceived());
			childhoodTruamaToUpdate.setPatientInfo(childhoodTruama.getPatientInfo()); 
*/			
			childhoodTruamaRepository.saveAndFlush(childhoodTruama);
		}
		
		return childhoodTruamaToUpdate;
	}

	@Override
	public ChildhoodTruama deleteChildhoodTruama(Long childhoodTruamaId) {

		ChildhoodTruama childhoodTruamaToDelete = getChildhoodTruama(childhoodTruamaId);
		
		if(childhoodTruamaToDelete != null){
			childhoodTruamaRepository.delete(childhoodTruamaToDelete);
		}else{
			throw new PatientNotFoundException();
		}
		
		return childhoodTruamaToDelete;
	}

	@Override
	public List<ChildhoodTruama> getChildhoodTruamas() {
		return childhoodTruamaRepository.findAll();
	}
	
	@Override
	public List<ChildhoodTruama> findByPatientNumber(Long patientNumber){
		return childhoodTruamaRepository.findDistinctChildhoodTruamaByPatientPatientNumber(patientNumber);
	}

	@Override
	public List<ChildhoodTruama> getChildhoodTruamaSublist(List<Long> childhoodTruamaIdList) {
		List<ChildhoodTruama> childhoodTruamaList = new ArrayList<ChildhoodTruama>();
		
		for(Long childhoodTruamaId : childhoodTruamaIdList){
			childhoodTruamaList.add(getChildhoodTruama(childhoodTruamaId));
		}
		
		return childhoodTruamaList;
	}

}
