package com.simpolor.cms.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

@Component
public class SecurityInterceptor extends FilterSecurityInterceptor {

	final Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	public SecurityInterceptor(LogicalOrAccessDecisionManager accessDecisionManager,
			SecurityMetadataSource securityMetadataSource) {
		
		super.setAccessDecisionManager(accessDecisionManager);
		super.setSecurityMetadataSource(securityMetadataSource);
	}
	
}
