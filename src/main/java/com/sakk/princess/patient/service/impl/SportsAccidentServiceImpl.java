package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.SportsAccidentRepository;
import com.sakk.princess.patient.model.SportsAccident;
import com.sakk.princess.patient.service.SportsAccidentService;
import com.sakk.princess.patient.service.exception.PatientNotFoundException;

@Service
@Transactional
public class SportsAccidentServiceImpl implements SportsAccidentService {
	
	static Logger logger = LoggerFactory.getLogger(SportsAccidentServiceImpl.class);

	@Autowired
	SportsAccidentRepository sportsAccidentRepository;


	@Override
	public List<SportsAccident> findAllSportsAccidents() {
		return getSportsAccidents();
	}

	@Override
	public SportsAccident addSportsAccident(SportsAccident sportsAccident) {
		return sportsAccidentRepository.save(sportsAccident);
	}

	@Override
	public SportsAccident getSportsAccident(Long sportsAccidentId) {
		return sportsAccidentRepository.getOne(sportsAccidentId);
	}

	@Override
	public SportsAccident updateSportsAccident(SportsAccident sportsAccident) {

		SportsAccident sportsAccidentToUpdate = getSportsAccident(sportsAccident.getId());
		
		if(sportsAccidentToUpdate != null){
/*			sportsAccidentToUpdate.setAccidentBriefAccount(sportsAccident.getAccidentBriefAccount());
			sportsAccidentToUpdate.setBodyPartInjured(sportsAccident.getBodyPartInjured());
			sportsAccidentToUpdate.setCareGivenBy(sportsAccident.getCareTypeGiven());
			sportsAccidentToUpdate.setId(sportsAccident.getId());
			sportsAccidentToUpdate.setInjuryResolved(sportsAccident.isInjuryResolved());
			sportsAccidentToUpdate.setMedicalCareReceived(sportsAccident.isMedicalCareReceived());
			sportsAccidentToUpdate.setPatientInfo(sportsAccident.getPatientInfo());
			sportsAccidentToUpdate.setSportsAccident(sportsAccident.isSportsAccident());
			sportsAccidentToUpdate.setSportsAccidentDate(sportsAccident.getSportsAccidentDate());	*/
			
			sportsAccidentRepository.saveAndFlush(sportsAccident);
			
		}
		
		return sportsAccidentToUpdate;
	}

	@Override
	public SportsAccident deleteSportsAccident(Long sportsAccidentId) {

		SportsAccident sportsAccidentToDelete = getSportsAccident(sportsAccidentId);
		
		if(sportsAccidentToDelete != null){
			sportsAccidentRepository.delete(sportsAccidentToDelete);
		}else{
			throw new PatientNotFoundException();
		}
		
		return sportsAccidentToDelete;
	}

	@Override
	public List<SportsAccident> getSportsAccidents() {
		return sportsAccidentRepository.findAll();
	}
	

	@Override
	public List<SportsAccident> getSportsAccidentSublist(List<Long> sportsAccidentIdList) {

		List<SportsAccident> sportsAccidentList = new ArrayList<SportsAccident>();
		
		for(Long childhoodTruamaId : sportsAccidentIdList){
			sportsAccidentList.add(getSportsAccident(childhoodTruamaId));
		}
		
		return sportsAccidentList;
	}
	
	@Override
	public List<SportsAccident> findByPatientNumber(Long patientNumber){
		return sportsAccidentRepository.findByPatientPatientNumber(patientNumber);
	}

}
