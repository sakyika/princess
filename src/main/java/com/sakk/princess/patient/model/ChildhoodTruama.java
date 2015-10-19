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
 * PAST CHILDHOOD
 */

@Entity
@Table(name = "CHILDHOODTRUAMAS")
public class ChildhoodTruama extends BaseEntity {

	static Logger logger = LoggerFactory.getLogger(ChildhoodTruama.class);

	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "PATIENT_CHILDHOODTRUAMAS", joinColumns = {
			@JoinColumn(name = "CHILDHOODTRUAMA_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") })
	private Patient patient;

	@Column(name = "CHILDHOODTRUAMA", columnDefinition = "TINYINT(1)")
	private boolean childhoodTruama;

	@Temporal(TemporalType.DATE)
	@Column(name = "TRUAMA_DATE")
	private Date truamaDate;

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

	public boolean isChildhoodTruama() {
		return childhoodTruama;
	}

	public void setChildhoodTruama(boolean childhoodTruama) {
		this.childhoodTruama = childhoodTruama;
	}

	public Date getTruamaDate() {
		return truamaDate;
	}

	public void setTruamaDate(Date truamaDate) {
		this.truamaDate = truamaDate;
	}

	public String getBodyPartsInjured() {
		return bodyPartsInjured;
	}

	public void setBodyPartsInjured(String bodyPartsInjured) {
		this.bodyPartsInjured = bodyPartsInjured;
	}

	public boolean isInjuriesResolved() {
		return injuriesResolved;
	}

	public void setInjuriesResolved(boolean injuriesResolved) {
		this.injuriesResolved = injuriesResolved;
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
