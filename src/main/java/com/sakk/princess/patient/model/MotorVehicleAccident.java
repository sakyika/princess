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
 * PAST MOTOR VEHICLE ACCIDENT
 */

@Entity
@Table(name = "MOTORVEHICLEACCIDENTS")
public class MotorVehicleAccident extends BaseEntity {

	static Logger logger = LoggerFactory.getLogger(MotorVehicleAccident.class);

	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "PATIENT_MOTORVEHICLEACCIDENTS", joinColumns = {
			@JoinColumn(name = "MOTORVEHICLEACCIDENT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") })
	private Patient patient;

	@Column(name = "MOTORVEHICLE_ACCIDENT", columnDefinition = "TINYINT(1)")
	private boolean motorVehicleAccident;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACCIDENT_DATE")
	private Date accidentDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "DRIVER_PASSENGER")
	private DriverPassenger driverOrPassenger;

	@Column(name = "WEARING_SEATBELT", columnDefinition = "TINYINT(1)")
	private boolean wearingSeatBelt;

	@Enumerated(EnumType.STRING)
	@Column(name = "VEHICLE_COLLISION")
	private VehicleCollisionPart vehicleCollisionPart;

	@Column(name = "STRIKE_HEAD", columnDefinition = "TINYINT(1)")
	private boolean strikeHead;

	@Column(name = "LOSSCONCIOUSNESS", columnDefinition = "TINYINT(1)")
	private boolean lossConsciousness;

	@Column(name = "SENT_TO_HOSPITAL", columnDefinition = "TINYINT(1)")
	private boolean sentToHospital;

	@Column(name = "XRAY_TAKEN", columnDefinition = "TINYINT(1)")
	private boolean xrayTaken;

	@Column(name = "MEDICATION_GIVEN", columnDefinition = "TINYINT(1)")
	private boolean medicationGiven;

	@Column(name = "CARE_TYPE_GIVEN")
	private String careGivenType;

	@Column(name = "CARE_GIVEN_BY_DOCTOR")
	private String careGivenByDoctor;

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

	public boolean isMotorVehicleAccident() {
		return motorVehicleAccident;
	}

	public void setMotorVehicleAccident(boolean motorVehicleAccident) {
		this.motorVehicleAccident = motorVehicleAccident;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date date) {
		this.accidentDate = date;
	}

	public DriverPassenger getDriverOrPassenger() {
		return driverOrPassenger;
	}

	public void setDriverOrPassenger(DriverPassenger driverOrPassenger) {
		this.driverOrPassenger = driverOrPassenger;
	}

	public boolean isWearingSeatBelt() {
		return wearingSeatBelt;
	}

	public void setWearingSeatBelt(boolean wearingSeatBelt) {
		this.wearingSeatBelt = wearingSeatBelt;
	}

	public VehicleCollisionPart getVehicleCollisionPart() {
		return vehicleCollisionPart;
	}

	public void setVehicleCollisionPart(VehicleCollisionPart vehicleCollisionPart) {
		this.vehicleCollisionPart = vehicleCollisionPart;
	}

	public boolean isStrikeHead() {
		return strikeHead;
	}

	public void setStrikeHead(boolean strikeHead) {
		this.strikeHead = strikeHead;
	}

	public boolean isLossConsciousness() {
		return lossConsciousness;
	}

	public void setLossConsciousness(boolean lossConsciousness) {
		this.lossConsciousness = lossConsciousness;
	}

	public boolean isSentToHospital() {
		return sentToHospital;
	}

	public void setSentToHospital(boolean sentToHospital) {
		this.sentToHospital = sentToHospital;
	}

	public boolean isXrayTaken() {
		return xrayTaken;
	}

	public void setXrayTaken(boolean xrayTaken) {
		this.xrayTaken = xrayTaken;
	}

	public boolean isMedicationGiven() {
		return medicationGiven;
	}

	public void setMedicationGiven(boolean medicationGiven) {
		this.medicationGiven = medicationGiven;
	}

	public String getCareGivenType() {
		return careGivenType;
	}

	public void setCareGivenType(String careGivenType) {
		this.careGivenType = careGivenType;
	}

	public String getCareGivenByDoctor() {
		return careGivenByDoctor;
	}

	public void setCareGivenByDoctor(String careGivenBy) {
		this.careGivenByDoctor = careGivenBy;
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
