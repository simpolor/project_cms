package com.simpolor.cms.module.board;

import com.simpolor.cms.component.Pagination;
import com.simpolor.cms.component.PaginationBuilder;
import com.simpolor.cms.component.PaginationUtil;
import com.simpolor.cms.module.board.model.Board;
import com.simpolor.cms.module.board.service.BoardService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

    final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/list")
    public ModelAndView boardList( ModelAndView mav, @RequestParam(value = "page", defaultValue = "1") int page ){

        logger.info("[M] boardList");

        Board board = new Board();

        // 전체 갯수 가져오기
        int totalCount = boardService.getBoardTotalCount(board);

        // 페이징 정보 추가
        PaginationUtil paging = new PaginationUtil();
        paging.setTotalCount(totalCount);
        paging.setPageNo(page);
        paging.makePagination();

        PaginationBuilder paginationBuilder = new PaginationBuilder();
        Pagination pagination = paginationBuilder
                                    .setCurrentPageNo(page)
                                    .setNumberOfRecords(totalCount)
                                    .build();

        // bookmarkVO에 offset, limit 세팅
        board.setOffset(paging.getOffset());
        board.setLimit(paging.getLimit());

        List<Board> list = boardService.getBoardList(board);

        System.out.println("list.size : "+list.size());

        mav.addObject("boardList", list);
        mav.addObject("paging", paging);
        mav.addObject("pagination", pagination);

        mav.setViewName("module/board/board_list");

        return mav;
    }

    @GetMapping("/board/view")
    public ModelAndView boardView( HttpServletRequest request, ModelAndView mav, @RequestParam(value = "seq") int seq ){

        logger.info("[M] boardView");

        Board board = boardService.getBoard(seq);
        System.out.println("board : "+board);

        String referer = request.getHeader("referer");

        if(ObjectUtils.isEmpty(board)){
            System.out.println("referer : "+referer);
            mav.setViewName("redirect:"+referer);
        }

        mav.addObject("board", board);
        mav.setViewName("module/board/board_view");

        return mav;
    }

    @GetMapping(value="/board/write")
    public ModelAndView boardWriteForm( ModelAndView mav ){

        logger.info("[M] boardWriteForm");

        mav.setViewName("module/board/board_write");

        return mav;
    }

    @PostMapping("/board/write")
    public ModelAndView boardWrite( ModelAndView mav, Board board ){

        logger.info("[M] boardAdd");

        board.setRegi_id("test");
        board.setRegi_name("test");

        /*int result = 0;
        for(int i=0; i<150; i++){
            result = boardService.registerBoard(board);
            String[] title = StringUtils.split(board.getTitle(), " - ");
            String[] content = StringUtils.split(board.getContent(), " - ");
            board.setTitle(title[0] + " - "+i);
            board.setContent(content[0] + " - "+i);
            System.out.println("i : "+i);
        }*/

        int result = boardService.registerBoard(board);
        if(result > 0){
            mav.setViewName("redirect:/board/list");
        }else{
            mav.setViewName("module/board/board_write");
        }

        return mav;
    }

    @GetMapping("/board/modify")
    public ModelAndView boardModifyForm( ModelAndView mav, @RequestParam(value = "seq") int seq ){

        logger.info("[M] boardModifyFrom");

        Board board = boardService.getBoard(seq);

        mav.addObject("board", board);
        mav.setViewName("module/board/board_modify");

        return mav;
    }

    @PostMapping("/board/modify")
    public ModelAndView boardModify( ModelAndView mav, Board board ){

        logger.info("[M] boardModify");

        board.setModi_id("test2");
        board.setModi_name("test2");
        System.out.println("board.seq : "+board.getSeq());
        System.out.println("board.title : "+board.getTitle());
        System.out.println("board.content : "+board.getContent());
        int result = boardService.modifyBoard(board);
        if(result > 0){
            mav.setViewName("redirect:/board/view?seq="+board.getSeq());
        }else{
            mav.setViewName("module/board/board_modify?seq="+board.getSeq());
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
            mav.setViewName("module/board/board_view?seq="+board.getSeq());
        }

        return mav;
    }
}


