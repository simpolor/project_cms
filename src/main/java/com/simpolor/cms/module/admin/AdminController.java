package com.simpolor.cms.module.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping("/admin/home")
	public String adminHome() {

		logger.info("[M] adminHome");

		return "adminHome";
	}
	
	@RequestMapping("/admin/login")
	public String adminLogin() {

		logger.info("[M] adminLogin");
		
		return "adminLogin";
	}
	
	@RequestMapping("/admin/userList")
	public ModelAndView adminUserList() {

		logger.info("[M] adminUserList");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminUserList");
		
		return mav;
	}
	
	@RequestMapping("/admin/security")
	public ModelAndView adminSecurity() {

		logger.info("[M] adminSecurity");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminSecurity");
		
		return mav;
	}
	
}
