package com.spring82.bbs.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring82.bbs.model.ModelBoard;
import com.spring82.bbs.service.IServiceBoard;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
    @Autowired
    @Qualifier("serviceboard")
    private IServiceBoard boardsrv; 
    public IServiceBoard getBoardsrv() { return boardsrv; } 
    public void setBoardsrv(IServiceBoard boardsrv) { this.boardsrv = boardsrv; } 
    
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
    @RequestMapping(value = "/boardlist", method = RequestMethod.GET)
    public String boardlist(Model model
            )  {
        logger.info("BoardController.boardlist");

        List<ModelBoard> list =  boardsrv.getBoardList();
        model.addAttribute("list", list );

        return "board/boardlist";
    }
    
    
    @RequestMapping(value = "/boardview", method = RequestMethod.GET)
    public String boardview( 
          @RequestParam(value="boardcd", required = false, defaultValue = "free") String boardcd 
        , @RequestParam(value="boardnm", required = false, defaultValue = ""    ) String boardnm
        , HttpServletRequest request
        , Model model ) {

        logger.info("BoardController.boardview");

//        boardcd = request.getParameter("boardcd");
//
//        if( StringUtils.isEmpty(boardcd) ) boardcd = "free";
//
//        // DB 처리
//        ModelBoard board =  boardsrv.getBoardOne(boardcd);
//        
//        // 모델 바인딩
//        model.addAttribute("boardNm", board.getBoardnm() );
//        model.addAttribute("board"  ,  board );

        return "board/boardview";
    }
	
}
