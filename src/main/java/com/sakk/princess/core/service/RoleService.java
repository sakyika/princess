package com.sakk.princess.core.service;

import java.util.List;

import com.sakk.princess.core.model.Role;

public interface RoleService {
	
	public List<Role> findAllRoles();

	public Role addRole(Role role);

	public Role getRole(Long roleId);

	public Role getRole(String rolename);

	public Role updateRole(Role role);

	public Role deleteRole(Long roleId);

	public List<Role> getRoles();
	
	public List<Role> getUserRoles(Long userId);

	public List<Role> getRoleSublist(List<String> rolenameList);
}
