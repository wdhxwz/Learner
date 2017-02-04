package com.wangdh.learner.mybatis.serviceTest;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wangdh.learner.mybatis.dto.StudentDto;
import com.wangdh.learner.mybatis.service.StudentService;

public class StudentServiceTest {
	private StudentService studentService;

	@Before
	public void setUp() {
		studentService = new StudentService();
	}

	@Test
	public void addStudent() {
		for (int i = 0; i < 20; i++) {
			StudentDto studentDto = new StudentDto();
			studentDto.setBirthday(new Date());
			studentDto.setEmail(i + "123@qq.com");
			studentDto.setName("张三,index=" + i);

			// studentService.addStudent(studentDto);
		}
	}

	@Test
	public void getStudent() {
		StudentDto studentDto = studentService.getStudent("18cf612805f148cca5f98f327ccea6ed");
		System.out.println(studentDto.getName());
		studentDto = studentService.getStudent("18cf612805f148cca5f98f327ccea6ed");
		System.out.println(studentDto.getName());
		Assert.assertNotNull(studentDto);
	}
}
