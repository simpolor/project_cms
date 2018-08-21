package com.simpolor.cms.module.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BoardStructureDao {

    @Autowired
    private SqlSession sqlSession;

    public int createBoardManager(Map<String, String> map){
        return sqlSession.insert("createBoardManager", map);
    }

}
