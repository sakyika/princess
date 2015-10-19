package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.Complaint;

public class ComplaintList {
	
	private List<Complaint> complaintList = new ArrayList<Complaint>();

	public ComplaintList(List<Complaint> complaintList) {
		this.complaintList = complaintList;
	}

	public List<Complaint> getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(List<Complaint> complaintList) {
		this.complaintList = complaintList;
	}

}
