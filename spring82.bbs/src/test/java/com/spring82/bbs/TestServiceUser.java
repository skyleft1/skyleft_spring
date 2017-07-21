package com.spring82.bbs;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.spring82.bbs.model.ModelUser;
import com.spring82.bbs.service.IServiceUser;


public class TestServiceUser {
    
    //private static SqlSession session = null;
    private static ApplicationContext context = null;
    private static IServiceUser service = null;

    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("serviceuser", IServiceUser.class);
    } // service 말고 user로 해도 된다.
    

    @Test
    public void testInsertUser() {
        ModelUser user = new ModelUser();
        user.setUserid("aa1");
        user.setEmail("dfdfdfdf");
        user.setPasswd("aa2");
        
        int result = service.insertUser(user);
        assertEquals(result, 1);
    }

    @Test
    public void testLogin() {
        ModelUser result = new ModelUser("aa1", "aa2");
        assertEquals(result.getPasswd(), "aa2");
    }

    @Test
    public void testLogout() {
    }

    @Test
    public void testupdateUserInfo() {
        ModelUser updatevalue = new ModelUser();
        ModelUser searchValue = new ModelUser();
        searchValue.setUserid("aa1");
        updatevalue.setPasswd("aa2");
        updatevalue.setEmail("dgdf");
        
        int result = service.updateUserInfo(updatevalue, searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void testupdatePasswd() {
        int result = service.updatePasswd("aa3", "aa2", "aa1");
        assertEquals(result, 1);
    }

    @Test
    public void testDeleteUser() {
        ModelUser model = new ModelUser();
        model.setUserid("aa1"); 
        int result = service.deleteUser(model);
        
        assertEquals(result, 1);
    }

    @Test
    public void testSelectUserOne() {
        ModelUser user = new ModelUser();
        user.setUserno(2);

        ModelUser result = service.selectUserOne(user);
        assertEquals(result.getUserid(), "aa1");
    }

    @Test
    public void testSelectUserList() {
        ModelUser user = new ModelUser();
        user.setName("miss");

        List<ModelUser> result = new ArrayList<ModelUser>(); 
                
        result = service.selectUserList(user); 
        assertEquals( result.size(), 1 );
    }
    
    @Test
    public void testCheckuserid() {
        ModelUser user = new ModelUser();
        user.setName("miss");

        List<ModelUser> result = service.selectUserList(user); 

        assertEquals( result.size(), 1 );
    }
    
}
