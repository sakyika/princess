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
import com.sakk.princess.patient.model.Complaint;
import com.sakk.princess.patient.rest.resource.ComplaintListResource;
import com.sakk.princess.patient.rest.resource.ComplaintResource;
import com.sakk.princess.patient.rest.resource.assembler.ComplaintListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.ComplaintResourceAssembler;
import com.sakk.princess.patient.service.ComplaintService;
import com.sakk.princess.patient.service.exception.DuplicateComplaintException;
import com.sakk.princess.patient.service.util.ComplaintList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/complaints", produces = "application/hal+json")
@Api(value = "/complaints")
// @PreAuthorize("denyAll")
public class ComplaintController {

	private ComplaintService complaintService;

	@Autowired
	public ComplaintController(ComplaintService complaintService) {
		this.complaintService = complaintService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get complaints", notes = "This can only be done by admin complaint")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ComplaintListResource> getComplaints() {

		ComplaintList complaintList = new ComplaintList(complaintService.getComplaints());

		ComplaintListResource complaintListResource = new ComplaintListResourceAssembler().toResource(complaintList);

		return new ResponseEntity<ComplaintListResource>(complaintListResource, HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<ComplaintListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		ComplaintList complaintList = null;

		if (idList.isEmpty()) {
			complaintList = new ComplaintList(new ArrayList<Complaint>());
		} else {
			complaintList = new ComplaintList(complaintService.getComplaintSublist(idList));

		}

		ComplaintListResource complaintListResource = new ComplaintListResourceAssembler().toResource(complaintList);

		return new ResponseEntity<ComplaintListResource>(complaintListResource, HttpStatus.OK);

	}

	@ApiOperation(value = "Get complaint", notes = "This can only be done by admin complaint")
	@RequestMapping(value = "/{complaintId}", method = RequestMethod.GET)
	public ResponseEntity<ComplaintResource> getComplaint(@PathVariable Long complaintId) {

		Complaint complaint = complaintService.getComplaint(complaintId);

		if (complaint != null) {
			ComplaintResource complaintResource = new ComplaintResourceAssembler().toResource(complaint);
			return new ResponseEntity<ComplaintResource>(complaintResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<ComplaintResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a complaint", notes = "This can only be done by admin complaint")
	@RequestMapping(value = "/{patientNumber}/complaints", method = RequestMethod.POST)
	public ResponseEntity<ComplaintResource> addComplaint(@RequestBody ComplaintResource sentComplaint) {

		Complaint createdComplaint = null;

		try {
			createdComplaint = complaintService.addComplaint(sentComplaint.toComplaint());
			ComplaintResource res = new ComplaintResourceAssembler().toResource(createdComplaint);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<ComplaintResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateComplaintException exception) {
			throw new ConflictException(exception);
		}
	}

}
