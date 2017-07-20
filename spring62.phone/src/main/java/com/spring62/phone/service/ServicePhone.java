package com.spring62.phone.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring62.phone.dao.IDaoPhone;
import com.spring62.phone.model.ModelPhone;


// @Service는 아래 클래스가 서비스다! 라는 것을 의미함
@Service("servicePhone")
public class ServicePhone implements IServicePhone {

    
// Dao를 사용하는것이 Service의 목적임
@Autowired // new 인스턴스를 만듬
@Qualifier("daoPhone") // 이름을 통해서 찾아감 (DaoPhone에 @Repository설정된 DaoPhone클래스를 의미)
    IDaoPhone dao;
    
    @Override
    public ModelPhone getPhoneOne(String name) {
        ModelPhone result = null;
        try {
            result = dao.getPhoneOne(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public List<ModelPhone> getPhoneList() {
        List<ModelPhone> result = null;
        try {
            result = dao.getPhoneList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
        int result = -1;
        try {
            result = dao.insertPhone(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        int result = -1;
        try {
            result = dao.insertPhoneList(phones);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
