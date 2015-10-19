package com.sakk.princess.patient.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.model.Patient;
import com.sakk.princess.patient.rest.controller.ChildhoodTruamaController;
import com.sakk.princess.patient.rest.controller.ChiropracticExperienceController;
import com.sakk.princess.patient.rest.controller.ComplaintController;
import com.sakk.princess.patient.rest.controller.FamilyHistoryController;
import com.sakk.princess.patient.rest.controller.HealthHabitController;
import com.sakk.princess.patient.rest.controller.MedicalHistoryController;
import com.sakk.princess.patient.rest.controller.MotorVehicleAccidentController;
import com.sakk.princess.patient.rest.controller.PatientController;
import com.sakk.princess.patient.rest.controller.SportsAccidentController;
import com.sakk.princess.patient.rest.controller.WorkAccidentController;
import com.sakk.princess.patient.rest.resource.PatientResource;

public class PatientResourceAssembler extends ResourceAssemblerSupport<Patient, PatientResource> {

	public PatientResourceAssembler() {
		super(PatientController.class, PatientResource.class);
	}

	@Override
	public PatientResource toResource(Patient patient) {

		PatientResource patientResource = new PatientResource(patient);

		patientResource
				.add(linkTo(methodOn(PatientController.class).getPatientByPatientNumber(patient.getPatientNumber()))
						.withSelfRel());

		patientResource.add(linkTo(methodOn(ChiropracticExperienceController.class).getChiropracticExperiences())
				.withRel(PatientResource.LINK_NAME_CHIROPRACTICEXPERIENCES));

		patientResource.add(linkTo(methodOn(ChildhoodTruamaController.class).getChildhoodTruamas())
				.withRel(PatientResource.LINK_NAME_CHILDHOODTRUAMAS));

		patientResource.add(linkTo(methodOn(ComplaintController.class).getComplaints())
				.withRel(PatientResource.LINK_NAME_COMPLAINTS));

		patientResource.add(linkTo(methodOn(FamilyHistoryController.class).getFamilyHistories())
				.withRel(PatientResource.LINK_NAME_FAMILYHISTORIES));

		patientResource.add(linkTo(methodOn(HealthHabitController.class).getHealthHabits())
				.withRel(PatientResource.LINK_NAME_HEALTHHABITS));

		patientResource.add(linkTo(methodOn(MedicalHistoryController.class).getMedicalHistories())
				.withRel(PatientResource.LINK_NAME_MEDICALHISTORIES));

		patientResource.add(linkTo(methodOn(MotorVehicleAccidentController.class).getMotorVehicleAccidents())
				.withRel(PatientResource.LINK_NAME_MOTORVEHICLEACCIDENTS));

		patientResource.add(linkTo(methodOn(SportsAccidentController.class).getSportsAccidents())
				.withRel(PatientResource.LINK_NAME_SPORTSACCIDENTS));

		patientResource.add(linkTo(methodOn(WorkAccidentController.class).getWorkAccidents())
				.withRel(PatientResource.LINK_NAME_WORKACCIDENTS));

		return patientResource;
	}

}
