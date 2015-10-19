package com.sakk.princess.core.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.core.model.Role;

public class RoleList {
	
	private List<Role> roleList = new ArrayList<Role>();

	public RoleList(List<Role> roleList) {
		super();
		this.roleList = roleList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
