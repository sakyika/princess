package com.sakk.princess.patient.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sakk.princess.core.model.BaseEntity;

/**
 * MEDICAL HISTORY
 */

@Entity
@Table(name = "MEDICALHISTORIES")
public class MedicalHistory extends BaseEntity {

	static Logger logger = LoggerFactory.getLogger(MedicalHistory.class);

	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "PATIENT_MEDICALHISTORIES", joinColumns = {
			@JoinColumn(name = "MEDICALHISTORY_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") })
	private Patient patient;

	@Column(name = "FAMILY_DOCTOR_NAME")
	private String familyDoctorName;

	@Column(name = "FAMILY_DOCTOR_PHONE")
	private String familyDoctorPhone;

	@Column(name = "FAMILY_DOCTOR_ADDRESS")
	private String familyDoctoryAddress;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_FULL_CHECKUP")
	private Date lastFullCheckUp;

	@Column(name = "ON_MEDICATION", columnDefinition = "TINYINT(1)")
	private boolean onMedication;

	@Column(name = "MEDICATION_TYPE1")
	private String medicationType1;

	@Column(name = "MEDICATION_TYPE1_FOR")
	private String medicationType1For;

	@Column(name = "MEDICATION_TYPE1_DOSE")
	private String medicationType1Dose;

	@Column(name = "MEDICATION_TYPE1_FREQUENCY")
	private String medicationType1Frequency;

	@Column(name = "MEDICATION_TYPE2")
	private String medicationType2;

	@Column(name = "MEDICATION_TYPE2_FOR")
	private String medicationType2For;

	@Column(name = "MEDICATION_TYPE2_DOSE")
	private String medicationType2Dose;

	@Column(name = "MEDICATION_TYPE2_FREQUENCY")
	private String medicationType2Frequency;

	@Column(name = "SURGERY1")
	private String surgery1;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SURGERY1_DATE")
	private Date surgery1Date;

	@Column(name = "SURGERY1_COMPLICATIONS", columnDefinition = "TINYINT(1)")
	private boolean surgery1Complications;

	@Column(name = "SURGERY2")
	private String surgery2;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SURGERY2_DATE")
	private Date surgery2Date;

	@Column(name = "SURGERY2_COMPLICATIONS", columnDefinition = "TINYINT(1)")
	private boolean surgery2Complications;

	@Column(name = "VISION", columnDefinition = "TINYINT(1)")
	private boolean vision;

	@Column(name = "HEARING", columnDefinition = "TINYINT(1)")
	private boolean hearing;

	@Column(name = "SMELL", columnDefinition = "TINYINT(1)")
	private boolean smell;

	@Column(name = "TASTE", columnDefinition = "TINYINT(1)")
	private boolean taste;

	@Column(name = "DIZZINESS", columnDefinition = "TINYINT(1)")
	private boolean dizziness;

	@Column(name = "HEADACHES", columnDefinition = "TINYINT(1)")
	private boolean headaches;

	@Column(name = "DIFFICULTY_SWALLOWING", columnDefinition = "TINYINT(1)")
	private boolean difficultySwallowing;

	@Column(name = "LOSS_OF_BALANCE", columnDefinition = "TINYINT(1)")
	private boolean lossOfBalance;

	@Column(name = "NIGHT_SWEATS", columnDefinition = "TINYINT(1)")
	private boolean nightSweats;

	@Column(name = "DIABETES", columnDefinition = "TINYINT(1)")
	private boolean diabetes;

	@Column(name = "STROKE", columnDefinition = "TINYINT(1)")
	private boolean stroke;

	@Column(name = "ANEURYSM", columnDefinition = "TINYINT(1)")
	private boolean aneurysm;

	@Column(name = "HEART_CONDITION", columnDefinition = "TINYINT(1)")
	private boolean heartContition;

	@Column(name = "OSTEOPROSIS", columnDefinition = "TINYINT(1)")
	private boolean osteoprosis;

	@Column(name = "ARTHRITIS", columnDefinition = "TINYINT(1)")
	private boolean arthritis;

	@Column(name = "PROSTATE_DISORDER", columnDefinition = "TINYINT(1)")
	private boolean prostateDisorder;

	@Column(name = "MENSTRUAL_PROBLEMS", columnDefinition = "TINYINT(1)")
	private boolean menstrualProblems;

	@Column(name = "HEPATITIS", columnDefinition = "TINYINT(1)")
	private boolean hepatitis;

	@Column(name = "HIV_INFECTED", columnDefinition = "TINYINT(1)")
	private boolean hivInfected;

	@Column(name = "SHORTNESS_OF_BREATH", columnDefinition = "TINYINT(1)")
	private boolean shortnessOfBreath;

	@Column(name = "CANCER", columnDefinition = "TINYINT(1)")
	private boolean cancer;

	@Column(name = "STD", columnDefinition = "TINYINT(1)")
	private boolean std;

	@Column(name = "TUBERCULOSIS", columnDefinition = "TINYINT(1)")
	private boolean tuberculosis;

	@Column(name = "CHEST_PAIN", columnDefinition = "TINYINT(1)")
	private boolean chestPain;

	@Column(name = "HIGH_BLOOD_PRESSURE", columnDefinition = "TINYINT(1)")
	private boolean highBloodPressure;

	@Column(name = "DIGESTIVE_PROBLEMS", columnDefinition = "TINYINT(1)")
	private boolean digestiveProblems;

	@Column(name = "BOWL_PROBLEMS", columnDefinition = "TINYINT(1)")
	private boolean bowlProblems;

	@Column(name = "BLADDER_PROBLEMS", columnDefinition = "TINYINT(1)")
	private boolean bladderProblems;

	@Column(name = "SIGNIFICANT_WEIGHT_LOSS", columnDefinition = "TINYINT(1)")
	private boolean significantWeightLoss;

	@Column(name = "PINS_AND_NEEDLES_IN_ARM", columnDefinition = "TINYINT(1)")
	private boolean pinsAndNeedlesInArm;

	@Column(name = "NUMBNESS_IN_FINGERS", columnDefinition = "TINYINT(1)")
	private boolean numbnessInFingers;

	@Column(name = "WEAKNESS_IN_FINGERS", columnDefinition = "TINYINT(1)")
	private boolean weaknessInFingers;

	@Column(name = "NUMBNESS_IN_LEGS", columnDefinition = "TINYINT(1)")
	private boolean numblessInLegs;

	@Column(name = "WEAKNESS_IN_LEGS", columnDefinition = "TINYINT(1)")
	private boolean weaknessInLegs;

	@Column(name = "BACK_PAIN", columnDefinition = "TINYINT(1)")
	private boolean backPain;

	@Column(name = "NECK_PAIN", columnDefinition = "TINYINT(1)")
	private boolean neckPain;

	@Column(name = "TMJ_DISORDER", columnDefinition = "TINYINT(1)")
	private boolean tmjDisorder;

	@Column(name = "EAR_RINGING")
	private boolean earRinging;

	@Column(name = "OTHER", columnDefinition = "TINYINT(1)")
	private boolean other;

	@Column(name = "OTHER_DESCRIPTION")
	private String otherDescription;

	@Enumerated(EnumType.STRING)
	@Column(name = "PREGNANCY")
	private Pregnancy pregnancy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MENSTRUAL_CYCLE")
	private Date lastMenstrualPeriod;

	@Column(name = "ALLOWED_TO_CONTACT_MEDICALDOCTOR", columnDefinition = "TINYINT(1)")
	private boolean allowedToContactMedicalDoctor;

	/*
	 * public Integer getMedicalHistoryId() { return medicalHistoryId; }
	 * 
	 * public void setMedicalHistoryId(Integer medicalHistoryId) {
	 * this.medicalHistoryId = medicalHistoryId; }
	 */
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getFamilyDoctorName() {
		return familyDoctorName;
	}

	public void setFamilyDoctorName(String familyDoctorName) {
		this.familyDoctorName = familyDoctorName;
	}

	public String getFamilyDoctorPhone() {
		return familyDoctorPhone;
	}

	public void setFamilyDoctorPhone(String familyDoctorPhone) {
		this.familyDoctorPhone = familyDoctorPhone;
	}

	public String getFamilyDoctoryAddress() {
		return familyDoctoryAddress;
	}

	public void setFamilyDoctoryAddress(String familyDoctoryAddress) {
		this.familyDoctoryAddress = familyDoctoryAddress;
	}

	public Date getLastFullCheckUp() {
		return lastFullCheckUp;
	}

	public void setLastFullCheckUp(Date lastFullCheckUp) {
		this.lastFullCheckUp = lastFullCheckUp;
	}

	public boolean isOnMedication() {
		return onMedication;
	}

	public void setOnMedication(boolean onMedication) {
		this.onMedication = onMedication;
	}

	public String getMedicationType1() {
		return medicationType1;
	}

	public void setMedicationType1(String medicationType1) {
		this.medicationType1 = medicationType1;
	}

	public String getMedicationType1For() {
		return medicationType1For;
	}

	public void setMedicationType1For(String medicationType1For) {
		this.medicationType1For = medicationType1For;
	}

	public String getMedicationType1Dose() {
		return medicationType1Dose;
	}

	public void setMedicationType1Dose(String medicationType1Dose) {
		this.medicationType1Dose = medicationType1Dose;
	}

	public String getMedicationType1Frequency() {
		return medicationType1Frequency;
	}

	public void setMedicationType1Frequency(String medicationType1Frequency) {
		this.medicationType1Frequency = medicationType1Frequency;
	}

	public String getMedicationType2() {
		return medicationType2;
	}

	public void setMedicationType2(String medicationType2) {
		this.medicationType2 = medicationType2;
	}

	public String getMedicationType2For() {
		return medicationType2For;
	}

	public void setMedicationType2For(String medicationType2For) {
		this.medicationType2For = medicationType2For;
	}

	public String getMedicationType2Dose() {
		return medicationType2Dose;
	}

	public void setMedicationType2Dose(String medicationType2Dose) {
		this.medicationType2Dose = medicationType2Dose;
	}

	public String getMedicationType2Frequency() {
		return medicationType2Frequency;
	}

	public void setMedicationType2Frequency(String medicationType2Frequency) {
		this.medicationType2Frequency = medicationType2Frequency;
	}

	public String getSurgery1() {
		return surgery1;
	}

	public void setSurgery1(String surgery1) {
		this.surgery1 = surgery1;
	}

	public Date getSurgery1Date() {
		return surgery1Date;
	}

	public void setSurgery1Date(Date surgery1Date) {
		this.surgery1Date = surgery1Date;
	}

	public boolean isSurgery1Complications() {
		return surgery1Complications;
	}

	public void setSurgery1Complications(boolean surgery1Complications) {
		this.surgery1Complications = surgery1Complications;
	}

	public String getSurgery2() {
		return surgery2;
	}

	public void setSurgery2(String surgery2) {
		this.surgery2 = surgery2;
	}

	public Date getSurgery2Date() {
		return surgery2Date;
	}

	public void setSurgery2Date(Date surgery2Date) {
		this.surgery2Date = surgery2Date;
	}

	public boolean isSurgery2Complications() {
		return surgery2Complications;
	}

	public void setSurgery2Complications(boolean surgery2Complications) {
		this.surgery2Complications = surgery2Complications;
	}

	public boolean isVision() {
		return vision;
	}

	public void setVision(boolean vision) {
		this.vision = vision;
	}

	public boolean isHearing() {
		return hearing;
	}

	public void setHearing(boolean hearing) {
		this.hearing = hearing;
	}

	public boolean isSmell() {
		return smell;
	}

	public void setSmell(boolean smell) {
		this.smell = smell;
	}

	public boolean isTaste() {
		return taste;
	}

	public void setTaste(boolean taste) {
		this.taste = taste;
	}

	public boolean isDizziness() {
		return dizziness;
	}

	public void setDizziness(boolean dizziness) {
		this.dizziness = dizziness;
	}

	public boolean isHeadaches() {
		return headaches;
	}

	public void setHeadaches(boolean headaches) {
		this.headaches = headaches;
	}

	public boolean isDifficultySwallowing() {
		return difficultySwallowing;
	}

	public void setDifficultySwallowing(boolean difficultySwallowing) {
		this.difficultySwallowing = difficultySwallowing;
	}

	public boolean isLossOfBalance() {
		return lossOfBalance;
	}

	public void setLossOfBalance(boolean lossOfBalance) {
		this.lossOfBalance = lossOfBalance;
	}

	public boolean isNightSweats() {
		return nightSweats;
	}

	public void setNightSweats(boolean nightSweats) {
		this.nightSweats = nightSweats;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isStroke() {
		return stroke;
	}

	public void setStroke(boolean stroke) {
		this.stroke = stroke;
	}

	public boolean isAneurysm() {
		return aneurysm;
	}

	public void setAneurysm(boolean aneurysm) {
		this.aneurysm = aneurysm;
	}

	public boolean isHeartContition() {
		return heartContition;
	}

	public void setHeartContition(boolean heartContition) {
		this.heartContition = heartContition;
	}

	public boolean isOsteoprosis() {
		return osteoprosis;
	}

	public void setOsteoprosis(boolean osteoprosis) {
		this.osteoprosis = osteoprosis;
	}

	public boolean isArthritis() {
		return arthritis;
	}

	public void setArthritis(boolean arthritis) {
		this.arthritis = arthritis;
	}

	public boolean isProstateDisorder() {
		return prostateDisorder;
	}

	public void setProstateDisorder(boolean prostateDisorder) {
		this.prostateDisorder = prostateDisorder;
	}

	public boolean isMenstrualProblems() {
		return menstrualProblems;
	}

	public void setMenstrualProblems(boolean menstrualProblems) {
		this.menstrualProblems = menstrualProblems;
	}

	public boolean isHepatitis() {
		return hepatitis;
	}

	public void setHepatitis(boolean hepatitis) {
		this.hepatitis = hepatitis;
	}

	public boolean isHivInfected() {
		return hivInfected;
	}

	public void setHivInfected(boolean hivInfected) {
		this.hivInfected = hivInfected;
	}

	public boolean isShortnessOfBreath() {
		return shortnessOfBreath;
	}

	public void setShortnessOfBreath(boolean shortnessOfBreath) {
		this.shortnessOfBreath = shortnessOfBreath;
	}

	public boolean isCancer() {
		return cancer;
	}

	public void setCancer(boolean cancer) {
		this.cancer = cancer;
	}

	public boolean isStd() {
		return std;
	}

	public void setStd(boolean std) {
		this.std = std;
	}

	public boolean isTuberculosis() {
		return tuberculosis;
	}

	public void setTuberculosis(boolean tuberculosis) {
		this.tuberculosis = tuberculosis;
	}

	public boolean isChestPain() {
		return chestPain;
	}

	public void setChestPain(boolean chestPain) {
		this.chestPain = chestPain;
	}

	public boolean isHighBloodPressure() {
		return highBloodPressure;
	}

	public void setHighBloodPressure(boolean highBloodPressure) {
		this.highBloodPressure = highBloodPressure;
	}

	public boolean isDigestiveProblems() {
		return digestiveProblems;
	}

	public void setDigestiveProblems(boolean digestiveProblems) {
		this.digestiveProblems = digestiveProblems;
	}

	public boolean isBowlProblems() {
		return bowlProblems;
	}

	public void setBowlProblems(boolean bowlProblems) {
		this.bowlProblems = bowlProblems;
	}

	public boolean isBladderProblems() {
		return bladderProblems;
	}

	public void setBladderProblems(boolean bladderProblems) {
		this.bladderProblems = bladderProblems;
	}

	public boolean isSignificantWeightLoss() {
		return significantWeightLoss;
	}

	public void setSignificantWeightLoss(boolean significantWeightLoss) {
		this.significantWeightLoss = significantWeightLoss;
	}

	public boolean isPinsAndNeedlesInArm() {
		return pinsAndNeedlesInArm;
	}

	public void setPinsAndNeedlesInArm(boolean pinsAndNeedlesInArm) {
		this.pinsAndNeedlesInArm = pinsAndNeedlesInArm;
	}

	public boolean isNumbnessInFingers() {
		return numbnessInFingers;
	}

	public void setNumbnessInFingers(boolean numbnessInFingers) {
		this.numbnessInFingers = numbnessInFingers;
	}

	public boolean isWeaknessInFingers() {
		return weaknessInFingers;
	}

	public void setWeaknessInFingers(boolean weaknessInFingers) {
		this.weaknessInFingers = weaknessInFingers;
	}

	public boolean isNumblessInLegs() {
		return numblessInLegs;
	}

	public void setNumblessInLegs(boolean numblessInLegs) {
		this.numblessInLegs = numblessInLegs;
	}

	public boolean isWeaknessInLegs() {
		return weaknessInLegs;
	}

	public void setWeaknessInLegs(boolean weaknessInLegs) {
		this.weaknessInLegs = weaknessInLegs;
	}

	public boolean isBackPain() {
		return backPain;
	}

	public void setBackPain(boolean backPain) {
		this.backPain = backPain;
	}

	public boolean isNeckPain() {
		return neckPain;
	}

	public void setNeckPain(boolean neckPain) {
		this.neckPain = neckPain;
	}

	public boolean isTmjDisorder() {
		return tmjDisorder;
	}

	public void setTmjDisorder(boolean tmjDisorder) {
		this.tmjDisorder = tmjDisorder;
	}

	public boolean isEarRinging() {
		return earRinging;
	}

	public void setEarRinging(boolean earRinging) {
		this.earRinging = earRinging;
	}

	public boolean isOther() {
		return other;
	}

	public void setOther(boolean other) {
		this.other = other;
	}

	public String getOtherDescription() {
		return otherDescription;
	}

	public void setOtherDescription(String otherDescription) {
		this.otherDescription = otherDescription;
	}

	public Pregnancy getPregnancy() {
		return pregnancy;
	}

	public void setPregnancy(Pregnancy pregnancy) {
		this.pregnancy = pregnancy;
	}

	public Date getLastMenstrualPeriod() {
		return lastMenstrualPeriod;
	}

	public void setLastMenstrualPeriod(Date lastMenstrualPeriod) {
		this.lastMenstrualPeriod = lastMenstrualPeriod;
	}

	public boolean isChiropractorToContactMedicalDoctor() {
		return allowedToContactMedicalDoctor;
	}

	public void setChiropractorToContactMedicalDoctor(boolean chiropractorToContactMedicalDoctor) {
		this.allowedToContactMedicalDoctor = chiropractorToContactMedicalDoctor;
	}

}
