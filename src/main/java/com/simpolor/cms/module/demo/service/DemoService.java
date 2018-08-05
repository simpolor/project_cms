package com.simpolor.cms.module.demo.service;

import com.simpolor.cms.module.demo.model.Demo;
import com.simpolor.cms.module.demo.dao.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

	@Autowired
    DemoRepository demoRepository;

	public int findAllCount() {
		return demoRepository.selectDemoCount();
	}

	public Demo findByDemo(int seq) {
		return demoRepository.selectDemo(seq);
	}

}
