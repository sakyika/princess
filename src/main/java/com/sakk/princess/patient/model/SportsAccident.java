package com.sakk.princess.patient.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * PAST SPORTS ACCIDENT
 */

@Entity
@Table(name = "SPORTSACCIDENTS")
public class SportsAccident extends BaseEntity {

	static Logger logger = LoggerFactory.getLogger(SportsAccident.class);

	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "PATIENT_SPORTSACCIDENTS", joinColumns = {
			@JoinColumn(name = "SPORTSACCIDENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") })
	private Patient patient;

	@Column(name = "SPORTS_ACCIDENT", columnDefinition = "TINYINT(1)")
	private boolean sportsAccident;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACCIDENT_DATE")
	private Date accidentDate;

	@Column(name = "BODYPARTS_INJURED")
	private String bodyPartsInjured;

	@Column(name = "INJURIES_RESOLVED", columnDefinition = "TINYINT(1)")
	private boolean injuriesResolved;

	@Column(name = "BRIEF_ACCOUNT")
	private String briefAccount;

	@Column(name = "MEDICAL_CARE_RECEIVED", columnDefinition = "TINYINT(1)")
	private boolean medicalCareReceived;

	@Column(name = "CARE_GIVEN_BY_DOCTOR")
	private String careGivenByDoctor;

	@Column(name = "CARE_TYPE_GIVEN")
	private String careTypeGiven;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean isSportsAccident() {
		return sportsAccident;
	}

	public void setSportsAccident(boolean accidentDate) {
		this.sportsAccident = accidentDate;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setSportsAccidentDate(Date sportsAccidentDate) {
		this.accidentDate = sportsAccidentDate;
	}

	public String getBodyPartsInjured() {
		return bodyPartsInjured;
	}

	public void setBodyPartInjured(String bodyPartsInjured) {
		this.bodyPartsInjured = bodyPartsInjured;
	}

	public boolean isInjuriesResolved() {
		return injuriesResolved;
	}

	public void setInjuryResolved(boolean injuryResolved) {
		this.injuriesResolved = injuryResolved;
	}

	public String getBriefAccount() {
		return briefAccount;
	}

	public void setBriefAccount(String briefAccount) {
		this.briefAccount = briefAccount;
	}

	public boolean isMedicalCareReceived() {
		return medicalCareReceived;
	}

	public void setMedicalCareReceived(boolean medicalCareReceived) {
		this.medicalCareReceived = medicalCareReceived;
	}

	public String getCareGivenByDoctor() {
		return careGivenByDoctor;
	}

	public void setCareGivenByDoctor(String careGivenByDoctor) {
		this.careGivenByDoctor = careGivenByDoctor;
	}

	public String getCareTypeGiven() {
		return careTypeGiven;
	}

	public void setCareTypeGiven(String careTypeGiven) {
		this.careTypeGiven = careTypeGiven;
	}

}
