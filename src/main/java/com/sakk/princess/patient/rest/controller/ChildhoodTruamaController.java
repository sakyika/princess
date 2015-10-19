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
import com.sakk.princess.patient.model.ChildhoodTruama;
import com.sakk.princess.patient.rest.resource.ChildhoodTruamaListResource;
import com.sakk.princess.patient.rest.resource.ChildhoodTruamaResource;
import com.sakk.princess.patient.rest.resource.assembler.ChildhoodTruamaListResourceAssembler;
import com.sakk.princess.patient.rest.resource.assembler.ChildhoodTruamaResourceAssembler;
import com.sakk.princess.patient.service.ChildhoodTruamaService;
import com.sakk.princess.patient.service.exception.DuplicateChildhoodTruamaException;
import com.sakk.princess.patient.service.util.ChildhoodTruamaList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/childhoodtruamas", produces = "application/hal+json")
//@RequestMapping(value = "/rest/childhoodtruamas")
@Api(value = "/childhoodTruamas")
// @PreAuthorize("denyAll")
public class ChildhoodTruamaController {

	private ChildhoodTruamaService childhoodTruamaService;

	@Autowired
	public ChildhoodTruamaController(ChildhoodTruamaService childhoodTruamaService) {
		this.childhoodTruamaService = childhoodTruamaService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@ApiOperation(value = "Get childhoodTruamas", notes = "This can only be done by admin childhoodTruama")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ChildhoodTruamaListResource> getChildhoodTruamas() {

		ChildhoodTruamaList childhoodTruamaList = new ChildhoodTruamaList(childhoodTruamaService.getChildhoodTruamas());

		ChildhoodTruamaListResource childhoodTruamaListResource = new ChildhoodTruamaListResourceAssembler()
				.toResource(childhoodTruamaList);

		return new ResponseEntity<ChildhoodTruamaListResource>(childhoodTruamaListResource, HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<ChildhoodTruamaListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<Long> idList) {

		ChildhoodTruamaList childhoodTruamaList = null;

		if (idList.isEmpty()) {
			childhoodTruamaList = new ChildhoodTruamaList(new ArrayList<ChildhoodTruama>());
		} else {
			childhoodTruamaList = new ChildhoodTruamaList(childhoodTruamaService.getChildhoodTruamaSublist(idList));

		}

		ChildhoodTruamaListResource childhoodTruamaListResource = new ChildhoodTruamaListResourceAssembler()
				.toResource(childhoodTruamaList);

		return new ResponseEntity<ChildhoodTruamaListResource>(childhoodTruamaListResource, HttpStatus.OK);

	}

	@ApiOperation(value = "Get childhoodTruama", notes = "This can only be done by admin childhoodTruama")
	@RequestMapping(value = "/{childhoodTruamaId}", method = RequestMethod.GET)
	public ResponseEntity<ChildhoodTruamaResource> getChildhoodTruama(@PathVariable Long childhoodTruamaId) {

		ChildhoodTruama childhoodTruama = childhoodTruamaService.getChildhoodTruama(childhoodTruamaId);

		if (childhoodTruama != null) {
			ChildhoodTruamaResource childhoodTruamaResource = new ChildhoodTruamaResourceAssembler()
					.toResource(childhoodTruama);
			return new ResponseEntity<ChildhoodTruamaResource>(childhoodTruamaResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<ChildhoodTruamaResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a childhoodTruama", notes = "This can only be done by admin childhoodTruama")
	@RequestMapping(value = "/{patientNumber}/childhoodtruamas", method = RequestMethod.POST)
	public ResponseEntity<ChildhoodTruamaResource> addChildhoodTruama(
			@RequestBody ChildhoodTruamaResource sentChildhoodTruama) {

		ChildhoodTruama createdChildhoodTruama = null;

		try {
			createdChildhoodTruama = childhoodTruamaService.addChildhoodTruama(sentChildhoodTruama.toChildhoodTruama());
			ChildhoodTruamaResource res = new ChildhoodTruamaResourceAssembler().toResource(createdChildhoodTruama);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<ChildhoodTruamaResource>(res, headers, HttpStatus.CREATED);
		} catch (DuplicateChildhoodTruamaException exception) {
			throw new ConflictException(exception);
		}
	}

}
