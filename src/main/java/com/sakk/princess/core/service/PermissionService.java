package com.sakk.princess.core.service;

import java.util.List;

import com.sakk.princess.core.model.Permission;

public interface PermissionService {
	
	public List<Permission> findAllPermissions();

	public Permission addPermission(Permission permission);

	public Permission getPermission(Long permissionId);

	public Permission getPermission(String permissionname);

	public Permission updatePermission(Permission permission);

	public Permission deletePermission(Long permissionId);

	public List<Permission> getPermissions();
	
	public List<Permission> getPermissionSublist(List<String> permissionnameList);

}
