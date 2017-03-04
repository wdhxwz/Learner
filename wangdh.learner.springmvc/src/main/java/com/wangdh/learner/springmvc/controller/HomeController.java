package com.wangdh.learner.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController implements EnvironmentAware{

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

	
	private Environment environment;
	
	/**
	 * 会在类实例化的时候设置值
	 */
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
		System.out.println("设置了环境");
	}
}
