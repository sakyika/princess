package com.sakk.princess.core.dao;

import java.util.List;

import com.sakk.princess.core.model.Permission;
import com.sakk.princess.core.service.exceptions.DuplicatePermissionException;
import com.sakk.princess.core.service.exceptions.PermissionNotFoundException;

public interface PermissionDAO {

	public Permission addPermission(Permission permission)
			throws DuplicatePermissionException;

	public Permission getPermission(Long permissionId) throws PermissionNotFoundException;

	public Permission getPermission(String permissionName)
			throws PermissionNotFoundException;

	public Permission updatePermission(Permission permission)
			throws PermissionNotFoundException, DuplicatePermissionException;

	public Permission deletePermission(Long permissionId) throws PermissionNotFoundException;

	public List<Permission> getPermissions();

}
