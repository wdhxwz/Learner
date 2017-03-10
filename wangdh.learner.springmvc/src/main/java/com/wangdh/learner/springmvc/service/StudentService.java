package com.wangdh.learner.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangdh.learner.springmvc.entity.StudentEntity;
import com.wangdh.learner.springmvc.mapper.StudentMapper;

@Service
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;

	public List<StudentEntity> getAll() {
		return studentMapper.selectAll();
	}
}
