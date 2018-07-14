package com.simpolor.cms.security.service;

import com.simpolor.cms.security.adapter.UserServiceAdapter;
import com.simpolor.cms.security.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDetailsService {

	final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserServiceAdapter userServiceAdapter;
	
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("[M] CustomUserDetailsService.loadUserByUsername");
		logger.info("-- username : {}", username);
		
		return userServiceAdapter.getUser(username);
	}
}
