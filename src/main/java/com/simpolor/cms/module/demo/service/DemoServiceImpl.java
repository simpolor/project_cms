package com.simpolor.cms.module.demo.service;

import com.simpolor.cms.module.demo.domain.Demo;
import com.simpolor.cms.module.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
    DemoRepository demoRepository;
	
	@Override
	public int findAllCount() {
		return demoRepository.selectDemoCount();
	}

	@Override
	public Demo findByDemo(int seq) {
		return demoRepository.selectDemo(seq);
	}

}
