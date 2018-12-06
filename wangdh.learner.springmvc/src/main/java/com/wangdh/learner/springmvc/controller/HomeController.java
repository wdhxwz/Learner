package com.wangdh.learner.springmvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangdh.learner.springmvc.model.User;

@Controller
@RequestMapping("/home")
public class HomeController {

	// @Autowired
	// private TestService testService;
	//
	// @Autowired
	// private TestService testService2;

	//@SuppressWarnings("unused")
	//@Autowired
	//private StudentService studentService;

	@RequestMapping("/api/{name}")
	public String index(HttpServletRequest request, @PathVariable("name") String name, @ModelAttribute User user) {
//		TestService testService = SpringUtil.getBean(TestService.class);
//		TestService testService2 = SpringUtil.getBean(TestService.class);
//		testService.setName(UUID.randomUUID().toString());
//		System.out.println(Thread.currentThread().getId() + " controller:" + testService.getName());
//		System.out.println(Thread.currentThread().getId() + " controller2:" + testService2.getName());
//
//		List<StudentEntity> students = studentService.getAll();
//		for (StudentEntity studentEntity : students) {
//			System.out.println("name=" + studentEntity.getName());
//		}
		 // request.getSession().setAttribute("王东鸿", "3333");
		 
		 System.out.println(request.getSession().getAttribute("王东鸿"));
		
		System.out.println(request.getServletPath()+",,,");
		System.out.println(request.getRequestURI()+"???");
		System.out.println("sessionId = " + request.getSession().getId());
		Enumeration<String> keys = request.getSession().getAttributeNames();
		while (keys.hasMoreElements()){
			String key = keys.nextElement();
			System.out.println("key = " + key + ",value = " + request.getSession().getAttribute(key));
		}

		return "home/index";
	}

	@RequestMapping(value = "/hello", params = "userid")
	public ModelAndView sayHello(HttpServletResponse response, HttpServletRequest request) {

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

	// @ModelAttribute
	// public void populateModel(@RequestParam String abc, Model model) {
	// model.addAttribute("attributeName", abc);
	// }

	@RequestMapping("/getdata")
	public String getData(Map<String, Object> map) throws IOException {
		map.put("aaa", "gegeg");

		for (String key : map.keySet()) {
			System.out.println("key=" + key + ",value=" + map.get(key));
		}

		try (InputStream inputStream = HomeController.class.getClassLoader().getResourceAsStream("")) {

		}

		return "home/getdata";
	}
	
	/**
	 * jmeter测试路由性能
	 * @return
	 */
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "success";
	}
}
