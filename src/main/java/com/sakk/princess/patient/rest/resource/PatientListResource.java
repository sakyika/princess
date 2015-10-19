package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class PatientListResource extends ResourceSupport {
	
	private List<PatientResource> patientListResource = new ArrayList<PatientResource>();

	public List<PatientResource> getPatientListResource() {
		return patientListResource;
	}

	public void setPatientListResource(List<PatientResource> patientListResource) {
		this.patientListResource = patientListResource;
	}

}
