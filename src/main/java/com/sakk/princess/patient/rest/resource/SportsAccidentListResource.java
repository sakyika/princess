package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class SportsAccidentListResource extends ResourceSupport {

	private List<SportsAccidentResource> sportsAccidentResourceList = new ArrayList<SportsAccidentResource>();

	public List<SportsAccidentResource> getSportsAccidentListResource() {
		return sportsAccidentResourceList;
	}

	public void setSportsAccidentListResource(List<SportsAccidentResource> sportsAccidentResourceList) {
		this.sportsAccidentResourceList = sportsAccidentResourceList;
	}
	
}
