package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.Patient;

public class PatientResource extends Resource<Patient> {
	
	public static final String LINK_NAME_PATIENT = "patient";
	
	public static final String LINK_NAME_CHILDHOODTRUAMAS = "childhoodtruamas";
	public static final String LINK_NAME_CHIROPRACTICEXPERIENCES = "chiropracticexperiences";
	public static final String LINK_NAME_COMPLAINTS = "complaints";
	public static final String LINK_NAME_FAMILYHISTORIES = "familyhistories";
	public static final String LINK_NAME_HEALTHHABITS = "heathhabits";
	public static final String LINK_NAME_HOMEACCIDENTS = "homeaccidents";
	public static final String LINK_NAME_MEDICALHISTORIES = "medicalhistories";
	public static final String LINK_NAME_MOTORVEHICLEACCIDENTS = "motorvehicleaccidents";
	public static final String LINK_NAME_SPORTSACCIDENTS = "sportsaccidents";
	public static final String LINK_NAME_WORKACCIDENTS = "workaccidents";
	
	PatientResource(){
		super(new Patient());
	}
	
	public PatientResource(Patient patient){
		super(patient);
	}
	
	public Patient toPatient(){
		
		Patient patient = new Patient();
		
		patient.setAddress(super.getContent().getAddress());
		patient.setCellPhone(super.getContent().getCellPhone());
		patient.setChildhoodTruamaList(super.getContent().getChildhoodTruamaList());
		patient.setChiropracticExperienceList(super.getContent().getChiropracticExperienceList());
		patient.setComplaintList(super.getContent().getComplaintList());
		patient.setDob(super.getContent().getDob());
		patient.setEmail(super.getContent().getEmail());
		patient.setEmergencyContact(super.getContent().getEmergencyContact());
		patient.setEmergencyContactPhone(super.getContent().getEmergencyContactPhone());
		patient.setEmployer(super.getContent().getEmployer());
		patient.setFamilyHistory(super.getContent().getFamilyHistory());
		patient.setFirstName(super.getContent().getFirstName());
		patient.setHealthHabit(super.getContent().getHealthHabit());
		patient.setHearAboutUs(super.getContent().getHearAboutUs());
		patient.setHomeAccidentList(super.getContent().getHomeAccidentList());
		patient.setHomePhone(super.getContent().getHomePhone());
		patient.setId(super.getContent().getId());
		patient.setLastName(super.getContent().getLastName());
		patient.setMotorVehicleAccidentList(super.getContent().getMotorVehicleAccidentList());
		patient.setOccupation(super.getContent().getOccupation());
		patient.setMedicalHistory(super.getContent().getMedicalHistory());
		patient.setPatientNumber(super.getContent().getPatientNumber());
		patient.setSportsAccidentList(super.getContent().getSportsAccidentList());
		patient.setTitle(super.getContent().getTitle());
		patient.setWorkAccident(super.getContent().getWorkAccidentList());
		patient.setWorkPhone(super.getContent().getWorkPhone());
		
		return patient;
		
	}
	

}
