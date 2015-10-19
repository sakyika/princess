package com.sakk.princess.patient.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.patient.model.HealthHabit;

public class HealthHabitResource extends Resource<HealthHabit> {

	HealthHabitResource() {
		super(new HealthHabit());
	}
	
	public HealthHabitResource(HealthHabit healthHabbit) {
		super(healthHabbit);
	}
	
	public HealthHabit toHealthHabit(){
		
		HealthHabit healthHabit = new HealthHabit();
		
		healthHabit.setDidDoDrink(super.getContent().isDidDoDrink());
		healthHabit.setDidDoDrinkHowMuch(super.getContent().getDidDoDrinkHowMuch());
		healthHabit.setDidDoWearOrthodics(super.getContent().isDidDoWearOrthodics());
		healthHabit.setExerciseFrequency(super.getContent().getExerciseFrequency());
		healthHabit.setExerciseRegularly(super.getContent().isExerciseRegularly());
		healthHabit.setGlassesOfWaterPerDay(super.getContent().getGlassesOfWaterPerDay());
		healthHabit.setId(super.getContent().getId());
		healthHabit.setNonMedicalCare(super.getContent().isNonMedicalCare());
		healthHabit.setNonMedicalCareDescription(super.getContent().getNonMedicalCareDescription());
		healthHabit.setNumberOfPillows(super.getContent().getNumberOfPillows());
		healthHabit.setPatient(super.getContent().getPatient());
		healthHabit.setSleepPosition(super.getContent().getSleepPosition());
		healthHabit.setSmoke(super.getContent().isSmoke());
		healthHabit.setSmokeQuantity(super.getContent().getSmokeQuantity());
		healthHabit.setSportsExerciseActivity(super.getContent().getSportsExerciseActivity());
		
		return healthHabit;
		
	}

}
