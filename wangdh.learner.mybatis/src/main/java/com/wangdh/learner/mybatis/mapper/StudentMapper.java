package com.wangdh.learner.mybatis.mapper;

import com.wangdh.learner.mybatis.entity.StudentEntity;

public interface StudentMapper {
	StudentEntity getStudentById(String id);
	void insertStudent(StudentEntity student);
}
