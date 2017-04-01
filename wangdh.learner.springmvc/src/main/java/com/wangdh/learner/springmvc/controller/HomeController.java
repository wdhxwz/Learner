package com.wangdh.learner.springmvc.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wangdh.learner.springmvc.base.SpringUtil;
import com.wangdh.learner.springmvc.entity.StudentEntity;
import com.wangdh.learner.springmvc.model.User;
import com.wangdh.learner.springmvc.service.StudentService;
import com.wangdh.learner.springmvc.service.TestService;

@Controller
@RequestMapping("/home")
public class HomeController {

	// @Autowired
	// private TestService testService;
	//
	// @Autowired
	// private TestService testService2;

	@Autowired
	private StudentService studentService;

	@RequestMapping("/api/{name}")
	public String index(HttpServletRequest request, @PathVariable("name") String name, @ModelAttribute User user) {
		TestService testService = SpringUtil.getBean(TestService.class);
		TestService testService2 = SpringUtil.getBean(TestService.class);
		testService.setName(UUID.randomUUID().toString());
		System.out.println(Thread.currentThread().getId() + " controller:" + testService.getName());
		System.out.println(Thread.currentThread().getId() + " controller2:" + testService2.getName());

		List<StudentEntity> students = studentService.getAll();
		for (StudentEntity studentEntity : students) {
			System.out.println("name=" + studentEntity.getName());
		}

		return "home/index";
	}

	@RequestMapping(value = "/hello")
	public ModelAndView sayHello(HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Hello Spring Mvc");
		modelAndView.addObject("date", new Date());
		modelAndView.addObject("Content-Type", "text/html;charset=UTF-8");
		modelAndView.setViewName("home/hello");

		System.out.println(response.getContentType());

		return modelAndView;

	}

	@RequestMapping("/add")
	public String addUser(User user) {

		System.out.println(user.getName());

		return "home/index";
	}
}
