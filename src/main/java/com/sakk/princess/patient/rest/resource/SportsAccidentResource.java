package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.SportsAccident;

public class SportsAccidentResource extends Resource<SportsAccident> {

	SportsAccidentResource() {
		super(new SportsAccident());
	}

	public SportsAccidentResource(SportsAccident sportsAccident) {
		super(sportsAccident);
	}
	
	public SportsAccident toSportsAccident(){
		
		SportsAccident sportsAccident = new SportsAccident();
		
		sportsAccident.setBriefAccount(super.getContent().getBriefAccount());
		sportsAccident.setBodyPartInjured(super.getContent().getBodyPartsInjured());
		sportsAccident.setCareGivenByDoctor(super.getContent().getCareGivenByDoctor());
		sportsAccident.setCareTypeGiven(super.getContent().getCareTypeGiven());
		sportsAccident.setId(super.getContent().getId());
		sportsAccident.setInjuryResolved(super.getContent().isInjuriesResolved());
		sportsAccident.setMedicalCareReceived(super.getContent().isMedicalCareReceived());
		sportsAccident.setPatient(super.getContent().getPatient());
		sportsAccident.setSportsAccident(super.getContent().isSportsAccident());
		sportsAccident.setSportsAccidentDate(super.getContent().getAccidentDate());

		return sportsAccident;
	
	}

}
