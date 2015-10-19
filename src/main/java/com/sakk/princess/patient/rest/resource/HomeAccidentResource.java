package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.HomeAccident;

public class HomeAccidentResource extends Resource<HomeAccident> {

	HomeAccidentResource() {
		super(new HomeAccident());
	}

	public HomeAccidentResource(HomeAccident homeAccident) {
		super(homeAccident);
	}
	
	public HomeAccident toHomeAccident(){
		
		HomeAccident homeAccident = new HomeAccident();
		
		homeAccident.setBriefAccount(super.getContent().getBriefAccount());
		homeAccident.setBodyPartsInjured(super.getContent().getBodyPartsInjured());
		homeAccident.setBriefAccount(super.getContent().getBriefAccount());
		homeAccident.setCareGivenByDoctor(super.getContent().getCareGivenByDoctor());
		homeAccident.setCareTypeGiven(super.getContent().getCareTypeGiven());
		homeAccident.setHomeAccident(super.getContent().isHomeAccident());
		homeAccident.setAccidentDate(super.getContent().getAccidentDate());
		homeAccident.setId(super.getContent().getId());
		homeAccident.setInjuriesResolved(super.getContent().isInjuriesResolved());
		homeAccident.setMedicalCareReceived(super.getContent().isMedicalCareReceived());
		homeAccident.setPatient(super.getContent().getPatient());
	
		return homeAccident;
		
	}

}
