package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class ChiropracticExperienceListResource extends ResourceSupport {
	
	private List<ChiropracticExperienceResource> chiropracticExperienceListResource = new ArrayList<ChiropracticExperienceResource>();

	public List<ChiropracticExperienceResource> getChiropracticExperinceListResource() {
		return chiropracticExperienceListResource;
	}

	public void setChiropracticExperinceListResource(List<ChiropracticExperienceResource> chiropracticExperienceListResource) {
		this.chiropracticExperienceListResource = chiropracticExperienceListResource;
	}

}
