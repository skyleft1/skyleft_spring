package com.spring62.phone.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring62.phone.model.ModelPhone;
import com.spring62.phone.repository.RepositoryPhone;
import com.spring62.phone.service.IServicePhone;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	IServicePhone svc;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/phone/writeone", method = RequestMethod.GET)
	public String writeone(Model model
	        
	        ) {
		logger.info("Welcome home!");
		
//		model.addAttribute("serverTime", formattedDate );
		
		return "phone/writeOneForm";
	}
	
//    @RequestMapping(value = "/phone/writeone1", method = RequestMethod.POST)
//    public String writeOneForm(Model model
//            , HttpServletRequest request
//    ) {
//        logger.info("Welcome home!");
//        
//        String name = request.getParameter("name");
//        String manufacturer = request.getParameter("manufacturer"); 
//        Integer price = Integer.valueOf(request.getParameter("price"));
//                
//        ModelPhone phone = new ModelPhone(name, manufacturer, price); 
//        int result =  svc.insertPhone(phone);
//
//        model.addAttribute("phone", phone);
//        
//        return "phone/writeOneResult";
//    }
    @RequestMapping(value = "/phone/writeone1", method = RequestMethod.POST)
    public String writeListForm(Model model
            , HttpServletRequest request
    ) {
        logger.info("Welcome home!");
        
        String name = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer"); 
        Integer price = Integer.valueOf(request.getParameter("price"));

        ModelPhone phone = new ModelPhone(name, manufacturer, price); 
        
        int result =  svc.insertPhone(phone);


        List<ModelPhone> list = svc.getPhoneList();
        model.addAttribute("list", list);
        
        return "phone/writeListResult";
    }
    
    
    @RequestMapping(value = "/phone/writeone2", method = RequestMethod.POST)
    public String writeOneForm(Model model
            , @RequestParam(value="name",  defaultValue="") String name
            , @RequestParam(value="manufacturer",  defaultValue="") String manufacturer
            , @RequestParam(value="price",  defaultValue="") Integer price
    ) {
        logger.info("Welcome home!");
        
        ModelPhone phone = new ModelPhone(name, manufacturer, price);
        int result =  svc.insertPhone(phone);

        model.addAttribute("phone", phone );
        
        return "phone/writeOneResult";
    }
    @RequestMapping(value = "/phone/writeone3", method = RequestMethod.POST)
    public String writeOneForm(Model model
            , @ModelAttribute ModelPhone phone
    ) {
        logger.info("Welcome home!");
        
        int result =  svc.insertPhone(phone);

        model.addAttribute("phone", phone );
        
        return "phone/writeOneResult";
    }

    
    @RequestMapping(value = "/phone/writeone4", method = RequestMethod.POST)
    public String writeOneForm(Model model
            
    ) {
        logger.info("Welcome home!");
        
        return "phone/writeOneResult";
    }
    
    @RequestMapping(value = "/phone/writeList", method = RequestMethod.GET)
    public String writeList(Model model
            ) {
        logger.info("Welcome home!");
        
//      model.addAttribute("serverTime", formattedDate );
        
        return "phone/writeListForm";
    }
    
    
    @RequestMapping(value = "/phone/writeList", method = RequestMethod.POST)
    public String writeList(Model model
            , @ModelAttribute RepositoryPhone phone
    ) {
        logger.info("Welcome home!");
        
//        int result = svc.insertPhoneList(phone);
        
        List<ModelPhone> list = svc.getPhoneList();
        
        model.addAttribute("list", list );
        
        return "phone/writeListResult";
    }
}
