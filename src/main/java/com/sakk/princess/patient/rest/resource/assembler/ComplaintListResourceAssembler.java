package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.ComplaintController;
import com.sakk.princess.patient.rest.resource.ComplaintListResource;
import com.sakk.princess.patient.rest.resource.ComplaintResource;
import com.sakk.princess.patient.service.util.ComplaintList;

public class ComplaintListResourceAssembler extends ResourceAssemblerSupport<ComplaintList, ComplaintListResource> {

	public ComplaintListResourceAssembler() {
		super(ComplaintController.class, ComplaintListResource.class);
	}

	@Override
	public ComplaintListResource toResource(ComplaintList complaintList) {

		List<ComplaintResource> complaintResourceList = new ComplaintResourceAssembler()
				.toResources(complaintList.getComplaintList());
		ComplaintListResource finalComplaintResource = new ComplaintListResource();
		finalComplaintResource.setComplaintListResource(complaintResourceList);

		return finalComplaintResource;
	}

}
