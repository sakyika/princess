package com.sakk.princess.patient.rest.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakk.princess.core.rest.exception.ConflictException;
import com.sakk.princess.patient.model.ChildhoodTruama;
import com.sakk.princess.patient.model.ChiropracticExperience;
import com.sakk.princess.patient.model.Complaint;
import com.sakk.princess.patient.model.FamilyHistory;
import com.sakk.princess.patient.model.HealthHabit;
import com.sakk.princess.patient.model.HomeAccident;
import com.sakk.princess.patient.model.MedicalHistory;
import com.sakk.princess.patient.model.MotorVehicleAccident;
import com.sakk.princess.patient.model.Patient;
import com.sakk.princess.patient.model.SportsAccident;
import com.sakk.princess.patient.model.WorkAccident;
import com.sakk.princess.patient.rest.resource.ChildhoodTruamaListResource;
import com.sakk.princess.patient.rest.resource.ChildhoodTruamaResource;
import com.sakk.princess.patient.rest.resource.ChiropracticExperienceListResource;
import com.sakk.princess.patient.rest.resource.ChiropracticExperienceResource;
import com.sakk.princess.patient.rest.resource.ComplaintListResource;
import com.sakk.princess.patient.rest.resource.ComplaintResource;
import com.sakk.princess.patient.rest.resource.FamilyHistoryListResource;
import com.sakk.princess.patient.rest.resource.FamilyHistoryResource;
import com.sakk.princess.patient.rest.resource.HealthHabitListResource;
import com.sakk.princess.patient.rest.resource.HealthHabitResource;
import com.sakk.princess.patient.rest.resource.HomeAccidentListResource;
import com.sakk.princess.patient.rest.resource.HomeAccidentResource;
import com.sakk.princess.patient.rest.resource.MedicalHistoryListResource;
import com.sakk.princess.patient.rest.resource.MedicalHistoryResource;
import com.sakk.princess.patient.rest.resource.MotorVehicleAccidentListResource;
import com.sakk.princess.patient.rest.resource.MotorVehicleAccidentResource;
import com.sakk.princess.patient.rest.resource.PatientListResource;
import com.sakk.princess.patient.rest.resource.PatientResource;
import com.sakk.princess.patient.rest.resource.SportsAccidentListResource;
import com.sakk.princess.patient.rest.resource.SportsAccidentResource;
import com.sakk.princess.patient.rest.resource.WorkAccidentListResource;
import com.sakk.princess.patient.rest.resource.WorkAccidentResource;
import com.sakk.princess.patient.rest.resource.assembler.ChildhoodTruamaListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.ChildhoodTruamaResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.ChiropracticExperienceListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.ChiropracticExperienceResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.ComplaintListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.ComplaintResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.FamilyHistoryListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.FamilyHistoryResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.HealthHabitListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.HealthHabitResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.HomeAccidentListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.HomeAccidentResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.MedicalHistoryListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.MedicalHistoryResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.MotorVehicleAccidentListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.MotorVehicleAccidentResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.PatientListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.PatientResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.SportsAccidentListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.SportsAccidentResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.WorkAccidentListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.WorkAccidentResourceAssembler;
import com.sakk.princess.patient.service.PatientService;
import com.sakk.princess.patient.service.exception.DuplicateChildhoodTruamaException;
import com.sakk.princess.patient.service.exception.DuplicateChiropracticExperienceException;
import com.sakk.princess.patient.service.exception.DuplicateComplaintException;
import com.sakk.princess.patient.service.exception.DuplicateFamilyHistoryException;
import com.sakk.princess.patient.service.exception.DuplicateHealthHabitException;
import com.sakk.princess.patient.service.exception.DuplicateHomeAccidentException;
import com.sakk.princess.patient.service.exception.DuplicateMedicalHistoryException;
import com.sakk.princess.patient.service.exception.DuplicateMotorVehicleAccidentException;
import com.sakk.princess.patient.service.exception.DuplicatePatientException;
import com.sakk.princess.patient.service.exception.DuplicateSportsAccidentException;
import com.sakk.princess.patient.service.exception.DuplicateWorkAccidentException;
import com.sakk.princess.patient.service.util.ChildhoodTruamaList;
import com.sakk.princess.patient.service.util.ChiropracticExperienceList;
import com.sakk.princess.patient.service.util.ComplaintList;
import com.sakk.princess.patient.service.util.FamilyHistoryList;
import com.sakk.princess.patient.service.util.HealthHabitList;
import com.sakk.princess.patient.service.util.HomeAccidentList;
import com.sakk.princess.patient.service.util.MedicalHistoryList;
import com.sakk.princess.patient.service.util.MotorVehicleAccidentList;
import com.sakk.princess.patient.service.util.PatientList;
import com.sakk.princess.patient.service.util.SportsAccidentList;
import com.sakk.princess.patient.service.util.WorkAccidentList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/patients", produces = "application/hal+json")
@Api(value = "/patients")
@PreAuthorize("denyAll")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PreAuthorize("hasAuthority('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get patients", notes = "This can only be done by admin patient")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PatientListResource> getPatients(
			@RequestParam(value = "patientNumber", required = false) Long patientNumber) {

		PatientList patientList = null;

		if (patientNumber == null) {
			patientList = new PatientList(patientService.getPatients());
		} else {
			Patient patient = patientService.getPatientByPatientNumber(patientNumber);

			if (patient != null) {
				patientList = new PatientList(Arrays.asList(patient));

			}
		}

		PatientListResource patientListResource = new PatientListResourceAssembler().toResource(patientList);

		return new ResponseEntity<PatientListResource>(patientListResource, HttpStatus.OK);

	}
