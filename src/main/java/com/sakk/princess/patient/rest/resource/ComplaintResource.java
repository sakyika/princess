package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.Complaint;

public class ComplaintResource extends Resource<Complaint> {

	ComplaintResource() {
		super(new Complaint());
	}

	public ComplaintResource(Complaint complaint) {
		super(complaint);
	}
	
	public Complaint toComplaint(){
		
		Complaint complaint = new Complaint();
		
		complaint.setAching(super.getContent().isAching());
		complaint.setBurning(super.getContent().isBurning());
		complaint.setDull(super.getContent().isBurning());
		complaint.setHowItHappened(super.getContent().getHowItHappened());
		complaint.setId(super.getContent().getId());
		complaint.setLocation(super.getContent().getLocation());
		complaint.setNumbness(super.getContent().isNumbness());
		complaint.setOther(super.getContent().isOther());
		complaint.setOtherDescription(super.getContent().getOtherDescription());
		complaint.setPainPattern(super.getContent().getPainPattern());
		complaint.setPainRadiatesWhere(super.getContent().getPainRadiatesWhere());
		complaint.setPainScale(super.getContent().getPainScale());
		complaint.setPainWorst(super.getContent().getPainWorst());
		complaint.setPatient(super.getContent().getPatient());
		complaint.setPreviousOccurance(super.getContent().isPreviousOccurance());
		complaint.setPreviousOccuranceDate(super.getContent().getPreviousOccuranceDate());
		complaint.setSharp(super.getContent().isSharp());
		complaint.setStabbing(super.getContent().isStabbing());
		complaint.setStartDate(super.getContent().getStartDate());
		complaint.setThrobbing(super.getContent().isThrobbing());
		complaint.setTingling(super.getContent().isTingling());
		complaint.setWeakness(super.getContent().isWeakness());
		complaint.setWhatMakesBetter(super.getContent().getWhatMakesBetter());
		complaint.setWhatMakesWorst(super.getContent().getWhatMakesWorst());
		complaint.setComplaintDate(super.getContent().getComplaintDate());
		
		return complaint;
		
	}

}
