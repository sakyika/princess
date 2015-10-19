package com.sakk.princess.patient.service;

import java.util.List;

import com.sakk.princess.patient.model.Complaint;

public interface ComplaintService {
	
	List<Complaint> findAllComplaints();
	
	public Complaint addComplaint(Complaint complaint);
	
	public Complaint getComplaint(Long complaintId);
	
	public Complaint updateComplaint(Complaint complaint);
	
	public Complaint updateComplaintByPatientNumber(Long patientNumber, Complaint complaint);
	
	public Complaint deleteComplaint(Long complaintId);
	
	public List<Complaint> getComplaints();
	
	List<Complaint> findByPatientNumber(Long patientNumber);
	
	public List<Complaint> getComplaintSublist(List<Long> complaintIdList);

}
