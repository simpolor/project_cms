package com.simpolor.cms.module.board.service;

import com.simpolor.cms.module.board.dao.BoardDao;
import com.simpolor.cms.module.board.dao.BoardManagerDao;
import com.simpolor.cms.module.board.model.Board;
import com.simpolor.cms.module.board.model.BoardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardManagerService {

    @Autowired
    private BoardManagerDao boardManagerDao;

    public int getBoardManagerTotalCount(BoardManager boardManager) {
        return boardManagerDao.selectBoardManagerTotalCount(boardManager);
    }

    public List<BoardManager> getBoardManagerList(BoardManager boardManager) {
        return boardManagerDao.selectBoardManagerList(boardManager);
    }

    public BoardManager getBoardManager(int board_seq) {
        return boardManagerDao.selectBoardManager(board_seq);
    }

    public int registerBoardManager(BoardManager boardManager) {
        return boardManagerDao.insertBoardManager(boardManager);
    }

    public int changeBoardManager(BoardManager boardManager) {
        return boardManagerDao.updateBoardManager(boardManager);
    }

    public int removeBoardManager(BoardManager boardManager) {
        return boardManagerDao.deleteBoardManager(boardManager);
    }

}
