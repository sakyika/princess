package com.sakk.princess.patient.rest.resource.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.sakk.princess.patient.rest.controller.WorkAccidentController;
import com.sakk.princess.patient.rest.resource.WorkAccidentListResource;
import com.sakk.princess.patient.rest.resource.WorkAccidentResource;
import com.sakk.princess.patient.service.util.WorkAccidentList;

public class WorkAccidentListResourceAssembler
		extends ResourceAssemblerSupport<WorkAccidentList, WorkAccidentListResource> {

	public WorkAccidentListResourceAssembler() {
		super(WorkAccidentController.class, WorkAccidentListResource.class);
	}

	@Override
	public WorkAccidentListResource toResource(WorkAccidentList workAccidentList) {

		List<WorkAccidentResource> workAccidentListResource = new WorkAccidentResourceAssembler()
				.toResources(workAccidentList.getWorkAccidentList());
		WorkAccidentListResource finalWorkAccidentListResource = new WorkAccidentListResource();
		finalWorkAccidentListResource.setWorkAccidentListResource(workAccidentListResource);

		return finalWorkAccidentListResource;
	}

}
