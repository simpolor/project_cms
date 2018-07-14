package com.simpolor.cms.module.role.dao;


import com.simpolor.cms.module.role.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleRepository {

	List<Role> selectRoleList();
	
	Role selectRole(int role_seq);
	
	int selectRoleCodeCheck(String role_code);
	
	int insertRole(Role role);
	
	int updateRole(Role role);
	
	int deleteRole(Role role);
	
}
