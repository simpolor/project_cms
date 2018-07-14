package com.simpolor.cms.module.access.dao;


import com.simpolor.cms.module.access.model.Access;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccessRepository {

	List<Access> selectAccessList();
	
	Access selectAccess(int access_seq);
	
	int selectAccessUrlCheck(String access_url);
	
	int insertAccess(Access access);
	
	int updateAccess(Access access);
	
	int deleteAccess(Access access);
	
}
