package com.spring51.jstl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class jstlController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/jstl/jstl01", method = RequestMethod.GET)
	public String jstl01(Locale locale, Model model) {
		logger.info("jstl");

		
		// return 에는 jsp 파일이 와야한다.
		return "jstl/jstl01";
	}
	
    @RequestMapping(value = "/jstl/jstl02", method = RequestMethod.GET)
    public String jstl02(Locale locale, Model model) {
        logger.info("jstl");
        
        int num1 = 7;
        int num2 = 9;
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        
        return "jstl/jstl02";
    }
    
    
    @RequestMapping(value = "/jstl/jstl03", method = RequestMethod.GET)
    public String jstl03(Locale locale, Model model) {
        logger.info("jstl");
        
        return "jstl/jstl03";
    }
    
//    if문
    @RequestMapping(value = "/jstl/jstl11", method = RequestMethod.GET)
    public String jstl11(Locale locale, Model model) {
        logger.info("jstl");
        
        return "jstl/jstl11";
    }

    // choose문
    @RequestMapping(value = "/jstl/jstl12", method = RequestMethod.GET)
    public String jstl12(Locale locale, Model model) {
        logger.info("jstl");
        
        return "jstl/jstl12";
    }

    // for문
    @RequestMapping(value = "/jstl/jstl21", method = RequestMethod.GET)
    public String jstl21(Locale locale, Model model) {
        logger.info("jstl");
        
        return "jstl/jstl21";
    }
    
    
    // foreach문
    @RequestMapping(value = "/jstl/jstl22", method = RequestMethod.GET)
    public String jstl22(Locale locale, Model model) {
        logger.info("jstl");
        
        /* ====String 배열===== */
        String[] arr = {"순두부","된장찌개","제육덮밥"};
        model.addAttribute("array", arr);
        /* ====ArrayList 배열===== */
        List<String> arr1 = new ArrayList<String>();
        arr1.add("두부");
        arr1.add("찌개");
        arr1.add("덮밥");
        model.addAttribute("list11", arr1);
        
        return "jstl/jstl22";
    }
    
    // fortokens문
    @RequestMapping(value = "/jstl/jstl23", method = RequestMethod.GET)
    public String jstl23(Locale locale, Model model) {
        logger.info("jstl");
        
        model.addAttribute("members", "효성^^지은~선화//////징거");
        
        return "jstl/jstl23";
    }
    
    
    // 정적 include문
    @RequestMapping(value = "/jstl/jstl31", method = RequestMethod.GET)
    public String jstl31(Locale locale, Model model) {
        logger.info("jstl");
        
        return "jstl/jstl31";
    }
    
    // 동적 include문
    @RequestMapping(value = "/jstl/jstl32", method = RequestMethod.GET)
    public String jstl32(Locale locale, Model model) {
        logger.info("jstl");
        
        return "jstl/jstl32";
    }
    
    
 // redirect문
    @RequestMapping(value = "/jstl/jstl51", method = RequestMethod.GET)
    public String jstl51(Locale locale, Model model) {
        logger.info("jstl");
        
        return "jstl/jstl51";
    }
    
    // scope 문
    @RequestMapping(value = "/jstl/jstl61", method = RequestMethod.GET)
    public String jstl61(Locale locale, Model model) {
        logger.info("jstl");
        
        return "jstl/jstl61";
    }
    // fmt 문
    @RequestMapping(value = "/jstl/jstl71", method = RequestMethod.GET)
    public String jstl71(Locale locale, Model model) {
        logger.info("jstl");
        
        model.addAttribute("DateString1", "19980312");
        model.addAttribute("DateString2", new Date());
        
        return "jstl/jstl71";
    }
}
