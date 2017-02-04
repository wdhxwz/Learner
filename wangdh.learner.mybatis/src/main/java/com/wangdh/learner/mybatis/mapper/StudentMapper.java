package com.wangdh.learner.mybatis.mapper;

import java.util.Map;

import com.wangdh.learner.mybatis.entity.StudentEntity;

public interface StudentMapper {
	StudentEntity getStudentById(Map<String, String> map);
	void insertStudent(StudentEntity student);
}
