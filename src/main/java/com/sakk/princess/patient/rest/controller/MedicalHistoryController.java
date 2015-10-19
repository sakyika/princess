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
import com.sakk.princess.patient.model.MedicalHistory;
import com.sakk.princess.patient.rest.resource.MedicalHistoryListResource;
import com.sakk.princess.patient.rest.resource.MedicalHistoryResource;
import com.sakk.princess.patient.rest.resource.assembler.MedicalHistoryListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.MedicalHistoryResourceAssembler;
import com.sakk.princess.patient.service.MedicalHistoryService;
import com.sakk.princess.patient.service.exception.DuplicateMedicalHistoryException;
import com.sakk.princess.patient.service.util.MedicalHistoryList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/medicalhistories", produces = "application/hal+json")
@Api(value = "/medicalhistories")
// @PreAuthorize("denyAll")
public class MedicalHistoryController {

	private MedicalHistoryService medicalHistoryService;

	@Autowired
	public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {
		this.medicalHistoryService = medicalHistoryService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get MedicalHistories", notes = "This can only be done by admin MedicalHistory")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<MedicalHistoryListResource> getMedicalHistories() {

		MedicalHistoryList medicalHistoryList = new MedicalHistoryList(medicalHistoryService.getMedicalHistories());

		MedicalHistoryListResource medicalHistoryListResource = new MedicalHistoryListResourceAssembler()
				.toResource(medicalHistoryList);

		return new ResponseEntity<MedicalHistoryListResource>(medicalHistoryListResource, HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<MedicalHistoryListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		MedicalHistoryList medicalHistoryList = null;

		if (idList.isEmpty()) {
			medicalHistoryList = new MedicalHistoryList(new ArrayList<MedicalHistory>());
		} else {
			medicalHistoryList = new MedicalHistoryList(medicalHistoryService.getMedicalHistorySublist(idList));

		}

		MedicalHistoryListResource medicalHistoryListResource = new MedicalHistoryListResourceAssembler()
				.toResource(medicalHistoryList);

		return new ResponseEntity<MedicalHistoryListResource>(medicalHistoryListResource, HttpStatus.OK);

	}

	@ApiOperation(value = "Get MedicalHistory", notes = "This can only be done by admin MedicalHistory")
	@RequestMapping(value = "/{medicalHistoryId}", method = RequestMethod.GET)
	public ResponseEntity<MedicalHistoryResource> getMedicalHistory(@PathVariable Long medicalHistoryId) {

		MedicalHistory medicalHistory = medicalHistoryService.getMedicalHistory(medicalHistoryId);

		if (medicalHistory != null) {
			MedicalHistoryResource medicalHistoryResource = new MedicalHistoryResourceAssembler()
					.toResource(medicalHistory);
			return new ResponseEntity<MedicalHistoryResource>(medicalHistoryResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<MedicalHistoryResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a MedicalHistory", notes = "This can only be done by admin MedicalHistory")
	@RequestMapping(value = "/{patientNumber}/medicalhistory", method = RequestMethod.POST)
	public ResponseEntity<MedicalHistoryResource> addMedicalHistory(
			@RequestBody MedicalHistoryResource sentMedicalHistory) {

		MedicalHistory createdMedicalHistory = null;

		try {
			createdMedicalHistory = medicalHistoryService.addMedicalHistory(sentMedicalHistory.toMedicalHistory());
			MedicalHistoryResource res = new MedicalHistoryResourceAssembler().toResource(createdMedicalHistory);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<MedicalHistoryResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateMedicalHistoryException exception) {
			throw new ConflictException(exception);
		}
	}

}
