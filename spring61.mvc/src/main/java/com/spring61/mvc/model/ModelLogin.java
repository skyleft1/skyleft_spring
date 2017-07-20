package com.spring61.mvc.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelLogin {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private String id = null;
    private String pw = null;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public ModelLogin(String id, String pw) {
        super();
        this.id = id;
        this.pw = pw;
    }
    public ModelLogin() {
        super();
    }
    @Override
    public String toString() {
        return "ModelLogin [logger=" + logger + ", id=" + id + ", pw=" + pw
                + "]";
    }
    
    
    
}
