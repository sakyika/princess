package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class HomeAccidentListResource extends ResourceSupport {
	
	private List<HomeAccidentResource> homeAccidentResourceList = new ArrayList<HomeAccidentResource>();

	public List<HomeAccidentResource> getHomeAccidentResource() {
		return homeAccidentResourceList;
	}

	public void setHomeAccidentResource(List<HomeAccidentResource> homeAccidentResourceList) {
		this.homeAccidentResourceList = homeAccidentResourceList;
	}

}
