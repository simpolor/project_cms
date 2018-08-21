package com.simpolor.cms.module.board;

import com.simpolor.cms.component.Pagination;
import com.simpolor.cms.component.PaginationBuilder;
import com.simpolor.cms.component.PaginationUtil;
import com.simpolor.cms.module.board.model.Board;
import com.simpolor.cms.module.board.model.BoardManager;
import com.simpolor.cms.module.board.service.BoardManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardManagerController {

    final Logger logger = LoggerFactory.getLogger(BoardManagerController.class);

    @Autowired
    private BoardManagerService boardManagerService;

    @GetMapping("/board/manager/list")
    public ModelAndView boardManagerList(ModelAndView mav, @RequestParam(value = "page", defaultValue = "1") int page ) {

        logger.info("[M] boardManagerList");

        BoardManager boardManager = new BoardManager();

        // 전체 갯수 가져오기
        int totalCount = boardManagerService.getBoardManagerTotalCount(boardManager);

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
        boardManager.setOffset(paging.getOffset());
        boardManager.setLimit(paging.getLimit());

        List<BoardManager> list = boardManagerService.getBoardManagerList(boardManager);

        System.out.println("list.size : "+list.size());

        mav.addObject("boardManagerList", list);

        mav.addObject("paging", paging);
        mav.addObject("pagination", pagination);

        mav.setViewName("module/board/board_manager_list");

        return mav;
    }

    @GetMapping("/board/manager/info")
    public ModelAndView boardMangerInfo(HttpServletRequest request, ModelAndView mav, @RequestParam(value = "board_seq") int board_seq ) {

        logger.info("[M] boardManagerInfo");

        BoardManager boardManager = boardManagerService.getBoardManager(board_seq);
        System.out.println("boardManager : "+boardManager);

        String referer = request.getHeader("referer");

        if(ObjectUtils.isEmpty(boardManager)){
            System.out.println("referer : "+referer);
            mav.setViewName("redirect:"+referer);
        }

        mav.addObject("boardManager", boardManager);
        mav.setViewName("module/board/board_manager_info");

        return mav;
    }

    @GetMapping(value="/board/manager/register")
    public ModelAndView boardManagerRegisterForm(ModelAndView mav) {

        logger.info("[M] boardManagerRegisterForm");

        mav.setViewName("module/board/board_manager_register");

        return mav;
    }

    @PostMapping("/board/manager/register")
    public ModelAndView boardManagerRegister(ModelAndView mav, BoardManager boardManager) {

        logger.info("[M] boardManagerRegister");

        boardManager.setRegi_id("test");
        boardManager.setRegi_name("test");

        /*int result = 0;
        for(int i=0; i<150; i++){
            result = boardService.registerBoard(board);
            String[] title = StringUtils.split(board.getTitle(), " - ");
            String[] content = StringUtils.split(board.getContent(), " - ");
            board.setTitle(title[0] + " - "+i);
            board.setContent(content[0] + " - "+i);
            System.out.println("i : "+i);
        }*/

        int result = boardManagerService.registerBoardManager(boardManager);
        if(result > 0){
            mav.setViewName("redirect:/board/manager/list");
        }else{
            mav.setViewName("module/board/board_manager_register");
        }

        return mav;
    }

    @GetMapping("/board/manager/change")
    public ModelAndView boardManagerChangeForm( ModelAndView mav, @RequestParam(value = "board_seq") int board_seq ) {

        logger.info("[M] boardManagerChangeFrom");

        BoardManager boardManager = boardManagerService.getBoardManager(board_seq);

        mav.addObject("boardManager", boardManager);
        mav.setViewName("module/board/board_manager_change");

        return mav;
    }

    @PostMapping("/board/manager/change")
    public ModelAndView boardManagerChange( ModelAndView mav, BoardManager boardManager ){

        logger.info("[M] boardManager Change");

        boardManager.setModi_id("test2");
        boardManager.setModi_name("test2");
        System.out.println("boardManager.seq : "+boardManager.getBoard_seq());
        System.out.println("boardManager.id : "+boardManager.getBoard_id());
        System.out.println("boardManager.name: "+boardManager.getBoard_name());
        int result = boardManagerService.changeBoardManager(boardManager);
        if(result > 0){
            mav.setViewName("redirect:/board/manager/info?board_seq="+boardManager.getBoard_seq());
        }else{
            mav.setViewName("module/board/board_manager_change");
        }

        return mav;
    }

    @PostMapping("/board/manager/remove")
    public ModelAndView boardManagerRemove( ModelAndView mav, BoardManager boardManager ){

        logger.info("[M] boardManagerRemove");

        boardManager.setModi_id("test3");
        boardManager.setModi_name("test3");
        int result = boardManagerService.removeBoardManager(boardManager);
        if(result > 0){
            mav.setViewName("redirect:/board/manager/list");
        }else{
            mav.setViewName("redirect:/board/manager/info?board_seq="+boardManager.getBoard_seq());
        }

        return mav;
    }

}


