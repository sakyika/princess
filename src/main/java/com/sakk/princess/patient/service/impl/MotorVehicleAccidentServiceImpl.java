package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.MotorVehicleAccidentRepository;
import com.sakk.princess.patient.model.MotorVehicleAccident;
import com.sakk.princess.patient.service.MotorVehicleAccidentService;
import com.sakk.princess.patient.service.exception.PatientNotFoundException;

@Service
@Transactional
public class MotorVehicleAccidentServiceImpl implements MotorVehicleAccidentService {
	
	static Logger logger = LoggerFactory.getLogger(MotorVehicleAccidentServiceImpl.class);

	@Autowired
	MotorVehicleAccidentRepository motorVehicleAccidentRepository;

	@Override
	public List<MotorVehicleAccident> findAllMotorVehicleAccidents() {
		return getMotorVehicleAccidents();
	}

	@Override
	public MotorVehicleAccident addMotorVehicleAccident(MotorVehicleAccident motorVehicleAccident) {
		return motorVehicleAccidentRepository.saveAndFlush(motorVehicleAccident);
	}

	@Override
	public MotorVehicleAccident getMotorVehicleAccident(Long motorVehicleAccidentId) {
		return motorVehicleAccidentRepository.getOne(motorVehicleAccidentId);
	}

	@Override
	public MotorVehicleAccident updateMotorVehicleAccident(MotorVehicleAccident motorVehicleAccident) {

		MotorVehicleAccident motorVehicleAccidentToUpdate = getMotorVehicleAccident(motorVehicleAccident.getId());
		
		if(motorVehicleAccidentToUpdate != null){
/*			
			motorVehicleAccidentToUpdate.setCareGivenBy(motorVehicleAccident.getCareGivenBy());
			motorVehicleAccidentToUpdate.setCareGivenType(motorVehicleAccident.getCareGivenType());
			motorVehicleAccidentToUpdate.setDate(motorVehicleAccident.getDate());
			motorVehicleAccidentToUpdate.setDriverOrPassenger(motorVehicleAccident.getDriverOrPassenger());
			motorVehicleAccidentToUpdate.setId(motorVehicleAccident.getId());
			motorVehicleAccidentToUpdate.setInjuriesResolved(motorVehicleAccident.isInjuriesResolved());
			motorVehicleAccidentToUpdate.setInjuriesSustained(motorVehicleAccident.getInjuriesSustained());
			motorVehicleAccidentToUpdate.setLossConsciousness(motorVehicleAccident.isLossConsciousness());
			motorVehicleAccidentToUpdate.setMedicationGiven(motorVehicleAccident.isMedicationGiven());
			motorVehicleAccidentToUpdate.setMotorVehicleAccident(motorVehicleAccident.isMotorVehicleAccident());
			motorVehicleAccidentToUpdate.setPatientInfo(motorVehicleAccident.getPatientInfo());
			motorVehicleAccidentToUpdate.setSentToHospital(motorVehicleAccident.isSentToHospital());
			motorVehicleAccidentToUpdate.setStrikeHead(motorVehicleAccident.isStrikeHead());
			motorVehicleAccidentToUpdate.setVehicleCollisionPart(motorVehicleAccident.getVehicleCollisionPart());
			motorVehicleAccidentToUpdate.setWearingSeatBelt(motorVehicleAccident.isWearingSeatBelt());
			motorVehicleAccidentToUpdate.setXrayTaken(motorVehicleAccident.isXrayTaken());	*/
			
			motorVehicleAccidentRepository.saveAndFlush(motorVehicleAccident);
			
		}
		
		return motorVehicleAccidentToUpdate;
	}

	@Override
	public MotorVehicleAccident deleteMotorVehicleAccident(Long motorVehicleAccidentId) {

		MotorVehicleAccident motorVehicleAccidentToDelete = getMotorVehicleAccident(motorVehicleAccidentId);
		
		if(motorVehicleAccidentToDelete != null){
			motorVehicleAccidentRepository.delete(motorVehicleAccidentToDelete);
		}else{
			throw new PatientNotFoundException();
		}
		
		return motorVehicleAccidentToDelete;
	}

	@Override
	public List<MotorVehicleAccident> getMotorVehicleAccidents() {
		return motorVehicleAccidentRepository.findAll();
	}
	
	@Override
	public List<MotorVehicleAccident> findByPatientNumber(Long patientNumber){
		return motorVehicleAccidentRepository.findByPatientPatientNumber(patientNumber);
	}

	@Override
	public List<MotorVehicleAccident> getMotorVehicleAccidentSublist(List<Long> motorVehicleAccidentIdList) {

		List<MotorVehicleAccident> motorVehicleAccidentList = new ArrayList<MotorVehicleAccident>();
		
		for(Long motorVehicleAccidentId : motorVehicleAccidentIdList){
			motorVehicleAccidentList.add(getMotorVehicleAccident(motorVehicleAccidentId));
		}
		
		return motorVehicleAccidentList;
	}

}
