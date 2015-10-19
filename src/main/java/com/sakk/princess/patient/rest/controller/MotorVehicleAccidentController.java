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
import com.sakk.princess.patient.model.MotorVehicleAccident;
import com.sakk.princess.patient.rest.resource.MotorVehicleAccidentListResource;
import com.sakk.princess.patient.rest.resource.MotorVehicleAccidentResource;
import com.sakk.princess.patient.rest.resource.assembler.MotorVehicleAccidentListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.MotorVehicleAccidentResourceAssembler;
import com.sakk.princess.patient.service.MotorVehicleAccidentService;
import com.sakk.princess.patient.service.exception.DuplicateMotorVehicleAccidentException;
import com.sakk.princess.patient.service.util.MotorVehicleAccidentList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/motorvehicleaccidents", produces = "application/hal+json")
@Api(value = "/motorvehicleaccidents")
// @PreAuthorize("denyAll")
public class MotorVehicleAccidentController {

	private MotorVehicleAccidentService motorVehicleAccidentService;

	@Autowired
	public MotorVehicleAccidentController(MotorVehicleAccidentService motorVehicleAccidentService) {
		this.motorVehicleAccidentService = motorVehicleAccidentService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get motorVehicleAccidents", notes = "This can only be done by admin motorVehicleAccident")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<MotorVehicleAccidentListResource> getMotorVehicleAccidents() {

		MotorVehicleAccidentList motorVehicleAccidentList = new MotorVehicleAccidentList(
				motorVehicleAccidentService.getMotorVehicleAccidents());

		MotorVehicleAccidentListResource motorVehicleAccidentListResource = new MotorVehicleAccidentListResourceAssembler()
				.toResource(motorVehicleAccidentList);

		return new ResponseEntity<MotorVehicleAccidentListResource>(motorVehicleAccidentListResource, HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<MotorVehicleAccidentListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		MotorVehicleAccidentList motorVehicleAccidentList = null;

		if (idList.isEmpty()) {
			motorVehicleAccidentList = new MotorVehicleAccidentList(new ArrayList<MotorVehicleAccident>());
		} else {
			motorVehicleAccidentList = new MotorVehicleAccidentList(
					motorVehicleAccidentService.getMotorVehicleAccidentSublist(idList));

		}

		MotorVehicleAccidentListResource motorVehicleAccidentListResource = new MotorVehicleAccidentListResourceAssembler()
				.toResource(motorVehicleAccidentList);

		return new ResponseEntity<MotorVehicleAccidentListResource>(motorVehicleAccidentListResource, HttpStatus.OK);

	}

	@ApiOperation(value = "Get motorVehicleAccident", notes = "This can only be done by admin motorVehicleAccident")
	@RequestMapping(value = "/{motorVehicleAccidentId}", method = RequestMethod.GET)
	public ResponseEntity<MotorVehicleAccidentResource> getMotorVehicleAccident(
			@PathVariable Long motorVehicleAccidentId) {

		MotorVehicleAccident motorVehicleAccident = motorVehicleAccidentService
				.getMotorVehicleAccident(motorVehicleAccidentId);

		if (motorVehicleAccident != null) {
			MotorVehicleAccidentResource motorVehicleAccidentResource = new MotorVehicleAccidentResourceAssembler()
					.toResource(motorVehicleAccident);
			return new ResponseEntity<MotorVehicleAccidentResource>(motorVehicleAccidentResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<MotorVehicleAccidentResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a motorVehicleAccident", notes = "This can only be done by admin motorVehicleAccident")
	@RequestMapping(value = "/{patientNumber}/motorVehicleAccidents", method = RequestMethod.POST)
	public ResponseEntity<MotorVehicleAccidentResource> addMotorVehicleAccident(
			@RequestBody MotorVehicleAccidentResource sentMotorVehicleAccident) {

		MotorVehicleAccident createdMotorVehicleAccident = null;

		try {
			createdMotorVehicleAccident = motorVehicleAccidentService
					.addMotorVehicleAccident(sentMotorVehicleAccident.toMotorVehicleAccident());
			MotorVehicleAccidentResource res = new MotorVehicleAccidentResourceAssembler()
					.toResource(createdMotorVehicleAccident);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<MotorVehicleAccidentResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateMotorVehicleAccidentException exception) {
			throw new ConflictException(exception);
		}
	}

}
