package com.spring62.phone.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring62.phone.model.ModelPhone;



public class RepositoryPhone {

    private List<ModelPhone> phoneItems;

    public RepositoryPhone() {
        super();
    }

    public List<ModelPhone> getPhoneItems() {
        return phoneItems;
    }

    public void setPhoneItems(List<ModelPhone> phoneItems) {
        this.phoneItems = phoneItems;
    }
    
    
    
    
//    
//    private List<ModelPhone> phoneItems;
//    
//    // getter & setter
//    public List<ModelPhone> getPhoneItems() {
//        return phoneItems;
//    }
//    
//    public void setPhoneItems(List<ModelPhone> phoneItems) {
//        this.phoneItems = phoneItems;
//    }
//    
//    // 생성자
//    public RepositoryPhone() {
//        super();
//    }

}
