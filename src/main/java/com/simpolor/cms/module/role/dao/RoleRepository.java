package com.simpolor.cms.module.role.dao;


import com.simpolor.cms.module.role.model.Role;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<Role> selectRoleList(){
		return sqlSession.selectList("selectRoleList");
	}

	public Role selectRole(int role_seq){
		return sqlSession.selectOne("selectRole", role_seq);
	}

	public int selectRoleCodeCheck(String role_code){
		return sqlSession.selectOne("selectRoleCodeCheck", role_code);
	}

	public int insertRole(Role role){
		return sqlSession.insert("insertRole", role);
	}

	public int updateRole(Role role){
		return sqlSession.update("updateRole", role);
	}

	public int deleteRole(Role role){
		return sqlSession.update("deleteRole", role);
	}
	
}
