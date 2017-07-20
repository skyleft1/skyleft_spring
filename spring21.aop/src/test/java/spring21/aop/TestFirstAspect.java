package spring21.aop;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ModelProduct;
import service.IServiceProduct;

public class TestFirstAspect {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ApplicationContext context = null;
    private static IServiceProduct service = null;
   
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        try {
            context = new ClassPathXmlApplicationContext("classpath:aop.xml");
            service = context.getBean("serviceProduct", IServiceProduct.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testGetProduct() {
        logger.debug("using spring AOP");
        ModelProduct product = null;
        try {
            product = service.getProduct("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(product.toString());
        logger.debug("it should be now cached");
    }
    
    @Test
    public void testGetException() {
        logger.debug("using spring AOP");
        try {
            service.getException("");
        } catch (Exception e) {
            logger.error("testGetException" + e.getMessage() );
        }
        logger.debug("it should be now cached");
    }
    
    @Test
    public void testGetNone() {
    logger.debug("Using Spring AOP:");
    service.getNone();
    logger.debug("It should be now cached!");
    }
}
