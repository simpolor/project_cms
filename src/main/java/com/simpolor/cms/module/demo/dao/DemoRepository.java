package com.simpolor.cms.module.demo.dao;

import com.simpolor.cms.module.demo.model.Demo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoRepository {

	int selectDemoCount();
	
	Demo selectDemo(int seq);

}
