package com.sakk.princess.core.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.core.model.Permission;

public class PermissionList {

	private List<Permission> permissionList = new ArrayList<Permission>();

	public PermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

}
