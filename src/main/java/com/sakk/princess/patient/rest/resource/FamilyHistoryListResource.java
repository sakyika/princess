package com.sakk.princess.patient.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class FamilyHistoryListResource extends ResourceSupport {

	private List<FamilyHistoryResource> familyHistoryResourceList = new ArrayList<FamilyHistoryResource>();

	public List<FamilyHistoryResource> getFamilyHistoryResource() {
		return familyHistoryResourceList;
	}

	public void setFamilyHistoryResource(List<FamilyHistoryResource> familyHistoryResourceList) {
		this.familyHistoryResourceList = familyHistoryResourceList;
	}

}
