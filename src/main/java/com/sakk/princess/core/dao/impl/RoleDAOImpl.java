package com.sakk.princess.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sakk.princess.core.dao.RoleDAO;
import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.service.exceptions.DuplicateRoleException;
import com.sakk.princess.core.service.exceptions.RoleNotFoundException;

@Repository
public class RoleDAOImpl implements RoleDAO {
	static Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Role addRole(Role role) throws DuplicateRoleException {
		logger.debug("RoleDAOImpl.addRole() - [" + role.getRolename() + "]");
		try {
			// if the role is not found, then a RoleNotFoundException is
			// thrown from the getRole method call, and the new role will be
			// added.
			//
			// if the role is found, then the flow will continue from the
			// getRole
			// method call and the DuplicateRoleException will be thrown.
			Role roleCheck = getRole(role.getRolename());
			String message = "The role [" + roleCheck.getRolename()
					+ "] already exists";
			throw new DuplicateRoleException(message);
		} catch (RoleNotFoundException e) {
			getCurrentSession().save(role);
		}
		
		return role;
	}

	@Override
	public Role getRole(Long role_id) throws RoleNotFoundException {
		Role roleObject = null;
		
		roleObject = (Role) getCurrentSession().get(Role.class, role_id);
		if (roleObject == null) {
			throw new RoleNotFoundException("Role id [" + role_id
					+ "] not found");
		} else {
			return roleObject;
		}
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Role getRole(String usersRole) throws RoleNotFoundException {
		logger.debug("RoleDAOImpl.getRole() - [" + usersRole + "]");
		Query query = getCurrentSession().createQuery(
				"from Role where rolename = :usersRole ");
		query.setString("usersRole", usersRole);

		logger.debug(query.toString());
		if (query.list().size() == 0) {
			throw new RoleNotFoundException("Role [" + usersRole
					+ "] not found");
		} else {
			logger.debug("Role List Size: " + query.list().size());
			List<Role> list = (List<Role>) query.list();
			Role roleObject = (Role) list.get(0);

			return roleObject;
		}
	}

	@Override
	public Role updateRole(Role role) throws RoleNotFoundException {
		Role roleToUpdate = getRole(role.getId());
		roleToUpdate.setId(role.getId());
		roleToUpdate.setRolename(role.getRolename());
		getCurrentSession().update(roleToUpdate);
		
		return role;
	}

	@Override
	public Role deleteRole(Long role_id) throws RoleNotFoundException {
		Role role = getRole(role_id);
		if (role != null) {
			getCurrentSession().delete(role);
		}
		
		return role;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Role> getRoles() {
		return getCurrentSession().createQuery("from Role").list();
	}
}