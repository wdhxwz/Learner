package com.wangdh.learner.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wangdh.learner.springmvc.exception.UserNotFoundException;
import com.wangdh.learner.springmvc.model.User;

/**
 * Spring MVC异常处理
 * 
 * @author wangdh 2017年3月8日下午7:44:27
 */
@Controller
@RequestMapping(value = "exception")
public class ExceptionHandleController {
	private Map<String, User> users = new HashMap<>();

	@PostConstruct
	public void setUp() {
		System.out.println("执行PostConstruct");
		users.put("wangdh", new User());
		users.put("cxx", new User());
	}

	@RequestMapping(value = "/index/{userName}")
	public String index(@PathVariable("userName") String userName) throws UserNotFoundException {
		User user = users.get(userName);
		if (user == null) {
			throw new UserNotFoundException(userName);
		}
		
		return "";
	}
}