package com.sakk.princess.patient.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * PREVIOUS CHIROPRACTIC EXPERIENCE
 */

@Entity
@Table(name = "CHIROPRACTICEXPERIENCES")
public class ChiropracticExperience extends BaseEntity {

	static Logger logger = LoggerFactory.getLogger(ChiropracticExperience.class);

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonBackReference
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JoinTable(name = "PATIENT_CHIROPRACTICEXPERIENCES", joinColumns = {
			@JoinColumn(name = "CHIROPRACTICEXPERIENCE_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") })
	private Patient patient;

	@Column(name = "NAME", length = 50)
	private String previousChiropractorName;

	@Column(name = "LOCATION", length = 100)
	private String previousChiropractorLocation;

	@Column(name = "PHONE")
	private String previousChiropractorPhone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_VISIT")
	private Date lastChiropractorVisit;

	@Column(name = "XRAY_TAKEN", columnDefinition = "TINYINT(1)")
	private boolean xRayTaken;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getPreviousChiropractorName() {
		return previousChiropractorName;
	}

	public void setPreviousChiropractorName(String previousChiropractorName) {
		this.previousChiropractorName = previousChiropractorName;
	}

	public String getPreviousChiropractorLocation() {
		return previousChiropractorLocation;
	}

	public void setPreviousChiropractorLocation(String previousChiropractorLocation) {
		this.previousChiropractorLocation = previousChiropractorLocation;
	}

	public String getPreviousChiropractorPhone() {
		return previousChiropractorPhone;
	}

	public void setPreviousChiropractorPhone(String previousChiropractorPhone) {
		this.previousChiropractorPhone = previousChiropractorPhone;
	}

	public Date getLastChiropractorVisit() {
		return lastChiropractorVisit;
	}

	public void setLastChiropractorVisit(Date lastChiropractorVisit) {
		this.lastChiropractorVisit = lastChiropractorVisit;
	}

	public boolean isxRayTaken() {
		return xRayTaken;
	}

	public void setxRayTaken(boolean xRayTaken) {
		this.xRayTaken = xRayTaken;
	}

}
