package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.WorkAccident;

public class WorkAccidentResource extends Resource<WorkAccident> {

	WorkAccidentResource() {
		super(new WorkAccident());
	}

	public WorkAccidentResource(WorkAccident workAccident) {
		super(workAccident);
	}
	
	public WorkAccident toWorkAccident(){
		
		WorkAccident workAccident = new WorkAccident();
		
		workAccident.setBodyPartsInjured(super.getContent().getBodyPartsInjured());
		workAccident.setBriefAccount(super.getContent().getBriefAccount());
		workAccident.setMedicalCareReceived(super.getContent().isMedicalCareReceived());
		workAccident.setCareGivenByDoctor(super.getContent().getCareGivenByDoctor());
		workAccident.setCareGivenType(super.getContent().getCareGivenType());
		workAccident.setAccidentDate(super.getContent().getAccidentDate());
		workAccident.setEmployer(super.getContent().getEmployer());
		workAccident.setId(super.getContent().getId());
		workAccident.setInjuriesResolved(super.getContent().isInjuriesResolved());
		workAccident.setInjuriesSustained(super.getContent().getInjuriesSustained());
		workAccident.setPatient(super.getContent().getPatient());
		workAccident.setPermanentOrPartialDisability(super.getContent().getPermanentOrPartialDisability());
		workAccident.setDisability(super.getContent().isDisability());
		workAccident.setWorkAccident(super.getContent().isWorkAccident());
		workAccident.setWSIBClaim(super.getContent().isWsibClaim());
		workAccident.setXrayTaken(super.getContent().isXrayTaken());
		
		return workAccident;
		
	}
	
}
