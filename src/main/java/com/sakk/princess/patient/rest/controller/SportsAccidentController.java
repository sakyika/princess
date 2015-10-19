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
import com.sakk.princess.patient.model.SportsAccident;
import com.sakk.princess.patient.rest.resource.SportsAccidentListResource;
import com.sakk.princess.patient.rest.resource.SportsAccidentResource;
import com.sakk.princess.patient.rest.resource.assembler.SportsAccidentListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.SportsAccidentResourceAssembler;
import com.sakk.princess.patient.service.SportsAccidentService;
import com.sakk.princess.patient.service.exception.DuplicateSportsAccidentException;
import com.sakk.princess.patient.service.util.SportsAccidentList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/sportsaccidents", produces = "application/hal+json")
@Api(value = "/sportsaccidents")
// @PreAuthorize("denyAll")
public class SportsAccidentController {

	private SportsAccidentService sportsAccidentService;

	@Autowired
	public SportsAccidentController(SportsAccidentService sportsAccidentService) {
		this.sportsAccidentService = sportsAccidentService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get sportsAccidents", notes = "This can only be done by admin sportsAccident")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<SportsAccidentListResource> getSportsAccidents() {

		SportsAccidentList sportsAccidentList = new SportsAccidentList(sportsAccidentService.getSportsAccidents());

		SportsAccidentListResource sportsAccidentListResource = new SportsAccidentListResourceAssembler()
				.toResource(sportsAccidentList);

		return new ResponseEntity<SportsAccidentListResource>(sportsAccidentListResource, HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<SportsAccidentListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		SportsAccidentList sportsAccidentList = null;

		if (idList.isEmpty()) {
			sportsAccidentList = new SportsAccidentList(new ArrayList<SportsAccident>());
		} else {
			sportsAccidentList = new SportsAccidentList(sportsAccidentService.getSportsAccidentSublist(idList));

		}

		SportsAccidentListResource sportsAccidentListResource = new SportsAccidentListResourceAssembler()
				.toResource(sportsAccidentList);

		return new ResponseEntity<SportsAccidentListResource>(sportsAccidentListResource, HttpStatus.OK);

	}

	@ApiOperation(value = "Get sportsAccident", notes = "This can only be done by admin sportsAccident")
	@RequestMapping(value = "/{sportsAccidentId}", method = RequestMethod.GET)
	public ResponseEntity<SportsAccidentResource> getSportsAccident(@PathVariable Long sportsAccidentId) {

		SportsAccident sportsAccident = sportsAccidentService.getSportsAccident(sportsAccidentId);

		if (sportsAccident != null) {
			SportsAccidentResource sportsAccidentResource = new SportsAccidentResourceAssembler()
					.toResource(sportsAccident);
			return new ResponseEntity<SportsAccidentResource>(sportsAccidentResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<SportsAccidentResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a sportsAccident", notes = "This can only be done by admin sportsAccident")
	@RequestMapping(value = "/{patientNumber}/sportsaccidents", method = RequestMethod.POST)
	public ResponseEntity<SportsAccidentResource> addSportsAccident(
			@RequestBody SportsAccidentResource sentSportsAccident) {

		SportsAccident createdSportsAccident = null;

		try {
			createdSportsAccident = sportsAccidentService.addSportsAccident(sentSportsAccident.toSportsAccident());
			SportsAccidentResource res = new SportsAccidentResourceAssembler().toResource(createdSportsAccident);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<SportsAccidentResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateSportsAccidentException exception) {
			throw new ConflictException(exception);
		}
	}

}
