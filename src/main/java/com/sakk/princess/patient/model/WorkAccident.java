package com.sakk.princess.patient.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sakk.princess.core.model.BaseEntity;

/**
 * PAST WORK ACCIDENTS
 */

@Entity
@Table(name = "WORKACCIDENTS")
public class WorkAccident extends BaseEntity {

	static Logger logger = LoggerFactory.getLogger(WorkAccident.class);

	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "PATIENT_WORKACCIDENTS", joinColumns = {
			@JoinColumn(name = "WORKACCIDENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") })
	private Patient patient;

	@Column(name = "WORK_ACCIDENT", columnDefinition = "TINYINT(1)")
	private boolean workAccident;

	@Column(name = "ACCIDENT_DATE")
	private Date accidentDate;

	@Column(name = "EMPLOYER")
	private String employer;

	@Column(name = "WSIB_CLAIM", columnDefinition = "TINYINT(1)")
	private boolean wsibClaim;

	@Column(name = "DISABILITY", columnDefinition = "TINYINT(1)")
	private boolean disability;

	@Column(name = "DISABILITIES")
	private String permanentOrPartialDisability;

	@Column(name = "BODYPARTS_INJURED")
	private String bodyPartsInjured;

	@Column(name = "XRAY_TAKEN", columnDefinition = "TINYINT(1)")
	private boolean xrayTaken;

	@Column(name = "BRIEF_ACCOUNT")
	private String briefAccount;
	
	@Column(name = "MEDICAL_CARE_RECEIVED", columnDefinition = "TINYINT(1)")
	private boolean medicalCareReceived;

	@Column(name = "CARE_GIVEN_BY_DOCTOR")
	private String careGivenByDoctor;

	@Column(name = "CARE_TYPE_GIVEN")
	private String careGivenType;

	@Column(name = "INJURIES_SUSTAINED")
	private String injuriesSustained;

	@Column(name = "INJURIES_RESOLVED", columnDefinition = "TINYINT(1)")
	private boolean injuriesResolved;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean isWorkAccident() {
		return workAccident;
	}

	public void setWorkAccident(boolean workAccident) {
		this.workAccident = workAccident;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public boolean isWsibClaim() {
		return wsibClaim;
	}

	public boolean isDisability() {
		return disability;
	}

	public void setDisability(boolean disability) {
		this.disability = disability;
	}

	public void setWSIBClaim(boolean wsibClaim) {
		this.wsibClaim = wsibClaim;
	}

	public String getPermanentOrPartialDisability() {
		return permanentOrPartialDisability;
	}

	public void setPermanentOrPartialDisability(String permanentOrPartialDisability) {
		this.permanentOrPartialDisability = permanentOrPartialDisability;
	}

	public String getBodyPartsInjured() {
		return bodyPartsInjured;
	}

	public void setBodyPartsInjured(String bodyPartsInjured) {
		this.bodyPartsInjured = bodyPartsInjured;
	}

	public boolean isXrayTaken() {
		return xrayTaken;
	}

	public void setXrayTaken(boolean xrayTaken) {
		this.xrayTaken = xrayTaken;
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

	public String getCareGivenType() {
		return careGivenType;
	}

	public void setCareGivenType(String careGivenType) {
		this.careGivenType = careGivenType;
	}

	public String getInjuriesSustained() {
		return injuriesSustained;
	}

	public void setInjuriesSustained(String injuriesSustained) {
		this.injuriesSustained = injuriesSustained;
	}

	public boolean isInjuriesResolved() {
		return injuriesResolved;
	}

	public void setInjuriesResolved(boolean injuriesResolved) {
		this.injuriesResolved = injuriesResolved;
	}

}
