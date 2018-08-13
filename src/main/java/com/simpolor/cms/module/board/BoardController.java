package com.simpolor.cms.module.board;

import com.simpolor.cms.component.Pagination;
import com.simpolor.cms.module.board.model.Board;
import com.simpolor.cms.module.board.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/list")
    public ModelAndView boardList(ModelAndView mav){

        logger.info("[M] boardList");

        Board board = new Board();

        // 전체 갯수 가져오기
        int totalCount = boardService.getBoardTotalCount(board);

        // page 파라미터 값 가져오기
        int page = 1;

        // 페이징 정보 추가
        Pagination paging = new Pagination();
        paging.setTotalCount(totalCount);
        paging.setPageNo(page);
        paging.makePagination();

        // bookmarkVO에 offset, limit 세팅
        board.setOffset(paging.getOffset());
        board.setLimit(paging.getLimit());

        List<Board> list = boardService.getBoardList(board);

        System.out.println("list.size : "+list.size());

        mav.addObject("boardList", list);
        mav.addObject("paging", paging);
        mav.setViewName("module/board/boardList");

        return mav;
    }

    @GetMapping("/board/view/{seq}")
    public ModelAndView boardView(ModelAndView mav, @PathVariable int seq){

        logger.info("[M] boardView");

        Board board = boardService.getBoard(seq);

        mav.addObject("board", board);
        mav.setViewName("module/board/boardView");

        return mav;
    }

    @GetMapping(value="/board/write")
    public ModelAndView boardWriteForm(ModelAndView mav, Board board){

        logger.info("[M] boardWriteForm");

        mav.setViewName("module/board/boardWrite");

        return mav;
    }

    @PostMapping("/board/write")
    public ModelAndView boardWrite(ModelAndView mav, Board board){

        logger.info("[M] boardAdd");

        board.setRegi_id("test");
        board.setRegi_name("test");
        int result = boardService.registerBoard(board);
        if(result > 0){
            mav.setViewName("redirect:/board/list");
        }else{
            mav.setViewName("module/board/boardWrite");
        }

        return mav;
    }

    @GetMapping("/board/modify/{seq}")
    public ModelAndView boardModifyForm(ModelAndView mav, @PathVariable int seq){

        logger.info("[M] boardModifyFrom");

        Board board = boardService.getBoard(seq);

        mav.addObject("board", board);
        mav.setViewName("module/board/boardModify");

        return mav;
    }

    @PostMapping("/board/modify")
    public ModelAndView boardModify(ModelAndView mav, Board board){

        logger.info("[M] boardModify");

        board.setModi_id("test2");
        board.setModi_name("test2");
        System.out.println("board.seq : "+board.getSeq());
        System.out.println("board.title : "+board.getTitle());
        System.out.println("board.content : "+board.getContent());
        int result = boardService.modifyBoard(board);
        if(result > 0){
            mav.setViewName("redirect:/board/view/"+board.getSeq());
        }else{
            mav.setViewName("module/board/boardEdit");
        }

        return mav;
    }

    @PostMapping("/board/delete")
    public ModelAndView boardDelete(ModelAndView mav, Board board){

        logger.info("[M] boardRemove");

        board.setModi_id("test3");
        board.setModi_name("test3");
        int result = boardService.deleteBoard(board);
        if(result > 0){
            mav.setViewName("redirect:/board/list");
        }else{
            mav.setViewName("module/board/boardView");
        }

        return mav;
    }
}


