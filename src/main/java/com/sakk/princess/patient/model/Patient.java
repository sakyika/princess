package com.sakk.princess.patient.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sakk.princess.core.model.BaseEntity;

/**
 * 
 * General Information
 *
 */

@Entity
@Table(name = "PATIENTS")
public class Patient extends BaseEntity {

	static Logger logger = LoggerFactory.getLogger(Patient.class);

	@Column(name = "PATIENT_NUMBER", unique = true, nullable = false)
	@NotNull
	private Long patientNumber;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JoinTable(name = "PATIENT_CHIROPRACTICEXPERIENCES", joinColumns = {
			@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "CHIROPRACTICEXPERIENCE_ID", referencedColumnName = "ID") })
	private List<ChiropracticExperience> ChiropracticExperienceList;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name = "PATIENT_FAMILYHISTORIES", joinColumns = {
			@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "FAMILYHISTORY_ID", referencedColumnName = "ID") })
	private FamilyHistory familyHistory;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name = "PATIENT_MEDICALHISTORIES", joinColumns = {
			@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "MEDICALHISTORY_ID", referencedColumnName = "ID") })
	private MedicalHistory medicalHistory;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name = "PATIENT_HEALTHHABITS", joinColumns = {
			@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "HEALTHHABIT_ID", referencedColumnName = "ID") })
	private HealthHabit healthHabit;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name = "PATIENT_CHILDHOODTRUAMAS", joinColumns = {
			@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "CHILDHOODTRUAMA_ID", referencedColumnName = "ID") })
	private List<ChildhoodTruama> childhoodTruamaList;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name = "PATIENT_MOTORVEHICLEACCIDENTS", joinColumns = {
			@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "MOTORVEHICLEACCIDENT_ID", referencedColumnName = "ID") })
	private List<MotorVehicleAccident> motorVehicleAccidentList;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name = "PATIENT_HOMEACCIDENTS", joinColumns = {
			@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "HOMEACCIDENT_ID", referencedColumnName = "ID") })
	private List<HomeAccident> homeAccidentList;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name = "PATIENT_SPORTSACCIDENTS", joinColumns = {
			@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "SPORTSACCIDENT_ID", referencedColumnName = "ID") })
	private List<SportsAccident> sportsAccidentList;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name = "PATIENT_WORKACCIDENTS", joinColumns = {
			@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "WORKACCIDENT_ID", referencedColumnName = "ID") })
	private List<WorkAccident> workAccidentList;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinTable(name = "PATIENT_COMPLAINTS", joinColumns = {
			@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "COMPLAINT_ID", referencedColumnName = "ID") })
	private List<Complaint> complaintList;

	@Enumerated(EnumType.STRING)
	@Column(name = "TITLE")
	private Title title;

	@Column(name = "FIRSTNAME", length = 50)
	private String firstName;

	@Column(name = "LASTNAME", length = 50)
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DOB")
	private Date dob;

	@Column(name = "ADDRESS", length = 100)
	private String address;

	@Column(name = "HOMEPHONE", length = 50)
	private String homePhone;

	@Column(name = "WORKPHONE", length = 50)
	private String workPhone;

	@Column(name = "CELLPHONE", length = 50)
	private String cellPhone;

	@Column(name = "OCCUPATION", length = 50)
	private String occupation;

	@Column(name = "EMPLOYER", length = 50)
	private String employer;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "HEAR_ABOUT_US", length = 500)
	private String hearAboutUs;

	@Column(name = "EMERGENCYCONTACT", length = 50)
	private String emergencyContact;

	@Column(name = "EMERGENCYCONTACT_PHONE", length = 50)
	private String emergencyContactPhone;

	public Long getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(Long patientNumber) {
		this.patientNumber = patientNumber;
	}

	public List<ChiropracticExperience> getChiropracticExperienceList() {
		return ChiropracticExperienceList;
	}

	public void setChiropracticExperienceList(List<ChiropracticExperience> ChiropracticExperienceList) {
		this.ChiropracticExperienceList = ChiropracticExperienceList;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHearAboutUs() {
		return hearAboutUs;
	}

	public void setHearAboutUs(String hearAboutUs) {
		this.hearAboutUs = hearAboutUs;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public FamilyHistory getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(FamilyHistory familyHistory) {
		this.familyHistory = familyHistory;
	}

	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	/*
	 * public ChiroMedicalHistory getMedicalHistory() { return medicalHistory; }
	 * 
	 * public void setMedicalHistory(ChiroMedicalHistory medicalHistory) {
	 * this.medicalHistory = medicalHistory; }
	 */
	public HealthHabit getHealthHabit() {
		return healthHabit;
	}

	public void setHealthHabit(HealthHabit healthHabit) {
		this.healthHabit = healthHabit;
	}

	public List<ChildhoodTruama> getChildhoodTruamaList() {
		return childhoodTruamaList;
	}

	public void setChildhoodTruamaList(List<ChildhoodTruama> childhoodTruamaList) {
		this.childhoodTruamaList = childhoodTruamaList;
	}

	public List<MotorVehicleAccident> getMotorVehicleAccidentList() {
		return motorVehicleAccidentList;
	}

	public void setMotorVehicleAccidentList(List<MotorVehicleAccident> motorVehicleAccidentList) {
		this.motorVehicleAccidentList = motorVehicleAccidentList;
	}

	public List<HomeAccident> getHomeAccidentList() {
		return homeAccidentList;
	}

	public void setHomeAccidentList(List<HomeAccident> homeAccident) {
		this.homeAccidentList = homeAccident;
	}

	public List<SportsAccident> getSportsAccidentList() {
		return sportsAccidentList;
	}

	public void setSportsAccidentList(List<SportsAccident> sportsAccidentList) {
		this.sportsAccidentList = sportsAccidentList;
	}

	public List<WorkAccident> getWorkAccidentList() {
		return workAccidentList;
	}

	public void setWorkAccident(List<WorkAccident> workAccidentList) {
		this.workAccidentList = workAccidentList;
	}

	public List<Complaint> getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(List<Complaint> complaintList) {
		this.complaintList = complaintList;
	}

}
