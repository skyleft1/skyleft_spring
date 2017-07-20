package com.spring61.mvc.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring61.mvc.model.ModelLogin;
import com.spring61.mvc.model.ModelPerson;
import com.spring61.mvc.model.ModelPhone;


/**
 * Handles requests for the application home page.
 */
@Controller
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/rest/", method = RequestMethod.GET)
	public String home(Locale locale
	        , Model model ){
	    
//      model.addAttribute("serverTime", formattedDate );
        return "redirect:/rest/ajaxone";
	}
	
	@RequestMapping(value = "/rest/ajaxone", method = RequestMethod.GET)
    public String ajaxone(Locale locale
            , Model model
            ){
	    logger.info("ajax");

        return "rest/ajaxone";
    }
	
    @RequestMapping(value = "/rest/ajaxone", method = RequestMethod.POST)
    @ResponseBody
    public ModelPerson ajaxone(Locale locale
            , Model model
            , @RequestParam(value="name", defaultValue="") String name
            , @RequestParam(value="id", defaultValue="") String id
            , @RequestParam(value="email", defaultValue="") String email
            , @RequestParam(value="pw", defaultValue="") String password
            ) {
        logger.info("ajax");
        
        ModelPerson login = new ModelPerson();
        
        login.setName("김갑환");
        login.setId(id);
        login.setEmail("dfd호롤롤로@ㅇㄹㅇ");
        login.setPassword(password);
        
        return login;
    }
    
    @RequestMapping(value = "/rest/newversion", method = RequestMethod.GET)
    @ResponseBody
    public String newversion(
            @RequestParam(value="current_version", defaultValue="") String current_version
            ) {
        logger.info("current_version");
        
        String result = "";
        
        if(current_version.isEmpty()){
            LocalDate locdate = LocalDate.now();
            result = locdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        
        return result;
    }
}

