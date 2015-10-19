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
import com.sakk.princess.patient.model.ChiropracticExperience;
import com.sakk.princess.patient.rest.resource.ChiropracticExperienceListResource;
import com.sakk.princess.patient.rest.resource.ChiropracticExperienceResource;
import com.sakk.princess.patient.rest.resource.assembler.ChiropracticExperienceListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.ChiropracticExperienceResourceAssembler;
import com.sakk.princess.patient.service.ChiropracticExperienceService;
import com.sakk.princess.patient.service.exception.DuplicateChiropracticExperienceException;
import com.sakk.princess.patient.service.util.ChiropracticExperienceList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/chiropracticexperiences", produces = "application/hal+json")
@Api(value = "/chiropracticexperiences")
// @PreAuthorize("denyAll")
public class ChiropracticExperienceController {

	private ChiropracticExperienceService chiropracticExperienceService;

	@Autowired
	public ChiropracticExperienceController(ChiropracticExperienceService chiropracticExperienceService) {
		this.chiropracticExperienceService = chiropracticExperienceService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get chiropracticExperiences", notes = "This can only be done by admin chiropracticExperience")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ChiropracticExperienceListResource> getChiropracticExperiences() {

		ChiropracticExperienceList chiropracticExperienceList = new ChiropracticExperienceList(
				chiropracticExperienceService.getChiropracticExperiences());

		ChiropracticExperienceListResource chiropracticExperienceListResource = new ChiropracticExperienceListResourceAssembler()
				.toResource(chiropracticExperienceList);

		return new ResponseEntity<ChiropracticExperienceListResource>(chiropracticExperienceListResource,
				HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<ChiropracticExperienceListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		ChiropracticExperienceList chiropracticExperienceList = null;

		if (idList.isEmpty()) {
			chiropracticExperienceList = new ChiropracticExperienceList(new ArrayList<ChiropracticExperience>());
		} else {
			chiropracticExperienceList = new ChiropracticExperienceList(
					chiropracticExperienceService.getChiropracticExperienceSublist(idList));

		}

		ChiropracticExperienceListResource chiropracticExperienceListResource = new ChiropracticExperienceListResourceAssembler()
				.toResource(chiropracticExperienceList);

		return new ResponseEntity<ChiropracticExperienceListResource>(chiropracticExperienceListResource,
				HttpStatus.OK);

	}

	@ApiOperation(value = "Get chiropracticExperience", notes = "This can only be done by admin chiropracticExperience")
	@RequestMapping(value = "/{chiropracticExperienceId}", method = RequestMethod.GET)
	public ResponseEntity<ChiropracticExperienceResource> getChiropracticExperience(
			@PathVariable Long chiropracticExperienceId) {

		ChiropracticExperience chiropracticExperience = chiropracticExperienceService
				.getChiropracticExperience(chiropracticExperienceId);

		if (chiropracticExperience != null) {
			ChiropracticExperienceResource chiropracticExperienceResource = new ChiropracticExperienceResourceAssembler()
					.toResource(chiropracticExperience);
			return new ResponseEntity<ChiropracticExperienceResource>(chiropracticExperienceResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<ChiropracticExperienceResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a chiropracticExperience", notes = "This can only be done by admin chiropracticExperience")
	@RequestMapping(value = "/{patientNumber}/chiropracticexperiences", method = RequestMethod.POST)
	public ResponseEntity<ChiropracticExperienceResource> addChiropracticExperience(
			@RequestBody ChiropracticExperienceResource sentChiropracticExperience) {

		ChiropracticExperience createdChiropracticExperience = null;

		try {
			createdChiropracticExperience = chiropracticExperienceService
					.addChiropracticExperience(sentChiropracticExperience.toChiropracticExperience());
			ChiropracticExperienceResource res = new ChiropracticExperienceResourceAssembler()
					.toResource(createdChiropracticExperience);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<ChiropracticExperienceResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateChiropracticExperienceException exception) {
			throw new ConflictException(exception);
		}
	}

}
