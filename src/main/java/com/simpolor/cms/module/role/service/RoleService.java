package com.simpolor.cms.module.role.service;

import com.simpolor.cms.module.role.model.Role;
import com.simpolor.cms.module.role.dao.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public List<Role> getRoleList() {
		return roleRepository.selectRoleList();
	}
	
	public Role getRole(int role_seq) {
		return roleRepository.selectRole(role_seq);
	}
	
	public int isRoleCode(String role_code) {
		return roleRepository.selectRoleCodeCheck(role_code);
	}
	
	public int registerRole(Role role) {
		return roleRepository.insertRole(role);
	}
	
	public int modifyRole(Role role) {
		return roleRepository.updateRole(role);
	}
	
	public int deleteRole(Role role) {
		return roleRepository.deleteRole(role);
	}

}
