package com.simpolor.cms.module.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @RequestMapping("/board/list")
    public ModelAndView boardList(ModelAndView mav){

        logger.info("[M] boardList");

        mav.setViewName("module/board/boardList");

        return mav;
    }
}


