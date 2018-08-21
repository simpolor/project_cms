package com.simpolor.cms.module.board.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardStructureDao {

    @Autowired
    private SqlSession sqlSession;

    public int createBoardManager(Map<String, String> map){
        return sqlSession.update("createBoardManager", map);
    }

    public int selectBoardManagerCheck(Map<String, String> map){
        return sqlSession.update("selectBoardManagerCheck", map);
    }

}
