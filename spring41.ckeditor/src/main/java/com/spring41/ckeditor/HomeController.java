package com.spring41.ckeditor;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

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
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	   
	
	@RequestMapping(value = "/ckeditor", method = RequestMethod.GET)
    public String ckeditor(Model model) {
	    model.addAttribute("msg", "aaa1" );  //msg 라는 이름을 찾아서 값 ("aaa1")을 대입한다.
	    return "ckeditor";
	}
	
	@RequestMapping(value = "/ckeditor", method = RequestMethod.POST)
    public String ckeditor(Model model, HttpServletRequest request) {
	    String input = request.getParameter("inputArticleContents");

	    return "redirect:/";
    }
}
