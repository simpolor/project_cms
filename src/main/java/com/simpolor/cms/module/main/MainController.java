package com.simpolor.cms.module.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpolor.cms.property.SecurityProperty;
import com.simpolor.cms.security.SecurityContext;
import com.simpolor.cms.security.model.User;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private SecurityProperty securityProperty;

    @RequestMapping({"/", "/index", "/main", "/main/index"})
    public ModelAndView index(ModelAndView mav) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication : "+authentication.getName());
        System.out.println("SecurityContext.isAuthenticated() : "+SecurityContext.isAuthenticated());

        if(SecurityContext.isAuthenticated()){
            User user = SecurityContext.getPrincipal();
            System.out.println("user.getIdentity() : "+user.getIdentity());
            System.out.println("user.getPassword() : "+user.getPassword());
            System.out.println("user.getName() : "+user.getName());
            System.out.println("user.getEmail() : "+user.getEmail());
            System.out.println("user.getAuthorities() : "+user.getAuthorities());

            mav.addObject("user", user);
        }
        mav.setViewName("module/main/index");

        return mav;
    }
}
