package com.sakk.princess.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.core.jpa.repository.PermissionRepository;
import com.sakk.princess.core.model.Permission;
import com.sakk.princess.core.service.PermissionService;
import com.sakk.princess.core.service.exceptions.PermissionNotFoundException;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	//@Autowired
	//private PermissionDAO permissionDAO;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	public List<Permission> findAllPermissions(){	
		return permissionRepository.findAll();	
	}

	@Override
	public Permission addPermission(Permission permission){
		//return permissionDAO.addPermission(permission);
		return permissionRepository.save(permission);
	}

	@Override
	public Permission getPermission(Long permissionId) {
		//return permissionDAO.getPermission(permissionId);
		return permissionRepository.findOne(permissionId);
	}

	@Override
	public Permission getPermission(String permissionName){
		//return permissionDAO.getPermission(permissionName);
		return permissionRepository.findByPermissionName(permissionName);
	}

	@Override
	public Permission updatePermission(Permission permission){
		
		Permission permissionToUpdate = getPermission(permission.getId());
		
		if(permissionToUpdate != null){
		
			permissionToUpdate.setId(permission.getId());
			permissionToUpdate.setPermissionName(permission.getPermissionName());
			permissionToUpdate.setRoleList(permission.getRoleList());
		}else{
			throw new PermissionNotFoundException();
		}

		//return permissionDAO.updatePermission(permission);
		return permission;

	}

	@Override
	public Permission deletePermission(Long permissionId) {
		
		Permission permissionToDelete = getPermission(permissionId);
		
		if(permissionToDelete != null){
			
			permissionRepository.delete(permissionToDelete);
			
		}else{
			
			throw new PermissionNotFoundException();
			
		}

		//return permissionDAO.deletePermission(permissionId);
		
		return permissionToDelete;

	}

	@Override
	public List<Permission> getPermissions() {
		//return permissionDAO.getPermissions();
		return permissionRepository.findAll();
	}
	
	@Override
	public List<Permission> getPermissionSublist(List<String> permissionnameList){
		
		List<Permission> permissionList = new ArrayList<Permission>();
		
		for(String permissionname : permissionnameList){
			try {
				permissionList.add(getPermission(permissionname));
			} catch (PermissionNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return permissionList;
	}

}
