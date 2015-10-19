package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.Patient;

public interface PatientService {

	List<Patient> findAllPatients();

	public Patient addPatient(Patient patient);

	public Patient getPatient(Long patientId);

	public Patient getPatientByPatientNumber(Long patientNumber);

	public Patient updatePatientByPatientNumber(Long patientNumber, Patient patient);

	public Patient updatePatient(Patient patient);

	public Patient deletePatient(Long patientId);

	public List<Patient> getPatients();

	public List<Patient> getPatientSublist(List<Long> patientIdList);

}
