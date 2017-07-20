package com.spring62.phone.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring62.phone.model.ModelPhone;

@Repository("daoPhone")
public class DaoPhone implements IDaoPhone {

@Autowired
@Qualifier("sqlSession")
private SqlSession session;
    
    @Override
    public ModelPhone getPhoneOne(String name) {
        return session.selectOne("mapper.mysql.mapperPhone.getPhoneOne", name);
//      mapper를 가져와야함, namespace 가져오고 . id 
//      (mapper의) "namespace.id", parameter
        
//        IDao 작성
//        mapper 작성
//        Dao 작성 

        
    }
    
    @Override
    public List<ModelPhone> getPhoneList() {
        return session.selectList("mapper.mysql.mapperPhone.getPhoneList");
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
        return session.insert("mapper.mysql.mapperPhone.insertPhone", phone);
    }
    
    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        return session.insert("mapper.mysql.mapperPhone.insertPhoneList", phones);
    }
}
