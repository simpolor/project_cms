package com.simpolor.cms.module.access.dao;


import com.simpolor.cms.module.access.model.Access;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccessRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<Access> selectAccessList(){
		return  sqlSession.selectList("selectAccessList");
	}

	public Access selectAccess(int access_seq){
		return sqlSession.selectOne("selectAccess", access_seq);
	}

	public int selectAccessUrlCheck(String access_url){
		return sqlSession.selectOne("selectAccessUrlCheck", access_url);
	}

	public int insertAccess(Access access){
		return sqlSession.insert("insertAccess", access);
	}

	public int updateAccess(Access access){
		return sqlSession.update("updateAccess", access);
	}

	public int deleteAccess(Access access){
		return sqlSession.update("deleteAccess", access);
	}

	public List<Access> selectResourceList(){
		return  sqlSession.selectList("selectResourceList");
	}

	
}
