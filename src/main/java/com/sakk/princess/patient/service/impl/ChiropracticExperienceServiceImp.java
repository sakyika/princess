package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.ChiropracticExperienceRepository;
import com.sakk.princess.patient.model.ChiropracticExperience;
import com.sakk.princess.patient.service.ChiropracticExperienceService;
import com.sakk.princess.patient.service.impl.ChildhoodTruamaServiceIml;

@Service
@Transactional
public class ChiropracticExperienceServiceImp implements ChiropracticExperienceService {

	static Logger logger = LoggerFactory.getLogger(ChildhoodTruamaServiceIml.class);

	@Autowired
	ChiropracticExperienceRepository chiropracticExperienceRepository;

	@Override
	public List<ChiropracticExperience> findAllChiropracticExperiences() {
		return getChiropracticExperiences();
	}

	@Override
	public ChiropracticExperience addChiropracticExperience(ChiropracticExperience chiropracticExperience) {
		return chiropracticExperienceRepository.save(chiropracticExperience);
	}

	@Override
	public ChiropracticExperience getChiropracticExperience(Long chiropracticExperienceId) {

		return chiropracticExperienceRepository.getOne(chiropracticExperienceId);
	}

	@Override
	public ChiropracticExperience updateChiropracticExperience(Long chiropracticExperienceId,
			ChiropracticExperience chiropracticExperience) {

		ChiropracticExperience chiropracticExperienceToUpdate = getChiropracticExperience(chiropracticExperienceId);

		if (chiropracticExperienceToUpdate != null) {
			
			chiropracticExperienceToUpdate.setLastChiropractorVisit(chiropracticExperience.getLastChiropractorVisit());
			chiropracticExperienceToUpdate.setPatient(chiropracticExperience.getPatient());
			chiropracticExperienceToUpdate
					.setPreviousChiropractorName(chiropracticExperience.getPreviousChiropractorName());
			chiropracticExperienceToUpdate
					.setPreviousChiropractorLocation(chiropracticExperience.getPreviousChiropractorLocation());
			chiropracticExperienceToUpdate
					.setPreviousChiropractorPhone(chiropracticExperience.getPreviousChiropractorPhone());
			chiropracticExperienceToUpdate.setxRayTaken(chiropracticExperience.isxRayTaken());

			chiropracticExperienceRepository.saveAndFlush(chiropracticExperienceToUpdate);
		}

		return chiropracticExperienceToUpdate;
	}

	@Override
	public ChiropracticExperience deleteChiropracticExperience(Long chiropracticExperienceId) {

		ChiropracticExperience chiropracticExperienceToDelete = new ChiropracticExperience();

		if (chiropracticExperienceToDelete != null) {
			chiropracticExperienceRepository.delete(chiropracticExperienceToDelete);
		}

		return chiropracticExperienceToDelete;
	}

	@Override
	public List<ChiropracticExperience> getChiropracticExperiences() {
		return chiropracticExperienceRepository.findAll();
	}

	@Override
	public List<ChiropracticExperience> getChiropracticExperienceSublist(List<Long> chiropracticExperienceIdList) {

		List<ChiropracticExperience> chiropracticExperienceList = new ArrayList<ChiropracticExperience>();

		for (Long chiropracticExperienceId : chiropracticExperienceIdList) {
			chiropracticExperienceList.add(getChiropracticExperience(chiropracticExperienceId));
		}

		return chiropracticExperienceList;
	}

	@Override
	public List<ChiropracticExperience> findByPatientNumber(Long patientNumber) {

		return chiropracticExperienceRepository.findByPatientPatientNumber(patientNumber);
	}

}
