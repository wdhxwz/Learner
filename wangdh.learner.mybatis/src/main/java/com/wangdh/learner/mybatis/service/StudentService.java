package com.wangdh.learner.mybatis.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wangdh.learner.mybatis.Utils.GUIDUtils;
import com.wangdh.learner.mybatis.Utils.MybatisUtils;
import com.wangdh.learner.mybatis.dto.StudentDto;
import com.wangdh.learner.mybatis.entity.StudentEntity;
import com.wangdh.learner.mybatis.mapper.StudentMapper;

public class StudentService {

	private StudentMapper studentMapper;
	private SqlSession sqlSession;

	public StudentService() {
		sqlSession = MybatisUtils.openSession();
		studentMapper = sqlSession.getMapper(StudentMapper.class);
	}

	public StudentDto getStudent(String id) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		StudentEntity studentEntity = studentMapper.getStudentById(map);

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
		}
	}
}
