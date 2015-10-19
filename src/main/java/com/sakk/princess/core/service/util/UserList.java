package com.sakk.princess.core.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.core.model.User;

public class UserList {

	private List<User> userList = new ArrayList<User>();

	public UserList(List<User> userList) {
		this.userList = userList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
