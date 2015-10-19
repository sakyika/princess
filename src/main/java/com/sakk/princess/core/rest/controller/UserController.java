package com.sakk.princess.core.rest.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakk.princess.core.model.User;
import com.sakk.princess.core.rest.exception.ConflictException;
import com.sakk.princess.core.rest.resource.UserListResource;
import com.sakk.princess.core.rest.resource.UserResource;
import com.sakk.princess.core.rest.resource.assembler.UserListResourceAssembler;
import com.sakk.princess.core.rest.resource.assembler.UserResourceAssembler;
import com.sakk.princess.core.service.UserService;
import com.sakk.princess.core.service.exceptions.DuplicateUserException;
import com.sakk.princess.core.service.exceptions.UserExistsException;
import com.sakk.princess.core.service.exceptions.UserNotFoundException;
import com.sakk.princess.core.service.util.UserList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rest/users", produces = "application/hal+json")
@Api(value = "/users")
@PreAuthorize("denyAll")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value="Get users", notes = "This can only be done by admin user")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<UserListResource> getUsers(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "password", required = false) String password)
			throws UserNotFoundException {

		UserList userList = null;
		
		if (name == null) {
			userList = new UserList(userService.getUsers());
		} else {
			User user = userService.getUser(name);

			userList = new UserList(new ArrayList<User>());
			if (user != null) {
				if (password != null) {
					if (user.getPassword().equals(password)) {
						userList = new UserList(Arrays.asList(user));
					}
				} else {
					userList = new UserList(Arrays.asList(user));
				}
			}
		}

		UserListResource userListResource = new UserListResourceAssembler()
				.toResource(userList);

		return new ResponseEntity<UserListResource>(userListResource, HttpStatus.OK);

	}
	
	// @PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET')")
	@RequestMapping(value = "/nameList", method = RequestMethod.GET)
	public ResponseEntity<UserListResource> getUserSublist(
			@RequestParam(value = "nameList", required = false) List<String> nameList)
			throws UserNotFoundException {

		UserList userList = null;
		
		if (nameList.isEmpty()) {
			userList = new UserList(new ArrayList<User>());
		} else {
			userList = new UserList(userService.getUserSublist(nameList));

		}

		UserListResource userListResource = new UserListResourceAssembler()
				.toResource(userList);

		return new ResponseEntity<UserListResource>(userListResource, HttpStatus.OK);

	}

	@ApiOperation(value="Get user", notes = "This can only be done by admin user")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<UserResource> getUser(@PathVariable Long userId) throws UserNotFoundException {
		
		User user = userService.getUser(userId);
		
		if (user != null) {
			UserResource userResource = new UserResourceAssembler().toResource(user);
			return new ResponseEntity<UserResource>(userResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserResource>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value="Create a user", notes = "This can only be done by admin user")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserResource> createAccount(
			@RequestBody UserResource sentUser) throws DuplicateUserException {
		
		User createdUser = null;

		try {
			createdUser = userService.addUser(sentUser.toUser());
			UserResource res = new UserResourceAssembler()
					.toResource(createdUser);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<UserResource>(res, headers,
					HttpStatus.CREATED);
		} catch (UserExistsException exception) {
			throw new ConflictException(exception);
		}
	}

}
