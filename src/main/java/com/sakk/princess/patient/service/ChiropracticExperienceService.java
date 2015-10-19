package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.ChiropracticExperience;

public interface ChiropracticExperienceService {

	List<ChiropracticExperience> findAllChiropracticExperiences();

	public ChiropracticExperience addChiropracticExperience(ChiropracticExperience chiropracticExperience);

	public ChiropracticExperience getChiropracticExperience(Long chiropracticExperienceId);

	public ChiropracticExperience updateChiropracticExperience(Long chiropracticExperienceId,
			ChiropracticExperience chiropracticExperience);

	public ChiropracticExperience deleteChiropracticExperience(Long chiropracticExperienceId);

	public List<ChiropracticExperience> getChiropracticExperiences();

	public List<ChiropracticExperience> findByPatientNumber(Long patientNumber);

	public List<ChiropracticExperience> getChiropracticExperienceSublist(List<Long> chiropracticExperienceIdList);

}
