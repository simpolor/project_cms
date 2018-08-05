package com.simpolor.cms.module.demo;

import com.simpolor.cms.module.demo.model.Demo;
import com.simpolor.cms.module.demo.service.DemoService;
import com.simpolor.cms.security.SecurityContext;
import com.simpolor.cms.security.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	final Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private DemoService demoService;

	@RequestMapping("/demo")
	public ModelAndView demo(ModelAndView mav) {

		logger.info("[M] demo");

		System.out.println("- demo count : "+demoService.findAllCount());
		
		Demo demo = demoService.findByDemo(1);
		if(demo != null) {
			System.out.println("- seq : "+demo.getSeq());
			System.out.println("- name : "+demo.getName());
			System.out.println("- age : "+demo.getAge());
			System.out.println("- hobby : "+demo.getHobby());
		}

		if(SecurityContext.isAuthenticated()){
			User user = SecurityContext.getPrincipal();
			System.out.println("- user.getIdentity() : "+user.getIdentity());
			System.out.println("- user.getPassword() : "+user.getPassword());
			System.out.println("- user.getName() : "+user.getName());
			System.out.println("- user.getEmail() : "+user.getEmail());
			System.out.println("- user.getAuthorities() : "+user.getAuthorities());
		}

		mav.addObject("demo", demo);
		mav.setViewName("module/demo/demo");
		
		return mav;
	}
	
	@RequestMapping("/demo/{seq}")
	public ModelAndView demo(@PathVariable int seq, ModelAndView mav) {

		logger.info("[M] demo/{seq}");

		Demo demo = demoService.findByDemo(seq);
		if(demo != null) {
			logger.info("- seq : "+demo.getSeq());
			logger.info("- name : "+demo.getName());
			logger.info("- age : "+demo.getAge());
			logger.info("- hobby : "+demo.getHobby());
			mav.addObject("demo", demo);
		}

		if(SecurityContext.isAuthenticated()){
			User user = SecurityContext.getPrincipal();
			logger.info("- user.getIdentity() : "+user.getIdentity());
			logger.info("- user.getPassword() : "+user.getPassword());
			logger.info("- user.getName() : "+user.getName());
			logger.info("- user.getEmail() : "+user.getEmail());
			logger.info("- user.getAuthorities() : "+user.getAuthorities());
		}
		
		mav.setViewName("module/demo/demo");
		
		return mav;
	}
	
	@RequestMapping("/demo1")
	public ModelAndView demo1(ModelAndView mav) {

		logger.info("[M] demo1");

		System.out.println("- demo count : "+demoService.findAllCount());
		
		Demo demo = demoService.findByDemo(1);
		if(demo != null) {
			logger.info("- seq : "+demo.getSeq());
			logger.info("- name : "+demo.getName());
			logger.info("- age : "+demo.getAge());
			logger.info("- hobby : "+demo.getHobby());
			mav.addObject("demo", demo);
		}
		
		mav.setViewName("module/demo/demo");
		
		return mav;
	}
	
	@RequestMapping("/demo2")
	public ModelAndView demo2(ModelAndView mav) {

		logger.info("[M] demo2");

		System.out.println("- demo count : "+demoService.findAllCount());
		
		Demo demo = demoService.findByDemo(1);
		if(demo != null) {
			logger.info("- seq : "+demo.getSeq());
			logger.info("- name : "+demo.getName());
			logger.info("- age : "+demo.getAge());
			logger.info("- hobby : "+demo.getHobby());
			mav.addObject("demo", demo);
		}

		System.out.println("SecurityContext.isAuthenticated() : "+SecurityContext.isAuthenticated());
		if(SecurityContext.isAuthenticated()){
			User user = SecurityContext.getPrincipal();
			logger.info("- getUsername : "+user.getUsername());
			logger.info("- getIdentity : "+user.getIdentity());
			logger.info("- getPassword : "+user.getPassword());
			logger.info("- getName : "+user.getName());
			logger.info("- getEmail : "+user.getEmail());
			logger.info("- isAccountNonExpired : "+user.isAccountNonExpired());
			for(GrantedAuthority ga : user.getAuthorities()){
				logger.info("- getAuthority : "+ga.getAuthority());
			}
		}
		
		mav.setViewName("module/demo/demo");
		
		return mav;
	}
	
}
