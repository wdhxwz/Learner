package com.wangdh.learner.springmvc.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wangdh.learner.springmvc.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ModelAndView handleException(UserNotFoundException ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorMessage", "全局错误:" + ex.getMessage());
		modelAndView.setViewName("error");

		return modelAndView;
	}
}
