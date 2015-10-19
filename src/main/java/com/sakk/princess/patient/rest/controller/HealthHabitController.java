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
import com.sakk.princess.patient.model.HealthHabit;
import com.sakk.princess.patient.rest.resource.HealthHabitListResource;
import com.sakk.princess.patient.rest.resource.HealthHabitResource;
import com.sakk.princess.patient.rest.resource.assembler.HealthHabitListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.HealthHabitResourceAssembler;
import com.sakk.princess.patient.service.HealthHabitService;
import com.sakk.princess.patient.service.exception.DuplicateHealthHabitException;
import com.sakk.princess.patient.service.util.HealthHabitList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/healthhabits", produces = "application/hal+json")
@Api(value = "/healthhabits")
// @PreAuthorize("denyAll")
public class HealthHabitController {

	private HealthHabitService healthHabitService;

	@Autowired
	public HealthHabitController(HealthHabitService healthHabitService) {
		this.healthHabitService = healthHabitService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get HealthHabits", notes = "This can only be done by admin HealthHabit")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<HealthHabitListResource> getHealthHabits() {

		HealthHabitList healthHabitList = new HealthHabitList(healthHabitService.getHealthHabits());

		HealthHabitListResource healthHabitListResource = new HealthHabitListResourceAssembler()
				.toResource(healthHabitList);

		return new ResponseEntity<HealthHabitListResource>(healthHabitListResource, HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<HealthHabitListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		HealthHabitList healthHabitList = null;

		if (idList.isEmpty()) {
			healthHabitList = new HealthHabitList(new ArrayList<HealthHabit>());
		} else {
			healthHabitList = new HealthHabitList(healthHabitService.getHealthHabitSublist(idList));

		}

		HealthHabitListResource healthHabitListResource = new HealthHabitListResourceAssembler()
				.toResource(healthHabitList);

		return new ResponseEntity<HealthHabitListResource>(healthHabitListResource, HttpStatus.OK);

	}

	@ApiOperation(value = "Get HealthHabit", notes = "This can only be done by admin HealthHabit")
	@RequestMapping(value = "/{healthHabitId}", method = RequestMethod.GET)
	public ResponseEntity<HealthHabitResource> getHealthHabit(@PathVariable Long healthHabitId) {

		HealthHabit healthHabit = healthHabitService.getHealthHabit(healthHabitId);

		if (healthHabit != null) {
			HealthHabitResource healthHabitResource = new HealthHabitResourceAssembler().toResource(healthHabit);
			return new ResponseEntity<HealthHabitResource>(healthHabitResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<HealthHabitResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a HealthHabit", notes = "This can only be done by admin HealthHabit")
	@RequestMapping(value = "/{patientNumber}/healthhabit", method = RequestMethod.POST)
	public ResponseEntity<HealthHabitResource> addHealthHabit(@RequestBody HealthHabitResource sentHealthHabit) {

		HealthHabit createdHealthHabit = null;

		try {
			createdHealthHabit = healthHabitService.addHealthHabit(sentHealthHabit.toHealthHabit());
			HealthHabitResource res = new HealthHabitResourceAssembler().toResource(createdHealthHabit);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<HealthHabitResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateHealthHabitException exception) {
			throw new ConflictException(exception);
		}
	}

}
