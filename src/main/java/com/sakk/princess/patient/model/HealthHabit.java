package com.sakk.princess.patient.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sakk.princess.core.model.BaseEntity;

/**
 * HEALTH HABITS
 */

@Entity
@Table(name = "HEALTHHABITS")
public class HealthHabit extends BaseEntity {

	static Logger logger = LoggerFactory.getLogger(HealthHabit.class);

	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "PATIENT_HEALTHHABITS", joinColumns = {
			@JoinColumn(name = "HEALTHHABIT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") })
	private Patient patient;

	@Column(name = "SMOKER", columnDefinition = "TINYINT(1)")
	private boolean smoke;

	@Column(name = "SMOKE_QUANTITY")
	private String smokeQuantity;

	@Column(name = "DID_DO_DRINK", columnDefinition = "TINYINT(1)")
	private boolean didDoDrink;

	@Column(name = "AMOUNT_OF_DRINKS")
	private String didDoDrinkHowMuch;

	@Column(name = "AMOUNT_OF_WATER")
	private String glassesOfWaterPerDay;

	@Column(name = "SPORTS_EXERCISE_ACTIVITY")
	private String sportsExerciseActivity;

	@Column(name = "EXERCISE_REGULARLY", columnDefinition = "TINYINT(1)")
	private boolean exerciseRegularly;

	@Column(name = "EXERCISE_FREQUENCY")
	private String exerciseFrequency;

	@Enumerated(EnumType.STRING)
	@Column(name = "SLEEP_POSITION")
	private SleepPosition sleepPosition;

	@Column(name = "NUMBER_OF_PILLOWS")
	private String numberOfPillows;

	@Column(name = "DID_DO_WEAR_ORTHODICS", columnDefinition = "TINYINT(1)")
	private boolean didDoWearOrthodics;

	@Column(name = "NON_MEDICAL_CARE", columnDefinition = "TINYINT(1)")
	private boolean nonMedicalCare;

	public String getNonMedicalCareDescription() {
		return nonMedicalCareDescription;
	}

	public void setNonMedicalCareDescription(String nonMedicalCareDescription) {
		this.nonMedicalCareDescription = nonMedicalCareDescription;
	}

	@Column(name = "NON_MEDICAL_CARE_DESCRIPTION")
	private String nonMedicalCareDescription;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean isSmoke() {
		return smoke;
	}

	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
	}

	public String getSmokeQuantity() {
		return smokeQuantity;
	}

	public void setSmokeQuantity(String smokeQuantity) {
		this.smokeQuantity = smokeQuantity;
	}

	public boolean isDidDoDrink() {
		return didDoDrink;
	}

	public void setDidDoDrink(boolean didDoDrink) {
		this.didDoDrink = didDoDrink;
	}

	public String getDidDoDrinkHowMuch() {
		return didDoDrinkHowMuch;
	}

	public void setDidDoDrinkHowMuch(String didDoDrinkHowMuch) {
		this.didDoDrinkHowMuch = didDoDrinkHowMuch;
	}

	public String getGlassesOfWaterPerDay() {
		return glassesOfWaterPerDay;
	}

	public void setGlassesOfWaterPerDay(String glassesOfWaterPerDay) {
		this.glassesOfWaterPerDay = glassesOfWaterPerDay;
	}

	public String getSportsExerciseActivity() {
		return sportsExerciseActivity;
	}

	public void setSportsExerciseActivity(String sportsExerciseActivity) {
		this.sportsExerciseActivity = sportsExerciseActivity;
	}

	public boolean isExerciseRegularly() {
		return exerciseRegularly;
	}

	public void setExerciseRegularly(boolean exerciseRegularly) {
		this.exerciseRegularly = exerciseRegularly;
	}

	public String getExerciseFrequency() {
		return exerciseFrequency;
	}

	public void setExerciseFrequency(String exerciseFrequency) {
		this.exerciseFrequency = exerciseFrequency;
	}

	public SleepPosition getSleepPosition() {
		return sleepPosition;
	}

	public void setSleepPosition(SleepPosition sleepPosition) {
		this.sleepPosition = sleepPosition;
	}

	public String getNumberOfPillows() {
		return numberOfPillows;
	}

	public void setNumberOfPillows(String numberOfPillows) {
		this.numberOfPillows = numberOfPillows;
	}

	public boolean isDidDoWearOrthodics() {
		return didDoWearOrthodics;
	}

	public void setDidDoWearOrthodics(boolean didDoWearOrthodics) {
		this.didDoWearOrthodics = didDoWearOrthodics;
	}

	public boolean isNonMedicalCare() {
		return nonMedicalCare;
	}

	public void setNonMedicalCare(boolean noneMedicalCare) {
		this.nonMedicalCare = noneMedicalCare;
	}

}
