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

import com.spring82.bbs.commons.PagingHelper;
import com.spring82.bbs.model.ModelArticle;
import com.spring82.bbs.model.ModelAttachFile;
import com.spring82.bbs.model.ModelBoard;
import com.spring82.bbs.model.ModelComments;
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
            , @RequestParam(value="curPage", defaultValue="1") int curPage
            , @RequestParam(value="searchWord", defaultValue="") String searchWord
            )  {
        logger.info("boardlist");

        List<ModelBoard> result = boardsrv.getBoardList();
        model.addAttribute("list", result );

        return "board/boardlist";
    }
    
//    @RequestMapping(value = "/articlelist/{boardcd}", method = RequestMethod.GET)
//    public String articlelist(Model model
//            , @PathVariable(value="boardcd") String boardcd
//            , @RequestParam(value="curPage", defaultValue="1") int curPage
//            , @RequestParam(value="searchWord", defaultValue="") String searchWord
//            )  {
//        logger.info("articlelist");
//        
//        String boardnm = boardsrv.getBoardName(boardcd);
//                
//        model.addAttribute("boardnm", boardnm);
//        model.addAttribute("boardcd", boardcd);
//        model.addAttribute("curPage", curPage);
//        model.addAttribute("searchWord", searchWord);
//        
//        // 전체 개시글 갯수 가져오기
//        int totalRecord = boardsrv.getArticleTotalRecord(boardcd, searchWord);
//        
//        // 페이지 처리
//        PagingHelper paging = new PagingHelper(totalRecord, curPage);
//        int start = paging.getStartRecord();
//        int end = paging.getEndRecord();
//            
//        List<ModelArticle> list = boardsrv.getArticleList(boardcd, searchWord, start, end);
//        model.addAttribute("list", list);
//        model.addAttribute("no", paging.getListNo());
//        model.addAttribute("prevLink", paging.getPrevLink());
//        model.addAttribute("firstPage", paging.getFirstPage());
//        model.addAttribute("pageLinks", paging.getPageLinks());
//        model.addAttribute("nextLink", paging.getNextLink());
//        model.addAttribute("lastPage", paging.getLastPage());
//        
//        return "board/articlelist";
//    }
    
    

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
            , @PathVariable(value="boardcd") String boardcd 
            )  {
        logger.info("boardlist");

        ModelBoard board = new ModelBoard();
        board.setBoardcd(boardcd);
        
        int result = boardsrv.deleteBoard(board);
        
        if(result == 1){
            return "redirect:/board/boardlist";
        }
        else {
            return "redirect:/board/boardview" + boardcd;
        }
    }
    
    
    // 여기서부터 article
    
    @RequestMapping(value = "/articlelist/{boardcd}", method = RequestMethod.GET)
    public String articlelist(Model model
            , @PathVariable(value="boardcd") String boardcd
            , @RequestParam(value="curPage", defaultValue="1") int curPage
            , @RequestParam(value="searchWord", defaultValue="") String searchWord
            )  {
        logger.info("articlelist");
        
        String boardnm = boardsrv.getBoardName(boardcd);
                
        model.addAttribute("boardnm", boardnm);
        model.addAttribute("boardcd", boardcd);
        model.addAttribute("curPage", curPage);
        model.addAttribute("searchWord", searchWord);
        
        // 전체 개시글 갯수 가져오기
        int totalRecord = boardsrv.getArticleTotalRecord(boardcd, searchWord);
        
        // 페이지 처리
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        int start = paging.getStartRecord();
        int end = paging.getEndRecord();
            
        List<ModelArticle> list = boardsrv.getArticleList(boardcd, searchWord, start, end);
        model.addAttribute("list", list);
        model.addAttribute("no", paging.getListNo());
        model.addAttribute("prevLink", paging.getPrevLink());
        model.addAttribute("firstPage", paging.getFirstPage());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("nextLink", paging.getNextLink());
        model.addAttribute("lastPage", paging.getLastPage());
        
        return "/board/articlelist";
    }
    
    //http://localhost:8080/board/articlelist/free
    @RequestMapping(value = "/articleview/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articleview(Model model
            , @PathVariable(value="boardcd") String boardcd
            , @PathVariable(value="articleno") Integer articleno
            , @RequestParam(value="curPage", defaultValue="1") Integer curPage 
            , @RequestParam(value="searchWord", defaultValue="") String searchWord
            )  {
        model.addAttribute("curPage", curPage);
        model.addAttribute("searchWord", searchWord);
//        
//        boardNm
        String boardnm = boardsrv.getBoardName(boardcd);
        model.addAttribute("boardnm", boardnm);
        
//        thisArticle
        ModelArticle thisArticle = boardsrv.getArticle(articleno);   
        model.addAttribute("thisArticle", thisArticle);
        
//        attachFileList
        List<ModelAttachFile> attachFileList = boardsrv.getAttachFileList(articleno);
        model.addAttribute("attachFileList", attachFileList);
        
//        commentList
        List<ModelComments> commentList = boardsrv.getCommentList(articleno);
        model.addAttribute("commentList", commentList);

//        nextArticle
        ModelArticle nextArticle = boardsrv.getNextArticle(boardcd, articleno, searchWord) ;
        model.addAttribute("nextArticle", nextArticle);
        
//        prevArticle
        ModelArticle prevArticle = boardsrv.getPrevArticle(boardcd, articleno, searchWord);
        model.addAttribute("prevArticle", prevArticle);
        
//        articleList
     // 전체 개시글 갯수 가져오기
        int totalRecord = boardsrv.getArticleTotalRecord(boardcd, searchWord);
        
        // 페이지 처리
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        int start = paging.getStartRecord();
        int end = paging.getEndRecord();
            
        List<ModelArticle> list = boardsrv.getArticleList(boardcd, searchWord, start, end);
        model.addAttribute("list", list);
        model.addAttribute("no", paging.getListNo());
        model.addAttribute("prevLink", paging.getPrevLink());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("nextLink", paging.getNextLink());
        
//        no
//        prevLink
//        pageLinks
//        nextLink
        
        return "/board/articleview";
    }
    
    @RequestMapping(value = "/articlemodify/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articlemodify(Model model
            ,@PathVariable(value="boardcd") String boardcd
            ,@PathVariable(value="articleno") Integer articleno
            ,@RequestParam(value="curPage"   , defaultValue="1") int    curPage
            ,@RequestParam(value="searchWord", defaultValue="" ) String searchWord) {
            
            String boardnm = boardsrv.getBoardName(boardcd);
            model.addAttribute("boardnm",boardnm);
            
            ModelArticle thisArticle = boardsrv.getArticle(articleno);
            model.addAttribute("thisArticle",thisArticle);
        
            model.addAttribute("articleno", articleno);
            model.addAttribute("curPage", curPage);
            model.addAttribute("searchWord", searchWord);
        
         return "/board/articlemodify";
    }
    
    @RequestMapping(value = "/articlemodify", method = RequestMethod.POST)
    public String articlemodify2(Model model
            ,@RequestParam(value="boardcd", defaultValue="" ) String boardcd
            ,@RequestParam(value="articleno", defaultValue=""  ) Integer articleno
            ,@RequestParam(value="curPage"   , defaultValue="1") int    curPage
            ,@RequestParam(value="searchWord", defaultValue="" ) String searchWord
            , @ModelAttribute ModelArticle article
            ) {
            
        ModelArticle curArticle = new ModelArticle();
            
        model.addAttribute("boardcd",boardcd);
        model.addAttribute("articleno", articleno);
        model.addAttribute("curPage", curPage);
        model.addAttribute("searchWord", searchWord);
            
            
            curArticle = boardsrv.getArticle(article.getArticleno());

            int result = boardsrv.updateArticle(article, curArticle);
            if (result == 1 ){
                return "redirect:/board/articleview/{boardcd}/{articleno}";
            } else {
                return "redirect:/board/articleview/{boardcd}/{articleno}";
            }
    }
    
    @RequestMapping(value = "/articledelete/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articledelete(Model model
            , @PathVariable(value="boardcd") String boardcd
            , @PathVariable(value="articleno") Integer articleno
            , @RequestParam(value="curPage"   , defaultValue="1") int    curPage
            , @RequestParam(value="searchWord", defaultValue="" ) String searchWord
            , @ModelAttribute ModelArticle article
            ) {
            
        model.addAttribute("boardcd",boardcd);
        model.addAttribute("articleno", articleno);
        model.addAttribute("curPage", curPage);
        model.addAttribute("searchWord", searchWord);
        
        int result = boardsrv.deleteArticle(article);
        if (result == 1 ){
            model.addAttribute("msg", "성공~~~~~~");
            return "redirect:/board/articlelist/{boardcd}";
        } else {
            return "redirect:/board/articlelist/{boardcd}";
        }
    }
}
