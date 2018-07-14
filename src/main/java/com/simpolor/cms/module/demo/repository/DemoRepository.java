package com.simpolor.cms.module.demo.repository;

import com.simpolor.cms.module.demo.domain.Demo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoRepository {

	int selectDemoCount();
	
	Demo selectDemo(int seq);

}
