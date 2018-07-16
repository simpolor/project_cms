package com.simpolor.cms.security;

import com.simpolor.cms.security.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityContext {

    private static final String ANONYMOUS_USER  = "anonymousUser";

    public static User getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            // ignoring에 포함되지 않는 경우 무조건 인증을 통과하며,
            if (!isAnonymousUser(authentication.getName())){
                return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            }
        }
        return null;
    }

    public static boolean isAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && !isAnonymousUser(authentication.getName()) ){
            return authentication.isAuthenticated();
        }
        return false;
    }

    private static boolean isAnonymousUser(String name){
        return ANONYMOUS_USER.equals(name);
    }
}
