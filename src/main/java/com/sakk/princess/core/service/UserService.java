package com.sakk.princess.core.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sakk.princess.core.model.User;

public interface UserService extends UserDetailsService {

	public List<User> findAllUsers();

	public User addUser(User user);

	public User getUser(Long userId);

	public User getUser(String username);

	public User updateUser(User user);

	public User deleteUser(Long userId);

	public List<User> getUsers();

	public List<User> getUserSublist(List<String> usernameList);
}