package com.spring62.phone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring62.phone.model.ModelPhone;
import com.spring62.phone.service.IServicePhone;

public class TestServicePhone {

    private static ApplicationContext context = null;
    private static IServicePhone service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("servicePhone", IServicePhone.class);
    } // getBean 에는 Service의 @Service 이름을 준다.
    

    @Test
    public void testinsertPhone() {
        ModelPhone phone = new ModelPhone("우오", "캬오", 11);
        
        int result = service.insertPhone(phone);
        assertEquals(result, 1);
    }
    
    @Test
    public void testgetPhoneOne() {
        ModelPhone result = service.getPhoneOne("우오");
        assertEquals("캬오", result.getManufacturer());
    }
    @Test
    public void testgetPhoneList() {
        List<ModelPhone> result = service.getPhoneList();
        assertEquals("캬오", result.get(0).getManufacturer());
    }
    
    @Test
    public void testinsertPhoneList() {
        ModelPhone phone = null;
        List<ModelPhone> list = new ArrayList<ModelPhone>();
        
        
     for(int i=1; i<6; i=i+1){
        phone= new ModelPhone();
       
        phone.setName("극혐"+ i);
        phone.setManufacturer("후아");
        phone.setPrice(1212);

        list.add(phone);
     }
     int result= service.insertPhoneList(list);
     
     assertEquals(result, 5);
    }
}
