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

import com.sakk.princess.core.model.Permission;
import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.rest.exception.ConflictException;
import com.sakk.princess.core.rest.resource.PermissionListResource;
import com.sakk.princess.core.rest.resource.PermissionResource;
import com.sakk.princess.core.rest.resource.RoleListResource;
import com.sakk.princess.core.rest.resource.assembler.PermissionListResourceAssembler;
import com.sakk.princess.core.rest.resource.assembler.PermissionResourceAssembler;
import com.sakk.princess.core.rest.resource.assembler.RoleListResourceAssembler;
import com.sakk.princess.core.service.PermissionService;
import com.sakk.princess.core.service.exceptions.DuplicatePermissionException;
import com.sakk.princess.core.service.exceptions.PermissionExistsException;
import com.sakk.princess.core.service.exceptions.PermissionNotFoundException;
import com.sakk.princess.core.service.util.PermissionList;
import com.sakk.princess.core.service.util.RoleList;

@RestController
@RequestMapping(value = "/rest/permissions", produces = "application/hal+json")
// @PreAuthorize("denyAll")
public class PermissionController {

	private PermissionService permissionService;

	@Autowired
	public PermissionController(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	// @PreAuthorize("hasAnyRole('CTRL_PERM_LIST_GET')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PermissionListResource> getPermissions(
			@RequestParam(value = "permissionName", required = false) String permissionName){

		PermissionList permissionList = null;

		if (permissionName == null) {
			permissionList = new PermissionList(permissionService.getPermissions());
			
		} else {
			Permission permission = permissionService.getPermission(permissionName);

			permissionList = new PermissionList(new ArrayList<Permission>());
			if (permission != null) {

				permissionList = new PermissionList(Arrays.asList(permission));
			}
		}

		PermissionListResource permissionListResource = new PermissionListResourceAssembler()
				.toResource(permissionList);

		return new ResponseEntity<PermissionListResource>(permissionListResource, HttpStatus.OK);

	}
	
	// @PreAuthorize("hasAnyRole('CTRL_PERM_LIST_GET')")
		@RequestMapping(value = "/{permissionId}/roles", method = RequestMethod.GET)
		public ResponseEntity<RoleListResource> getPermissionRoles(@PathVariable Long permissionId){

			Permission permission = permissionService.getPermission(permissionId);
			RoleList roleList = null;
			RoleListResource roleListResource = null;
			
			List<Role> rList = null;
			

			if (permission != null) {
				rList = permission.getRoleList();		
			} 
			
			if(!rList.isEmpty()){
				roleList = new RoleList(rList);
				roleListResource = new RoleListResourceAssembler().toResource(roleList);
				return new ResponseEntity<RoleListResource>(roleListResource, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<RoleListResource>(HttpStatus.NOT_FOUND);
			}

		}
	
	// @PreAuthorize("hasAnyRole('CTRL_PERM_LIST_GET')")
	@RequestMapping(value = "/permissionnameList", method = RequestMethod.GET)
	public ResponseEntity<PermissionListResource> getPermissionSublist(
			@RequestParam(value = "permissionnameList", required = false) List<String> permissionnameList)
			throws PermissionNotFoundException {

		PermissionList permissionList = null;
		
		if (permissionnameList.isEmpty()) {
			permissionList = new PermissionList(new ArrayList<Permission>());
		} else {
			permissionList = new PermissionList(permissionService.getPermissionSublist(permissionnameList));

		}

		PermissionListResource permissionListResource = new PermissionListResourceAssembler()
				.toResource(permissionList);

		return new ResponseEntity<PermissionListResource>(permissionListResource, HttpStatus.OK);

	}

	@RequestMapping(value = "/{permissionId}", method = RequestMethod.GET)
	public ResponseEntity<PermissionResource> getPermission(@PathVariable Long permissionId)
			throws PermissionNotFoundException {

		Permission permission = permissionService.getPermission(permissionId);

		if (permission != null) {
			PermissionResource permissionResource = new PermissionResourceAssembler()
					.toResource(permission);
			return new ResponseEntity<PermissionResource>(permissionResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<PermissionResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	//@PreAuthorize("permitAll")
	public ResponseEntity<PermissionResource> createPermission(
			@RequestBody PermissionResource sentPermission) throws DuplicatePermissionException {

		Permission createdPermission = null;

		try {
			createdPermission = permissionService.addPermission(sentPermission.getContent());
			PermissionResource permissionResource = new PermissionResourceAssembler()
					.toResource(createdPermission);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(permissionResource.getLink("self").getHref()));
			return new ResponseEntity<PermissionResource>(permissionResource, headers,
					HttpStatus.CREATED);
		} catch (PermissionExistsException exception) {
			throw new ConflictException(exception);
		}
	}
	
	
	@RequestMapping(value = "/{permissionId}", method = RequestMethod.DELETE)
	public ResponseEntity<PermissionResource> deletePermission(@PathVariable Long permissionId) throws DuplicatePermissionException {
		
		Permission permission = permissionService.deletePermission(permissionId);
		
		if(permission != null){
			PermissionResource permissionResource = new PermissionResourceAssembler().toResource(permission);
			return new ResponseEntity<PermissionResource>(permissionResource, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<PermissionResource>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/{permissionId}", method = RequestMethod.PUT)
	public ResponseEntity<PermissionResource> updatePermission(@PathVariable Long permissionId, 
			@RequestBody PermissionResource sentPermisionResource) {
		
		Permission permissionToUpdate = permissionService.getPermission(permissionId);
		
		if(permissionToUpdate != null){
			permissionToUpdate.setPermissionName(sentPermisionResource.toPermission().getPermissionName());
			permissionToUpdate.setRoleList(sentPermisionResource.toPermission().getRoleList());
			
			Permission permission = permissionService.updatePermission(permissionToUpdate);
			if(permission != null){
				PermissionResource permissionResource = new PermissionResourceAssembler().toResource(permission);
				return new ResponseEntity<PermissionResource>(permissionResource, HttpStatus.OK);
			}
			else{
				return new ResponseEntity<PermissionResource>(HttpStatus.NOT_FOUND);
			}
				
		}
		else{
			return new ResponseEntity<PermissionResource>(HttpStatus.NOT_FOUND);
		}
	}
}

