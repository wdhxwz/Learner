package com.wangdh.learner.springmvc.mapper;

import java.util.Map;

import com.wangdh.learner.springmvc.base.MSSQLMapper;
import com.wangdh.learner.springmvc.entity.StudentEntity;

public interface StudentMapper extends MSSQLMapper<StudentEntity> {
	StudentEntity getStudentById(Map<String, String> map);

	void insertStudent(StudentEntity student);
}
