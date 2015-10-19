package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class ChildhoodTruamaListResource extends ResourceSupport {
	
	private List<ChildhoodTruamaResource> childhoodTruamaListResource = new ArrayList<ChildhoodTruamaResource>();

	public List<ChildhoodTruamaResource> getChildhoodTruamaListResource() {
		return childhoodTruamaListResource;
	}

	public void setChildhoodTruamaListResource(List<ChildhoodTruamaResource> childhoodTruamaListResource) {
		this.childhoodTruamaListResource = childhoodTruamaListResource;
	}

}
