package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class MedicalHistoryListResource extends ResourceSupport {
	
	private List<MedicalHistoryResource> medicalHistoryResourceList = new ArrayList<MedicalHistoryResource>();

	public List<MedicalHistoryResource> getMedicalHistoryListResource() {
		return medicalHistoryResourceList;
	}

	public void setMedicalHistoryListResource(List<MedicalHistoryResource> medicalHistoryResourceList) {
		this.medicalHistoryResourceList = medicalHistoryResourceList;
	}

}
