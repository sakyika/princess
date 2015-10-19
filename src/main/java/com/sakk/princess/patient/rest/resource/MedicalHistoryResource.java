package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.MedicalHistory;

public class MedicalHistoryResource extends Resource<MedicalHistory> {

	MedicalHistoryResource() {
		super(new MedicalHistory());
	}

	public MedicalHistoryResource(MedicalHistory medicalHistory) {
		super(medicalHistory);
	}
	
	public MedicalHistory toMedicalHistory(){
		
		MedicalHistory medicalHistory = new MedicalHistory();
		
		medicalHistory.setAneurysm(super.getContent().isAneurysm());
		medicalHistory.setArthritis(super.getContent().isArthritis());
		medicalHistory.setBackPain(super.getContent().isBackPain());
		medicalHistory.setBladderProblems(super.getContent().isBladderProblems());
		medicalHistory.setBowlProblems(super.getContent().isBowlProblems());
		medicalHistory.setCancer(super.getContent().isCancer());
		medicalHistory.setChestPain(super.getContent().isChestPain());
		medicalHistory.setChiropractorToContactMedicalDoctor(super.getContent().isChiropractorToContactMedicalDoctor());
		medicalHistory.setDiabetes(super.getContent().isDiabetes());
		medicalHistory.setDifficultySwallowing(super.getContent().isDifficultySwallowing());
		medicalHistory.setDigestiveProblems(super.getContent().isDigestiveProblems());
		medicalHistory.setDizziness(super.getContent().isDizziness());
		medicalHistory.setEarRinging(super.getContent().isEarRinging());
		medicalHistory.setFamilyDoctorName(super.getContent().getFamilyDoctorName());
		medicalHistory.setFamilyDoctorPhone(super.getContent().getFamilyDoctorPhone());
		medicalHistory.setFamilyDoctoryAddress(super.getContent().getFamilyDoctoryAddress());
		medicalHistory.setHeadaches(super.getContent().isHeadaches());
		medicalHistory.setHearing(super.getContent().isHearing());
		medicalHistory.setHeartContition(super.getContent().isHeartContition());
		medicalHistory.setHepatitis(super.getContent().isHepatitis());
		medicalHistory.setHighBloodPressure(super.getContent().isHighBloodPressure());
		medicalHistory.setHivInfected(super.getContent().isHivInfected());
		medicalHistory.setId(super.getContent().getId());
		medicalHistory.setLastFullCheckUp(super.getContent().getLastFullCheckUp());
		medicalHistory.setLastMenstrualPeriod(super.getContent().getLastMenstrualPeriod());
		medicalHistory.setLossOfBalance(super.getContent().isLossOfBalance());
		medicalHistory.setMedicationType1(super.getContent().getMedicationType1());
		medicalHistory.setMedicationType1Dose(super.getContent().getMedicationType1Dose());
		medicalHistory.setMedicationType1For(super.getContent().getMedicationType1For());
		medicalHistory.setMedicationType1Frequency(super.getContent().getMedicationType1Frequency());
		medicalHistory.setMedicationType2(super.getContent().getMedicationType2());
		medicalHistory.setMedicationType2Dose(super.getContent().getMedicationType2Dose());
		medicalHistory.setMedicationType2For(super.getContent().getMedicationType2For());
		medicalHistory.setMedicationType2Frequency(super.getContent().getMedicationType2Frequency());
		medicalHistory.setMenstrualProblems(super.getContent().isMenstrualProblems());
		medicalHistory.setNeckPain(super.getContent().isNeckPain());
		medicalHistory.setNightSweats(super.getContent().isNightSweats());
		medicalHistory.setNumblessInLegs(super.getContent().isNumblessInLegs());
		medicalHistory.setNumbnessInFingers(super.getContent().isNumbnessInFingers());
		medicalHistory.setOnMedication(super.getContent().isOnMedication());
		medicalHistory.setOsteoprosis(super.getContent().isOsteoprosis());
		medicalHistory.setOther(super.getContent().isOther());
		medicalHistory.setOtherDescription(super.getContent().getOtherDescription());
		medicalHistory.setPatient(super.getContent().getPatient());
		medicalHistory.setPinsAndNeedlesInArm(super.getContent().isPinsAndNeedlesInArm());
		medicalHistory.setPregnancy(super.getContent().getPregnancy());
		medicalHistory.setProstateDisorder(super.getContent().isProstateDisorder());
		medicalHistory.setShortnessOfBreath(super.getContent().isShortnessOfBreath());
		medicalHistory.setSignificantWeightLoss(super.getContent().isSignificantWeightLoss());
		medicalHistory.setSmell(super.getContent().isSmell());
		medicalHistory.setStd(super.getContent().isStd());
		medicalHistory.setStroke(super.getContent().isStroke());
		medicalHistory.setSurgery1(super.getContent().getSurgery1());
		medicalHistory.setSurgery1Complications(super.getContent().isSurgery1Complications());
		medicalHistory.setSurgery1Date(super.getContent().getSurgery1Date());
		medicalHistory.setSurgery2(super.getContent().getSurgery2());
		medicalHistory.setSurgery2Complications(super.getContent().isSurgery2Complications());
		medicalHistory.setSurgery2Date(super.getContent().getSurgery2Date());
		medicalHistory.setTaste(super.getContent().isTaste());
		medicalHistory.setTmjDisorder(super.getContent().isTmjDisorder());
		medicalHistory.setTuberculosis(super.getContent().isTuberculosis());
		medicalHistory.setVision(super.getContent().isVision());
		medicalHistory.setWeaknessInFingers(super.getContent().isWeaknessInFingers());
		medicalHistory.setWeaknessInLegs(super.getContent().isWeaknessInLegs());

		return medicalHistory;
		
	}

}
