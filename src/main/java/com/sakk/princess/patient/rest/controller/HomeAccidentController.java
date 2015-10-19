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
import com.sakk.princess.patient.model.HomeAccident;
import com.sakk.princess.patient.rest.resource.HomeAccidentListResource;
import com.sakk.princess.patient.rest.resource.HomeAccidentResource;
import com.sakk.princess.patient.rest.resource.assembler.HomeAccidentListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.HomeAccidentResourceAssembler;
import com.sakk.princess.patient.service.HomeAccidentService;
import com.sakk.princess.patient.service.exception.DuplicateHomeAccidentException;
import com.sakk.princess.patient.service.util.HomeAccidentList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/homeaccidents", produces = "application/hal+json")
@Api(value = "/homeaccidents")
// @PreAuthorize("denyAll")
public class HomeAccidentController {

	private HomeAccidentService homeAccidentsService;

	@Autowired
	public HomeAccidentController(HomeAccidentService homeAccidentsService) {
		this.homeAccidentsService = homeAccidentsService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get homeaccidents", notes = "This can only be done by admin homeAccidents")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<HomeAccidentListResource> getHomeAccidents() {

		HomeAccidentList homeAccidentsList = new HomeAccidentList(homeAccidentsService.getHomeAccidents());

		HomeAccidentListResource homeAccidentsListResource = new HomeAccidentListResourceAssembler()
				.toResource(homeAccidentsList);

		return new ResponseEntity<HomeAccidentListResource>(homeAccidentsListResource, HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<HomeAccidentListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		HomeAccidentList homeAccidentsList = null;

		if (idList.isEmpty()) {
			homeAccidentsList = new HomeAccidentList(new ArrayList<HomeAccident>());
		} else {
			homeAccidentsList = new HomeAccidentList(homeAccidentsService.getHomeAccidentSublist(idList));

		}

		HomeAccidentListResource homeAccidentsListResource = new HomeAccidentListResourceAssembler()
				.toResource(homeAccidentsList);

		return new ResponseEntity<HomeAccidentListResource>(homeAccidentsListResource, HttpStatus.OK);

	}

	@ApiOperation(value = "Get homeAccidents", notes = "This can only be done by admin homeAccidents")
	@RequestMapping(value = "/{homeAccidentsId}", method = RequestMethod.GET)
	public ResponseEntity<HomeAccidentResource> getHomeAccident(@PathVariable Long homeAccidentsId) {

		HomeAccident homeAccidents = homeAccidentsService.getHomeAccident(homeAccidentsId);

		if (homeAccidents != null) {
			HomeAccidentResource homeAccidentsResource = new HomeAccidentResourceAssembler().toResource(homeAccidents);
			return new ResponseEntity<HomeAccidentResource>(homeAccidentsResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<HomeAccidentResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a homeAccidents", notes = "This can only be done by admin homeAccidents")
	@RequestMapping(value = "/{patientNumber}/homeaccidents", method = RequestMethod.POST)
	public ResponseEntity<HomeAccidentResource> addHomeAccident(@RequestBody HomeAccidentResource sentHomeAccident) {

		HomeAccident createdHomeAccident = null;

		try {
			createdHomeAccident = homeAccidentsService.addHomeAccident(sentHomeAccident.toHomeAccident());
			HomeAccidentResource res = new HomeAccidentResourceAssembler().toResource(createdHomeAccident);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<HomeAccidentResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateHomeAccidentException exception) {
			throw new ConflictException(exception);
		}
	}

}
