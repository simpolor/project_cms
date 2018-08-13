package com.simpolor.cms.module.board.service;

import com.simpolor.cms.module.access.dao.AccessRepository;
import com.simpolor.cms.module.board.dao.BoardDao;
import com.simpolor.cms.module.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;

    public int getBoardTotalCount(Board board) {
        return boardDao.selectBoardTotalCount(board);
    }

    public List<Board> getBoardList(Board board) {
        return boardDao.selectBoardList(board);
    }

    public Board getBoard(int seq) {
        return boardDao.selectBoard(seq);
    }

    public int registerBoard(Board board) {
        return boardDao.insertBoard(board);
    }

    public int modifyBoard(Board board) {
        return boardDao.updateBoard(board);
    }

    public int deleteBoard(Board board) {
        return boardDao.deleteBoard(board);
    }

}
