package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.ChiropracticExperience;

public class ChiropracticExperienceResource extends Resource<ChiropracticExperience> {

	ChiropracticExperienceResource() {
		super(new ChiropracticExperience());
	}

	public ChiropracticExperienceResource(ChiropracticExperience chiropracticExperience) {
		super(chiropracticExperience);
	}
	
	public ChiropracticExperience toChiropracticExperience(){
		
		ChiropracticExperience chiropracticExperience = new ChiropracticExperience();
		
		chiropracticExperience.setId(super.getContent().getId());
		chiropracticExperience.setLastChiropractorVisit(super.getContent().getLastChiropractorVisit());
		chiropracticExperience.setPatient(super.getContent().getPatient());
		chiropracticExperience.setPreviousChiropractorName(super.getContent().getPreviousChiropractorName());
		chiropracticExperience.setPreviousChiropractorLocation(super.getContent().getPreviousChiropractorLocation());
		chiropracticExperience.setPreviousChiropractorPhone(super.getContent().getPreviousChiropractorPhone());
		chiropracticExperience.setxRayTaken(super.getContent().isxRayTaken());
		
		return chiropracticExperience;
		
	}
	
}
