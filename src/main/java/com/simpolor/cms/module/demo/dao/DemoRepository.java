package com.simpolor.cms.module.demo.dao;

import com.simpolor.cms.module.demo.model.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {

	@Autowired
	private SqlSession sqlSession;

	public int selectDemoCount(){
		return sqlSession.selectOne("selectDemoCount");
	}
	
	public Demo selectDemo(int seq){
		return  sqlSession.selectOne("selectDemo", seq);
	}

}
