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
import com.sakk.princess.patient.model.FamilyHistory;
import com.sakk.princess.patient.rest.resource.FamilyHistoryListResource;
import com.sakk.princess.patient.rest.resource.FamilyHistoryResource;
import com.sakk.princess.patient.rest.resource.assembler.FamilyHistoryListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.FamilyHistoryResourceAssembler;
import com.sakk.princess.patient.service.FamilyHistoryService;
import com.sakk.princess.patient.service.exception.DuplicateFamilyHistoryException;
import com.sakk.princess.patient.service.util.FamilyHistoryList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/familyhistories", produces = "application/hal+json")
@Api(value = "/familyhistories")
// @PreAuthorize("denyAll")
public class FamilyHistoryController {

	@Autowired
	private FamilyHistoryService familyHistoryService;

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get familyHistories", notes = "This can only be done by admin FamilyHistory")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<FamilyHistoryListResource> getFamilyHistories() {

		FamilyHistoryList familyHistoryList = new FamilyHistoryList(familyHistoryService.getFamilyHistories());

		FamilyHistoryListResource familyHistoryListResource = new FamilyHistoryListResourceAssembler()
				.toResource(familyHistoryList);

		return new ResponseEntity<FamilyHistoryListResource>(familyHistoryListResource, HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<FamilyHistoryListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		FamilyHistoryList familyHistoryList = null;

		if (idList.isEmpty()) {
			familyHistoryList = new FamilyHistoryList(new ArrayList<FamilyHistory>());
		} else {
			familyHistoryList = new FamilyHistoryList(familyHistoryService.getFamilyHistorySublist(idList));

		}

		FamilyHistoryListResource familyHistoryListResource = new FamilyHistoryListResourceAssembler()
				.toResource(familyHistoryList);

		return new ResponseEntity<FamilyHistoryListResource>(familyHistoryListResource, HttpStatus.OK);

	}

	@ApiOperation(value = "Get FamilyHistory", notes = "This can only be done by admin FamilyHistory")
	@RequestMapping(value = "/{familyHistoryId}", method = RequestMethod.GET)
	public ResponseEntity<FamilyHistoryResource> getFamilyHistory(@PathVariable Long familyHistoryId) {

		FamilyHistory familyHistory = familyHistoryService.getFamilyHistory(familyHistoryId);

		if (familyHistory != null) {
			FamilyHistoryResource familyHistoryResource = new FamilyHistoryResourceAssembler()
					.toResource(familyHistory);
			return new ResponseEntity<FamilyHistoryResource>(familyHistoryResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<FamilyHistoryResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a FamilyHistory", notes = "This can only be done by admin FamilyHistory")
	@RequestMapping(value = "/{patientNumber}/familyhistory", method = RequestMethod.POST)
	public ResponseEntity<FamilyHistoryResource> addFamilyHistory(
			@RequestBody FamilyHistoryResource sentFamilyHistory) {

		FamilyHistory createdFamilyHistory = null;

		try {
			createdFamilyHistory = familyHistoryService.addFamilyHistory(sentFamilyHistory.toFamilyHistory());
			FamilyHistoryResource res = new FamilyHistoryResourceAssembler().toResource(createdFamilyHistory);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<FamilyHistoryResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateFamilyHistoryException exception) {
			throw new ConflictException(exception);
		}
	}

}