/*
	@PreAuthorize("hasRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<PatientListResource> getPatientSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		PatientList patientList = null;

		if (idList.isEmpty()) {
			patientList = new PatientList(new ArrayList<Patient>());
		} else {
			patientList = new PatientList(patientService.getPatientSublist(idList));

		}

		PatientListResource patientListResource = new PatientListResourceAssembler().toResource(patientList);

		return new ResponseEntity<PatientListResource>(patientListResource, HttpStatus.OK);

	}
*/
	@ApiOperation(value = "Get patient", notes = "This can only be done by admin patient")
	@RequestMapping(value = "/{patientNumber}", method = RequestMethod.GET)
	public ResponseEntity<PatientResource> getPatientByPatientNumber(@PathVariable Long patientNumber) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		if (patient != null) {
			PatientResource patientResource = new PatientResourceAssembler().toResource(patient);
			return new ResponseEntity<PatientResource>(patientResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<PatientResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a patient", notes = "This can only be done by admin patient")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PatientResource> addPatient(@RequestBody PatientResource sentPatient) {

		try {
			Patient createdPatient = patientService.addPatient(sentPatient.toPatient());
			PatientResource res = new PatientResourceAssembler().toResource(createdPatient);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<PatientResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicatePatientException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Update a patient", notes = "This can only be done by admin patient")
	@RequestMapping(value = "/{patientNumber}", method = RequestMethod.PUT)
	public ResponseEntity<PatientResource> updatePatient(@PathVariable Long patientNumber,
			@RequestBody PatientResource sentPatient) {

		try {
			Patient createdPatient = patientService.updatePatientByPatientNumber(patientNumber,
					sentPatient.toPatient());
			PatientResource res = new PatientResourceAssembler().toResource(createdPatient);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<PatientResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicatePatientException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a chiropracticExperience", notes = "This can only be done by admin chiropracticExperience")
	@RequestMapping(value = "/{patientNumber}/chiropracticexperiences", method = RequestMethod.POST)
	public ResponseEntity<ChiropracticExperienceResource> addChiropracticExperience(@PathVariable Long patientNumber,
			@RequestBody ChiropracticExperienceResource sentChiropracticExperienceResource) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		ChiropracticExperience sentChiropracticExperience = sentChiropracticExperienceResource.toChiropracticExperience();

		try {
			
			patient.getChiropracticExperienceList().add(sentChiropracticExperience);
			
			patientService.updatePatient(patient);
			
			int index = patient.getChiropracticExperienceList().indexOf(sentChiropracticExperience);
			
			Patient patientSaved = patientService.getPatientByPatientNumber(patientNumber);

			ChiropracticExperienceResource res = new ChiropracticExperienceResourceAssembler()
					.toResource(patientSaved.getChiropracticExperienceList().get(index));
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<ChiropracticExperienceResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateChiropracticExperienceException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a chiropracticExperience", notes = "This can only be done by admin chiropracticExperience")
	@RequestMapping(value = "/{patientNumber}/chiropracticexperiences", method = RequestMethod.GET)
	public ResponseEntity<ChiropracticExperienceListResource> getChiropracticExperiences(
			@PathVariable Long patientNumber) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);
		
		try {

			ChiropracticExperienceList createdChiropracticExperienceList = new ChiropracticExperienceList(
					patient.getChiropracticExperienceList());

			ChiropracticExperienceListResource chiropracticListResource = new ChiropracticExperienceListResourceAssembler()
					.toResource(createdChiropracticExperienceList);

			return new ResponseEntity<ChiropracticExperienceListResource>(chiropracticListResource, HttpStatus.CREATED);
		} catch (DuplicateChiropracticExperienceException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a medicalhistory", notes = "This can only be done by admin medicalhistory")
	@RequestMapping(value = "/{patientNumber}/medicalhistory", method = RequestMethod.POST)
	public ResponseEntity<MedicalHistoryResource> addMedicalHistory(@PathVariable Long patientNumber,
			@RequestBody MedicalHistoryResource sentMedicalHistoryResource) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		MedicalHistory createdMedicalHistory = sentMedicalHistoryResource.toMedicalHistory();

		try {
			
			patient.setMedicalHistory(createdMedicalHistory);
			
			patientService.updatePatient(patient);
			
			Patient patientSaved = patientService.getPatientByPatientNumber(patientNumber);

			MedicalHistoryResource res = new MedicalHistoryResourceAssembler().toResource(patientSaved.getMedicalHistory());
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			
			return new ResponseEntity<MedicalHistoryResource>(res, headers, HttpStatus.CREATED);
			
		} catch (DuplicateMedicalHistoryException exception) {
			
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "get medicalhisotry of a patient", notes = "This can only be done by admin medicalhistory")
	@RequestMapping(value = "/{patientNumber}/medicalhistory", method = RequestMethod.GET)
	public ResponseEntity<MedicalHistoryListResource> getMedicalHistory(@PathVariable Long patientNumber) {

		MedicalHistory medicalHistory = patientService.getPatientByPatientNumber(patientNumber).getMedicalHistory();
		
		List<MedicalHistory> medicalHistoryList = new ArrayList<MedicalHistory>();
		
		if(medicalHistory != null){
			medicalHistoryList.add(medicalHistory);
		}
		
		try {

			MedicalHistoryList retrievedMedicalHistoryList = new MedicalHistoryList(medicalHistoryList);

			MedicalHistoryListResource medicalHistoryListResource = new MedicalHistoryListResourceAssembler()
					.toResource(retrievedMedicalHistoryList);

			return new ResponseEntity<MedicalHistoryListResource>(medicalHistoryListResource, HttpStatus.CREATED);
		} catch (DuplicateMedicalHistoryException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a familyhistory", notes = "This can only be done by admin familyhistory")
	@RequestMapping(value = "/{patientNumber}/familyhistory", method = RequestMethod.POST)
	public ResponseEntity<FamilyHistoryResource> addFamilyHistory(@PathVariable Long patientNumber,
			@RequestBody FamilyHistoryResource sentFamilyHistoryResource) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		FamilyHistory createdFamilyHistory = sentFamilyHistoryResource.toFamilyHistory();

		try {
			
			patient.setFamilyHistory(createdFamilyHistory);
			
			patientService.updatePatient(patient);
			
			Patient patientSaved = patientService.getPatientByPatientNumber(patientNumber);

			FamilyHistoryResource res = new FamilyHistoryResourceAssembler().toResource(patientSaved.getFamilyHistory());
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			
			return new ResponseEntity<FamilyHistoryResource>(res, headers, HttpStatus.CREATED);
			
		} catch (DuplicateFamilyHistoryException exception) {
			
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "get medicalhisotry of a patient", notes = "This can only be done by admin medicalhistory")
	@RequestMapping(value = "/{patientNumber}/familyhistory", method = RequestMethod.GET)
	public ResponseEntity<FamilyHistoryListResource> getFamilyHistory(@PathVariable Long patientNumber) {

		FamilyHistory familyHistory = patientService.getPatientByPatientNumber(patientNumber).getFamilyHistory();
		
		List<FamilyHistory> familyHistoryList = new ArrayList<FamilyHistory>();
		
		if(familyHistory != null){
			familyHistoryList.add(familyHistory);
		}

		try {

			FamilyHistoryList retrievedFamilyHistoryList = new FamilyHistoryList(familyHistoryList);

			FamilyHistoryListResource familyHistoryListResource = new FamilyHistoryListResourceAssembler()
					.toResource(retrievedFamilyHistoryList);

			return new ResponseEntity<FamilyHistoryListResource>(familyHistoryListResource, HttpStatus.CREATED);
		} catch (DuplicateFamilyHistoryException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a healthhabit", notes = "This can only be done by admin familyhistory")
	@RequestMapping(value = "/{patientNumber}/healthhabit", method = RequestMethod.POST)
	public ResponseEntity<HealthHabitResource> addHealthHabit(@PathVariable Long patientNumber,
			@RequestBody HealthHabitResource sentHealthHabitResource) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		HealthHabit createdHealthHabit = sentHealthHabitResource.toHealthHabit();

		try {
			
			patient.setHealthHabit(createdHealthHabit);
			
			patientService.updatePatient(patient);
			
			Patient patientSaved = patientService.getPatientByPatientNumber(patientNumber);

			HealthHabitResource res = new HealthHabitResourceAssembler().toResource(patientSaved.getHealthHabit());
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			
			return new ResponseEntity<HealthHabitResource>(res, headers, HttpStatus.CREATED);
			
		} catch (DuplicateHealthHabitException exception) {
			
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "get healthhabit of a patient", notes = "This can only be done by admin healthhabit")
	@RequestMapping(value = "/{patientNumber}/healthhabit", method = RequestMethod.GET)
	public ResponseEntity<HealthHabitListResource> getHealthHabit(@PathVariable Long patientNumber) {

		HealthHabit healthHabit = patientService.getPatientByPatientNumber(patientNumber).getHealthHabit();
		
		List<HealthHabit> healthHabitList = new ArrayList<HealthHabit>();
		
		if(healthHabit != null){
			healthHabitList.add(healthHabit);
		}

		try {

			HealthHabitList createdHealthHabitList = new HealthHabitList(healthHabitList);

			HealthHabitListResource healthHabitListResource = new HealthHabitListResourceAssembler()
					.toResource(createdHealthHabitList);

			return new ResponseEntity<HealthHabitListResource>(healthHabitListResource, HttpStatus.CREATED);
			
		} catch (DuplicateHealthHabitException exception) {
			
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a childhoodtruama", notes = "This can only be done by admin childhoodtruama")
	@RequestMapping(value = "/{patientNumber}/childhoodtruamas", method = RequestMethod.POST)
	public ResponseEntity<ChildhoodTruamaResource> addChildhoodTruamas(@PathVariable Long patientNumber,
			@RequestBody ChildhoodTruamaResource sentChildhoodTruamaResource) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		ChildhoodTruama sentChildhoodTruama = sentChildhoodTruamaResource.toChildhoodTruama();

		try {
			
			patient.getChildhoodTruamaList().add(sentChildhoodTruama);
			
			patientService.updatePatient(patient);
			
			int index = patient.getChildhoodTruamaList().indexOf(sentChildhoodTruama);
			
			Patient patientSaved = patientService.getPatientByPatientNumber(patientNumber);
			
			ChildhoodTruamaResource res = new ChildhoodTruamaResourceAssembler().toResource(patientSaved.getChildhoodTruamaList().get(index));
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			
			return new ResponseEntity<ChildhoodTruamaResource>(res, headers, HttpStatus.CREATED);
			
		} catch (DuplicateChildhoodTruamaException exception) {
			
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "get childhoodtruamas of a patient", notes = "This can only be done by admin childhoodtruama")
	@RequestMapping(value = "/{patientNumber}/childhoodtruamas", method = RequestMethod.GET)
	public ResponseEntity<ChildhoodTruamaListResource> getChildhoodTruamas(@PathVariable Long patientNumber) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		try {

			ChildhoodTruamaList createdChildhoodTruamaList = new ChildhoodTruamaList(
					patient.getChildhoodTruamaList());

			ChildhoodTruamaListResource childhoodTruamaListResource = new ChildhoodTruamaListResourceAssembler()
					.toResource(createdChildhoodTruamaList);

			return new ResponseEntity<ChildhoodTruamaListResource>(childhoodTruamaListResource, HttpStatus.CREATED);
		} catch (DuplicateChildhoodTruamaException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a motorvehicleaccident", notes = "This can only be done by admin motorvehicleaccident")
	@RequestMapping(value = "/{patientNumber}/motorvehicleaccidents", method = RequestMethod.POST)
	public ResponseEntity<MotorVehicleAccidentResource> addMotorVehicleAccidents(@PathVariable Long patientNumber,
			@RequestBody MotorVehicleAccidentResource sentMotorVehicleAccidentResource) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);
		
		MotorVehicleAccident sentMotorVehicleAccident = sentMotorVehicleAccidentResource.toMotorVehicleAccident();
		

		try {
			patient.getMotorVehicleAccidentList().add(sentMotorVehicleAccident);
			
			patientService.updatePatient(patient);
			
			
			
			int index = patient.getMotorVehicleAccidentList().indexOf(sentMotorVehicleAccident);
			
			System.out.println("The index of the new entity is: " + index);
			
			Patient patientSaved = patientService.getPatientByPatientNumber(patientNumber);

			MotorVehicleAccidentResource res = new MotorVehicleAccidentResourceAssembler()
					.toResource(patientSaved.getMotorVehicleAccidentList().get(index));
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			
			return new ResponseEntity<MotorVehicleAccidentResource>(res, headers, HttpStatus.CREATED);
			
		} catch (DuplicateMotorVehicleAccidentException exception) {
			
			throw new ConflictException(exception);
			
		}
	}

	@ApiOperation(value = "get motorvehicleaccident of a patient", notes = "This can only be done by admin motorvehicleaccident")
	@RequestMapping(value = "/{patientNumber}/motorvehicleaccidents", method = RequestMethod.GET)
	public ResponseEntity<MotorVehicleAccidentListResource> getMotorVehicleAccidents(@PathVariable Long patientNumber) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		try {

			MotorVehicleAccidentList createdMotorVehicleAccidentList = new MotorVehicleAccidentList(
					patient.getMotorVehicleAccidentList());
			
			System.out.println("MotorVehicleAccident has " + patient.getMotorVehicleAccidentList().size() + " entries");

			MotorVehicleAccidentListResource motorVehicleAccidentListResource = new MotorVehicleAccidentListResourceAssembler()
					.toResource(createdMotorVehicleAccidentList);

			return new ResponseEntity<MotorVehicleAccidentListResource>(motorVehicleAccidentListResource,
					HttpStatus.CREATED);
		} catch (DuplicateMotorVehicleAccidentException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a homeaccident", notes = "This can only be done by admin homeaccidents")
	@RequestMapping(value = "/{patientNumber}/homeaccidents", method = RequestMethod.POST)
	public ResponseEntity<HomeAccidentResource> addHomeAccidents(@PathVariable Long patientNumber,
			@RequestBody HomeAccidentResource sentHomeAccidentResource) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		HomeAccident sentHomeAccident = sentHomeAccidentResource.toHomeAccident();

		try {
			
			patient.getHomeAccidentList().add(sentHomeAccident);
			
			patientService.updatePatient(patient);
			
			int index = patient.getHomeAccidentList().indexOf(sentHomeAccident);
			
			Patient patientSaved = patientService.getPatientByPatientNumber(patientNumber);

			HomeAccidentResource res = new HomeAccidentResourceAssembler().toResource(patientSaved.getHomeAccidentList().get(index));
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			
			return new ResponseEntity<HomeAccidentResource>(res, headers, HttpStatus.CREATED);
			
		} catch (DuplicateHomeAccidentException exception) {
			
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "get homeaccidents of a patient", notes = "This can only be done by admin homeaccidents")
	@RequestMapping(value = "/{patientNumber}/homeaccidents", method = RequestMethod.GET)
	public ResponseEntity<HomeAccidentListResource> getHomeAccidents(@PathVariable Long patientNumber) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		try {

			HomeAccidentList createdHomeAccidentList = new HomeAccidentList(
					patient.getHomeAccidentList());

			HomeAccidentListResource homeAccidentListResource = new HomeAccidentListResourceAssembler()
					.toResource(createdHomeAccidentList);

			return new ResponseEntity<HomeAccidentListResource>(homeAccidentListResource, HttpStatus.CREATED);
		} catch (DuplicateHomeAccidentException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a homeaccident", notes = "This can only be done by admin homeaccidents")
	@RequestMapping(value = "/{patientNumber}/sportsaccidents", method = RequestMethod.POST)
	public ResponseEntity<SportsAccidentResource> addSportsAccidents(@PathVariable Long patientNumber,
			@RequestBody SportsAccidentResource sentSportsAccidentResource) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		SportsAccident sentSportsAccident = sentSportsAccidentResource.toSportsAccident();

		try {
			
			patient.getSportsAccidentList().add(sentSportsAccident);
			
			patientService.updatePatient(patient);
			
			int index = patient.getSportsAccidentList().indexOf(sentSportsAccident);
			
			Patient patientSaved = patientService.getPatientByPatientNumber(patientNumber);
			
			SportsAccidentResource res = new SportsAccidentResourceAssembler().toResource(patientSaved.getSportsAccidentList().get(index));
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			
			return new ResponseEntity<SportsAccidentResource>(res, headers, HttpStatus.CREATED);
			
		} catch (DuplicateSportsAccidentException exception) {
			
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "get homeaccidents of a patient", notes = "This can only be done by admin homeaccidents")
	@RequestMapping(value = "/{patientNumber}/sportsaccidents", method = RequestMethod.GET)
	public ResponseEntity<SportsAccidentListResource> getSportsAccidents(@PathVariable Long patientNumber) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		try {

			SportsAccidentList createdSportsAccidentList = new SportsAccidentList(
					patient.getSportsAccidentList());

			SportsAccidentListResource sportsAccidentListResource = new SportsAccidentListResourceAssembler()
					.toResource(createdSportsAccidentList);

			return new ResponseEntity<SportsAccidentListResource>(sportsAccidentListResource, HttpStatus.CREATED);
		} catch (DuplicateSportsAccidentException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a workaccident", notes = "This can only be done by admin homeaccidents")
	@RequestMapping(value = "/{patientNumber}/workaccidents", method = RequestMethod.POST)
	public ResponseEntity<WorkAccidentResource> addWorkAccidents(@PathVariable Long patientNumber,
			@RequestBody WorkAccidentResource sentWorkAccidentResource) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		WorkAccident sentWorkAccident = sentWorkAccidentResource.toWorkAccident();

		try {
			
			patient.getWorkAccidentList().add(sentWorkAccident);

			patientService.updatePatient(patient);
			
			int index = patient.getWorkAccidentList().indexOf(sentWorkAccident);
			
			Patient patientSaved = patientService.getPatientByPatientNumber(patientNumber);

			WorkAccidentResource res = new WorkAccidentResourceAssembler().toResource(patientSaved.getWorkAccidentList().get(index));
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			
			return new ResponseEntity<WorkAccidentResource>(res, headers, HttpStatus.CREATED);
			
		} catch (DuplicateWorkAccidentException exception) {
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "get workaccidents of a patient", notes = "This can only be done by admin workaccidents")
	@RequestMapping(value = "/{patientNumber}/workaccidents", method = RequestMethod.GET)
	public ResponseEntity<WorkAccidentListResource> getWorkAccidents(@PathVariable Long patientNumber) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);
		
		try {

			WorkAccidentList createdWorkAccidentList = new WorkAccidentList(
					patient.getWorkAccidentList());

			WorkAccidentListResource workAccidentListResource = new WorkAccidentListResourceAssembler()
					.toResource(createdWorkAccidentList);

			return new ResponseEntity<WorkAccidentListResource>(workAccidentListResource, HttpStatus.CREATED);
		} catch (DuplicateWorkAccidentException exception) {
			
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "Create a workaccident", notes = "This can only be done by admin homeaccidents")
	@RequestMapping(value = "/{patientNumber}/complaints", method = RequestMethod.POST)
	public ResponseEntity<ComplaintResource> addComplaints(@PathVariable Long patientNumber,
			@RequestBody ComplaintResource sentComplaintResource) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		Complaint sentComplaint = sentComplaintResource.toComplaint();

		try {
			
			patient.getComplaintList().add(sentComplaint);
			
			patientService.updatePatient(patient);
			
			int index = patient.getComplaintList().indexOf(sentComplaint);
			
			Patient patientSaved = patientService.getPatientByPatientNumber(patientNumber);

			ComplaintResource res = new ComplaintResourceAssembler().toResource(patientSaved.getComplaintList().get(index));
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			
			return new ResponseEntity<ComplaintResource>(res, headers, HttpStatus.CREATED);
			
		} catch (DuplicateComplaintException exception) {
			
			throw new ConflictException(exception);
		}
	}

	@ApiOperation(value = "get workaccidents of a patient", notes = "This can only be done by admin workaccidents")
	@RequestMapping(value = "/{patientNumber}/complaints", method = RequestMethod.GET)
	public ResponseEntity<ComplaintListResource> getComplaints(@PathVariable Long patientNumber) {

		Patient patient = patientService.getPatientByPatientNumber(patientNumber);

		try {

			ComplaintList createdComplaintList = new ComplaintList(patient.getComplaintList());

			ComplaintListResource complaintListResource = new ComplaintListResourceAssembler()
					.toResource(createdComplaintList);

			return new ResponseEntity<ComplaintListResource>(complaintListResource, HttpStatus.CREATED);
		} catch (DuplicateComplaintException exception) {
			throw new ConflictException(exception);
		}
	}

}
