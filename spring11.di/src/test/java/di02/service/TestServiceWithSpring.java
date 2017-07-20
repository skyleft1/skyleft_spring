package di02.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di00.model.Document;
import di00.model.Type;

public class TestServiceWithSpring {
    
   
    @Test
    public void testMakeInstanceWithNew() {
        Type webType = new Type();
        webType.setName("web");
        webType.setExtension(".url");
        webType.setDesc("web link");
        
        Document doc1 = new Document("aaa", webType, "/aaa.txt");
    }
    @Test
    public void testMakeInstanceWithSpring() {
        ApplicationContext context = null;
        try {
            context = new ClassPathXmlApplicationContext("classpath:service.xml");
        } catch (BeansException e) {
            e.printStackTrace();
        }
        Type webType = context.getBean("webType", Type.class);
        assertEquals("web", webType.getName());
        
        Document doc1 = context.getBean("doc1", Document.class);
        assertEquals("aaa", doc1.getName());
        assertEquals(webType, doc1.getType());
    }
}
