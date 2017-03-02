package com.wangdh.learner.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/api/{name}")
	public String index(HttpServletRequest request, @PathVariable("name") String name) {

		System.out.println(name);
		Map<String, String[]> paramMap = request.getParameterMap();
		for (String p : paramMap.keySet()) {
			System.out.println(p);
		}

		System.out.println(request.getParameter("name"));
		return "home/index";
	}
}
