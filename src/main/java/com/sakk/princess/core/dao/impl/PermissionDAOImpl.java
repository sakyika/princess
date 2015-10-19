package com.sakk.princess.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sakk.princess.core.dao.PermissionDAO;
import com.sakk.princess.core.model.Permission;
import com.sakk.princess.core.service.exceptions.DuplicatePermissionException;
import com.sakk.princess.core.service.exceptions.PermissionNotFoundException;

@Repository
public class PermissionDAOImpl implements PermissionDAO {
	static Logger logger = LoggerFactory.getLogger(PermissionDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Permission addPermission(Permission permission)
			throws DuplicatePermissionException {
		logger.debug("PermissionDAOImpl.addPermission() - ["
				+ permission.getPermissionName() + "]");
		try {
			// if the permission is not found, then a
			// PermissionNotFoundException is
			// thrown from the getPermission method call, and the new permission
			// will be
			// added.
			//
			// if the permission is found, then the flow will continue from the
			// getPermission
			// method call and the DuplicatePermissionException will be thrown.
			Permission permCheck = getPermission(permission.getPermissionName());
			String message = "The permission [" + permCheck.getPermissionName()
					+ "] already exists";
			throw new DuplicatePermissionException(message);
		} catch (PermissionNotFoundException e) {
			getCurrentSession().save(permission);
		}

		return permission;
	}

	@Override
	public Permission getPermission(Long permission_id)
			throws PermissionNotFoundException {
		Permission permObject = (Permission) getCurrentSession().get(
				Permission.class, permission_id);
		if (permObject == null) {
			throw new PermissionNotFoundException("Permission id ["
					+ permission_id + "] not found");
		} else {
			return permObject;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Permission getPermission(String usersPermission)
			throws PermissionNotFoundException {
		logger.debug("PermissionDAOImpl.getPermission() - [" + usersPermission
				+ "]");
		Query query = getCurrentSession().createQuery(
				"from Permission where permissionname = :usersPermission ");
		query.setString("usersPermission", usersPermission);

		logger.debug(query.toString());
		if (query.list().size() == 0) {
			throw new PermissionNotFoundException("Permission ["
					+ usersPermission + "] not found");
		} else {
			logger.debug("Permission List Size: " + query.list().size());
			List<Permission> list = (List<Permission>) query.list();
			Permission permObject = (Permission) list.get(0);

			return permObject;
		}
	}

	@Override
	public Permission updatePermission(Permission permission)
			throws PermissionNotFoundException, DuplicatePermissionException {
		Permission permToUpdate = getPermission(permission.getId());

		try {
			Permission permissionCheck = getPermission(permission
					.getPermissionName());
			if (permToUpdate.getId() == permissionCheck.getId()) {
				permToUpdate.setId(permission.getId());
				permToUpdate.setPermissionName(permission.getPermissionName());
				permToUpdate.setRoleSet(permission.getRoleSet());
				getCurrentSession().update(permToUpdate);
			} else {
				String message = "The permission ["
						+ permissionCheck.getPermissionName()
						+ "] already exists";
				throw new DuplicatePermissionException(message);
			}
		} catch (PermissionNotFoundException e) {
			permToUpdate.setId(permission.getId());
			permToUpdate.setPermissionName(permission.getPermissionName());
			permToUpdate.setRoleSet(permission.getRoleSet());
			getCurrentSession().update(permToUpdate);
		}

		return permission;
	}

	@Override
	public Permission deletePermission(Long permission_id)
			throws PermissionNotFoundException {
		Permission permission = getPermission(permission_id);
		if (permission != null) {
			getCurrentSession().delete(permission);
		}

		return permission;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Permission> getPermissions() {
		String hql = "FROM Permission p ORDER BY p.id";
		return getCurrentSession().createQuery(hql).list();
	}
}