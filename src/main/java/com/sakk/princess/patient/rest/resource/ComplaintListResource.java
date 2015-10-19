package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class ComplaintListResource extends ResourceSupport {
	
	private List<ComplaintResource> complaintResourceList = new ArrayList<ComplaintResource>();

	public List<ComplaintResource> getComplaintListResource() {
		return complaintResourceList;
	}

	public void setComplaintListResource(List<ComplaintResource> complaintResourceList) {
		this.complaintResourceList = complaintResourceList;
	}

}
