package com.simpolor.cms.security.repository;

import com.simpolor.cms.security.domain.Token;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenRepository {

	public Token selectToken(String series);
	public void insertToken(Token token);
	public void updateToken(Token token);
	public void deleteToken(String username);
}
