package com.sakk.princess.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.core.jpa.repository.RoleRepository;
import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.service.RoleService;
import com.sakk.princess.core.service.exceptions.RoleNotFoundException;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	//@Autowired
	//private RoleDAO roleDAO;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findAllRoles(){
		return roleRepository.findAll();
	}

	@Override
	public Role addRole(Role role) {
		//return roleDAO.addRole(role);
		return roleRepository.save(role);
	}

	@Override
	public Role getRole(Long roleId) {
		//return roleDAO.getRole(roleId);
		return roleRepository.findOne(roleId);
	}

	@Override
	public Role getRole(String rolename) {
		//return roleDAO.getRole(rolename);
		return roleRepository.findByRoleName(rolename);
	}

	@Override
	public Role updateRole(Role role) {
		
		Role roleToUpdate = getRole(role.getId());
		
		if(roleToUpdate != null){
			roleToUpdate.setId(role.getId());
			roleToUpdate.setPermissionList(role.getPermissionList());
			roleToUpdate.setRolename(role.getRolename());
			roleToUpdate.setUserList(role.getUserList());
		}else{
			throw new RoleNotFoundException();
		}
		
		//return roleDAO.updateRole(role);
		return role;
	}

	@Override
	public Role deleteRole(Long roleId) {
		
		Role roleToDelete = getRole(roleId);
		
		if(roleToDelete != null){
			roleRepository.delete(roleToDelete);
		}else{
			throw new RoleNotFoundException();
		}
		
		//return roleDAO.deleteRole(roleId);
		return roleToDelete;

	}

	@Override
	public List<Role> getRoles() {
		//return roleDAO.getRoles();
		return roleRepository.findAll();
	}
	
	@Override
	public List<Role> getUserRoles(Long userId){
		
		return roleRepository.findByuserListId(userId);
		
	}
	
	@Override
	public List<Role> getRoleSublist(List<String> rolenameList){
		
		List<Role> roleList = new ArrayList<Role>();
		
		for(String rolename : rolenameList){
			try {
				roleList.add(getRole(rolename));
			} catch (RoleNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return roleList;
		
	}

}
