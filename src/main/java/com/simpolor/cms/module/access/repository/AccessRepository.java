package com.simpolor.cms.module.access.repository;


import com.simpolor.cms.module.access.domain.Access;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccessRepository {

	public List<Access> selectAccessList();
	
	public Access selectAccess(int access_seq);
	
	public int selectAccessUrlCheck(String access_url);
	
	public int insertAccess(Access access);
	
	public int updateAccess(Access access);
	
	public int deleteAccess(Access access);
	
}
