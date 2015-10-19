package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.PatientRepository;
import com.sakk.princess.patient.model.Patient;
import com.sakk.princess.patient.service.PatientService;
import com.sakk.princess.patient.service.exception.DuplicatePatientException;
import com.sakk.princess.patient.service.exception.PatientNotFoundException;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	
	static Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> findAllPatients() {
		return getPatients();
	}

	@Override
	public Patient addPatient(Patient patient){
		
		Patient existingPatient = patientRepository.findByPatientNumber(patient.getPatientNumber());
		
		if(existingPatient != null){
			throw new DuplicatePatientException("Patient number : " + patient.getPatientNumber() + " already exists!");
		}
		else{
		
				return patientRepository.save(patient);
		}
	}

	@Override
	public Patient getPatient(Long patientId) {
		
		Patient patient = patientRepository.findOne(patientId);
		
		if(patient == null){
			throw new PatientNotFoundException("Patient with Id: " + patientId + " does not exist!");
		}
		else{
			return patientRepository.findOne(patientId);
		}
	}
	
	@Override
	public Patient getPatientByPatientNumber(Long patientNumber){
		

		Patient patient = patientRepository.findByPatientNumber(patientNumber);
		
		if(patient == null){
			throw new PatientNotFoundException("Patient with patient patientNumber: " + patientNumber + " does not exist!");
		}
		else{
			return patientRepository.findByPatientNumber(patientNumber);
		}
	}

	@Override
	public Patient updatePatientByPatientNumber(Long patientNumber, Patient patient) {
		
		Patient patientToUpdate = getPatientByPatientNumber(patientNumber);
			
		if(patientToUpdate != null){
/*			patientToUpdate.setAddress(patient.getAddress());
			patientToUpdate.setCellPhone(patient.getCellPhone());
			patientToUpdate.setChildhoodTruamaList(patient.getChildhoodTruamaList());
			patientToUpdate.setChiropracticExperienceList(patient.getChiropracticExperienceList());
			patientToUpdate.setComplaintList(patient.getComplaintList());
			patientToUpdate.setDob(patient.getDob());
			patientToUpdate.setEmail(patient.getEmail());
			patientToUpdate.setEmergencyContact(patient.getEmergencyContact());
			patientToUpdate.setEmergencyContactPhone(patient.getEmergencyContactPhone());
			patientToUpdate.setEmployer(patient.getEmployer());
			patientToUpdate.setFamilyHistory(patient.getFamilyHistory());
			patientToUpdate.setMedicalHistory(patient.getMedicalHistory());
			patientToUpdate.setFirstName(patient.getFirstName());
			patientToUpdate.setHealthHabit(patient.getHealthHabit());
			patientToUpdate.setHearAboutUs(patient.getHearAboutUs());
			patientToUpdate.setHomeAccidentList(patient.getHomeAccidentList());
			patientToUpdate.setHomePhone(patient.getHomePhone());
			patientToUpdate.setLastName(patient.getLastName());
			patientToUpdate.setMotorVehicleAccidentList(patient.getMotorVehicleAccidentList());
			patientToUpdate.setOccupation(patient.getOccupation());
			patientToUpdate.setPatientNumber(patient.getPatientNumber());	
			patientToUpdate.setSportsAccidentList(patient.getSportsAccidentList());
			patientToUpdate.setTitle(patient.getTitle());
			patientToUpdate.setWorkAccident(patient.getWorkAccidentList());
			patientToUpdate.setWorkPhone(patient.getWorkPhone());	*/
			
			patientRepository.saveAndFlush(patient);
			return patient;
		}
		else{
			throw new PatientNotFoundException("Patient with patientNumber: " + patientNumber + " does not exist!");
		}
	}
	
	@Override
	public Patient updatePatient(Patient patient) {

		if(patient != null){
			
			return patientRepository.saveAndFlush(patient);
			
		}
		else{
			throw new PatientNotFoundException("Patient cannot be updated!");
		}
	}

	@Override
	public Patient deletePatient(Long patientId) throws PatientNotFoundException {
		
		Patient patientToDelete = getPatient(patientId);
		
		if(patientToDelete != null){
			patientRepository.delete(patientToDelete);
			return patientToDelete;
		}else{
			throw new PatientNotFoundException("Patient with Id: " + patientId + " does not exist!");
		}
	
	}

	@Override
	public List<Patient> getPatients() {
		return patientRepository.findAll();
	}

	@Override
	public List<Patient> getPatientSublist(List<Long> patientIdList) {
		
		List<Patient> patientList = new ArrayList<Patient>();
		
		for(Long patientId : patientIdList){
			patientList.add(getPatient(patientId));
		}
		
		return patientList;
	}

}
