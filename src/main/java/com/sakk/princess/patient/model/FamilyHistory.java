package com.sakk.princess.patient.model;

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
 * FAMILY HISTORY
 */

@Entity
@Table(name = "FAMILYHISTORIES")
public class FamilyHistory extends BaseEntity {
	
	static Logger logger = LoggerFactory.getLogger(FamilyHistory.class);

	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "PATIENT_FAMILYHISTORIES", 
		joinColumns = { @JoinColumn(name = "FAMILYHISTORY_ID", referencedColumnName = "ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }
	)
	private Patient patient;

	@Column(name = "HEART_DISEASE", columnDefinition = "TINYINT(1)")
	private boolean heartDisease;

	@Column(name = "ARTHRITIS", columnDefinition = "TINYINT(1)")
	private boolean arthritis;

	@Column(name = "CANCER", columnDefinition = "TINYINT(1)")
	private boolean cancer;

	@Column(name = "DIABETES", columnDefinition = "TINYINT(1)")
	private boolean diabetes;

	@Column(name = "PSYCHOSOCIAL_DISEASE", columnDefinition = "TINYINT(1)")
	private boolean psychoSocialDisease;

	@Column(name = "OTHER", columnDefinition = "TINYINT(1)")
	private boolean other;

	@Column(name = "OTHER_DESCRIPTION")
	private String otherDescription;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean isFamilyHeartDisease() {
		return heartDisease;
	}

	public void setFamilyHeartDisease(boolean familyHeartDisease) {
		this.heartDisease = familyHeartDisease;
	}

	public boolean isArthritis() {
		return arthritis;
	}

	public void setArthritis(boolean arthritis) {
		this.arthritis = arthritis;
	}

	public boolean isCancer() {
		return cancer;
	}

	public void setCancer(boolean cancer) {
		this.cancer = cancer;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isPsychoSocialDisease() {
		return psychoSocialDisease;
	}

	public void setPsychoSocialDisease(boolean psychoSocialDisease) {
		this.psychoSocialDisease = psychoSocialDisease;
	}

	public boolean isOther() {
		return other;
	}

	public void setOther(boolean other) {
		this.other = other;
	}

	public void setOtherDescription(String otherDescription) {
		this.otherDescription = otherDescription;
	}

	public String getOtherDescription() {
		return this.otherDescription;
	}

}

