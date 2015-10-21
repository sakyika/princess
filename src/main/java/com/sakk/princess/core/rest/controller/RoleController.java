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
import com.sakk.princess.core.model.User;
import com.sakk.princess.core.rest.exception.ConflictException;
import com.sakk.princess.core.rest.resource.PermissionListResource;
import com.sakk.princess.core.rest.resource.RoleListResource;
import com.sakk.princess.core.rest.resource.RoleResource;
import com.sakk.princess.core.rest.resource.UserListResource;
import com.sakk.princess.core.rest.resource.assembler.PermissionListResourceAssembler;
import com.sakk.princess.core.rest.resource.assembler.RoleListResourceAssembler;
import com.sakk.princess.core.rest.resource.assembler.RoleResourceAssembler;
import com.sakk.princess.core.rest.resource.assembler.UserListResourceAssembler;
import com.sakk.princess.core.service.RoleService;
import com.sakk.princess.core.service.exceptions.DuplicateRoleException;
import com.sakk.princess.core.service.exceptions.RoleExistsException;
import com.sakk.princess.core.service.exceptions.RoleNotFoundException;
import com.sakk.princess.core.service.exceptions.UserNotFoundException;
import com.sakk.princess.core.service.util.PermissionList;
import com.sakk.princess.core.service.util.RoleList;
import com.sakk.princess.core.service.util.UserList;

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
		
		// @PreAuthorize("hasAnyRole('CTRL_ROLE_LIST_GET')")
		@RequestMapping(value = "/{roleId}/users", method = RequestMethod.GET)
		public ResponseEntity<UserListResource> getRoleUsers(@PathVariable Long roleId) throws UserNotFoundException {

			Role role = roleService.getRole(roleId);
			UserList userList = null;
			UserListResource userListResource = null;
			
			List<User> uList = null;

			if(role != null){
				uList = role.getUserList();
			}
			
			if(!uList.isEmpty()){
				userList = new UserList(uList);
				userListResource = new UserListResourceAssembler().toResource(userList);
				return new ResponseEntity<UserListResource>(userListResource, HttpStatus.OK);
			}
			else{
				return new ResponseEntity<UserListResource>(HttpStatus.NOT_FOUND);
			}

		}
		
	// @PreAuthorize("hasAnyRole('CTRL_ROLE_LIST_GET')")
	@RequestMapping(value = "/{roleId}/permissions", method = RequestMethod.GET)
	public ResponseEntity<PermissionListResource> getRolePermissions(@PathVariable Long roleId) throws UserNotFoundException {

		Role role = roleService.getRole(roleId);
		PermissionList permissionList = null;
		PermissionListResource permissionListResource = null;

		List<Permission> pList = null;

		if (role != null) {
			pList = role.getPermissionList();
		}

		if (!pList.isEmpty()) {
			permissionList = new PermissionList(pList);
			permissionListResource = new PermissionListResourceAssembler().toResource(permissionList);
			return new ResponseEntity<PermissionListResource>(permissionListResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<PermissionListResource>(HttpStatus.NOT_FOUND);
		}

	}

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
	
	@RequestMapping(value = "/{roleId}", method = RequestMethod.DELETE)
	public ResponseEntity<RoleResource> deleteRole(@PathVariable Long roleId) {
		
		Role role = roleService.deleteRole(roleId);
		
		if(role != null){
			RoleResource roleResource = new RoleResourceAssembler().toResource(role);
			return new ResponseEntity<RoleResource>(roleResource, HttpStatus.OK);
		}
		
		return null;
	}
	
	@RequestMapping(value = "/{roleId}", method = RequestMethod.PUT)
	public ResponseEntity<RoleResource> updateRole(@PathVariable Long roleId,
			@RequestBody RoleResource sentRoleResource) {
		
		Role roleToUpdate = roleService.getRole(roleId);
		
		if(roleToUpdate != null){
			roleToUpdate.setRolename(sentRoleResource.toRole().getRolename());
			roleToUpdate.setUserList(sentRoleResource.toRole().getUserList());
			
			Role permission = roleService.updateRole(roleToUpdate);
			if(permission != null){
				RoleResource permissionResource = new RoleResourceAssembler().toResource(permission);
				return new ResponseEntity<RoleResource>(permissionResource, HttpStatus.OK);
			}
			else{
				return new ResponseEntity<RoleResource>(HttpStatus.NOT_FOUND);
			}
				
		}
		else{
			return new ResponseEntity<RoleResource>(HttpStatus.NOT_FOUND);
		}
	}

}
