package com.wangdh.learner.springmvc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wangdh.learner.springmvc.model.User;

@Controller
@RequestMapping("/home")
public class HomeController implements EnvironmentAware {

	public HomeController() {
		System.out.println("执行构造函数");
	}

	@RequestMapping("/api/{name}")
	public String index(HttpServletRequest request, @PathVariable("name") String name, @ModelAttribute User user)
			{
		System.out.println(name);
		System.out.println(request.getRequestURL().toString());
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
