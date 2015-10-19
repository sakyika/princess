package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class WorkAccidentListResource extends ResourceSupport {
	
	private List<WorkAccidentResource> workAccidentResourceList = new ArrayList<WorkAccidentResource>();

	public List<WorkAccidentResource> getWorkAccidentListResource() {
		return workAccidentResourceList;
	}

	public void setWorkAccidentListResource(List<WorkAccidentResource> workAccidentResourceList) {
		this.workAccidentResourceList = workAccidentResourceList;
	}

}
