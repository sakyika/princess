package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.HealthHabitRepository;
import com.sakk.princess.patient.model.HealthHabit;
import com.sakk.princess.patient.service.HealthHabitService;

@Service
@Transactional
public class HealthHabitServiceImpl implements HealthHabitService {

	static Logger logger = LoggerFactory.getLogger(HealthHabitServiceImpl.class);

	@Autowired
	HealthHabitRepository healthHabitRepository;

	@Override
	public List<HealthHabit> findAllChildhoodTruama() {
		return getHealthHabits();
	}

	@Override
	public HealthHabit addHealthHabit(HealthHabit healthHabit) {
		return healthHabitRepository.save(healthHabit);
	}

	@Override
	public HealthHabit getHealthHabit(Long healthHabitId) {
		return healthHabitRepository.getOne(healthHabitId);
	}

	@Override
	public HealthHabit updateHealthHabit(HealthHabit healthHabit) {

		HealthHabit healthHabitToUpdate = getHealthHabit(healthHabit.getId());

		if (healthHabitToUpdate != null) {
			/*
			 * healthHabitToUpdate.setDidDoDrink(healthHabitToUpdate.
			 * isDidDoDrink());
			 * healthHabitToUpdate.setDidDoDrinkHowMuch(healthHabitToUpdate.
			 * getDidDoDrinkHowMuch());
			 * healthHabitToUpdate.setDidDoWearOrthodics(healthHabitToUpdate.
			 * isDidDoWearOrthodics());
			 * healthHabitToUpdate.setExerciseFrequency(healthHabitToUpdate.
			 * getExerciseFrequency());
			 * healthHabitToUpdate.setExerciseRegularly(healthHabitToUpdate.
			 * isExerciseRegularly());
			 * healthHabitToUpdate.setGlassesOfWaterPerDay(healthHabitToUpdate.
			 * getGlassesOfWaterPerDay());
			 * healthHabitToUpdate.setId(healthHabitToUpdate.getId());
			 * healthHabitToUpdate.setNonMedicalCare(healthHabitToUpdate.
			 * isNonMedicalCare());
			 * healthHabitToUpdate.setNonMedicalCareDescription(
			 * healthHabitToUpdate.getNonMedicalCareDescription());
			 * healthHabitToUpdate.setNumberOfPillows(healthHabitToUpdate.
			 * getNumberOfPillows());
			 * healthHabitToUpdate.setPatientInfo(healthHabitToUpdate.
			 * getPatientInfo());
			 * healthHabitToUpdate.setSleepPosition(healthHabitToUpdate.
			 * getSleepPosition());
			 * healthHabitToUpdate.setSmoke(healthHabitToUpdate.isSmoke());
			 * healthHabitToUpdate.setSmokeQuantity(healthHabitToUpdate.
			 * getSmokeQuantity());
			 * healthHabitToUpdate.setSportsExerciseActivity(healthHabitToUpdate
			 * .getSportsExerciseActivity());
			 */

			healthHabitRepository.saveAndFlush(healthHabit);

		}

		return healthHabitToUpdate;
	}

	@Override
	public HealthHabit deleteHealthHabit(Long healthHabitId) {

		HealthHabit healthHabitToDelete = healthHabitRepository.getOne(healthHabitId);

		if (healthHabitToDelete != null) {
			healthHabitRepository.delete(healthHabitToDelete);
		}

		return healthHabitToDelete;
	}

	@Override
	public List<HealthHabit> getHealthHabits() {
		return healthHabitRepository.findAll();
	}

	@Override
	public List<HealthHabit> findByPatientNumber(Long patientNumber) {
		return healthHabitRepository.findByPatientPatientNumber(patientNumber);
	}

	@Override
	public List<HealthHabit> getHealthHabitSublist(List<Long> healthHabitIdList) {

		List<HealthHabit> healthhabitList = new ArrayList<HealthHabit>();

		for (Long healthHabitId : healthHabitIdList) {
			healthhabitList.add(getHealthHabit(healthHabitId));
		}

		return healthhabitList;
	}

}
