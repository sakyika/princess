package com.sakk.princess.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.core.jpa.repository.UserRepository;
import com.sakk.princess.core.model.User;
import com.sakk.princess.core.service.UserService;
import com.sakk.princess.core.service.exceptions.UserNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//@Autowired
	//private UserDAO userDAO;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAllUsers(){
		return getUsers();
	}

	@Override
	public User addUser(User user) {
		//return userDAO.addUser(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long userId) {
		//return userDAO.getUser(userId);
		return userRepository.findOne(userId);
	}

	@Override
	public User getUser(String username) {
		//return userDAO.getUser(username);
		return userRepository.findByUserName(username);
	}

	@Override
	public User updateUser(User user) {
		
		User userToUpdate = getUser(user.getId());
		
		if(userToUpdate != null){
			userToUpdate.setId(user.getId());
			userToUpdate.setEnabled(user.getEnabled());
			userToUpdate.setUsername(user.getUsername());
			userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
			userToUpdate.setRole(user.getRole());
		}else{
			throw new UserNotFoundException();
		}
		
		//return userDAO.updateUser(user);
		return user;
	}

	@Override
	public User deleteUser(Long userId) {
		
		User userToDelete = getUser(userId);
		
		if( userToDelete != null){
			userRepository.delete(userToDelete);
		}else{
			throw new UserNotFoundException();
		}
		
		//return userDAO.deleteUser(userId);
		return userToDelete;
	}

	@Override
	public List<User> getUsers() {
		//return userDAO.getUsers();
		return userRepository.findAll();
	}
	
	@Override
	public List<User> getUserSublist(List<String> nameList){
		
		List<User> userList = new ArrayList<User>();
		
		for(String name : nameList){
			try {
				userList.add(getUser(name));
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return userList;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			return getUser(username);
		} catch (UserNotFoundException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}
}