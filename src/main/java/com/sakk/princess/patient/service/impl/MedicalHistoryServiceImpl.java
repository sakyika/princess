package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.MedicalHistoryRepository;
import com.sakk.princess.patient.model.MedicalHistory;
import com.sakk.princess.patient.service.MedicalHistoryService;
import com.sakk.princess.patient.service.exception.DuplicateMedicalHistoryException;
import com.sakk.princess.patient.service.exception.PatientNotFoundException;

@Service
@Transactional
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
	
	static Logger logger = LoggerFactory.getLogger(ChildhoodTruamaServiceIml.class);

	@Autowired
	MedicalHistoryRepository medicalHistoryRepository;

	@Override
	public List<MedicalHistory> findAllMedicalHistories() {
		return getMedicalHistories();
	}

	@Override
	public MedicalHistory addMedicalHistory(MedicalHistory medicalHistory) throws DuplicateMedicalHistoryException{
		return medicalHistoryRepository.save(medicalHistory);
	}

	@Override
	public MedicalHistory getMedicalHistory(Long medicalHistoryId) {
		return medicalHistoryRepository.getOne(medicalHistoryId);
	}

	@Override
	public MedicalHistory updateMedicalHistory(MedicalHistory medicalHistory) {

		MedicalHistory medicalHistoryToUpdate = getMedicalHistory(medicalHistory.getId());
		
		if(medicalHistoryToUpdate != null){
/*			medicalHistoryToUpdate.setAneurysm(medicalHistory.isAneurysm());
			medicalHistoryToUpdate.setArthritis(medicalHistory.isArthritis());
			medicalHistoryToUpdate.setBackPain(medicalHistory.isBackPain());
			medicalHistoryToUpdate.setBladderProblems(medicalHistory.isBladderProblems());
			medicalHistoryToUpdate.setBowlProblems(medicalHistory.isBowlProblems());
			medicalHistoryToUpdate.setCancer(medicalHistory.isCancer());
			medicalHistoryToUpdate.setChestPain(medicalHistory.isChestPain());
			medicalHistoryToUpdate.setChiropractorToContactMedicalDoctor(medicalHistory.isChiropractorToContactMedicalDoctor());
			medicalHistoryToUpdate.setDiabetes(medicalHistory.isDiabetes());
			medicalHistoryToUpdate.setDifficultySwallowing(medicalHistory.isDifficultySwallowing());
			medicalHistoryToUpdate.setDigestiveProblems(medicalHistory.isDigestiveProblems());
			medicalHistoryToUpdate.setDizziness(medicalHistory.isDizziness());
			medicalHistoryToUpdate.setEarRinging(medicalHistory.isEarRinging());
			medicalHistoryToUpdate.setFamilyDoctorName(medicalHistory.getFamilyDoctorName());
			medicalHistoryToUpdate.setFamilyDoctorPhone(medicalHistory.getFamilyDoctorPhone());
			medicalHistoryToUpdate.setFamilyDoctoryAddress(medicalHistory.getFamilyDoctoryAddress());
			medicalHistoryToUpdate.setHeadaches(medicalHistory.isHeadaches());
			medicalHistoryToUpdate.setHearing(medicalHistory.isHearing());
			medicalHistoryToUpdate.setHeartContition(medicalHistory.isHeartContition());
			medicalHistoryToUpdate.setHepatitis(medicalHistory.isHepatitis());
			medicalHistoryToUpdate.setHighBloodPressure(medicalHistory.isHighBloodPressure());
			medicalHistoryToUpdate.setHivInfected(medicalHistory.isHivInfected());
			medicalHistoryToUpdate.setId(medicalHistory.getId());
			medicalHistoryToUpdate.setLastFullCheckUp(medicalHistory.getLastFullCheckUp());
			medicalHistoryToUpdate.setLossOfBalance(medicalHistory.isLossOfBalance());
			medicalHistoryToUpdate.setMedicationType1(medicalHistory.getMedicationType1());
			medicalHistoryToUpdate.setMedicationType1Dose(medicalHistory.getMedicationType1Dose());
			medicalHistoryToUpdate.setMedicationType1For(medicalHistory.getMedicationType1For());
			medicalHistoryToUpdate.setMedicationType1Frequency(medicalHistory.getMedicationType1Frequency());
			medicalHistoryToUpdate.setMedicationType2(medicalHistory.getMedicationType2());
			medicalHistoryToUpdate.setMedicationType2Dose(medicalHistory.getMedicationType2Dose());
			medicalHistoryToUpdate.setMedicationType2For(medicalHistory.getMedicationType2For());
			medicalHistoryToUpdate.setMedicationType2Frequency(medicalHistory.getMedicationType2Frequency());
			medicalHistoryToUpdate.setMenstrualProblems(medicalHistory.isMenstrualProblems());
			medicalHistoryToUpdate.setNeckPain(medicalHistory.isNeckPain());
			medicalHistoryToUpdate.setNightSweats(medicalHistory.isNightSweats());
			medicalHistoryToUpdate.setNumblessInLegs(medicalHistory.isNumblessInLegs());
			medicalHistoryToUpdate.setNumbnessInFingers(medicalHistory.isNumbnessInFingers());
			medicalHistoryToUpdate.setOnMedication(medicalHistory.isOnMedication());
			medicalHistoryToUpdate.setOsteoprosis(medicalHistory.isOsteoprosis());
			medicalHistoryToUpdate.setOther(medicalHistory.isOther());
			medicalHistoryToUpdate.setOtherDescription(medicalHistory.getOtherDescription());
			medicalHistoryToUpdate.setPatientInfo(medicalHistory.getPatientInfo());
			medicalHistoryToUpdate.setPinsAndNeedlesInArm(medicalHistory.isPinsAndNeedlesInArm());
			medicalHistoryToUpdate.setPregnancy(medicalHistory.getPregnancy());
			medicalHistoryToUpdate.setProstateDisorder(medicalHistory.isProstateDisorder());
			medicalHistoryToUpdate.setShortnessOfBreath(medicalHistory.isShortnessOfBreath());
			medicalHistoryToUpdate.setSignificantWeightLoss(medicalHistory.isSignificantWeightLoss());
			medicalHistoryToUpdate.setSmell(medicalHistory.isSmell());
			medicalHistoryToUpdate.setStd(medicalHistory.isStd());
			medicalHistoryToUpdate.setStroke(medicalHistory.isStroke());
			medicalHistoryToUpdate.setSurgery1(medicalHistory.getSurgery1());
			medicalHistoryToUpdate.setSurgery1Complications(medicalHistory.isSurgery1Complications());
			medicalHistoryToUpdate.setSurgery1Date(medicalHistory.getSurgery1Date());
			medicalHistoryToUpdate.setSurgery2(medicalHistory.getSurgery2());
			medicalHistoryToUpdate.setSurgery2Complications(medicalHistory.isSurgery2Complications());
			medicalHistoryToUpdate.setSurgery2Date(medicalHistory.getSurgery2Date());
			medicalHistoryToUpdate.setTaste(medicalHistory.isTaste());
			medicalHistoryToUpdate.setTmjDisorder(medicalHistory.isTmjDisorder());
			medicalHistoryToUpdate.setTuberculosis(medicalHistory.isTuberculosis());
			medicalHistoryToUpdate.setVision(medicalHistory.isVision());
			medicalHistoryToUpdate.setWeaknessInFingers(medicalHistory.isWeaknessInFingers());
			medicalHistoryToUpdate.setWeaknessInLegs(medicalHistory.isWeaknessInLegs());	*/
			
			medicalHistoryRepository.saveAndFlush(medicalHistory);
			
		}
		
		return medicalHistoryToUpdate;
		
	}

	@Override
	public MedicalHistory deleteMedicalHistory(Long medicalHistoryId) {

		MedicalHistory medicalHistoryToDelete = getMedicalHistory(medicalHistoryId);
		
		if(medicalHistoryToDelete != null){
			medicalHistoryRepository.delete(medicalHistoryToDelete);
		}else{
			throw new PatientNotFoundException();
		}
		
		return medicalHistoryToDelete;
	}

	@Override
	public List<MedicalHistory> getMedicalHistories() {
		return medicalHistoryRepository.findAll();
	}
	
	@Override
	public List<MedicalHistory> findByPatientNumber(Long patientNumber){
		return medicalHistoryRepository.findByPatientPatientNumber(patientNumber);
	}

	@Override
	public List<MedicalHistory> getMedicalHistorySublist(List<Long> medicalHistoryIdList) {

		List<MedicalHistory> medicalHistoryList = new ArrayList<MedicalHistory>();
		
		for(Long medicalHistoryId : medicalHistoryIdList){
			medicalHistoryList.add(getMedicalHistory(medicalHistoryId));
		}
		
		return medicalHistoryList;
		
	}

}
