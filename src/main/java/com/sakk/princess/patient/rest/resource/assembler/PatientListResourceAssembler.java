package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.resource.PatientListResource;
import com.sakk.princess.patient.rest.resource.PatientResource;
import com.sakk.princess.patient.service.util.PatientList;

public class PatientListResourceAssembler extends ResourceAssemblerSupport<PatientList, PatientListResource> {

	public PatientListResourceAssembler() {
		super(PatientController.class, PatientListResource.class);
	}

	@Override
	public PatientListResource toResource(PatientList patientList) {

		List<PatientResource> patientResourceList = new PatientResourceAssembler()
				.toResources(patientList.getPatientList());
		PatientListResource finalPatientListResource = new PatientListResource();
		finalPatientListResource.setPatientListResource(patientResourceList);

		return finalPatientListResource;

	}

}
