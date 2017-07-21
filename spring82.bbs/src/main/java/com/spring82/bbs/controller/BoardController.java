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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring82.bbs.model.ModelBoard;
import com.spring82.bbs.service.IServiceBoard;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    @Qualifier("serviceboard")
    IServiceBoard boardsrv;
    
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
    @RequestMapping(value = "/boardlist", method = RequestMethod.GET)
    public String boardlist(Model model
            )  {
        logger.info("boardlist");

        List<ModelBoard> result = boardsrv.getBoardList();
        model.addAttribute("list", result );

        return "board/boardlist";
    }

    @RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
    public String boardwrite(Model model
            )  {
        logger.info("boardlist : GET");

//        model.addAttribute("list", result );

        return "board/boardwrite";
    }
    
    //POST는 input 태그를 받을수 있는 설정이 필요하다.
    //RequestParam 등이 필요
    @RequestMapping(value = "/boardwrite", method = RequestMethod.POST)
    public String boardwrite(Model model
            , @RequestParam(value="boardcd", defaultValue="") String boardcd 
            , @RequestParam(value="boardnm", defaultValue="") String boardnm
            , @RequestParam(value="UseYN", defaultValue="false") Boolean useYN
            )  {
        logger.info("boardlist : POST");
        //DB 에 insert 하고 list페이지가 열리도록 redirect한다.
        ModelBoard board = new ModelBoard();
        board.setBoardcd(boardcd);
        board.setBoardnm(boardnm);
        board.setUseYN(useYN);
        int result = boardsrv.insertBoard(board);
        
        // DB에 제대로 들어가면(result가 1이면) list로 redirect하고
        // 안 들어가면 write로 redirect
        if(result == 1 ){
            return "redirect:/board/boardlist";
        }
        else {
            return "board/boardwrite";
        }
//        model.addAttribute("list", result );
    }
    
    
    @RequestMapping(value = "/boardview", method = RequestMethod.GET)
    public String boardwrite(Model model
            , @RequestParam(value="boardcd", defaultValue="free") String boardcd 
            )  {
        logger.info("boardlist");
        //DB 에 insert 하고 list페이지가 열리도록 redirect한다.
        ModelBoard board = boardsrv.getBoardOne(boardcd);
        
        model.addAttribute("board", board);
        return "board/boardview";
    }

    @RequestMapping(value = "/boardview/{boardcd}", method = RequestMethod.GET)
    public String boardwrite1(Model model
            , @PathVariable(value="boardcd") String boardcd 
            )  {
        logger.info("boardlist");
        //DB 에 insert 하고 list페이지가 열리도록 redirect한다.
        ModelBoard board = boardsrv.getBoardOne(boardcd);
        
        model.addAttribute("board", board);
        return "board/boardview";
    }
    
    
    @RequestMapping(value = "/boardmodify/{boardcd}", method = RequestMethod.GET)
    public String boardmodify1(Model model
            , @PathVariable(value="boardcd") String boardcd 
            )  {
        logger.info("boardmodify");

        ModelBoard board = boardsrv.getBoardOne(boardcd);
        
        model.addAttribute("model", board);
        
        return "board/boardmodify";
    }
    @RequestMapping(value = "/boardmodify", method = RequestMethod.POST)
    public String boardmodify(Model model
            , @ModelAttribute ModelBoard board 
            )  {
        logger.info("boardmodify");

        ModelBoard searchValue = new ModelBoard();
        searchValue.setBoardcd(board.getBoardcd());
        
        ModelBoard updateValue = board;
        int result = boardsrv.updateBoard(updateValue, searchValue);
        
        if (result == 1) {
            return "redirect:/board/boardlist";
        } else {
            return "board/boardmodify";
        }
    }
    
    
    @RequestMapping(value = "/boarddelete/{boardcd}", method = RequestMethod.POST)
    public String boarddelete(Model model
            , @PathVariable(value="boardcd" ) String boardcd
            )  {
        logger.info("boarddelete");
        ModelBoard board = new ModelBoard(); 
        board.setBoardcd(boardcd);
        
        int result = boardsrv.deleteBoard(board);
        
        if(result == 1){
            return "redirect:/board/boardlist";
        }
        else {
            return "board/boardview";
        }
//        model.addAttribute("model", board);
    }
}
