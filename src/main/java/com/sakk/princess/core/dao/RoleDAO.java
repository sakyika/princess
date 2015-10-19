package com.sakk.princess.core.dao;

import java.util.List;

import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.service.exceptions.DuplicateRoleException;
import com.sakk.princess.core.service.exceptions.RoleNotFoundException;

public interface RoleDAO {

	public Role addRole(Role role) throws DuplicateRoleException;

	public Role getRole(Long id) throws RoleNotFoundException;

	public Role getRole(String roleName) throws RoleNotFoundException;

	public Role updateRole(Role role) throws RoleNotFoundException;

	public Role deleteRole(Long id) throws RoleNotFoundException;

	public List<Role> getRoles();

}