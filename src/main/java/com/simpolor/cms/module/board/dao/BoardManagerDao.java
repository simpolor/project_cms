package com.simpolor.cms.module.board.dao;

import com.simpolor.cms.module.board.model.BoardManager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardManagerDao {

    @Autowired
    private SqlSession sqlSession;

    public int selectBoardManagerTotalCount(BoardManager boardManager){
        return  sqlSession.selectOne("selectBoardManagerTotalCount", boardManager);
    }

    public List<BoardManager> selectBoardManagerList(BoardManager boardManager){
        return  sqlSession.selectList("selectBoardManagerList", boardManager);
    }

    public BoardManager selectBoardManager(int board_seq){
        return sqlSession.selectOne("selectBoardManager", board_seq);
    }

    public int insertBoardManager(BoardManager boardManager){
        return sqlSession.insert("insertBoardManager", boardManager);
    }

    public int updateBoardManager(BoardManager boardManager){
        return sqlSession.update("updateBoardManager", boardManager);
    }

    public int deleteBoardManager(BoardManager boardManager){
        return sqlSession.update("deleteBoardManager", boardManager);
    }


}
