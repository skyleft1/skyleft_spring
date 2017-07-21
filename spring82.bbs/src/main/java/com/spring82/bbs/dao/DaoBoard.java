package com.spring82.bbs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring82.bbs.model.ModelArticle;
import com.spring82.bbs.model.ModelAttachFile;
import com.spring82.bbs.model.ModelBoard;
import com.spring82.bbs.model.ModelComments;

@Repository("daoboard")
public class DaoBoard implements IDaoBoard {
    
    // dao에서는 Mybatis 의 session 인스턴스가 필요하다.
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;    

    @Override
    public String getBoardName(String boardcd) {
        return session.selectOne("mapper.mapperBoard.getBoardName", boardcd);
    }
    @Override
    public ModelBoard getBoardOne(String boardcd) {
        return session.selectOne("mapper.mapperBoard.getBoardOne", boardcd);
    }
    @Override
    public List<ModelBoard> getBoardList() {
        return session.selectList("mapper.mapperBoard.getBoardList");
    }
    @Override
    public int insertBoard(ModelBoard board) {
        return session.insert("mapper.mapperBoard.insertBoard", board);
    }
    @Override
    public int updateBoard(ModelBoard updateValue, ModelBoard searchValue) {
        Map<String, ModelBoard> map = new HashMap<String, ModelBoard>();
        map.put("updateValue", updateValue );
        map.put("searchValue", searchValue );
        return session.update("mapper.mapperBoard.updateBoard", map);
    }
    @Override
    public int deleteBoard(ModelBoard board) {
        return session.delete("mapper.mapperBoard.deleteBoard", board);
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        List<ModelBoard> list = new ArrayList<>(); 
        return session.selectList("mapper.mapperBoard.getBoardSearch", board);

    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord,
            Integer start, Integer end) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        return session.selectList("mapper.mapperBoard.getBoardPaging", map);
    }
    
    @Override
    public int insertBoardList(List<ModelBoard> board) {
        return session.insert("mapper.mapperBoard.insertBoardList", board);
    }
    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        return session.selectOne("mapper.mapperBoard.getArticleTotalRecord", map);
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord,
            Integer start, Integer end) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        return session.selectList("mapper.mapperBoard.getArticleList", map);
    }
    @Override
    public ModelArticle getArticle(int articleno) {
        return session.selectOne("mapper.mapperBoard.getArticle", articleno);
    }
    @Override
    public int insertArticle(ModelArticle article) {
        return session.insert("mapper.mapperBoard.insertArticle", article);
    }
    //??
    
    
    @Override
    public int updateArticle(ModelArticle updateValue,
            ModelArticle searchValue) {
        Map<String, ModelArticle> map = new HashMap<String, ModelArticle>();
        map.put("updateValue", updateValue );
        map.put("searchValue", searchValue );
        return session.update("mapper.mapperBoard.updateArticle", map);
    }
    @Override
    public int deleteArticle(ModelArticle article) {
        return session.delete("mapper.mapperBoard.deleteArticle", article);
    }

    @Override
    public int increaseHit(int articleno) {
        return session.update("mapper.mapperBoard.increaseHit", articleno);
    }
    @Override
    public ModelArticle getNextArticle(String boardcd, int articleno,
            String searchWord) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("articleno", articleno);
        map.put("searchWord", searchWord);
        return session.selectOne("mapper.mapperBoard.getNextArticle", map);
    }
    @Override
    public ModelArticle getPrevArticle(String boardcd, int articleno,
            String searchWord) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("articleno", articleno);
        map.put("searchWord", searchWord);
        return session.selectOne("mapper.mapperBoard.getPrevArticle", map);
    }
    @Override
    public ModelAttachFile getAttachFile(int attachfileno) {
        return session.selectOne("mapper.mapperBoard.getAttachFile", attachfileno);
    }
    @Override
    public List<ModelAttachFile> getAttachFileList(int articleno) {
        return session.selectList("mapper.mapperBoard.getAttachFileList", articleno);
    }
    @Override
    public int insertAttachFile(ModelAttachFile attachfile) {
        return session.insert("mapper.mapperBoard.insertAttachFile", attachfile);
    }
    @Override
    public int deleteAttachFile(ModelAttachFile attachfileno) {
        return session.delete("mapper.mapperBoard.deleteAttachFile", attachfileno);
    }
    @Override
    public ModelComments getComment(int comment) {
        return session.selectOne("mapper.mapperBoard.getComment", comment);
    }
    @Override
    public List<ModelComments> getCommentList(int articleno) {
        return session.selectList("mapper.mapperBoard.getCommentList", articleno);
    }
    @Override
    public int insertComment(ModelComments comment) {
        return session.insert("mapper.mapperBoard.insertComment", comment);
    }
    @Override
    public int updateComment(ModelComments updateValue,
            ModelComments searchValue) {
        Map<String, ModelComments> map = new HashMap<String, ModelComments>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        return session.insert("mapper.mapperBoard.updateComment", map);
    }
    @Override
    public int deleteComment(ModelComments comment) {
        return session.insert("mapper.mapperBoard.deleteComment", comment);
    }


    
    
    
