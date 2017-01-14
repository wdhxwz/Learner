package com.wangdh.learner.mybatis.service;

import com.wangdh.learner.mybatis.Utils.GUIDUtils;
import com.wangdh.learner.mybatis.Utils.MybatisUtils;
import com.wangdh.learner.mybatis.dto.StudentDto;
import com.wangdh.learner.mybatis.entity.StudentEntity;
import com.wangdh.learner.mybatis.mapper.StudentMapper;

public class StudentService {

	private StudentMapper studentMapper;

	public StudentService() {
		studentMapper = MybatisUtils.openSession().getMapper(StudentMapper.class);
	}

	public StudentDto getStudent(String id) {
		StudentEntity studentEntity = studentMapper.getStudentById(id);

		StudentDto studentDto = null;
		if (studentEntity != null) {
			studentDto = new StudentDto();
			studentDto.setBirthday(studentEntity.getBirthday());
			studentDto.setEmail(studentEntity.getEmail());
			studentDto.setName(studentEntity.getName());
		}

		return studentDto;
	}

	public void addStudent(StudentDto studentDto) {
		StudentEntity studentEntity = new StudentEntity();
		if (studentDto != null) {
			studentEntity.setBirthday(studentDto.getBirthday());
			studentEntity.setEmail(studentDto.getEmail());
			studentEntity.setName(studentDto.getName());
			studentEntity.setId(GUIDUtils.guid(""));
			studentMapper.insertStudent(studentEntity);
			MybatisUtils.commit();
		}
	}
}
