package com.simpolor.cms.module.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpolor.cms.property.SecurityProperty;
import com.simpolor.cms.security.SecurityContext;
import com.simpolor.cms.security.model.User;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private SecurityProperty securityProperty;

    @RequestMapping({"/", "/index", "/main", "/main/index"})
    public ModelAndView index(ModelAndView mav) {

        logger.info("[M] index");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("- authentication : "+authentication.getName());
        logger.info("- SecurityContext.isAuthenticated() : "+SecurityContext.isAuthenticated());

        if(SecurityContext.isAuthenticated()){
            User user = SecurityContext.getPrincipal();
            logger.info("- user.getIdentity() : "+user.getIdentity());
            logger.info("- user.getPassword() : "+user.getPassword());
            logger.info("- user.getName() : "+user.getName());
            logger.info("- user.getEmail() : "+user.getEmail());
            logger.info("- user.getAuthorities() : "+user.getAuthorities());

            mav.addObject("user", user);
        }
        mav.setViewName("module/main/index");

        return mav;
    }
}
