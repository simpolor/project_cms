package com.simpolor.cms.module.board.service;

import com.simpolor.cms.module.board.dao.BoardManagerDao;
import com.simpolor.cms.module.board.dao.BoardStructureDao;
import com.simpolor.cms.module.board.model.BoardManager;
import com.simpolor.cms.module.board.model.BoardStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardStructureService {

    @Autowired
    private BoardStructureDao boardStructureDao;

    public int createBoardManager() {
        return boardStructureDao.createBoardManager();
    }

}
