package com.sakk.princess.patient.rest.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakk.princess.core.rest.exception.ConflictException;
import com.sakk.princess.patient.model.WorkAccident;
import com.sakk.princess.patient.rest.resource.WorkAccidentListResource;
import com.sakk.princess.patient.rest.resource.WorkAccidentResource;
import com.sakk.princess.patient.rest.resource.assembler.WorkAccidentListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.WorkAccidentResourceAssembler;
import com.sakk.princess.patient.service.WorkAccidentService;
import com.sakk.princess.patient.service.exception.DuplicateWorkAccidentException;
import com.sakk.princess.patient.service.util.WorkAccidentList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/workaccidents", produces = "application/hal+json")
@Api(value = "/workaccidents")
// @PreAuthorize("denyAll")
public class WorkAccidentController {

	private WorkAccidentService workAccidentService;

	@Autowired
	public WorkAccidentController(WorkAccidentService workAccidentService) {
		this.workAccidentService = workAccidentService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get workAccidents", notes = "This can only be done by admin workAccident")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<WorkAccidentListResource> getWorkAccidents() {

		WorkAccidentList workAccidentList = new WorkAccidentList(workAccidentService.getWorkAccidents());

		WorkAccidentListResource workAccidentListResource = new WorkAccidentListResourceAssembler()
				.toResource(workAccidentList);

		return new ResponseEntity<WorkAccidentListResource>(workAccidentListResource, HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<WorkAccidentListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		WorkAccidentList workAccidentList = null;

		if (idList.isEmpty()) {
			workAccidentList = new WorkAccidentList(new ArrayList<WorkAccident>());
		} else {
			workAccidentList = new WorkAccidentList(workAccidentService.getWorkAccidentSublist(idList));

		}

		WorkAccidentListResource workAccidentListResource = new WorkAccidentListResourceAssembler()
				.toResource(workAccidentList);

		return new ResponseEntity<WorkAccidentListResource>(workAccidentListResource, HttpStatus.OK);

	}

	@ApiOperation(value = "Get workAccident", notes = "This can only be done by admin workAccident")
	@RequestMapping(value = "/{workAccidentId}", method = RequestMethod.GET)
	public ResponseEntity<WorkAccidentResource> getWorkAccident(@PathVariable Long workAccidentId) {

		WorkAccident workAccident = workAccidentService.getWorkAccident(workAccidentId);

		if (workAccident != null) {
			WorkAccidentResource workAccidentResource = new WorkAccidentResourceAssembler().toResource(workAccident);
			return new ResponseEntity<WorkAccidentResource>(workAccidentResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<WorkAccidentResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a workAccident", notes = "This can only be done by admin workAccident")
	@RequestMapping(value = "/{patientNumber}/workaccidents", method = RequestMethod.POST)
	public ResponseEntity<WorkAccidentResource> addWorkAccident(@RequestBody WorkAccidentResource sentWorkAccident) {

		WorkAccident createdWorkAccident = null;

		try {
			createdWorkAccident = workAccidentService.addWorkAccident(sentWorkAccident.toWorkAccident());
			WorkAccidentResource res = new WorkAccidentResourceAssembler().toResource(createdWorkAccident);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<WorkAccidentResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateWorkAccidentException exception) {
			throw new ConflictException(exception);
		}
	}

}
