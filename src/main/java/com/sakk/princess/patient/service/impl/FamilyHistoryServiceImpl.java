package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.FamilyHistoryRepository;
import com.sakk.princess.patient.model.FamilyHistory;
import com.sakk.princess.patient.service.FamilyHistoryService;

@Service
@Transactional
public class FamilyHistoryServiceImpl implements FamilyHistoryService {
	
	static Logger logger = LoggerFactory.getLogger(FamilyHistoryServiceImpl.class);

	@Autowired
	FamilyHistoryRepository familyHistoryRepository;

	@Override
	public List<FamilyHistory> findAllFamilyHistories() {
		return getFamilyHistories();
	}

	@Override
	public FamilyHistory addFamilyHistory(FamilyHistory familyHistory) {
		return familyHistoryRepository.save(familyHistory);
	}

	@Override
	public FamilyHistory getFamilyHistory(Long familyHistoryId) {
		return familyHistoryRepository.getOne(familyHistoryId);
	}

	@Override
	public FamilyHistory updateFamilyHistory(FamilyHistory familyHistory) {

		FamilyHistory familyHistoryToUpdate = familyHistoryRepository.getOne(familyHistory.getId());
		
		if(familyHistoryToUpdate != null){
/*			familyHistoryToUpdate.setArthritis(familyHistory.isArthritis());
			familyHistoryToUpdate.setCancer(familyHistory.isCancer());
			familyHistoryToUpdate.setDiabetes(familyHistory.isDiabetes());
			familyHistoryToUpdate.setFamilyHeartDisease(familyHistory.isFamilyHeartDisease());
			familyHistoryToUpdate.setId(familyHistory.getId());
			familyHistoryToUpdate.setOther(familyHistory.isOther());
			familyHistoryToUpdate.setOtherDescription(familyHistory.getOtherDescription());
			familyHistoryToUpdate.setPatientInfo(familyHistory.getPatientInfo());
			familyHistoryToUpdate.setPsychoSocialDisease(familyHistory.isPsychoSocialDisease());	*/
			
			familyHistoryRepository.saveAndFlush(familyHistory);
		}
		
		return familyHistoryToUpdate;
	}

	@Override
	public FamilyHistory deleteFamilyHistory(Long familyHistoryId) {
		
		FamilyHistory familyHistoryToDelete = familyHistoryRepository.getOne(familyHistoryId);
		
		if(familyHistoryToDelete != null){
			familyHistoryToDelete.setArthritis(familyHistoryToDelete.isArthritis());
			familyHistoryToDelete.setCancer(familyHistoryToDelete.isCancer());
			familyHistoryToDelete.setDiabetes(familyHistoryToDelete.isDiabetes());
			familyHistoryToDelete.setFamilyHeartDisease(familyHistoryToDelete.isFamilyHeartDisease());
			familyHistoryToDelete.setId(familyHistoryToDelete.getId());
			familyHistoryToDelete.setOther(familyHistoryToDelete.isOther());
			familyHistoryToDelete.setOtherDescription(familyHistoryToDelete.getOtherDescription());
			familyHistoryToDelete.setPatient(familyHistoryToDelete.getPatient());
			familyHistoryToDelete.setPsychoSocialDisease(familyHistoryToDelete.isPsychoSocialDisease());		
		}
		
		return familyHistoryToDelete;
	}

	@Override
	public List<FamilyHistory> getFamilyHistories() {
		return familyHistoryRepository.findAll();
	}
	
	@Override
	public List<FamilyHistory> findByPatientNumber(Long patientNumber){
		return familyHistoryRepository.findByPatientPatientNumber(patientNumber);
	}

	@Override
	public List<FamilyHistory> getFamilyHistorySublist(List<Long> familyHistoryIdList) {

		List<FamilyHistory> familyHistoryList = new ArrayList<FamilyHistory>();
		
		for(Long familyHistoryId : familyHistoryIdList){
			familyHistoryList.add(getFamilyHistory(familyHistoryId));
		}
		
		return familyHistoryList;
	}

}
