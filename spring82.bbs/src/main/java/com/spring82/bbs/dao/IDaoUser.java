package com.spring82.bbs.dao;

import java.util.List;

import com.spring82.bbs.model.ModelUser;


public interface IDaoUser {

    //사용자 추가
   int insertUser(ModelUser user);
   
   //사용자 로그인 처리(주목적은 httpSession에 사용자 정보 추가)
   ModelUser login(String id, String pw );
   
   //사용자 로그아웃 처리(주목적은 httpSession에 사용자 정보 삭제)
   int logout(String userid);
   
   //사용자 유저정보 변경
   int updateUserInfo(ModelUser updateValue, ModelUser searchValue);
   
   //사용자 패스워드 변경
   int updatePasswd(String newPasswd, String currentPasswd, String userid);
   
   //사용자 삭제
   int deleteUser(ModelUser user);
   
   
   ModelUser selectUserOne(ModelUser user);

   
   // 사용자 목록 출력
   List<ModelUser> selectUserList(ModelUser user);   

   // 사용자 아이디 존재여부 체크 (주목적은 사용 가능한 아이디 표시할때 사용)
   int checkuserid(String userid );
}
