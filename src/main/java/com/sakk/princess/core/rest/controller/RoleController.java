package com.sakk.princess.core.rest.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.rest.exception.ConflictException;
import com.sakk.princess.core.rest.resource.RoleListResource;
import com.sakk.princess.core.rest.resource.RoleResource;
import com.sakk.princess.core.rest.resource.assembler.RoleListResourceAssembler;
import com.sakk.princess.core.rest.resource.assembler.RoleResourceAssembler;
import com.sakk.princess.core.service.RoleService;
import com.sakk.princess.core.service.exceptions.DuplicateRoleException;
import com.sakk.princess.core.service.exceptions.RoleExistsException;
import com.sakk.princess.core.service.exceptions.RoleNotFoundException;
import com.sakk.princess.core.service.util.RoleList;

@RestController
@RequestMapping(value = "/rest/roles", produces = "application/hal+json")
// @PreAuthorize("denyAll")
public class RoleController {

	private RoleService roleService;

	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_ROLE_LIST_GET')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<RoleListResource> getRoles(
			@RequestParam(value = "roleName", required = false) String roleName) throws RoleNotFoundException {

		RoleList roleList = null;

		if (roleName == null) {
			roleList = new RoleList(roleService.getRoles());
		} else {
			Role role = roleService.getRole(roleName);

			roleList = new RoleList(new ArrayList<Role>());
			if (role != null) {
				roleList = new RoleList(Arrays.asList(role));
			}
		}

		RoleListResource roleListResource = new RoleListResourceAssembler().toResource(roleList);

		return new ResponseEntity<RoleListResource>(roleListResource, HttpStatus.OK);

	}
	
	
	// @PreAuthorize("hasAnyRole('CTRL_ROLE_LIST_GET')")
		@RequestMapping(value = "/roleNameList", method = RequestMethod.GET)
		public ResponseEntity<RoleListResource> getRoleUsers(
				@RequestParam(value = "roleId", required = false) Long roleId) throws RoleNotFoundException {
			

			RoleList roleList = new RoleList(roleService.getUserRoles(roleId));			

			RoleListResource roleListResource = new RoleListResourceAssembler().toResource(roleList);

			return new ResponseEntity<RoleListResource>(roleListResource, HttpStatus.OK);

		}
	
/*
	// @PreAuthorize("hasAnyRole('CTRL_ROLE_LIST_GET')")
	@RequestMapping(value = "/roleNameList", method = RequestMethod.GET)
	public ResponseEntity<RoleListResource> getRoleSublist(
			@RequestParam(value = "roleNameList", required = false) List<String> roleNameList)
					throws RoleNotFoundException {

		RoleList roleList = null;

		if (roleNameList.isEmpty()) {
			roleList = new RoleList(new ArrayList<Role>());
		} else {
			roleList = new RoleList(roleService.getRoleSublist(roleNameList));
		}

		RoleListResource roleListResource = new RoleListResourceAssembler().toResource(roleList);

		return new ResponseEntity<RoleListResource>(roleListResource, HttpStatus.OK);

	}

*/

	@RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
	public ResponseEntity<RoleResource> getRole(@PathVariable Long roleId) throws RoleNotFoundException {

		Role role = roleService.getRole(roleId);

		if (role != null) {
			RoleResource roleResource = new RoleResourceAssembler().toResource(role);
			return new ResponseEntity<RoleResource>(roleResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<RoleResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	// @PreAuthorize("permitAll")
	public ResponseEntity<RoleResource> createRole(@RequestBody RoleResource sentRole) throws DuplicateRoleException {

		Role createdRole = null;

		try {
			createdRole = roleService.addRole(sentRole.getContent());
			RoleResource roleResource = new RoleResourceAssembler().toResource(createdRole);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(roleResource.getLink("self").getHref()));
			return new ResponseEntity<RoleResource>(roleResource, headers, HttpStatus.CREATED);
		} catch (RoleExistsException exception) {
			throw new ConflictException(exception);
		}
	}

}
