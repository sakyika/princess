package com.sakk.princess.core.rest.resource;

import org.springframework.hateoas.Resource;

import com.sakk.princess.core.model.User;

public class UserResource extends Resource<User> {
	
	public static final String LINK_NAME_ROLE = "role";
	
	UserResource(){
		super(new User());
	}
	
	public UserResource(User user) {
		super(user);
	}
	
	public User toUser(){
		
		User user = new User();
		
		user.setUsername(super.getContent().getUsername());
		user.setPassword(super.getContent().getPassword());
		user.setRole(super.getContent().getRole());
		user.setEnabled(super.getContent().getEnabled());
		
		return user;
		
	}

}
