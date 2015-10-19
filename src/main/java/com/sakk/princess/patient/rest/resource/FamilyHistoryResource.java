package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.FamilyHistory;

public class FamilyHistoryResource extends Resource<FamilyHistory> {

	FamilyHistoryResource() {
		super(new FamilyHistory());
	}

	public FamilyHistoryResource(FamilyHistory familyHistory) {
		super(familyHistory);
	}
	
	public FamilyHistory toFamilyHistory(){
		
		FamilyHistory familyHistory = new FamilyHistory();
		
		familyHistory.setCancer(super.getContent().isCancer());
		familyHistory.setDiabetes(super.getContent().isDiabetes());
		familyHistory.setArthritis(super.getContent().isArthritis());
		familyHistory.setFamilyHeartDisease(super.getContent().isFamilyHeartDisease());
		familyHistory.setId(super.getContent().getId());
		familyHistory.setOther(super.getContent().isOther());
		familyHistory.setOtherDescription(super.getContent().getOtherDescription());
		familyHistory.setPatient(super.getContent().getPatient());
		familyHistory.setPsychoSocialDisease(super.getContent().isPsychoSocialDisease());
		
		return familyHistory;
		
	}

}
