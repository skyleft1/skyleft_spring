package com.spring82.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring82.bbs.model.ModelArticle;
import com.spring82.bbs.model.ModelAttachFile;
import com.spring82.bbs.model.ModelBoard;
import com.spring82.bbs.model.ModelComments;


public interface IDaoBoard {
    
//    /*
//     * 특정 게시판의 총 게시물 갯수 구하기
//     */
//    int getBoardTotalRecord(HashMap<String, String> hashmap);
//    
//    
    /*
     * 게시판이름 구하기
     */
    String getBoardName(String boardcd);


    /*
     * 게시판 모델 객체 구하기
     */
    ModelBoard getBoardOne(String boardcd);
    
    /*
     * 게시판종류 리스트 구하기
     */
    List<ModelBoard> getBoardList();
    
    
    /*
     * 게시판  추가
     */
    int insertBoard(ModelBoard board);
    
    /*
     * 게시판  수정
     */
    int updateBoard(ModelBoard updateValue, ModelBoard searchValue );
    
    /*
     * 게시판  삭제
     */
    int deleteBoard(ModelBoard board);
    
    
    List<ModelBoard> getBoardSearch(ModelBoard board);
    
    
    
  /*
  * 
  */
    List<ModelBoard> getBoardPaging(String boardcd, String searchWord, Integer start, Integer end);
 
    int insertBoardList(List<ModelBoard> board);
    
    int getArticleTotalRecord(String boardcd, String searchWord);
    
    List<ModelArticle> getArticleList(String boardcd, String searchWord, Integer start, Integer end);
    
    ModelArticle getArticle(int articleno);
    
    int insertArticle(ModelArticle article);
    
    int updateArticle(ModelArticle updateValue, ModelArticle searchValue); 
    
    int deleteArticle(ModelArticle article);
    
        
    int increaseHit(int articleno);
    
    ModelArticle getNextArticle(String boardcd, int articleno, String searchWord );
    // 용님과 다름
    
    ModelArticle getPrevArticle(String boardcd, int articleno, String searchWord );
    
    ModelAttachFile getAttachFile(int attachfileno);
    
    List<ModelAttachFile> getAttachFileList(int articleno);
    
    int insertAttachFile(ModelAttachFile attachfile);
        
    int deleteAttachFile(ModelAttachFile attachfileno);
    
    ModelComments getComment(int comment);
    
    List<ModelComments> getCommentList(int articleno);
    
    int insertComment(ModelComments comment);
    
    int updateComment(ModelComments updateValue, ModelComments searchValue);
    
    int deleteComment(ModelComments comment);
    // 이후 추가 

    /*
     *  
     */
//    public abstract List<ModelBoard> getBoardSearch(ModelBoard board);
//    

//    /*
//     * 
//     */
//    public abstract int insertBoardList(List<ModelBoard> list);
//    
//    
//    
//
//    /*
//     * 특정 게시판의 총 게시물 갯수 구하기
//     */
//    public abstract int getArticleTotalRecord(String boardcd, String searchWord);
//
//    /*
//     * 게시판 목록
//     */
//    public abstract List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end);
//
//    /*
//     * 게시글 상세보기
//     */
//    public abstract ModelArticle getArticle(int articleno);
//
//    /*
//     * 새로운 게시글  추가
//     */
//    public abstract int insertArticle(ModelArticle article);
//
//    /*
//     * 게시글 수정
//     */
//    public abstract int updateArticle(ModelArticle updateValue, ModelArticle searchValue);
//
//    /*
//     * 게시글 삭제
//     */
//    public abstract int deleteArticle(ModelArticle article);
//
//    /*
//     * 조회수 증가
//     */
//    public abstract int increaseHit(int articleno);
//    
//    /*
//     * 다음글 보기 articleno,boardcd,searchWord->HahMap 에 담는다
//     */
//    public abstract ModelArticle getNextArticle(Map<String, Object> hashmap);
//
//    /*
//     * 이전글 보기 articleno,boardcd,searchWord->HahMap 에 담는다
//     */
//    public abstract ModelArticle getPrevArticle(Map<String, Object> hashmap);
//
//    /*
//     * 첨부파일
//     */
//    public abstract ModelAttachFile getAttachFile(int attachfileno);
//    
//    /*
//     * 게시글의 첨부파일 리스트
//     */
//    public abstract List<ModelAttachFile> getAttachFileList(int articleno);
//
//    /*
//     * 새로운 첨부파일 추가 
//     */
//    public abstract int insertAttachFile(ModelAttachFile attachFile);
//
//    /*
//     * 첨부파일 삭제
//     */
//    public abstract int deleteAttachFile(ModelAttachFile attachFile);
//    
//    /*
//     * 덧글쓰기
//     */
//    public abstract int insertComment(ModelComments comment);
//
//    /*
//     * 덧글수정
//     */
//    public abstract int updateComment(ModelComments updateValue, ModelComments searchValue);
//
//    /*
//     * 덧글삭제
//     */
//    public abstract int deleteComment(ModelComments comment);
//
//    /*
//     * 덧글가져오기
//     */
//    public abstract ModelComments getComment(int commentno);
//
//    /*
//     * 게시글의 덧글리스트 구하기
//     */
//    public abstract List<ModelComments> getCommentList(int articleno);

}