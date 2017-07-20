package service;

import javax.inject.Qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IDaoProduct;
import model.ModelProduct;

@Service("serviceProduct")
//TestFirstAspect getBean에 사용됨

public class ServiceProduct implements IServiceProduct {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
//    @Qualifier("productDao")
    private IDaoProduct productDao;
    
    @Override
    public ModelProduct getProduct(String name) {
        ModelProduct product = productDao.getProduct("빵");        
        return product;
    }
    
    @Override
    public ModelProduct getException(String name) throws Exception {
        productDao.getException("빵");
        return null;
    }
    
    @Override
    public void getNone() {
        productDao.getProduct("빵");         
        return ;       
    }
}