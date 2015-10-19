package com.sakk.princess.core.dao;

import java.util.List;

import com.sakk.princess.core.model.User;
import com.sakk.princess.core.service.exceptions.DuplicateUserException;
import com.sakk.princess.core.service.exceptions.UserNotFoundException;

public interface UserDAO {

	public User addUser(User user) throws DuplicateUserException;

	public User getUser(Long userId) throws UserNotFoundException;

	public User getUser(String username) throws UserNotFoundException;

	public User updateUser(User user) throws UserNotFoundException,
			DuplicateUserException;

	public User deleteUser(Long userId) throws UserNotFoundException;

	public List<User> getUsers();

}