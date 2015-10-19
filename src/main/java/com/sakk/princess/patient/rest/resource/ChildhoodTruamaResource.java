package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.ChildhoodTruama;

public class ChildhoodTruamaResource extends Resource<ChildhoodTruama> {

	ChildhoodTruamaResource() {
		super(new ChildhoodTruama());
	}

	public ChildhoodTruamaResource(ChildhoodTruama childhoodTruama) {
		super(childhoodTruama);
	}
	
	public ChildhoodTruama toChildhoodTruama(){
		
		ChildhoodTruama childhoodTruama = new ChildhoodTruama();
		
		childhoodTruama.setId(super.getContent().getId());
		childhoodTruama.setBodyPartsInjured(super.getContent().getBodyPartsInjured());
		childhoodTruama.setBriefAccount(super.getContent().getBriefAccount());
		childhoodTruama.setCareGivenByDoctor(super.getContent().getCareGivenByDoctor());
		childhoodTruama.setCareTypeGiven(super.getContent().getCareTypeGiven());
		childhoodTruama.setChildhoodTruama(super.getContent().isChildhoodTruama());
		childhoodTruama.setTruamaDate(super.getContent().getTruamaDate());
		childhoodTruama.setId(super.getContent().getId());
		childhoodTruama.setInjuriesResolved(super.getContent().isInjuriesResolved());
		childhoodTruama.setMedicalCareReceived(super.getContent().isMedicalCareReceived());
		childhoodTruama.setPatient(super.getContent().getPatient());
		
		return childhoodTruama;
	}

}
