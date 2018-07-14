package com.simpolor.cms.security;

import com.simpolor.cms.security.model.User;
import com.simpolor.cms.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordProvider implements AuthenticationProvider {
	
	final Logger logger = LoggerFactory.getLogger(UsernamePasswordProvider.class);
	
	@Autowired
	private PasswordEncrypt passwordEncrypt;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user = userService.loadUserByUsername(username);

		if(!passwordEncrypt.matches(password, user.getPassword())) {
			throw new BadCredentialsException("The password does not match.");
		}
		
		return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