//    @Override
//    public int getBoardTotalRecord(HashMap<String, String> hashmap) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
   
//
//    @Override
//    public List<ModelBoard> getBoardSearch(ModelBoard board) {
//        return  session.selectList("mapper.mapperBoard.getBoardSearch", board);        
//    }
//
//
//    @Override
//    public int insertBoardList(List<ModelBoard> list) {
//        return  session.insert("mapper.mapperBoard.insertBoardList", list);        
//    }
//
//    @Override
//    public int getArticleTotalRecord(String boardcd, String searchWord) {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("boardcd"   , boardcd    );
//        map.put("searchWord", searchWord );
//        
//        return  session.selectOne("mapper.mapperBoard.getArticleTotalRecord", map);        
//    }
//
//    @Override
//    public List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end) {
//        
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("boardcd"   , boardcd    );
//        map.put("searchWord", "%"+searchWord+"%" );
//        map.put("start"     , start      );
//        map.put("end"       , end        );
//        
//        return  session.selectList("mapper.mapperBoard.getArticleList", map);        
//    }
//
//    @Override
//    public ModelArticle getArticle(int articleno) {
//        return  session.selectOne("mapper.mapperBoard.getArticle", articleno);        
//    }
//
//    @Override
//    public int insertArticle(ModelArticle article) {
//        
//        Map<String, Object> map = new HashMap<>();
//        map.put("article", article);
//        map.put("result", "");
//        
//        session.insert("mapper.mapperBoard.insertArticle", map );
//        int result = (int) map.get("result");
//        
//        return  result;        
//    }
//
//    @Override
//    public int updateArticle(ModelArticle updateValue, ModelArticle searchValue) {
//        
//        Map<String, ModelArticle> map = new HashMap<String, ModelArticle>();
//        map.put("updateValue", updateValue);
//        map.put("searchValue", searchValue);
//        
//        return  session.insert("mapper.mapperBoard.updateArticle", map );    
//    }
//
//    @Override
//    public int deleteArticle(ModelArticle article) {
//        return  session.insert("mapper.mapperBoard.deleteArticle", article ); 
//    }
//
//    @Override
//    public int increaseHit(int articleno) {
//        return  session.update("mapper.mapperBoard.increaseHit", articleno ); 
//    }
//
//    @Override
//    public ModelArticle getNextArticle(Map<String, Object> hashmap) {
//        return  session.selectOne("mapper.mapperBoard.getNextArticle", hashmap);        
//    }
//
//    @Override
//    public ModelArticle getPrevArticle(Map<String, Object> hashmap) {
//        return  session.selectOne("mapper.mapperBoard.getPrevArticle", hashmap);        
//    }
//
//    @Override
//    public ModelAttachfile getAttachFile(int attachfileno) {
//        return  session.selectOne("mapper.mapperBoard.getAttachFile", attachfileno);        
//    }
//
//    @Override
//    public List<ModelAttachfile> getAttachFileList(int articleno) {
//        return  session.selectList("mapper.mapperBoard.getAttachFileList", articleno);        
//    }
//
//    @Override
//    public int insertAttachFile(ModelAttachfile attachFile) {
//        return  session.insert("mapper.mapperBoard.insertAttachFile", attachFile );        
//    }
//
//    @Override
//    public int deleteAttachFile(ModelAttachfile attachFile) {
//        return  session.update("mapper.mapperBoard.deleteAttachFile", attachFile );        
//    }
//
//    @Override
//    public int insertComment(ModelComments comment) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("c"     , comment);
//        map.put("result", null   );
//        session.insert("mapper.mapperBoard.insertComment", map );
//        
//        return  (int)map.get("result");
//    }
//
//    @Override
//    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
//        
//        Map<String, ModelComments> map = new HashMap<>();
//        map.put("updateValue", updateValue);
//        map.put("searchValue", searchValue);
//        
//        return  session.update("mapper.mapperBoard.updateComment", map );        
//    }
//
//    @Override
//    public int deleteComment(ModelComments comment) {
//        return  session.delete("mapper.mapperBoard.deleteComment", comment );        
//    }
//
//    @Override
//    public ModelComments getComment(int commentno) {
//        return  session.selectOne("mapper.mapperBoard.getComment", commentno);        
//    }
//
//    @Override
//    public List<ModelComments> getCommentList(int articleno) {
//        return  session.selectList("mapper.mapperBoard.getCommentList", articleno);        
//    }
//    
    
}
