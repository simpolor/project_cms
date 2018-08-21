package com.simpolor.cms.module.board.service;

import com.simpolor.cms.module.board.dao.BoardStructureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BoardStructureService {

    @Autowired
    private BoardStructureDao boardStructureDao;

    public int createBoardManager(Map<String, String> map) {
        return boardStructureDao.createBoardManager(map);
    }

}
