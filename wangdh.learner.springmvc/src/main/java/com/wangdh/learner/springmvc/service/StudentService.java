package com.wangdh.learner.springmvc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangdh.learner.springmvc.base.SpringUtil;
import com.wangdh.learner.springmvc.entity.StudentEntity;
import com.wangdh.learner.springmvc.mapper.StudentMapper;

@Service
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;

	// @Autowired
	// private TestService testService;

	@Autowired
	HttpServletRequest httpServletRequest;

	public List<StudentEntity> getAll() {
		TestService testService = SpringUtil.getBean(TestService.class);
		System.out.println(httpServletRequest.getRequestURL());
		System.out.println(Thread.currentThread().getId() + " service :" + testService.getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		return studentMapper.selectAll();
	}
}
