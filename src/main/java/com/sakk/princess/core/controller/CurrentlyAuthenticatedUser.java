package com.sakk.princess.core.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentlyAuthenticatedUser {
	
	@RequestMapping("/user")
	public Principal user(Principal user){
		return user;
	}

}
