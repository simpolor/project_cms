package com.simpolor.cms.module.board.dao;

import com.simpolor.cms.module.board.model.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    @Autowired
    private SqlSession sqlSession;

    public int selectBoardTotalCount(Board board){
        return  sqlSession.selectOne("selectBoardTotalCount", board);
    }

    public List<Board> selectBoardList(Board board){
        return  sqlSession.selectList("selectBoardList", board);
    }

    public Board selectBoard(int seq){
        return sqlSession.selectOne("selectBoard", seq);
    }

    public int insertBoard(Board board){
        return sqlSession.insert("insertBoard", board);
    }

    public int updateBoard(Board board){
        return sqlSession.update("updateBoard", board);
    }

    public int deleteBoard(Board board){
        return sqlSession.update("deleteBoard", board);
    }

}
