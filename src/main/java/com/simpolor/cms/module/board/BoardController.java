package com.simpolor.cms.module.board;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @RequestMapping("/board/list")
    public String boardList(){
        return "Board List";
    }
}


