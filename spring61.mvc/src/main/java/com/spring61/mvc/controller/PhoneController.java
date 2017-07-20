package com.spring61.mvc.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring61.mvc.model.ModelPhone;
import com.spring61.mvc.repository.RepositoryPhone;
import com.spring61.mvc.service.IServicePhone;


/**
 * Handles requests for the application home page.
 */
@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	IServicePhone svrphone ;
	// 스프링에서의 new(인스턴스만듬)는 Autowired로 한다.
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/phone/writeone", method = RequestMethod.GET)
	public String writeone(Locale locale
	        , Model model ){
        return "phone/writeOneForm";
//        model.addAttribute("serverTime", formattedDate );
	}

	
    @RequestMapping(value = "/phone/writeone1", method = RequestMethod.POST)
    public String writeone1(Locale locale
            , Model model
            , HttpServletRequest request
            ) {

        logger.info("writeone", locale);

        String name = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        Integer price = Integer.valueOf(request.getParameter("price") );
        
        ModelPhone phone = new ModelPhone(name, manufacturer, price);
        
        //DB insert
        // controller가 서비스를 호출하는 것이 DB 호출의 핵심
        
        int result = svrphone.insertPhone(phone);
        
        // list 작업
        List<ModelPhone> list = svrphone.getPhoneList();
        
        model.addAttribute("list",  list);

        return "phone/writeListResult";
    }
           
        
    @RequestMapping(value = "/phone/writeone2", method = RequestMethod.POST)
    public String writeone2(Locale locale
            , Model model
            , @RequestParam(value="name", defaultValue="") String name
            , @RequestParam(value="manufacturer", defaultValue="") String manufacturer
            , @RequestParam(value="price", defaultValue="0") Integer price
            ) {
        
        logger.info("writeone", locale);
        
        ModelPhone phone = new ModelPhone(name, manufacturer, price);
        
        int result = svrphone.insertPhone(phone);
        
        model.addAttribute("phone",  phone);
                
        return "phone/writeOneResult";
    }

    
    
    
    @RequestMapping(value = "/phone/writeone3", method = RequestMethod.POST)
    public String writeone3(
            @ModelAttribute ModelPhone phone
            , Model model
            ) {
        
        logger.info("writeone");
        
        //DB insert
        // controller가 서비스를 호출하는 것이 DB 호출의 핵심
        List<ModelPhone> list = svrphone.getPhoneList();
        int result = svrphone.insertPhoneList(list);
        
        
        model.addAttribute("list",  list);
                
        return "phone/writeListResult";
    }

    
    
    @RequestMapping(value = "/phone/writeone4", method = RequestMethod.POST)
    public String writeone4(
            Model model
            ) {
        
        logger.info("writeone");
        
        return "phone/writeOneResult";
    }
    
    
    
    @RequestMapping(value = "/phone/writeList", method = RequestMethod.GET)
    public String phoneListGet(Model model) {
        return "phone/writeListForm";
    }
    
    @RequestMapping(value = "/phone/writeList", method = RequestMethod.POST)
    public String phoneListPost(Model model,
            @ModelAttribute RepositoryPhone phone) {
        List<ModelPhone> phonelist = phone.getPhoneItems();
        // DB insert. 어떻게?
        model.addAttribute("list", phonelist);
        
        int result = svrphone.insertPhoneList(phonelist);
        
        return "phone/writeListResult";
    }
}

