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
 * CURRENT CONDITION/PRESENT COMPLAINT
 */

@Entity
@Table(name = "COMPLAINTS")
public class Complaint extends BaseEntity {

	static Logger logger = LoggerFactory.getLogger(Complaint.class);

	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "PATIENT_COMPLAINTS", joinColumns = {
			@JoinColumn(name = "COMPLAINT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") })
	private Patient patient;

	@Column(name = "SHARP", columnDefinition = "TINYINT(1)")
	private boolean sharp;

	@Column(name = "DULL", columnDefinition = "TINYINT(1)")
	private boolean dull;

	@Column(name = "THROBBING", columnDefinition = "TINYINT(1)")
	private boolean throbbing;

	@Column(name = "ACHING", columnDefinition = "TINYINT(1)")
	private boolean aching;

	@Column(name = "BURNING", columnDefinition = "TINYINT(1)")
	private boolean burning;

	@Column(name = "STABBING", columnDefinition = "TINYINT(1)")
	private boolean stabbing;

	@Column(name = "WEAKNESS", columnDefinition = "TINYINT(1)")
	private boolean weakness;

	@Column(name = "NUMBNESS", columnDefinition = "TINYINT(1)")
	private boolean numbness;

	@Column(name = "TINGLING", columnDefinition = "TINYINT(1)")
	private boolean tingling;

	@Column(name = "OTHER", columnDefinition = "TINYINT(1)")
	private boolean other;

	@Column(name = "OTHER_DESCRIPTION")
	private String otherDescription;

	@Column(name = "LOCATION")
	private String location;

	@Temporal(TemporalType.DATE)
	@Column(name = "COMPLAINT_DATE")
	private Date complaintDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "PREVIOUS_OCCURANCE", columnDefinition = "TINYINT(1)")
	private boolean previousOccurance;

	@Temporal(TemporalType.DATE)
	@Column(name = "PREVIOUS_OCCURANCE_DATE")
	private Date previousOccuranceDate;

	@Column(name = "HOW_IT_HAPPENED")
	private String howItHappened;

	@Column(name = "WHAT_MAKES_WORST")
	private String whatMakesWorst;

	@Column(name = "WHAT_MAKES_BETTER")
	private String whatMakesBetter;

	@Column(name = "PAIN_RADIATES", columnDefinition = "TINYINT(1)")
	private boolean painRadiates;

	@Column(name = "PAIN_RADIATES_WHERE")
	private String painRadiatesWhere;

	@Enumerated(EnumType.STRING)
	@Column(name = "PAIN_PATTERN")
	private PainPattern painPattern;

	@Enumerated(EnumType.STRING)
	@Column(name = "PAIN_SCALE")
	private PainScale painScale;

	@Enumerated(EnumType.STRING)
	@Column(name = "PAIN_WORST")
	private TimeOfDay painWorst;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean isSharp() {
		return sharp;
	}

	public void setSharp(boolean sharp) {
		this.sharp = sharp;
	}

	public boolean isDull() {
		return dull;
	}

	public void setDull(boolean dull) {
		this.dull = dull;
	}

	public boolean isThrobbing() {
		return throbbing;
	}

	public void setThrobbing(boolean throbbing) {
		this.throbbing = throbbing;
	}

	public boolean isAching() {
		return aching;
	}

	public void setAching(boolean aching) {
		this.aching = aching;
	}

	public boolean isBurning() {
		return burning;
	}

	public void setBurning(boolean burning) {
		this.burning = burning;
	}

	public boolean isStabbing() {
		return stabbing;
	}

	public void setStabbing(boolean stabbing) {
		this.stabbing = stabbing;
	}

	public boolean isWeakness() {
		return weakness;
	}

	public void setWeakness(boolean weakness) {
		this.weakness = weakness;
	}

	public boolean isNumbness() {
		return numbness;
	}

	public void setNumbness(boolean numbness) {
		this.numbness = numbness;
	}

	public boolean isTingling() {
		return tingling;
	}

	public void setTingling(boolean tingling) {
		this.tingling = tingling;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean isPreviousOccurance() {
		return previousOccurance;
	}

	public void setPreviousOccurance(boolean previousOccurance) {
		this.previousOccurance = previousOccurance;
	}

	public Date getPreviousOccuranceDate() {
		return previousOccuranceDate;
	}

	public void setPreviousOccuranceDate(Date previousOccuranceDate) {
		this.previousOccuranceDate = previousOccuranceDate;
	}

	public String getHowItHappened() {
		return howItHappened;
	}

	public void setHowItHappened(String howItHappened) {
		this.howItHappened = howItHappened;
	}

	public String getWhatMakesWorst() {
		return whatMakesWorst;
	}

	public void setWhatMakesWorst(String whatMakesWorst) {
		this.whatMakesWorst = whatMakesWorst;
	}

	public String getWhatMakesBetter() {
		return whatMakesBetter;
	}

	public void setWhatMakesBetter(String whatMakesBetter) {
		this.whatMakesBetter = whatMakesBetter;
	}

	public boolean isPainRadiates() {
		return painRadiates;
	}

	public void setPainRadiates(boolean painRadiates) {
		this.painRadiates = painRadiates;
	}

	public String getPainRadiatesWhere() {
		return painRadiatesWhere;
	}

	public void setPainRadiatesWhere(String painRadiatesWhere) {
		this.painRadiatesWhere = painRadiatesWhere;
	}

	public PainPattern getPainPattern() {
		return painPattern;
	}

	public void setPainPattern(PainPattern painPattern) {
		this.painPattern = painPattern;
	}

	public PainScale getPainScale() {
		return painScale;
	}

	public void setPainScale(PainScale painScale) {
		this.painScale = painScale;
	}

	public TimeOfDay getPainWorst() {
		return painWorst;
	}

	public void setPainWorst(TimeOfDay painWorst) {
		this.painWorst = painWorst;
	}

}
