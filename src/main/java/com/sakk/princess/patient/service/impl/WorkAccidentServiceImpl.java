package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.WorkAccidentRepository;
import com.sakk.princess.patient.model.WorkAccident;
import com.sakk.princess.patient.service.WorkAccidentService;
import com.sakk.princess.patient.service.exception.PatientNotFoundException;

@Service
@Transactional
public class WorkAccidentServiceImpl implements WorkAccidentService {
	
	static Logger logger = LoggerFactory.getLogger(WorkAccidentServiceImpl.class);

	@Autowired
	WorkAccidentRepository workAccidentRepository;


	@Override
	public List<WorkAccident> findAllWorkAccident() {
		return getWorkAccidents();
	}

	@Override
	public WorkAccident addWorkAccident(WorkAccident workAccident) {
		return workAccidentRepository.saveAndFlush(workAccident);
	}

	@Override
	public WorkAccident getWorkAccident(Long workAccidentId) {
		return workAccidentRepository.getOne(workAccidentId);
	}

	@Override
	public WorkAccident updateWorkAccident(WorkAccident workAccident) {
		
		WorkAccident workAccidentToUpdate = getWorkAccident(workAccident.getId());
		
		if(workAccidentToUpdate != null){
/*			workAccidentToUpdate.setBodyPartInjured(workAccident.getBodyPartInjured());
			workAccidentToUpdate.setBriefAccountOfAccident(workAccident.getBriefAccountOfAccident());
			workAccidentToUpdate.setCareGivenBy(workAccident.getCareGivenBy());
			workAccidentToUpdate.setCareGivenType(workAccident.getCareGivenType());
			workAccidentToUpdate.setDate(workAccident.getDate());
			workAccidentToUpdate.setEmployer(workAccident.getEmployer());
			workAccidentToUpdate.setId(workAccident.getId());
			workAccidentToUpdate.setInjuryResolved(workAccident.isInjuryResolved());
			workAccidentToUpdate.setInjurySustained(workAccident.getInjurySustained());
			workAccidentToUpdate.setPatientInfo(workAccident.getPatientInfo());
			workAccidentToUpdate.setPermanentOrPartialDisability(workAccident.getPermanentOrPartialDisability());
			workAccidentToUpdate.setDisability(workAccident.isDisability());
			workAccidentToUpdate.setWorkAccident(workAccident.isWorkAccident());
			workAccidentToUpdate.setWSIBClaim(workAccident.isWSIBClaim());
			workAccidentToUpdate.setXrayTaken(workAccident.isXrayTaken());	*/
			
			workAccidentRepository.saveAndFlush(workAccident);
			
		}
		
		return workAccidentToUpdate;
	}

	@Override
	public WorkAccident deleteWorkAccident(Long workAccidentId) {

		WorkAccident workAccidentToDelete = getWorkAccident(workAccidentId);
		
		if(workAccidentToDelete != null){
			workAccidentRepository.delete(workAccidentToDelete);
		}else{
			throw new PatientNotFoundException();
		}
		
		return workAccidentToDelete;
	}

	@Override
	public List<WorkAccident> getWorkAccidents() {
		return workAccidentRepository.findAll();
	}

	@Override
	public List<WorkAccident> getWorkAccidentSublist(List<Long> workAccidentIdList) {

		List<WorkAccident> workAccidentList = new ArrayList<WorkAccident>();
		
		for(Long workAccidentId : workAccidentIdList){
			workAccidentList.add(getWorkAccident(workAccidentId));
		}
		
		return workAccidentList;
	}
	
	@Override
	public List<WorkAccident> findByPatientNumber(Long patientNumber){
		return workAccidentRepository.findByPatientPatientNumber(patientNumber);
	}

}
